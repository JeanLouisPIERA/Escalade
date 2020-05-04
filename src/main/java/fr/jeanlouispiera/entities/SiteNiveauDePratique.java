package fr.jeanlouispiera.entities;


public enum SiteNiveauDePratique {
	INITIATION ("INITIATION", "Initiation"),
	DEBUTANT ("DEBUTANT", "Débutant"),
	CONFIRME ("CONFIRME", "Confirmé"),
	ENGAGE ("ENGAGE", "Engagé"),
	SPORTIF ("SPORTIF", "Sportif"),
	ENFANT ("ENFANT", "Enfant");

   private String code;
   private String text;
   
private SiteNiveauDePratique(String code, String text) {
	this.code = code;
	this.text = text;
}
   
public static SiteNiveauDePratique getNiveauDePratiqueByCode(String code) {
	for (SiteNiveauDePratique siteNiveauDePratique : SiteNiveauDePratique.values()) {
		if(siteNiveauDePratique.code.equals(code)){
			return siteNiveauDePratique;
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
	if(this==INITIATION) {
		return"Initiation";
	}else if (this==DEBUTANT) {
		return"Débutant";
	}else if (this==CONFIRME) {
		return "Confirmé";
	}else if (this==ENGAGE) {
		return"Engagé";
	}else if (this==SPORTIF) {
		return"Sportif";
	}else if (this==ENFANT) {
		return"Possible avec Enfants";
	}
	return super.toString();
	
	}
}
	
	
	


