package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.User_DAO;
import co.edu.unbosque.model.persistence.User_DTO;

public class Usuarios {

	private User_DAO user_DAO;
	private User_DTO user_DTO;

//----------------------- contructor -------------------------------	
	
    public Usuarios() {
        user_DAO = new User_DAO();
    }

    
 // ---------------------------- Metodos de la Persistencia ------------------------------------------------------   
    
      // .............. metodos de usuario Persistencia ...............................
    
    
	 // Agregar un usuario
    public boolean agregarUsuario(String username, String password) {
    	
        return user_DAO.agregarUsuario(user_DTO = new User_DTO(username, password));
    }
    

    // Buscar un usuario por nombre de usuario
    public User_DTO buscarUsuario(String username) {
        return user_DAO.buscarUsuario(username);
    }

    // Obtener la lista de todos los usuarios
    public ArrayList<User_DTO> obtenerTodosLosUsuarios() {
      
        return user_DAO.consultarUsuarios();
    }
    
    
  // Validacion para el inicion de sesión
    
    public boolean validarInicioSesion(String username, String password) {
        user_DTO = buscarUsuario(username);
        if (user_DTO != null && user_DTO.getPassword().equals(password)) {
            return true; // Inicio de sesión exitoso
        }
        return false; // Inicio de sesión fallido
    }
	    
}
