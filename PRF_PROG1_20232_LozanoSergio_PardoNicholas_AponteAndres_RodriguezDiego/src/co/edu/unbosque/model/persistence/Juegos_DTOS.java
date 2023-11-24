package co.edu.unbosque.model.persistence;

import java.io.Serializable;

public interface Juegos_DTOS extends Serializable{
	
	// se extiende la Serializacion para que cuando se implemete esta interfaz a los dtos de los juegos se aplique tambien las serializaciones
	 
// Metodos to String que convertiran las consultas de datos a cadena 
	
	public abstract String toStringJuego();
	
	public abstract String toStringApostador();

	public abstract Double getPremio();
	
	
}
