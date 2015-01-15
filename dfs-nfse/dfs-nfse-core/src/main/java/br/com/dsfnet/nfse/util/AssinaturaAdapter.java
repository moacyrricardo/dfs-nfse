package br.com.dsfnet.nfse.util;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlAdapter;


public class AssinaturaAdapter extends XmlAdapter<String,byte[]> {
	HexBinaryAdapter hba = new HexBinaryAdapter();

	@Override
	public byte[] unmarshal(String v) throws Exception {
		if(v!= null){
			return hba.unmarshal(v.toUpperCase());
		}
		return hba.unmarshal(v);
	}

	@Override
	public String marshal(byte[] v) throws Exception {
		String ret = hba.marshal(v);
		if(ret != null){
			return ret.toLowerCase();
		}
		return ret;
	}

}
