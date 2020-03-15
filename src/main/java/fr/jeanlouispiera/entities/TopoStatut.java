package fr.jeanlouispiera.entities;

public enum TopoStatut {
	
	DIS ("DISPONIBLE"),
	DEM ("DEMANDE EN COURS"),
	PEC ("PRET EN COURS");
	
    
    private String inWords ;  
     
    private TopoStatut(String inWords) {  
        this.inWords = inWords;  
   }  
     
    public String getInWords() {  
        return  this.inWords ;  
   }  

}
