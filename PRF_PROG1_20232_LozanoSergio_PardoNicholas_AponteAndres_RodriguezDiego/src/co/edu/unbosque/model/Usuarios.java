package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.*;

public class Usuarios {

	private User_DAO user_DAO;

//----------------------- contructor -------------------------------	
	
    public Usuarios() {
        user_DAO = new User_DAO();
    }

    
 // ---------------------------- Metodos de la Persistencia ------------------------------------------------------   
    
      // .............. metodos de usuario Persistencia ...............................
    
  

    public boolean agregarUsuario(String username, String password) {
        if (username != null && !username.isEmpty() && password != null) {
            return user_DAO.agregarUsuario(username, password);
        }
        return false; // Datos de entrada no válidos
    }

    public User_DTO buscarUsuario(String username) {
        return user_DAO.buscarUsuario(username);
    }

    public ArrayList<User_DTO> obtenerTodosLosUsuarios() {
        return user_DAO.consultarUsuarios();
    }

    public boolean validarInicioSesion(String username, String password) {
        User_DTO userDTO = buscarUsuario(username);
        return userDTO != null && userDTO.getPassword().equals(password);
    }
}
	    

