package fr.jeanlouispiera.entities;

public enum SiteOrientation {
	
		N ("N", "Nord"),
		NE ("NE", "Nord-Est"),
		NO ("NO", "Nord-Ouest"),
		E ("E", "Est"),
		O ("O", "Ouest"),
		S ("S", "Sud"),
		SE ("S", "Sud-Est"),
		SO("SO", "Sud-Ouest");

   private String code;
   private String text;
   
private SiteOrientation(String code, String text) {
	this.code = code;
	this.text = text;
}
   
public static SiteOrientation getOrientationByCode(String code) {
	for (SiteOrientation siteOrientation : SiteOrientation.values()) {
		if(siteOrientation.code.equals(code)){
			return siteOrientation;
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
	if(this==N) {
		return"Nord";
	}else if (this==NE) {
		return"Nord-Est";
	}else if (this==NO) {
		return "Nord-Ouest";
	}else if (this==E) {
		return"Est";
	}else if (this==O) {
		return"Ouest";
	}else if (this==S) {
		return"Sud";
	}else if (this==SE) {
		return"Sud-Est";
	}else if (this==SO) {
		return"Sud-Ouest";
	}
	
	return super.toString();
	
	}
}
	
	
	

