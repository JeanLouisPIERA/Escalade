package fr.jeanlouispiera.entities;

public enum SiteMassif {
	
	ALP ("ALPES"),
	PYR ("PYRENEES"),
	MAC ("MASSIF CENTRAL"),
	VOS ("VOSGES"),
	JUR ("JURA");
	
	
    
    private String inWords ;  
     
    private SiteMassif(String inWords) {  
        this.inWords = inWords;  
   }  
     
    public String getInWords() {  
        return  this.inWords ;  
   }  
	
	
	

}
