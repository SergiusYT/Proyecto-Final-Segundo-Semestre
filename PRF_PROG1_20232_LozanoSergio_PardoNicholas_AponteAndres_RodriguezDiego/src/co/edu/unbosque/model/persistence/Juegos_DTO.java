package co.edu.unbosque.model.persistence;

import java.io.*;

public class Juegos_DTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	protected String nombre, tipoJuego;
	protected double presupuesto;

	
	 // Constructor sin parámetros en Juegos_DTO
  public Juegos_DTO() {
    // es para que  permita poner los dtos de las apuestas_juegos.dat en general y no dependizar de que haga un super en el contructor a la clase heredada
  }
	
	
	
  public Juegos_DTO(String nombre, String tipoJuego, double presupuesto) {
	  
	  this.nombre = nombre;
  	  this.tipoJuego = tipoJuego;
      this.presupuesto = presupuesto;

  }
	
  
  
  
  public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoJuego() {
		return tipoJuego;
	}
	
	public Double getPresupuesto() {
		return presupuesto;
    }
	
	public void setPresupuesto(double presupuesto) {
    	this.presupuesto = presupuesto;	 	
	}
 }
