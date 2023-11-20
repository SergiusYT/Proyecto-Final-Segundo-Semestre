package co.edu.unbosque.model.persistence;

import java.io.Serializable;

public class SuperAstro_DTO extends Juegos_DTO implements Serializable, ConversionString_DTOS {

	private static final long serialVersionUID = 1L;

	// juego
		private String numerosGanadores, signosGanadores;

	    // apostador
		private String usernameApostador, nombreApostador, numeroApostador, signoZodiacoDelApostador,cedula, nombreSede;
		private double valorApuesta;
	
	
	
	public SuperAstro_DTO(String nombre, String tipoJuego, String numerosGanadores, String signosGanadores, double presupuesto) {
		super(nombre, tipoJuego, presupuesto);
		
		this.numerosGanadores = numerosGanadores;
		this.signosGanadores = signosGanadores;
	}

	public SuperAstro_DTO(String usernameApostador, String nombreApostador, String nombreSede, String cedula, String fecha , double valorApuesta, String numeroApostador, String signoApostador) {
	

   	 this.usernameApostador = usernameApostador; 
   	 this.nombreApostador = nombreApostador;
        this.nombreSede = nombreSede;
        this.cedula = cedula;
        this.valorApuesta = valorApuesta;
        this.numeroApostador = numeroApostador;
        this.signoZodiacoDelApostador = signoApostador;
		
	}


	@Override
	public String toStringJuego() {
		return "<html>Nombre del juego: " + getNombre() +
                "<br>Tipo de juego: " + getTipoJuego() +
                "<br>Números ganadores: " + numerosGanadores +
                "<br>Series ganadoras: " + signosGanadores +
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
	                "<br>Serie apostada: " + signoZodiacoDelApostador +
	                "<br>Valor de la apuesta: " + valorApuesta +
	                "</html>";	
		 }
	
	
	public Double getPremio() {
		return getPresupuesto();
	}


}
