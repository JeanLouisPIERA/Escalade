package fr.jeanlouispiera.entities;

public enum TopoStatut {
	
	DIS ("DIS", "Disponible"),
	DEM ("DEM", "Demande en Cours"),
	PEC ("PEC", "Pret En Cours");
	
	private String code;
	private String text;
	   
	private TopoStatut(String code, String text) {
		this.code = code;
		this.text = text;
	}
	   
	public static TopoStatut getTopoStatutByCode(String code) {
		for (TopoStatut topoStatut : TopoStatut.values()) {
			if(topoStatut.code.equals(code)){
				return topoStatut;
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
		if(this==DIS) {
			return"Disponible";
		}else if (this==DEM) {
			return"Demande en Cours";
		}else if (this==PEC) {
			return"Prêt en Cours";
		}
		return super.toString();
		
		}

   

}
