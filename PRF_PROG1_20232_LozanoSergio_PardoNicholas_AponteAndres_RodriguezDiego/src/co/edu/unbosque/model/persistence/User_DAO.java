package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.*;

public class User_DAO {
 
	private ArrayList<User_DTO> usuarios = new ArrayList<>();
    private String archivo = "usuarios.dat";
	

	public User_DAO() {
		
        cargarUsuariosDesdeArchivo(); // Cargar usuarios al iniciar la aplicación
    
	}

    public boolean agregarUsuario(User_DTO usuario) {
    	
        if (buscarUsuario(usuario.getUsername()) == null) {
            usuarios.add(usuario);
            guardarUsuariosEnArchivo(); // Guardar la lista de usuarios en el archivo
            return true;
        }
        return false;
    }

    public User_DTO buscarUsuario(String username) {
        for (User_DTO usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return usuario;
            }
        }
        return null;
    }

    // Método para cargar usuarios desde el archivo .dat
    private void cargarUsuariosDesdeArchivo() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivo))) {
          
        	usuarios = (ArrayList<User_DTO>) inputStream.readObject();
        
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error al cargar, simplemente continuamos con la lista vacía
        }
    }

    // Método para guardar la lista de usuarios en el archivo .dat
    private void guardarUsuariosEnArchivo() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivo))) {
            outputStream.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}  
