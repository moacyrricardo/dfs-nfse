package br.com.dsfnet.nfse.wsnfe2.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoBairro {
	Bairro,
	Bosque,
	Chácara,
	Conjunto,
	Desmembramento,
	Distrito,
	Favela,
	Fazenda,
	Gleba,
	Horto,
	Jardim,
	Loteamento,
	Núcleo,
	Parque,
	Residencial,
	Sítio,
	Tropical,
	Vila,
	Zona,
	;
	
	private String name;
	
	private TipoBairro() {
	}

	private TipoBairro(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		if(name != null)
			return name;
		return super.toString();
	}
	
	static Map<String, TipoBairro> map = new HashMap<String,TipoBairro>();
	static {
		for(TipoBairro tp: values()){
			map.put(tp.name().toLowerCase(),tp);
			if(tp.getName() != null){
				map.put(tp.getName().toLowerCase(),tp);
			}
		}
	}
	
	public static TipoBairro from(String bairro){
		bairro = bairro.toLowerCase();
		for(Map.Entry<String, TipoBairro> en:map.entrySet()){
			if(bairro.startsWith(en.getKey())){
				return en.getValue();
			}
		}
		return null;
	}
}
