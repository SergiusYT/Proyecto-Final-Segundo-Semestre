package co.edu.unbosque.model;


import co.edu.unbosque.model.persistence.*;
import java.util.*;

public class Model {

	private User_DAO user_DAO;
	private User_DTO user_DTO;


//----------------------- contructor -------------------------------	
	
    public Model() {
        user_DAO = new User_DAO();
    }

    
 // ---------------------------- Metodos de la Persistencia ------------------------------------------------------   
    
    
    
    
    
      // .............. metodos de usuario Persistencia ...............................
    
    
	 // Agregar un usuario
	    public boolean agregarUsuario(User_DTO usuario) {
	        return user_DAO.agregarUsuario(usuario);
	    }
	
	    // Buscar un usuario por nombre de usuario
	    public User_DTO buscarUsuario(String username) {
	        return user_DAO.buscarUsuario(username);
	    }
	
	    // Obtener la lista de todos los usuarios
	    public ArrayList<User_DTO> obtenerTodosLosUsuarios() {
	      
	        return user_DAO.getUsuarios();
	    }
	    
	    
	    public User_DTO usuario(String username, String password) {
	    	
	    	 user_DTO = new User_DTO(username, password);
	    	 return user_DTO;

	    }
	    
	    public boolean validarInicioSesion(String username, String password) {
	        User_DTO usuario = buscarUsuario(username);
	        if (usuario != null && usuario.getPassword().equals(password)) {
	            return true; // Inicio de sesión exitoso
	        }
	        return false; // Inicio de sesión fallido
	    }
	    
	 
	    

	
	
	
}
