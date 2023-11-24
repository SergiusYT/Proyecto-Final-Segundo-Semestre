	package co.edu.unbosque.model;
	
	import java.util.ArrayList;
	import java.util.Calendar;
	import java.util.Date;
	
	import co.edu.unbosque.model.persistence.*;
	
	public class Usuarios {
	
		private User_DAO user_DAO;
	    private int edad;
		
	//----------------------- contructor -------------------------------	
		
	    public Usuarios() {
	        user_DAO = new User_DAO();
	    }
	
	    
	 // ---------------------------- Metodos de la Persistencia ------------------------------------------------------   
	    
	      // .............. metodos de usuario Persistencia ...............................
	    
	  
	
	    public boolean agregarUsuario(String username, String password, String nombreApostador, int edad, String cedula, String sede, String direccion, String celular) {
	    	
	        if (username != null && !username.isEmpty() && password != null && !password.isEmpty() ) {
	         
	        	return user_DAO.agregarUsuario(username, password, nombreApostador, edad, cedula, sede, direccion,  celular);
	        }
	        
	        return false; // Datos de entrada no válidos
	    }
	
	    public String buscarNombreDeUsuarioApostador(String username) {
	        return user_DAO.buscarUsuario(username);
	    }
	
	    public String obtenerTodosLosUsuarios() {
	        return user_DAO.consultarUsuarios();
	    }
	    
	    public int calcularEdad(Date fechaSeleccionada) {
	        if (fechaSeleccionada != null) {
	            Calendar fechaNacimiento = Calendar.getInstance();
	            fechaNacimiento.setTime(fechaSeleccionada);
	
	            Calendar fechaActual = Calendar.getInstance();
	
	             edad = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
	
	            // Ajuste adicional para casos en que aún no ha llegado el cumpleaños de este año
	            if (fechaActual.get(Calendar.DAY_OF_YEAR) < fechaNacimiento.get(Calendar.DAY_OF_YEAR)) {
	                edad--;
	            }
	
	            return edad;
	        } else {
	            return -1; // Indica que no se ha seleccionado una fecha
	        }
	    }
	  
	    public boolean validarInicioSesion(String username, String password) {
	     // Verificar si el usuario y la contraseña coinciden
	
	        return user_DAO.buscarUsuario(username) != null && user_DAO.comparararPassword(password) != null;
	    }
	    
	   public String getNombreReal(String nombre) {
		        return user_DAO.obtenerNombreReal(nombre);
		    
		
	   }
	   
	   public String getCedula(String nombre) {
	       return user_DAO.obtenerCedula(nombre);
	   }
	
	   public String getSededelApostador(String nombre) {
	       return user_DAO.obtenerSedeJugadaPorElApostador(nombre);
	   }
	   
	   
	  public int getEdad() {
		  return edad;
	  }
	   
	   
	}
		    
	
