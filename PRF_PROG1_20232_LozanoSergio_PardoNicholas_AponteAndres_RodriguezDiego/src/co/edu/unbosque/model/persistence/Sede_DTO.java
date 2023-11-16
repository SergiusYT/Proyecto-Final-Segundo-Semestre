package co.edu.unbosque.model.persistence;

import java.io.*;

public class Sede_DTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String ubicacion; // Localidad
	private int numeroDeEmpleados;
	
	public Sede_DTO(String ubicacion, int numeroDeEmpleados) {
		this.ubicacion = ubicacion;
		this.numeroDeEmpleados = numeroDeEmpleados;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getNumeroDeEmpleados() {
		return numeroDeEmpleados;
	}

	public void setNumeroDeEmpleados(int numeroDeEmpleados) {
		this.numeroDeEmpleados = numeroDeEmpleados;
	}
	
}