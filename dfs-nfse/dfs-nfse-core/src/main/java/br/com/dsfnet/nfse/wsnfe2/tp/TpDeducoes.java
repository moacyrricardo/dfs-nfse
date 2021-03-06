//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.08.19 at 01:26:29 PM BRT 
//


package br.com.dsfnet.nfse.wsnfe2.tp;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo deduções de nota fiscal.
 * 
 * <p>Java class for tpDeducoes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tpDeducoes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DeducaoPor" type="{http://localhost:8080/WsNFe2/tp}tpDeducaoPor"/>
 *         &lt;element name="TipoDeducao" type="{http://localhost:8080/WsNFe2/tp}tpTipoDeducao"/>
 *         &lt;element name="CPFCNPJReferencia" type="{http://localhost:8080/WsNFe2/tp}tpCPFCNPJnulo" minOccurs="0"/>
 *         &lt;element name="NumeroNFReferencia" type="{http://localhost:8080/WsNFe2/tp}tpNumeroNFReferencia" minOccurs="0"/>
 *         &lt;element name="ValorTotalReferencia" type="{http://localhost:8080/WsNFe2/tp}tpValor" minOccurs="0"/>
 *         &lt;element name="PercentualDeduzir" type="{http://localhost:8080/WsNFe2/tp}tpPercentual"/>
 *         &lt;element name="ValorDeduzir" type="{http://localhost:8080/WsNFe2/tp}tpValor"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tpDeducoes", propOrder = {
    "deducaoPor",
    "tipoDeducao",
    "cpfcnpjReferencia",
    "numeroNFReferencia",
    "valorTotalReferencia",
    "percentualDeduzir",
    "valorDeduzir"
})
public class TpDeducoes {

    @XmlElement(name = "DeducaoPor", required = true)
    protected TpDeducaoPor deducaoPor;
    @XmlElement(name = "TipoDeducao", required = true)
    protected String tipoDeducao;
    @XmlElement(name = "CPFCNPJReferencia")
    protected String cpfcnpjReferencia;
    @XmlElement(name = "NumeroNFReferencia")
    protected Long numeroNFReferencia;
    @XmlElement(name = "ValorTotalReferencia")
    protected BigDecimal valorTotalReferencia;
    @XmlElement(name = "PercentualDeduzir", required = true)
    protected BigDecimal percentualDeduzir;
    @XmlElement(name = "ValorDeduzir", required = true)
    protected BigDecimal valorDeduzir;

    /**
     * Gets the value of the deducaoPor property.
     * 
     * @return
     *     possible object is
     *     {@link TpDeducaoPor }
     *     
     */
    public TpDeducaoPor getDeducaoPor() {
        return deducaoPor;
    }

    /**
     * Sets the value of the deducaoPor property.
     * 
     * @param value
     *     allowed object is
     *     {@link TpDeducaoPor }
     *     
     */
    public void setDeducaoPor(TpDeducaoPor value) {
        this.deducaoPor = value;
    }

    /**
     * Gets the value of the tipoDeducao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDeducao() {
        return tipoDeducao;
    }

    /**
     * Sets the value of the tipoDeducao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDeducao(String value) {
        this.tipoDeducao = value;
    }

    /**
     * Gets the value of the cpfcnpjReferencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPFCNPJReferencia() {
        return cpfcnpjReferencia;
    }

    /**
     * Sets the value of the cpfcnpjReferencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPFCNPJReferencia(String value) {
        this.cpfcnpjReferencia = value;
    }

    /**
     * Gets the value of the numeroNFReferencia property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumeroNFReferencia() {
        return numeroNFReferencia;
    }

    /**
     * Sets the value of the numeroNFReferencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumeroNFReferencia(Long value) {
        this.numeroNFReferencia = value;
    }

    /**
     * Gets the value of the valorTotalReferencia property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorTotalReferencia() {
        return valorTotalReferencia;
    }

    /**
     * Sets the value of the valorTotalReferencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorTotalReferencia(BigDecimal value) {
        this.valorTotalReferencia = value;
    }

    /**
     * Gets the value of the percentualDeduzir property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPercentualDeduzir() {
        return percentualDeduzir;
    }

    /**
     * Sets the value of the percentualDeduzir property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPercentualDeduzir(BigDecimal value) {
        this.percentualDeduzir = value;
    }

    /**
     * Gets the value of the valorDeduzir property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorDeduzir() {
        return valorDeduzir;
    }

    /**
     * Sets the value of the valorDeduzir property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorDeduzir(BigDecimal value) {
        this.valorDeduzir = value;
    }

}
