package co.edu.unbosque.model.persistence;

import java.io.*;

public class Juegos_DTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String nombre, tipoJuego;
	private double presupuesto;

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
