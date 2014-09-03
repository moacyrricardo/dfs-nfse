package br.com.dsfnet.nfse.services;

/**
 * XML Signature: Based on code found at http://www.xinotes.net/notes/note/751/
 * 
 * @author <a href="mailto:mpereira@quintoandar.com.br">moa</a>
 *
 */
public enum TipoAssinatura {
	/**
	 * Define que procurará um elemento com id que <i>match</i> o criterio de busca
	 */
	POR_ID, 
	/**
	 * Define que procurará um elemento com seletor XPATH que <i>match</i> o criterio de busca
	 */
	POR_PATH, 
	/**
	 * Define que a assinatura usara o documento por completo
	 */
	POR_DOCUMENTO
}