package fr.jeanlouispiera.entities;



public enum SiteCotation {
	
	C3 ("3"),
	C31("3+"),
	C41("4a"),
	C42("4b"),
	C43("4c"),
	C51("5b"),
	C62("6a+"),
	C74("7d+"),
	C85("8c"),
	C92 ("9a+");
    
    private String inWords ;  
     
    private SiteCotation(String inWords) {  
        this.inWords = inWords;  
   }  
     
    public String getInWords() {  
        return  this.inWords ;  
   }  
	
	
	
	
	
	
	

}
