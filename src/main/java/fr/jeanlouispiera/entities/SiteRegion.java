package fr.jeanlouispiera.entities;


public enum SiteRegion{
	AUV ("AUVERGNE"),
	BOU ("BOURGOGNE FRANCHE COMTE"),
	COR ("CORSE"),
	GES ("GRAND EST"),
	OCC ("OCCITANiE"),
	PAC ("PACA"),
	REU ("REUNION"),
	GUA ("GUADELOUPE"),
	MAR ("MARTINIQUE");

    private String inWords ;  
     
    private SiteRegion(String inWords) {  
        this.inWords = inWords;  
   }  
     
    public String getInWords() {  
        return  this.inWords ;  
   }  
	
	
	

}
