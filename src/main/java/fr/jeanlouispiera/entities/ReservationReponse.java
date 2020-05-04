package fr.jeanlouispiera.entities;

public enum ReservationReponse {
	
	ENCOURS("ENCOURS", "En cours"),
	ACCORD("ACCORD", "Accord"),
	REFUS("REFUS", "Refus");
	
	 private String code;
	  private String text;
	  
	private ReservationReponse(String code, String text) {
		this.code = code;
		this.text = text;
	}
	
	public static ReservationReponse getReservationReponseByCode(String code) {
		for (ReservationReponse reservationReponse : ReservationReponse.values()) {
			if(reservationReponse.code.equals(code)){
				return reservationReponse;
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
		if(this==ENCOURS) {
			return"En cours";
		}else if (this==ACCORD) {
			return"Accord";
		}else if (this==REFUS) {
			return"Refus";
		}
		return super.toString();
	}
	
	
}
