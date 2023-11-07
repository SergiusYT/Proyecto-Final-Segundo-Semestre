package co.edu.unbosque.model.persistence;

import java.io.*;

public class Loteria_DTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private int numerosGanadores, series;
	

    public Loteria_DTO(int numerosGanadores, int series) {
    	
        this.numerosGanadores = numerosGanadores;
        this.series = series;
    }
    
    @Override
    public String toString() {
        return "Loteria_DTO{" +
               "numerosGanadores='" + numerosGanadores + '\'' +
               ", series='" + series + '\'' +
               '}';
    }

    public int getNumerosGanadores() {
        return numerosGanadores;
    }
    public int getSeries() {
        return series;
    }
}
