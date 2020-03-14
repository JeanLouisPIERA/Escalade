package fr.jeanlouispiera.entities;

public enum TopoStatut {
	
	DEM ("DEMANDE EN COURS"),
	PEC ("PRET EN COURS"),
	DIS ("DISPONIBLE");
	
	
	
    
    private String inWords ;  
     
    private TopoStatut(String inWords) {  
        this.inWords = inWords;  
   }  
     
    public String getInWords() {  
        return  this.inWords ;  
   }  

}
