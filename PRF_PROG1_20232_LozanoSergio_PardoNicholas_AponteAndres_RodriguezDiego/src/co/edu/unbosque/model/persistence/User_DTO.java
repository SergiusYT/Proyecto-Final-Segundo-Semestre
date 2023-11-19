package co.edu.unbosque.model.persistence;

import java.io.Serializable;

//--------------------- Definir los atributos que contendra el usuario -------------

public class User_DTO implements Serializable{

  //---------------------- atributos de usuario-------------------------------
	

	private static final long serialVersionUID = 1L;
	private String username, password, nombreApostador, cedula, sede, direccion, celular;
    private int edad;
    private Double saldo; // es el dinero que tendra el usuario para sus apuestas
   
    
  //-------------------------- Contructor que tomara los datos ----------------------  
    
    public User_DTO(String username, String password, String nombreApostador, int edad, String cedula, String sede, String direccion, String celular) {
        this.username = username;
        this.password = password;
        this.nombreApostador = nombreApostador;
        this.edad = edad;
        this.cedula = cedula;
        this.sede = sede;
        this.direccion = direccion;
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "User_DTO{" +
               "username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", nombre del Apostador='" + nombreApostador + '\'' +
               ", edad del Apostador='" + edad + '\'' +
               ", cedula del Apostador='" + cedula + '\'' +
               ", sede que juega el Apostador='" + sede + '\'' +
               ", direccion del Apostador='" + direccion + '\'' +
               ", celular del Apostador='" + celular + '\'' +

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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
    
    
}
