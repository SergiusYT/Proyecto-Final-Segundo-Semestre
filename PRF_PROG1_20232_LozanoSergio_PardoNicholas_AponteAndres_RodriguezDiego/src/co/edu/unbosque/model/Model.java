package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ConfiguracionCasaApuestas;

public class Model {

	private ConfiguracionCasaApuestas configuracion;
	private Usuarios usuario; 
	private Loteria loteria;

//----------------------- contructor -------------------------------	
	
    public Model() {
    	
    	configuracion = new ConfiguracionCasaApuestas();
    	
    	usuario = new Usuarios();
        loteria = new Loteria();
    }

    
    
    public void gestionarPropiedades(int numeroSedes, double presupuestoTOTAL) {
    	configuracion.escribirPropiedades(numeroSedes, presupuestoTOTAL);
    	
        double presupuestoPorJuego = configuracion.getPresupuestoPorJuego();
        
        // Pasamos el presupuesto por juego a los juegos específicos (puedes ajustar esto según tus necesidades)
        loteria.setPresupuestoParaLoteria(presupuestoPorJuego);
	}
    
      
    
    
 // ---------------------------- Metodos de devuelven una clase ------------------------------------------------------   
    
    
	    public Usuarios getUsuarios() {
	    	return usuario;
	    }
	    
	    public void setDatosNecesariosApostador(String nombre) {
	    	
	    	loteria.setUsuarioEnSesion(usuario.buscarNombreApostador(nombre));

	    	
	    }
	    
	    public Loteria getLoteria() {	    	
	    	
	    	return loteria;
	    }
	    
	    
	    

	
	
	
}
