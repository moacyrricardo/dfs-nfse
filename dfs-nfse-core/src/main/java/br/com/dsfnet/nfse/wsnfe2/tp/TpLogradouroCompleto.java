//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.08.19 at 01:26:29 PM BRT 
//


package br.com.dsfnet.nfse.wsnfe2.tp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Informações do Logradouro com o seu Tipo.
 * 
 * <p>Java class for tpLogradouroCompleto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tpLogradouroCompleto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TipoLogradouro" type="{http://localhost:8080/WsNFe2/tp}tpTipoLogradouro"/>
 *         &lt;element name="NomeLogradouro" type="{http://localhost:8080/WsNFe2/tp}tpLogradouro"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tpLogradouroCompleto", propOrder = {
    "tipoLogradouro",
    "nomeLogradouro"
})
public class TpLogradouroCompleto {

    @XmlElement(name = "TipoLogradouro", required = true)
    protected String tipoLogradouro;
    @XmlElement(name = "NomeLogradouro", required = true)
    protected String nomeLogradouro;

    /**
     * Gets the value of the tipoLogradouro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    /**
     * Sets the value of the tipoLogradouro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoLogradouro(String value) {
        this.tipoLogradouro = value;
    }

    /**
     * Gets the value of the nomeLogradouro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    /**
     * Sets the value of the nomeLogradouro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeLogradouro(String value) {
        this.nomeLogradouro = value;
    }

}
