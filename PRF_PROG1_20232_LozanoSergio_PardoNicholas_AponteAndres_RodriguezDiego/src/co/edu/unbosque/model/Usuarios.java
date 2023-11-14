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

    public String buscarNombreApostador(String nombre) {
        return user_DAO.buscarUsuario(nombre);
    }

    public ArrayList<User_DTO> obtenerTodosLosUsuarios() {
        return user_DAO.consultarUsuarios();
    }

    public String obtenerNombreApostador() {
        return user_DAO.consultarNombreApostadorEnSesion();
    }
    
    public boolean validarInicioSesion(String username, String password) {
     // Verificar si el usuario y la contraseña coinciden

        return user_DAO.buscarUsuario(username) != null && user_DAO.comparararPassword(password) != null;
    }
}
	    

