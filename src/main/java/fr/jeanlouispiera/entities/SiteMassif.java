package fr.jeanlouispiera.entities;

public enum SiteMassif {
	
	ALP ("ALP", "Alpes"),
	JUR ("JUR", "Jura"), 
	MAC ("MAC", "Massif Central"),
	ARD ("ARD", "Monts d'Ardèche"),
	PYR ("PYR", "Pyrénées"),
	VOS ("VOS", "Vosges");
	
   private String code;
   private String text;
   
private SiteMassif(String code, String text) {
	this.code = code;
	this.text = text;
}
   
public static SiteMassif getSiteMassifByCode(String code) {
	for (SiteMassif siteMassif : SiteMassif.values()) {
		if(siteMassif.code.equals(code)){
			return siteMassif;
		}
	}
	return null;
}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}

@Override
public String toString() {
	if(this==ALP) {
		return"Alpes";
	}else if (this==PYR) {
		return"Pyrénées";
	}else if (this==MAC) {
		return "Massif Central";
	}else if (this==VOS) {
		return"Vosges";
	}else if (this==JUR) {
		return"Jura";
	}else if (this==ARD) {
		return"Monts d'Ardèche";
	}
	return super.toString();
	
	}
}
	
	
   
	
	


