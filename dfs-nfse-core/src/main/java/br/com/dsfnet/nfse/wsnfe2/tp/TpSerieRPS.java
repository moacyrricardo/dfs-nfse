//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.08.19 at 01:26:29 PM BRT 
//


package br.com.dsfnet.nfse.wsnfe2.tp;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tpSerieRPS.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tpSerieRPS">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tpSerieRPS")
@XmlEnum
public enum TpSerieRPS {


    /**
     * Nota Fiscal de Servicos
     * 
     */
    NF;

    public String value() {
        return name();
    }

    public static TpSerieRPS fromValue(String v) {
        return valueOf(v);
    }

}
