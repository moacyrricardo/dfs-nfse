package br.com.dsfnet.nfse.services;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.crypto.dsig.spec.XPathFilterParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.axis.utils.ByteArrayOutputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.dsfnet.nfse.wsnfe2.tp.TpDeducaoPor;
import br.com.dsfnet.nfse.wsnfe2.tp.TpDeducoes;
import br.com.dsfnet.nfse.wsnfe2.tp.TpItens;
import br.com.dsfnet.nfse.wsnfe2.tp.TpRPS;
import br.com.dsfnet.nfse.wsnfe2.tp.TpTipoRecolhimento;

/**
 * Gerador de assinaturas para RPS E também é um acessório para assinar XMLs
 * 
 * XML Signature: Based on code found at http://www.xinotes.net/notes/note/751/
 * 
 * @author <a href="mailto:mpereira@quintoandar.com.br">moa</a>
 * 
 */
public class Assinador {
	public static final String KEY_STORE_TYPE_JKS = "JKS";

	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	private TipoAssinatura tipo = TipoAssinatura.POR_DOCUMENTO;

	private String xpath;

	private String id;

	private Document doc;

	private PrivateKey privateKey;

	private X509Certificate cert;

	private KeyInfoFactory keyInfoFactory;

	private KeyValue keyValue;

	private XMLSignatureFactory sigFactory;

	// private KeyStore keyStore;

	public Assinador(Document doc) {
		this.doc = doc;
	}

	public Assinador(InputStream is) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dbFactory.setNamespaceAware(true);
		this.doc = dbFactory.newDocumentBuilder().parse(is);
	}

	public Assinador assinarPorId(String id) {
		tipo = TipoAssinatura.POR_ID;
		this.id = id;
		return this;
	}

	public Assinador assinarPorXPath(String xpath) throws XPathExpressionException {
		tipo = TipoAssinatura.POR_PATH;
		this.xpath = xpath;

		// testando expressao xpath: estoura exception aqui direto
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpathTst = factory.newXPath();
		xpathTst.compile(this.xpath);
		return this;
	}

	public Assinador useKeystore(KeyStore keyStore, String keyAlias, String privateKeyPass) throws UnrecoverableKeyException,
			KeyStoreException, NoSuchAlgorithmException, KeyException {
		this.privateKey = (PrivateKey) keyStore.getKey(keyAlias, privateKeyPass.toCharArray());
		this.cert = (X509Certificate) keyStore.getCertificate(keyAlias);
		// Retrieve signing key
		// PrivateKey privateKey = (PrivateKey) keyStore.getKey(KEY_ALIAS,
		// PRIVATE_KEY_PASS.toCharArray());
		//
//		 X509Certificate cert = (X509Certificate)
//		 keyStore.getCertificate(KEY_ALIAS);

		try {
			String providerName = System.getProperty("jsr105Provider", "org.jcp.xml.dsig.internal.dom.XMLDSigRI");
			sigFactory = XMLSignatureFactory.getInstance("DOM", (Provider) Class.forName(providerName).newInstance());
		} catch (Throwable e) {
			throw new RuntimeException(
					"Error while loading XMLSignatureFactory (using 'jsr105Provider=org.jcp.xml.dsig.internal.dom.XMLDSigRI')", e);
		}
		PublicKey publicKey = cert.getPublicKey();

		// Create a KeyValue containing the RSA PublicKey
		this.keyInfoFactory = sigFactory.getKeyInfoFactory();
		this.keyValue = keyInfoFactory.newKeyValue(publicKey);
		return this;
	}

	public Assinador useKeystore(InputStream keyStoreSt, String tipo, String keyStorePass, String keyAlias, String privateKeyPass)
			throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, KeyException {
		KeyStore keyStore = null;
		try {
			keyStore = KeyStore.getInstance(tipo);
			keyStore.load(keyStoreSt, keyStorePass.toCharArray());
		} catch (Throwable t) {
			throw new RuntimeException("Error while loading keystore", t);
		}
		return useKeystore(keyStore, keyAlias, privateKeyPass);
	}

	public OutputStream buildAsStream() throws TransformerFactoryConfigurationError, NoSuchAlgorithmException,
			InvalidAlgorithmParameterException, TransformerException, MarshalException, XMLSignatureException {
		return buildAsStream(new ByteArrayOutputStream());
	}

	public OutputStream buildAsStream(OutputStream out)  throws TransformerFactoryConfigurationError, NoSuchAlgorithmException,
	InvalidAlgorithmParameterException, TransformerException, MarshalException, XMLSignatureException {
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		trans.transform(new DOMSource(build()), new StreamResult(out));
		return out;
	}

	public Document build() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, MarshalException, XMLSignatureException {
		// XMLSignatureFactory sigFactoryTemp = null;
		// try {
		// sigFactoryTemp = XMLSignatureFactory.getInstance("DOM", (Provider)
		// Class.forName(providerName).newInstance());
		// } catch (Throwable e) {
		// throw new
		// RuntimeException("Error loading jsr105Provider=org.jcp.xml.dsig.internal.dom.XMLDSigRI for SignatureFactory",e);
		// }
		// final XMLSignatureFactory sigFactory = sigFactoryTemp;

		Node nodeToSign = null;
		Node sigParent = null;
		String referenceURI = null;
		XPathExpression expr = null;
		NodeList nodes;
		List transforms = null;

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		HashMap<String, String> prefMap = new HashMap<String, String>() {
			{
				put("main", "http://schemas.openxmlformats.org/spreadsheetml/2006/main");
				put("r", "http://schemas.openxmlformats.org/officeDocument/2006/relationships");
				put("ns1", "http://localhost:8080/WsNFe2/lote");
			}
		};
		xpath.setNamespaceContext(new SimpleNamespaceContext(prefMap));
		switch (tipo) {
		case POR_ID:
			String idAttr = null;
			for (String curIdAttr : Arrays.asList("id", "ID", "Id", "iD")) {
				try {
					expr = xpath.compile(String.format("//*[@" + curIdAttr + "='%s']", id));
					nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
				} catch (XPathExpressionException e) {
					throw new RuntimeException("Error with id XPath expression", e);
				}
				if (nodes.getLength() > 0) {
					idAttr = curIdAttr;
					nodeToSign = nodes.item(0);
					break;
				}
			}
			if (nodeToSign == null) {
				throw new RuntimeException("Can't find node with id: " + id);
				// return;
			}

			((Element) nodeToSign).setIdAttribute("Id", true);
			sigParent = nodeToSign.getParentNode();
			referenceURI = "#" + id;
			
			transforms = new ArrayList<Transform>() {
				{
					add(sigFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null));
					add(sigFactory.newCanonicalizationMethod( CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null));
				}
			};
			
			/*
			 * This is not needed since the signature is alongside the signed
			 * element, not enclosed in it. transforms =
			 * Collections.singletonList( sigFactory.newTransform(
			 * Transform.ENVELOPED, (TransformParameterSpec) null ) );
			 */
			break;
		case POR_PATH:
			// Find the node to be signed by PATH
			try {
				expr = xpath.compile(this.xpath);
				nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			} catch (XPathExpressionException e) {
				throw new RuntimeException("Error with XPath expression", e);
			}
			if (nodes.getLength() < 1) {
				throw new RuntimeException("Invalid document, can't find node by PATH: " + xpath);
				// System.out.println("Invalid document, can't find node by PATH: "
				// + xpath);
				// return;
			}

			nodeToSign = nodes.item(0);
			sigParent = nodeToSign.getParentNode();
			referenceURI = ""; // Empty string means whole document
			transforms = new ArrayList<Transform>() {
				{
					add(sigFactory.newTransform(Transform.XPATH, new XPathFilterParameterSpec(Assinador.this.xpath)));
					add(sigFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null));
				}
			};

			break;
		default:
			sigParent = doc.getDocumentElement();
			referenceURI = ""; // Empty string means whole document
			transforms = Collections.singletonList(sigFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null));
			break;
		}

		//TODO add a way to choose if want X509, RSA Key Value or both 
		// Create a KeyInfo and add the KeyValue to it
		KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Arrays.asList(keyInfoFactory.newX509Data(Collections.singletonList(cert))));

		// Create a DOMSignContext and specify the RSA PrivateKey and
		// location of the resulting XMLSignature's parent element
		DOMSignContext dsc = new DOMSignContext(privateKey, sigParent);
		Reference ref = sigFactory.newReference(referenceURI, sigFactory.newDigestMethod(DigestMethod.SHA1, null), transforms, null, null);

		// Create the SignedInfo
		SignedInfo signedInfo = sigFactory.newSignedInfo(
				sigFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null),
				sigFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null), 
				Collections.singletonList(ref));
		// Create the XMLSignature (but don't sign it yet)
		XMLSignature signature = sigFactory.newXMLSignature(signedInfo, keyInfo);

		// Marshal, generate (and sign) the enveloped signature
		signature.sign(dsc);

		return doc;
	}

	/**
	 * @param stringAPreencher
	 *            string base a ser preenchida
	 * @param tam
	 *            tamanho máximo do preenchimento
	 * @param aDireita
	 *            se for true, preenche à direita, se não preenche a esquerda
	 * @param prencher
	 *            caracter que será usado para preencher
	 * @return
	 */
	private static String preencher(String stringAPreencher, int tam, boolean aDireita, char prencher) {
		while (stringAPreencher.length() < tam) {
			if (aDireita) {
				stringAPreencher = stringAPreencher + prencher;
			} else {
				stringAPreencher = prencher + stringAPreencher;
			}
		}
		return stringAPreencher;
	}

	// private static String preencherComZeros(int aPreencher, int tam){
	// return preencher(aPreencher+"", tam, false, '0');
	// }

	private static String preencherComZeros(Number aPreencher, int tam) {
		return preencherComZeros(aPreencher + "", tam);
	}

	private static String preencherComZeros(String stringAPreencher, int tam) {
		return preencher(stringAPreencher, tam, false, '0');
	}

	private static String preencherComEspacos(String stringAPreencher, int tam) {
		return preencher(stringAPreencher, tam, true, ' ');
	}

	public static String gerarSeedAssinatura(TpRPS rps) {
		StringBuilder assinatura = new StringBuilder();

		assinatura.append(preencherComZeros(rps.getInscricaoMunicipalPrestador(), 11));
		assinatura.append(preencherComEspacos(rps.getSerieRPS() + "", 5));
		assinatura.append(preencherComZeros(rps.getNumeroRPS(), 12));
		assinatura.append(sdf.format(rps.getDataEmissaoRPS().toGregorianCalendar().getTime()));
		assinatura.append(preencherComEspacos(rps.getTributacao() + "", 2));

		assinatura.append(rps.getSituacaoRPS());
		assinatura.append(rps.getTipoRecolhimento() == TpTipoRecolhimento.A ? "N" : "S");

		BigDecimal valorSemDeducao = new BigDecimal(0);
		BigDecimal valorDaDeducao = new BigDecimal(0);
		for (TpItens it : rps.getItens().getItem()) {
			valorSemDeducao = valorSemDeducao.add(it.getValorTotal());
		}
		
		if(rps.getDeducoes() != null){				
			if(  rps.getDeducoes().getDeducao() != null){
				for (TpDeducoes it : rps.getDeducoes().getDeducao()) {
					BigDecimal deducaoAtual = new BigDecimal(0);
					if (it.getDeducaoPor() == TpDeducaoPor.PERCENTUAL) {
						deducaoAtual = it.getPercentualDeduzir();
						deducaoAtual = deducaoAtual.multiply(valorSemDeducao);
					} else if (it.getDeducaoPor() == TpDeducaoPor.VALOR) {
						deducaoAtual = it.getValorDeduzir();
					}
					valorDaDeducao = valorDaDeducao.add(deducaoAtual);
					// valorSemDeducao.add(it.getValorTotal());
				}
			}
		}
		valorSemDeducao.setScale(2, RoundingMode.HALF_UP);
		valorDaDeducao.setScale(2, RoundingMode.HALF_UP);

		valorSemDeducao = valorSemDeducao.subtract(valorDaDeducao);
		assinatura.append(preencherComZeros(valorSemDeducao.toString().replaceAll("[^0-9]", ""), 15));
		assinatura.append(preencherComZeros(valorDaDeducao.toString().replaceAll("[^0-9]", ""), 15));

		assinatura.append(preencherComZeros(rps.getCodigoAtividade(), 10));
		assinatura.append(preencherComZeros(rps.getCPFCNPJTomador().replaceAll("[^0-9]", ""), 14));

		return assinatura.toString();
	}

	public static byte[] gerarHashAssinatura(TpRPS rps) {
		String seed = gerarSeedAssinatura(rps);
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			messageDigest.reset();
			messageDigest.update(seed.getBytes("utf8"));
			return messageDigest.digest();
		} catch (NoSuchAlgorithmException e) {
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}

	public static void assinarRPSs(List<TpRPS> rpss) {
		for (TpRPS rps : rpss) {
			byte[] ass = gerarHashAssinatura(rps);
			rps.setAssinatura(ass);
		}
	}
}
