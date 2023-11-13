package co.edu.unbosque.model.persistence;

import java.io.*;

public class Loteria_DTO extends Juegos_DTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private String numerosGanadores, series;



    public Loteria_DTO(String nombre, String tipoJuego, String numerosGanadores, String series, double presupuesto) {
    	
        super(nombre, tipoJuego, presupuesto); //super donde llevara los datos i 
    	
        this.numerosGanadores = numerosGanadores;
        this.series = series;
    }
    
    @Override
    public String toString() {
        return "Loteria_DTO{ nombre del juego " + getNombre() + " tipo de juego " + getTipoJuego() +
                " numerosGanadores='" + numerosGanadores + '\'' +
                ", series='" + series + " Premio Acumulado: " + getPresupuesto() + '\'' +
                '}';
    }
    
    

    

	public String getNumerosGanadores() {
        return numerosGanadores;
    }
    public String getSeries() {
        return series;
    }

	public Double getPremio() {
		return getPresupuesto();
	}
   
}
