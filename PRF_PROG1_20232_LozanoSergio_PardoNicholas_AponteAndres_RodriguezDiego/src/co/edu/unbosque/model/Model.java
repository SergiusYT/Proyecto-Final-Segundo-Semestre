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

    
 //------------------------------------- metodo para implementar las propiedades necesaria a la casa de apuestas ------------------------
    
    public void gestionarPropiedades(int numeroSedes, double presupuestoTOTAL) {
    	configuracion.escribirPropiedades(numeroSedes, presupuestoTOTAL);
    	
        double presupuestoPorJuego = configuracion.getPresupuestoPorJuego();
        
        // Pasamos el presupuesto por juego a los juegos específicos (puedes ajustar esto según tus necesidades)
        loteria.setPresupuestoParaLoteria(presupuestoPorJuego);
	}
    
    
 //------------------metodo donde pondra los datos necesarios de los apostadoires leidos por los archivos ------------------------------   
    
    
    
    public void setDatosNecesariosApostador(String username) {
    	
    	//cabe recalcar que todos los datos estaran vinculados directamente con el username porque estos son datos diferentes en cada usuario 
    	    	
    	    	
    	    //-------------------->   Loteria
    	    	
    	    	loteria.setUsuarioEnSesion(usuario.buscarNombreDeUsuarioApostador(username));	    	
    	    	loteria.setNombreRealApostador(usuario.getNombreReal(username));


    	    	
    	    }
    

    
    
    
//------------------------------- Metodos de manejo de excepciones -----------------------------------------    
    
    public void validarNumeroDigitos(String entrada) throws IllegalArgumentException {  
  		
           if (!entrada.matches("\\d{10}")){ 
	       // \\d: Representa cualquier dígito numérico.	         
	       // {10}: Indica que debe haber exactamente 10 dígitos numéricos ya que esos son la cantidad de digitos de un numero de celular.) 
              throw new IllegalArgumentException();
          //ocurrido un problema y lanze una excepcion especifica , donde cabe recalcar que esto es una instancia de la clase Throwable*/

          }    
    }     
           
    public void validarSiesNumero(String entrada) throws IllegalArgumentException{
         		
           if (!entrada.matches("\\d*")){     	      	         
    	       // d*: Indica que no tiene una longitudad exacta y son valores numericos unicamente.) 
                  throw new IllegalArgumentException();
              //ocurrido un problema y lanze una excepcion especifica , donde cabe recalcar que esto es una instancia de la clase Throwable*/

              }           
  }    
    
    
    
    
    
    
    
 // ---------------------------- Metodos que devuelven una clase ------------------------------------------------------   
    
    
	    public Usuarios getUsuarios() {
	    	return usuario;
	    }
	    
	 
	    
	    public Loteria getLoteria() {	    	
	    	
	    	return loteria;
	    }
	    
	    
	    

	
	
	
}
