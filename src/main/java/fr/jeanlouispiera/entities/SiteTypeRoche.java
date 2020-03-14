package fr.jeanlouispiera.entities;

public enum SiteTypeRoche {
	
	GRANIT ("GRANIT"),
	CALCAIRE ("CALCAIRE"),
	SCHISTE ("SCHISTE"),
	GNEISS ("GNEISS"),
	ARDOISE ("ARDOISE");

    private String inWords ;  
     
    private SiteTypeRoche(String inWords) {  
        this.inWords = inWords;  
   }  
     
    public String getInWords() {  
        return  this.inWords ;  
   }  
	
	
	

}
