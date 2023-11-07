package co.edu.unbosque.model.persistence;

import java.io.*;

public class Loteria_DTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private String numerosGanadores, series;
	

    public Loteria_DTO(String numerosGanadores, String series) {
    	
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

    public String getNumerosGanadores() {
        return numerosGanadores;
    }
    public String getSeries() {
        return series;
    }
}
