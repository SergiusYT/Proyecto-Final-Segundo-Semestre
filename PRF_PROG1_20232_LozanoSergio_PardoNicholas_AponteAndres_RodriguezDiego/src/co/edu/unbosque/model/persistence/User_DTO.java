package co.edu.unbosque.model.persistence;

import java.io.Serializable;

//--------------------- Definir los atributos que contendra el usuario -------------

public class User_DTO implements Serializable{

  //---------------------- atributos de usuario-------------------------------
	

	private static final long serialVersionUID = 1L;
	private String username;
    private String password;
    private Double saldo; // es el dinero que tendra el usuario para sus apuestas
   
    
  //-------------------------- Contructor que tomara los datos ----------------------  
    
    public User_DTO(String username, String password) {
        this.username = username;
        this.password = password;
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
    
    
}
