package co.edu.unbosque.model.persistence;

import java.io.*;

public class Loteria_DTO extends Juegos_DTO implements Serializable, ConversionString_DTOS{

	private static final long serialVersionUID = 1L;
	
	// juego
	private String numerosGanadores, seriesGanadores;

    // apostador
	private String usernameApostador, nombreApostador, numeroApostador, serieApostador,cedula, nombreSede;
	private int fraccion;
	private double valorApuesta;

	
// ------------------------------ Contructor que tomara datos del juego en general -------------------------------------	
	
    public Loteria_DTO(String nombre, String tipoJuego, String numerosGanadores, String seriesGanadores, double presupuesto) {
    	
        super(nombre, tipoJuego, presupuesto); //super donde llevara los datos heredados a la clase jugador_dto
    	
        this.numerosGanadores = numerosGanadores;
        this.seriesGanadores = seriesGanadores;
    }
    
  
 // ------------------------------ Contructor que tomara datos de las apuestas de los apostadores -------------------------------------	
    
    
    public Loteria_DTO(String usernameApostador, String nombreApostador, String nombreSede, String cedula, String fecha , double valorApuesta, String numeroApostador, String serieApostador, int fraccion) {
        
    	 this.usernameApostador = usernameApostador; 
    	 this.nombreApostador = nombreApostador;
         this.nombreSede = nombreSede;
         this.cedula = cedula;
         this.valorApuesta = valorApuesta;
         this.numeroApostador = numeroApostador;
         this.serieApostador = serieApostador;
         this.fraccion = fraccion;
    	
    }    
    
//...................................................................................................................................    
    
    
    @Override
    
    public String toStringJuego() {
        return "<html>Nombre del juego: " + getNombre() +
                "<br>Tipo de juego: " + getTipoJuego() +
                "<br>Números ganadores: " + numerosGanadores +
                "<br>Series ganadoras: " + seriesGanadores +
                "<br>Premio acumulado: " + getPresupuesto() +
                "</html>";
    }

    public String toStringApostador() {
        return  "<html>Nombre de usuario del apostador: "+ usernameApostador +
        		"<br>Nombre del apostador: " + nombreApostador +
                "<br>Numero de cedula: "+ cedula +
        		"<br>Número apostado: " + numeroApostador +
                "<br>Serie apostada: " + serieApostador +
                "<br>Fracciones compradas: " + fraccion +
                "<br>Valor de la apuesta: " + valorApuesta +
                "</html>";

    }
    

    

	public String getNumerosGanadores() {
        return numerosGanadores;
    }
    public String getSeries() {
        return seriesGanadores;
    }

	public Double getPremio() {
		return getPresupuesto();
	}


	
   
}
