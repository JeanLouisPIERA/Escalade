package fr.jeanlouispiera.entities;



public enum SiteCotation {
	
	C3 ("C3", "3"),
	C31("C31", "3+"),
	C41("C41", "4a"),
	C42("C42", "4b"),
	C43("C43", "4c"),
	C51("C51", "5b"),
	C62("C62", "6a+"),
	C74("C74", "7d+"),
	C85("C85", "8c"),
	C92("C92", "9a+");
    
	

   private String code;
   private String text;
   
private SiteCotation(String code, String text) {
	this.code = code;
	this.text = text;
}
   
public static SiteCotation getSiteCotationByCode(String code) {
	for (SiteCotation siteCotation : SiteCotation.values()) {
		if(siteCotation.code.equals(code)){
			return siteCotation;
		}
	}
	return null;
}

public static SiteCotation getSiteCotationByText(String text) {
	for (SiteCotation siteCotation : SiteCotation.values()) {
		if(siteCotation.text.equals(text)){
			return siteCotation;
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
	if(this==C3) {
		return"3";
	}else if (this==C31) {
		return"3+";
	}else if (this==C41) {
		return"4a";
	}else if (this==C42) {
		return"4b";
	}else if (this==C43) {
		return"4c";
	}else if (this==C51) {
		return"5b";
	}else if (this==C62) {
		return"6a+";
	}else if (this==C74) {
		return"7d+";
	}else if (this==C85) {
		return"8c";
	}else if (this==C92) {
		return"9a+";

	}
	return super.toString();
	
	}

}
	
	
	
	
	
	
	

