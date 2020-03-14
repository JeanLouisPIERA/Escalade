package fr.jeanlouispiera.entities;


public enum SiteNiveauDePratique {
	INITIATION ("INITIATION"),
	DEBUTANT ("DEBUTANT"),
	CONFIRME ("CONFIRME"),
	ENGAGE ("ENGAGE"),
	SPORTIF ("SPORTIF"),
	ENFANT ("ENFANT");

    
    private String inWords ;  
     
    private SiteNiveauDePratique(String inWords) {  
        this.inWords = inWords;  
   }  
     
    public String getInWords() {  
        return  this.inWords ;  
   }  
}
	


