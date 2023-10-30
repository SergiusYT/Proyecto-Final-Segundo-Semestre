package co.edu.unbosque.model;


import co.edu.unbosque.model.persistence.*;
import java.util.*;

public class Model {

	private User_DAO user_DAO;

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
	        // Si es necesario, puedes implementar este método en UsuarioDAO
	        // y luego llamarlo desde aquí
	        return user_DAO.getUsuarios();
	    }

	
	
	
}
