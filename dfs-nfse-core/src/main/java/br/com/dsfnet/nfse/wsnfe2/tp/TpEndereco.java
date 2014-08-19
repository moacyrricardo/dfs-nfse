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
 * Tipo Endereço.
 * 
 * <p>Java class for tpEndereco complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tpEndereco">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TipoLogradouro" type="{http://localhost:8080/WsNFe2/tp}tpTipoLogradouro" minOccurs="0"/>
 *         &lt;element name="Logradouro" type="{http://localhost:8080/WsNFe2/tp}tpLogradouro" minOccurs="0"/>
 *         &lt;element name="NumeroEndereco" type="{http://localhost:8080/WsNFe2/tp}tpNumeroEndereco" minOccurs="0"/>
 *         &lt;element name="ComplementoEndereco" type="{http://localhost:8080/WsNFe2/tp}tpComplementoEndereco" minOccurs="0"/>
 *         &lt;element name="TipoBairro" type="{http://localhost:8080/WsNFe2/tp}tpTipoBairro" minOccurs="0"/>
 *         &lt;element name="Bairro" type="{http://localhost:8080/WsNFe2/tp}tpBairro" minOccurs="0"/>
 *         &lt;element name="Cidade" type="{http://localhost:8080/WsNFe2/tp}tpCidade" minOccurs="0"/>
 *         &lt;element name="UF" type="{http://localhost:8080/WsNFe2/tp}tpUF" minOccurs="0"/>
 *         &lt;element name="CEP" type="{http://localhost:8080/WsNFe2/tp}tpCEP" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tpEndereco", propOrder = {
    "tipoLogradouro",
    "logradouro",
    "numeroEndereco",
    "complementoEndereco",
    "tipoBairro",
    "bairro",
    "cidade",
    "uf",
    "cep"
})
public class TpEndereco {

    @XmlElement(name = "TipoLogradouro")
    protected String tipoLogradouro;
    @XmlElement(name = "Logradouro")
    protected String logradouro;
    @XmlElement(name = "NumeroEndereco")
    protected String numeroEndereco;
    @XmlElement(name = "ComplementoEndereco")
    protected String complementoEndereco;
    @XmlElement(name = "TipoBairro")
    protected String tipoBairro;
    @XmlElement(name = "Bairro")
    protected String bairro;
    @XmlElement(name = "Cidade")
    protected Long cidade;
    @XmlElement(name = "UF")
    protected String uf;
    @XmlElement(name = "CEP")
    protected Integer cep;

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
     * Gets the value of the logradouro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * Sets the value of the logradouro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogradouro(String value) {
        this.logradouro = value;
    }

    /**
     * Gets the value of the numeroEndereco property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    /**
     * Sets the value of the numeroEndereco property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroEndereco(String value) {
        this.numeroEndereco = value;
    }

    /**
     * Gets the value of the complementoEndereco property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    /**
     * Sets the value of the complementoEndereco property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComplementoEndereco(String value) {
        this.complementoEndereco = value;
    }

    /**
     * Gets the value of the tipoBairro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoBairro() {
        return tipoBairro;
    }

    /**
     * Sets the value of the tipoBairro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoBairro(String value) {
        this.tipoBairro = value;
    }

    /**
     * Gets the value of the bairro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Sets the value of the bairro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBairro(String value) {
        this.bairro = value;
    }

    /**
     * Gets the value of the cidade property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCidade() {
        return cidade;
    }

    /**
     * Sets the value of the cidade property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCidade(Long value) {
        this.cidade = value;
    }

    /**
     * Gets the value of the uf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUF() {
        return uf;
    }

    /**
     * Sets the value of the uf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUF(String value) {
        this.uf = value;
    }

    /**
     * Gets the value of the cep property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCEP() {
        return cep;
    }

    /**
     * Sets the value of the cep property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCEP(Integer value) {
        this.cep = value;
    }

}
