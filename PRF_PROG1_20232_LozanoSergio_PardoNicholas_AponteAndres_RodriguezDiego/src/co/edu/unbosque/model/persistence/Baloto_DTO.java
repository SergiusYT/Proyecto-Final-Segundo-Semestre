package co.edu.unbosque.model.persistence;

import java.io.*;

public class Baloto_DTO extends Juegos_DTO implements Serializable, Juegos_DTOS{

	private static final long serialVersionUID = 1L;

	// juego
		private String numerosGanadores, superBalotaGanadora;

	    // apostador
		private String usernameApostador, nombreApostador, numeroApostador, superBalotaApostada,cedula, nombreSede;
		private double valorApuesta;
	
	
	
	public Baloto_DTO(String nombre, String tipoJuego, String numerosGanadores, String superBalotaGanadora, double presupuesto) {
		super(nombre, tipoJuego, presupuesto);
		
		this.numerosGanadores = numerosGanadores;
		this.superBalotaGanadora = superBalotaGanadora;
	}

	public Baloto_DTO(String usernameApostador, String nombreApostador, String nombreSede, String cedula, String fecha , double valorApuesta, String numeroApostador, String superBalotaGanadora) {
	

   	 this.usernameApostador = usernameApostador; 
   	 this.nombreApostador = nombreApostador;
        this.nombreSede = nombreSede;
        this.cedula = cedula;
        this.valorApuesta = valorApuesta;
        this.numeroApostador = numeroApostador;
        this.superBalotaApostada = superBalotaGanadora;
		
	}


	@Override
	public String toStringJuego() {
		return "<html>Nombre del juego: " + getNombre() +
                "<br>Tipo de juego: " + getTipoJuego() +
                "<br>Números ganadores: " + numerosGanadores +
                "<br>SuperBalota ganadora: " + superBalotaGanadora +
                "<br>Numero completo ganador: " +numerosGanadores+ superBalotaGanadora +
                "<br>Premio acumulado: " + getPresupuesto() +
                "</html>";
		}



	@Override
	public String toStringApostador() {
		 return  "<html>Nombre de usuario del apostador: "+ usernameApostador +
	        		"<br>Nombre del apostador: " + nombreApostador +
	                "<br>Numero de cedula: "+ cedula +
	                "<br>Sede en la que juega: "+ nombreSede +
	        		"<br>Número apostado: " + numeroApostador +
	                "<br>SuperBalota apostada: " + superBalotaApostada +
	                "<br>Numero completo apostado: " + numeroApostador+superBalotaApostada +
	                "<br>Valor de la apuesta: " + valorApuesta +
	                "</html>";	
		 }
	
	
	public Double getPremio() {
		return getPresupuesto();
	}


}
