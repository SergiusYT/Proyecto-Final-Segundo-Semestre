package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.*;

public class User_DAO {
    private ArrayList<User_DTO> usuarios;
    private String archivo;
    private User_DTO user_DTO;

    public User_DAO() {
        usuarios = new ArrayList<>();
        archivo = "Archives//apostadores.dat";
        consultarUsuarios(); // Cargar usuarios al iniciar el programa
    }

    public User_DTO buscarUsuario(String username) {
        for (User_DTO usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean agregarUsuario(String username, String password) {
    	
    	consultarUsuarios();

        // Verificar si el usuario ya existe
        if (buscarUsuario(username) == null) {
            user_DTO = new User_DTO(username, password);
            usuarios.add(user_DTO);

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

    public void eliminarUsuario(String username) {
        usuarios.removeIf(usuario -> usuario.getUsername().equals(username));

        // Guardar usuarios en archivo
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivo))) {
            outputStream.writeObject(usuarios); // Serializar y guardar el ArrayList de usuarios
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
	public ArrayList<User_DTO> consultarUsuarios() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivo))) {
            usuarios = (ArrayList<User_DTO>) inputStream.readObject(); // Deserializar el ArrayList de usuarios
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error al cargar, simplemente continuamos con la lista vacía
        }
		return usuarios;
    }
}