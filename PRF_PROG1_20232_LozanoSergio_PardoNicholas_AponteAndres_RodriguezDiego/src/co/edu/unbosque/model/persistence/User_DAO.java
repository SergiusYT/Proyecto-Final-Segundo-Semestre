package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.*;

public class User_DAO {
    private ArrayList<User_DTO> usuarios;
    private String archivo;
    private User_DTO user_DTO;

    public User_DAO() {
        usuarios = new ArrayList<>();
        archivo = "Archives//Apostadores// apostadores.dat";
        consultarUsuarios(); // Cargar usuarios al iniciar el programa
    }
    
    
//-------------------------------- METODOS PARA OBTENER ALGUN DATO EN ESPECIFICO ------------------------------------------    

    public String buscarUsuario(String username) {
        for (User_DTO usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return usuario.getUsername();
            }
        }
        return null;
    }

    
    public String comparararPassword(String password) {
        for (User_DTO contraseña : usuarios) {
            if (contraseña.getPassword().equals(password)) {
                return contraseña.getPassword();
            }
        }
        return null;
    }
    
    public String obtenerNombreReal(String username) {
        for (User_DTO usuario : usuarios) {
            if (usuario.getUsername().equals(username)) { // como dependende del usuario en el que este retornara el nombre de ese usuario especificamente
                return usuario.getNombreApostador();
            }
        }
        return null;
    }
    
    public String obtenerCedula(String username) {
        for (User_DTO usuario : usuarios) {
            if (usuario.getUsername().equals(username)) { // como dependende del usuario en el que este retornara el nombre de ese usuario especificamente
                return usuario.getCedula();
            }
        }
        return null;
    }
    
    public String obtenerSedeJugadaPorElApostador(String username) {
        for (User_DTO usuario : usuarios) {
            if (usuario.getUsername().equals(username)) { // como dependende del usuario en el que este retornara el nombre de ese usuario especificamente
                return usuario.getSede();
            }
        }
        return null;
    }
    
//-------------------------------- METODOS CRUD -----------------------------------------------------------    
    
    
    public boolean agregarUsuario(String username, String password, String nombreApostador, int edad, String cedula, String sede, String direccion, String celular) {
    	
    	consultarUsuarios();

        // Verificar si el usuario ya existe
        if (buscarUsuario(username) == null) {
            user_DTO = new User_DTO(username, password, nombreApostador, edad, cedula, sede, direccion, celular);
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
    

    
    // Método para cargar los juegos desde el archivo .dat
       @SuppressWarnings("unchecked")
   	public String consultarUsuarios() {
       	try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivo))) {
       		usuarios = (ArrayList<User_DTO>) inputStream.readObject(); // Deserializar el ArrayList de números ganadores
               String resultado = "";
               for (User_DTO user : usuarios) {
                   resultado += user.toString();
               }
               return resultado;
           } catch (IOException | ClassNotFoundException e) {
               // Si hay un error al cargar, simplemente continuamos con la lista vacía
        	   usuarios = new ArrayList<>();
               return "Error al cargar los usuarios.";
           }

       }
	

}