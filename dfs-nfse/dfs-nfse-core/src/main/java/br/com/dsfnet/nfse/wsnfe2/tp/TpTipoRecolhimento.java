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
 * <p>Java class for tpTipoRecolhimento.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tpTipoRecolhimento">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="R"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tpTipoRecolhimento")
@XmlEnum
public enum TpTipoRecolhimento {


    /**
     * A Recolher.
     * 
     */
    A,

    /**
     * Retido na Fonte.
     * 
     */
    R;

    public String value() {
        return name();
    }

    public static TpTipoRecolhimento fromValue(String v) {
        return valueOf(v);
    }

}
