package fr.jeanlouispiera.entities;

public enum SiteTag {
	
		AMIS ("AMIS","Tag Officiel"), 
		PAS ("PAS","Non Homologué");

	 private String code;
	   private String text;
	   
	private SiteTag(String code, String text) {
		this.code = code;
		this.text = text;
	}
	   
	public static SiteTag getSiteTagByCode(String code) {
		for (SiteTag siteTag : SiteTag.values()) {
			if(siteTag.code.equals(code)){
				return siteTag;
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
		if(this==AMIS) {
			return"Tag Officiel";
		}else if (this==PAS) {
			return"Non Homologué";
		}
		return super.toString();
		
		}

	}