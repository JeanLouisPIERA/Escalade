package fr.jeanlouispiera.entities;

public enum SiteTypeRoche {
	
	GRANIT ("GRANIT", "Granit"),
	CALCAIRE ("CALCAIRE", "Granit"),
	SCHISTE ("SCHISTE", "Schiste"),
	GNEISS ("GNEISS", "Gneiss"),
	ARDOISE ("ARDOISE", "Ardoise");

	 private String code;
	   private String text;
	   
	private SiteTypeRoche(String code, String text) {
		this.code = code;
		this.text = text;
	}
	   
	public static SiteTypeRoche getSiteTypeRocheByCode(String code) {
		for (SiteTypeRoche siteTypeRoche : SiteTypeRoche.values()) {
			if(siteTypeRoche.code.equals(code)){
				return siteTypeRoche;
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
		if(this==GRANIT) {
			return"Granit";
		}else if (this==CALCAIRE) {
			return"Calcaire";
		}else if (this==SCHISTE) {
			return"Schiste";
		}else if (this==GNEISS) {
			return"Gneiss";
		}else if (this==ARDOISE) {
			return"ARDOISE";

		}
		return super.toString();
		
		}

	}
	
	
	

