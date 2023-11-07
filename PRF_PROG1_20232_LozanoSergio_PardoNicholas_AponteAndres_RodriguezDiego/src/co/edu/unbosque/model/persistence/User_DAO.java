package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.*;

public class User_DAO {
    private ArrayList<User_DTO> usuarios;
    private String archivo;

    public User_DAO() {
    	
        usuarios = new ArrayList<>();
        archivo = "Archives// apostadores.dat";
        consultarUsuarios(); // Cargar usuarios al iniciar el programa
    }
    
    
    
    
  // Método para buscar un usuario en ESPECIFICO  por su nombre de usuario
    
    public User_DTO buscarUsuario(String username) {
        for (User_DTO usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return usuario; // Devolver el usuario si se encuentra
            }
        }
        return null; // Devolver null si el usuario no se encuentra
    }
    
   

    // Método para agregar un usuario, cargar usuarios desde archivo y guardar en el archivo
    public boolean agregarUsuario(User_DTO usuario) {
        // Cargar usuarios desde archivo
    	consultarUsuarios();

        // Verificar si el usuario ya existe
        if (buscarUsuario(usuario.getUsername()) == null) {
            usuarios.add(usuario);

            // Guardar usuarios en archivo
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivo))) {
                outputStream.writeObject(usuarios); // Serializar y guardar el ArrayList de usuarios
            } catch (IOException e) {
                e.printStackTrace();
            }

            return true; // Indicar que el usuario se agregó exitosamente
        }
        return false; // Indicar que el usuario ya existe y no se pudo agregar
    }
    
    
    
  
    
    

    // Método para actualizar un usuario
    public void actualizarUsuario(String username, User_DTO nuevoUsuario, User_DTO usuarioExistente) {
        for (int i = 0; i < usuarios.size(); i++) {
            usuarioExistente = usuarios.get(i);
            if (usuarioExistente.getUsername().equals(username)) {
                usuarios.set(i, nuevoUsuario);

                // Guardar usuarios en archivo
                try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivo))) {
                    outputStream.writeObject(usuarios); // Serializar y guardar el ArrayList de usuarios
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return;
            }
        }
    }
    
    
    
    

    // Método para eliminar un usuario
    public void eliminarUsuario(String username) {
        usuarios.removeIf(usuario -> usuario.getUsername().equals(username));

        // Guardar usuarios en archivo
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivo))) {
            outputStream.writeObject(usuarios); // Serializar y guardar el ArrayList de usuarios
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    

 // Método para cargar usuarios desde el archivo .dat
    @SuppressWarnings("unchecked")
	public ArrayList<User_DTO> consultarUsuarios() {
    	try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivo))) {
    		
            usuarios = (ArrayList<User_DTO>) inputStream.readObject(); // Deserializar el ArrayList de usuarios
            return usuarios;
            
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error al cargar, simplemente continuamos con la lista vacía
        	return null;
        }
    }
    
    
    
    

}