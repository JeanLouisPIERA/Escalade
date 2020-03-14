package fr.jeanlouispiera.entities;

public enum SiteTag {
	
		AMIS ("OFFICIEL LES AMIS DE L'ESCALADE"), 
		PAS ("AUCUN TAG");

	    
	    private String inWords ;  
	     
	    private SiteTag(String inWords) {  
	        this.inWords = inWords;  
	   }  
	     
	    public String getInWords() {  
	        return  this.inWords ;  
	   }  

}
