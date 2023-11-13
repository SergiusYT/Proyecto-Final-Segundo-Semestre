package co.edu.unbosque.model.persistence;

import java.io.*;

public class Loteria_DTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private String numerosGanadores, series;
	private double premio_Acumulado;


    public Loteria_DTO(String numerosGanadores, String series, double premio_Acumulado) {
    	
        this.numerosGanadores = numerosGanadores;
        this.series = series;
        this.premio_Acumulado = premio_Acumulado;
    }
    
    @Override
    public String toString() {
        return "Loteria_DTO{" +
               "numerosGanadores='" + numerosGanadores + '\'' +
               ", series='" + series + " Premio Acumulado: "+premio_Acumulado+ '\'' +
               '}';
    }

    public String getNumerosGanadores() {
        return numerosGanadores;
    }
    public String getSeries() {
        return series;
    }
    public Double getPremio_Acumulado() {
    	return premio_Acumulado;
    }
    public void setPremio_Acumulado(double premio_Acumulado) {
    	this.premio_Acumulado = premio_Acumulado;
    }
}
