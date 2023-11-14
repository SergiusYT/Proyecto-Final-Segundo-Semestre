package co.edu.unbosque.model.persistence;

import java.io.Serializable;

//--------------------- Definir los atributos que contendra el usuario -------------

public class User_DTO implements Serializable{

  //---------------------- atributos de usuario-------------------------------
	

	private static final long serialVersionUID = 1L;
	private String username, password, nombreApostador;

    private Double saldo; // es el dinero que tendra el usuario para sus apuestas
   
    
  //-------------------------- Contructor que tomara los datos ----------------------  
    
    public User_DTO(String username, String password, String nombreApostador) {
        this.username = username;
        this.password = password;
        this.nombreApostador = nombreApostador;
    }

    @Override
    public String toString() {
        return "User_DTO{" +
               "username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", nombre del Apostador='" + nombreApostador + '\'' +

               '}';
    }
    
 //-------------------------- Getters y Setters ------------------------------------
    
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombreApostador() {
		return nombreApostador;
	}

	public void setNombreApostador(String nombreApostador) {
		this.nombreApostador = nombreApostador;
	}
    
    
}
