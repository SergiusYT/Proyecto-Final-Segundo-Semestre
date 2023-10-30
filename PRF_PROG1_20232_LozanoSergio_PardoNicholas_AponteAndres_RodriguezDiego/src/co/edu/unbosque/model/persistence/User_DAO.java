package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.*;

public class User_DAO {
 
	private ArrayList<User_DTO> usuarios = new ArrayList<>();
    private String archivo = "usuarios.dat";
	

	public User_DAO() {
		
        cargarUsuariosDesdeArchivo(); // Cargar usuarios al iniciar el programa
    
	}

// -------------- metodo para agregar un usuario --------------------------------
	
    public boolean agregarUsuario(User_DTO usuario) {
    	
    	// verifcar si el usuario ya existe
    	
        if (buscarUsuario(usuario.getUsername()) == null) {   // se llama el metodo de buscarUsario para ver si este se encuentra ya registrado
            usuarios.add(usuario); 
            guardarUsuariosEnArchivo(); // Guardar la lista de usuarios en el archivo
            return true; // Indicar que el usuario se agregó exitosamente
        }
        
        return false; // Indicar que el usuario ya existe y no se pudo agregar
    
    }
    
    
    
    
    // Buscar un usuario por su nombre de usuario
    
    public User_DTO buscarUsuario(String username) {
        for (User_DTO usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                
            	return usuario;// Devolver el usuario si se encuentra
            }
        }
        return null; // Devolver null si el usuario no se encuentra
    }

    // Método para cargar usuarios desde el archivo .dat
    @SuppressWarnings("unchecked")
	public void cargarUsuariosDesdeArchivo() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivo))) { 
          
        	usuarios = (ArrayList<User_DTO>) inputStream.readObject(); // Deserializar el arraylist de usuarios
        
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error al cargar, simplemente continuamos con la lista vacía
        }
    }

    // Método para guardar el arraylist de los usuarios en el archivo .dat
    private void guardarUsuariosEnArchivo() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivo))) {
            outputStream.writeObject(usuarios); // Serializar y guardar el arraylist de usuarios
     
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public ArrayList<User_DTO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<User_DTO> usuarios) {
		this.usuarios = usuarios;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
    
    
    
}  
