package fr.jeanlouispiera.entities;



public enum UtilisateurRole {

	
	M ("MEMBRE"),
	V ("VISITEUR");
	

    private String inWords ;  
     
    private UtilisateurRole(String inWords) {  
        this.inWords = inWords;  
   }  
     
    public String getInWords() {  
        return  this.inWords ;  
   }  
	
	
	

}
