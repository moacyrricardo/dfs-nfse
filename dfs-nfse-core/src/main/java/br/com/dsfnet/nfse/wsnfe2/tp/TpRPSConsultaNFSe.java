//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.08.19 at 01:26:29 PM BRT 
//


package br.com.dsfnet.nfse.wsnfe2.tp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo Detalhes do RPSSe.
 * 
 * <p>Java class for tpRPSConsultaNFSe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tpRPSConsultaNFSe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InscricaoMunicipalPrestador" type="{http://localhost:8080/WsNFe2/tp}tpInscricaoMunicipal"/>
 *         &lt;element name="NumeroRPS" type="{http://localhost:8080/WsNFe2/tp}tpNumero"/>
 *         &lt;element name="SeriePrestacao" type="{http://localhost:8080/WsNFe2/tp}tpSeriePrestacao"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tpRPSConsultaNFSe", propOrder = {
    "inscricaoMunicipalPrestador",
    "numeroRPS",
    "seriePrestacao"
})
public class TpRPSConsultaNFSe {

    @XmlElement(name = "InscricaoMunicipalPrestador")
    protected long inscricaoMunicipalPrestador;
    @XmlElement(name = "NumeroRPS")
    protected int numeroRPS;
    @XmlElement(name = "SeriePrestacao")
    protected byte seriePrestacao;
    @XmlAttribute(name = "Id")
    protected String id;

    /**
     * Gets the value of the inscricaoMunicipalPrestador property.
     * 
     */
    public long getInscricaoMunicipalPrestador() {
        return inscricaoMunicipalPrestador;
    }

    /**
     * Sets the value of the inscricaoMunicipalPrestador property.
     * 
     */
    public void setInscricaoMunicipalPrestador(long value) {
        this.inscricaoMunicipalPrestador = value;
    }

    /**
     * Gets the value of the numeroRPS property.
     * 
     */
    public int getNumeroRPS() {
        return numeroRPS;
    }

    /**
     * Sets the value of the numeroRPS property.
     * 
     */
    public void setNumeroRPS(int value) {
        this.numeroRPS = value;
    }

    /**
     * Gets the value of the seriePrestacao property.
     * 
     */
    public byte getSeriePrestacao() {
        return seriePrestacao;
    }

    /**
     * Sets the value of the seriePrestacao property.
     * 
     */
    public void setSeriePrestacao(byte value) {
        this.seriePrestacao = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
