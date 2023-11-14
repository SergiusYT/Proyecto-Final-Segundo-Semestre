package co.edu.unbosque.model.persistence;

import java.io.*;

public class Loteria_DTO extends Juegos_DTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// juego
	private String numerosGanadores, seriesGanadores;

    // apostador
	private String nombreApostador, numeroApostador, serieApostador, nombreSede;
	private int fraccion, cedula;
	private double valorApuesta;

	
// ------------------------------ Contructor que tomara datos del juego en general -------------------------------------	
	
    public Loteria_DTO(String nombre, String tipoJuego, String numerosGanadores, String seriesGanadores, double presupuesto) {
    	
        super(nombre, tipoJuego, presupuesto); //super donde llevara los datos heredados a la clase jugador_dto
    	
        this.numerosGanadores = numerosGanadores;
        this.seriesGanadores = seriesGanadores;
    }
    
  
 // ------------------------------ Contructor que tomara datos de las apuestas de los apostadores -------------------------------------	
    
    
    public Loteria_DTO(String nombreApostador, String nombreSede, int cedula, String fecha , double valorApuesta, String numeroApostador, String serieApostador, int fraccion) {
        
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
    public String toString() {
        if (numerosGanadores != null && seriesGanadores != null) {
            return "Loteria_DTO{ nombre del juego " + getNombre() + " tipo de juego " + getTipoJuego() +
                    " numerosGanadores='" + numerosGanadores + '\'' +
                    ", series='" + seriesGanadores + " Premio Acumulado: " + getPresupuesto() + '\'' +
                    '}';
        } else {
            return "Loteria_DTO{ nombre del apostador " + nombreApostador + " nombre de la sede " + nombreSede +
                    " cedula='" + cedula + '\'' +
                    ", valorApuesta='" + valorApuesta + '\'' +
                    ", numeroApostador='" + numeroApostador + '\'' +
                    ", serieApostador='" + serieApostador + '\'' +
                    '}';
        }
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
