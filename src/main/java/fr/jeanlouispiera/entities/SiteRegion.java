package fr.jeanlouispiera.entities;


public enum SiteRegion{
	AUV ("AUV", "Auvergne"),
	BOU ("BOU", "Bourgogne Franche-Comté"),
	COR ("COR", "Corse"),
	GES ("GES", "Grand-est"),
	OCC ("OCC", "Occitanie"),
	PAC ("PAC", "Paca"),
	REU ("REU", "Réunion"),
	GUA ("GUA", "Guadeloupe"),
	MIL ("MIL", "Milan"),
	MAR ("MAR", "Martinique");

   private String code;
   private String text;
   
private SiteRegion(String code, String text) {
	this.code = code;
	this.text = text;
}
   
public static SiteRegion getSiteRegionByCode(String code) {
	for (SiteRegion siteRegion : SiteRegion.values()) {
		if(siteRegion.code.equals(code)){
			return siteRegion;
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
	if(this==AUV) {
		return"Auvergne";
	}else if (this==COR) {
		return"Corse";
	}else if (this==BOU) {
		return"Bourgogne";
	}else if (this==GES) {
		return"Grand Est";
	}else if (this==OCC) {
		return"Occitanie";
	}else if (this==PAC) {
		return"PACA";
	}else if (this==REU) {
		return"Réunion";
	}else if (this==GUA) {
		return"Guadeloupe";
	}else if (this==MAR) {
		return"Martinique";
	}else if (this==MIL) {
		return"Milan";

	}
	return super.toString();
	
	}

}
