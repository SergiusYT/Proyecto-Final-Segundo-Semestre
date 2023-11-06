package co.edu.unbosque.model;



public class Model {

	private Usuarios usuario; 
	private Loteria loteria;

//----------------------- contructor -------------------------------	
	
    public Model() {
    	
    	usuario = new Usuarios();
        loteria = new Loteria();
    }

    
 // ---------------------------- Metodos de devuelven un clase ------------------------------------------------------   
    
    
	    public Usuarios getUsuarios() {
	    	return usuario;
	    }
	    
	    public Loteria getLoteria() {
	    	
	    	return loteria;
	    }
	    
	    
	    

	
	
	
}
