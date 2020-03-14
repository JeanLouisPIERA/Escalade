package fr.jeanlouispiera.entities;

public enum SiteOrientation {
	
		N ("NORD"),
		NE ("NORD-EST"),
		NO ("NORD-OUEST"),
		E ("EST"),
		O ("OUEST"),
		S ("SUD"),
		SE ("SUD-EST"),
		SO("SUD-OUEST");

	    private String inWords ;  
	     
	    private SiteOrientation(String inWords) {  
	        this.inWords = inWords;  
	   }  
	     
	    public String getInWords() {  
	        return  this.inWords ;  
	   }  
	

}
