package br.com.dsfnet.nfse.util;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class XMLGregorianCalendarAdapter extends XmlAdapter<String,XMLGregorianCalendar> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public XMLGregorianCalendarAdapter() {
		// TODO Auto-generated constructor stub
	}

	 @Override
	    public String marshal(XMLGregorianCalendar v) throws Exception {
	        return dateFormat.format(v.toGregorianCalendar().getTime());
	    }

    @Override
    public XMLGregorianCalendar unmarshal(String v) throws Exception {
    		
    	   GregorianCalendar gc = new GregorianCalendar();
           gc.setTimeInMillis(dateFormat.parse(v).getTime());
           
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
    }
}
