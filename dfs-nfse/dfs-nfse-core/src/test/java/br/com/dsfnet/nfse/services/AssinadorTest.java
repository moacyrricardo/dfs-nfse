package br.com.dsfnet.nfse.services;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Test;

import br.com.dsfnet.nfse.wsnfe2.tp.TpItens;
import br.com.dsfnet.nfse.wsnfe2.tp.TpListaItens;
import br.com.dsfnet.nfse.wsnfe2.tp.TpOperacao;
import br.com.dsfnet.nfse.wsnfe2.tp.TpRPS;
import br.com.dsfnet.nfse.wsnfe2.tp.TpSerieRPS;
import br.com.dsfnet.nfse.wsnfe2.tp.TpSituacaoRPS;
import br.com.dsfnet.nfse.wsnfe2.tp.TpTipoRecolhimento;
import br.com.dsfnet.nfse.wsnfe2.tp.TpTributacao;

public class AssinadorTest {

	@Test
	public void testGerarSeedAssinatura() {
		TpRPS rps = new TpRPS();
		rps.setDataEmissaoNFSeSubstituida("1900-01-01");
		rps.setSeriePrestacao((byte)99); 
		rps.setInscricaoMunicipalTomador("0000000");
		rps.setInscricaoMunicipalPrestador(2459566l);
		rps.setSerieRPS(TpSerieRPS.NF);
		rps.setNumeroRPS(47);
		rps.setOperacao(TpOperacao.A);
		rps.setTributacao(TpTributacao.T);
		rps.setTipoRecolhimento(TpTipoRecolhimento.A);
		
		double aliquotaPIS = 0.65;
		double aliquotaCOFINS = 3;
		double aliquotaINSS = 0;
		double aliquotaIR = 0;
		double aliquotaCSLL = 0;
		
		rps.setAliquotaPIS(new BigDecimal(aliquotaPIS).setScale(2, RoundingMode.HALF_UP));
		rps.setAliquotaCOFINS(new BigDecimal(aliquotaCOFINS).setScale(2, RoundingMode.HALF_UP));
		rps.setAliquotaINSS(new BigDecimal(aliquotaINSS).setScale(2, RoundingMode.HALF_UP));
		rps.setAliquotaIR(new BigDecimal(aliquotaIR).setScale(2, RoundingMode.HALF_UP));
		rps.setAliquotaCSLL(new BigDecimal(aliquotaCSLL).setScale(2, RoundingMode.HALF_UP));
		rps.setDescricaoRPS("");
		
		rps.setDDDPrestador("19");
		rps.getTelefonePrestador().add("40071686");
		GregorianCalendar c = new GregorianCalendar();
		try {
			c.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("07-01-2015"));
			XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			rps.setDataEmissaoRPS(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rps.setTributacao(TpTributacao.T);
		rps.setSituacaoRPS(TpSituacaoRPS.N);
		
		double valorTotal = 5400.002;
		TpListaItens itens = new TpListaItens();
		TpItens item = new TpItens();
		BigDecimal valorDesp = new BigDecimal(valorTotal);
		valorDesp = valorDesp.setScale(2,RoundingMode.HALF_UP);
		item.setValorTotal(valorDesp);
		item.setValorUnitario(valorDesp);
		item.setQuantidade(new BigDecimal(1));
		itens.getItem().add(item);
		
		double valorPIS = valorTotal * aliquotaPIS * 0.1;
		double valorCOFINS = valorTotal * aliquotaCOFINS * 0.1;
		double valorINSS = valorTotal * aliquotaINSS * 0.1;
		double valorIR = valorTotal * aliquotaIR * 0.1;
		double valorCSLL = valorTotal * aliquotaCSLL * 0.1;
		
		rps.setValorPIS(new BigDecimal(valorPIS).setScale(2, RoundingMode.HALF_UP));
		rps.setValorCOFINS(new BigDecimal(valorCOFINS).setScale(2, RoundingMode.HALF_UP));
		rps.setValorINSS(new BigDecimal(valorINSS).setScale(2, RoundingMode.HALF_UP));
		rps.setValorIR(new BigDecimal(valorIR).setScale(2, RoundingMode.HALF_UP));
		rps.setValorCSLL(new BigDecimal(valorCSLL).setScale(2, RoundingMode.HALF_UP));
		
		rps.setItens(itens);
		rps.setCPFCNPJTomador("15412417540");
		rps.setCodigoAtividade(682260000);
//		rps.setTipoRecolhimento(TpTipoRecolhimento.);
		assertEquals("00002459566NF   00000000004720150107T NN000000000540000000000000000000068226000000015412417540", Assinador.gerarSeedAssinatura(rps));
	}
	@Test
	public void testGerarSeedAssinatura2() {
		TpRPS rps = new TpRPS();
		rps.setDataEmissaoNFSeSubstituida("1900-01-01");
		rps.setSeriePrestacao((byte)99); 
		rps.setInscricaoMunicipalTomador("0000000");
		rps.setInscricaoMunicipalPrestador(2459566l);
		rps.setSerieRPS(TpSerieRPS.NF);
		rps.setNumeroRPS(13);
		rps.setOperacao(TpOperacao.A);
		rps.setTributacao(TpTributacao.T);
		rps.setTipoRecolhimento(TpTipoRecolhimento.A);
		
		double aliquotaPIS = 0.65;
		double aliquotaCOFINS = 3;
		double aliquotaINSS = 0;
		double aliquotaIR = 0;
		double aliquotaCSLL = 0;
		
		rps.setAliquotaPIS(new BigDecimal(aliquotaPIS).setScale(2, RoundingMode.HALF_UP));
		rps.setAliquotaCOFINS(new BigDecimal(aliquotaCOFINS).setScale(2, RoundingMode.HALF_UP));
		rps.setAliquotaINSS(new BigDecimal(aliquotaINSS).setScale(2, RoundingMode.HALF_UP));
		rps.setAliquotaIR(new BigDecimal(aliquotaIR).setScale(2, RoundingMode.HALF_UP));
		rps.setAliquotaCSLL(new BigDecimal(aliquotaCSLL).setScale(2, RoundingMode.HALF_UP));
		rps.setDescricaoRPS("");
		
		rps.setDDDPrestador("19");
		rps.getTelefonePrestador().add("40071686");
		GregorianCalendar c = new GregorianCalendar();
		try {
			c.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("10-01-2015"));
			XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			rps.setDataEmissaoRPS(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rps.setTributacao(TpTributacao.T);
		rps.setSituacaoRPS(TpSituacaoRPS.N);
		
		double valorTotal = 2527.79;
		TpListaItens itens = new TpListaItens();
		TpItens item = new TpItens();
		BigDecimal valorDesp = new BigDecimal(valorTotal);
		valorDesp = valorDesp.setScale(2,RoundingMode.HALF_UP);
		item.setValorTotal(valorDesp);
		item.setValorUnitario(valorDesp);
		item.setQuantidade(new BigDecimal(1));
		itens.getItem().add(item);
		
		double valorPIS = valorTotal * aliquotaPIS * 0.1;
		double valorCOFINS = valorTotal * aliquotaCOFINS * 0.1;
		double valorINSS = valorTotal * aliquotaINSS * 0.1;
		double valorIR = valorTotal * aliquotaIR * 0.1;
		double valorCSLL = valorTotal * aliquotaCSLL * 0.1;
		
		rps.setValorPIS(new BigDecimal(valorPIS).setScale(2, RoundingMode.HALF_UP));
		rps.setValorCOFINS(new BigDecimal(valorCOFINS).setScale(2, RoundingMode.HALF_UP));
		rps.setValorINSS(new BigDecimal(valorINSS).setScale(2, RoundingMode.HALF_UP));
		rps.setValorIR(new BigDecimal(valorIR).setScale(2, RoundingMode.HALF_UP));
		rps.setValorCSLL(new BigDecimal(valorCSLL).setScale(2, RoundingMode.HALF_UP));
		
		rps.setItens(itens);
		rps.setCPFCNPJTomador("00284792624");
		rps.setCodigoAtividade(682260000);
//		rps.setTipoRecolhimento(TpTipoRecolhimento.);
		//TODO em bla: 84d15d500d8a90b4a9b8be04f915c26239c9cb20
		assertEquals("00002459566NF   00000000001320150110T NN000000000252779000000000000000068226000000000284792624", Assinador.gerarSeedAssinatura(rps));
	}

}
