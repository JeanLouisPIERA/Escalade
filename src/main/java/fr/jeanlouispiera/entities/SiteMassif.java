package fr.jeanlouispiera.entities;

public enum SiteMassif {
	
	ALP ("ALP", "Alpes"),
	PYR ("PYR", "Pyrénées"),
	MAC ("MAC", "Massif Central"),
	VOS ("VOS", "Vosges"),
	JUR ("JUR", "Jura"), 
	ARD ("ARD", "Monts d'Ardèche");
	
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
	
	
   
	
	


