package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.*;

public class Loteria_DTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private ArrayList<Integer> numerosGanadores, series;
	

    public Loteria_DTO(ArrayList<Integer> numerosGanadores, ArrayList<Integer> series) {
    	
        this.numerosGanadores = numerosGanadores;
        this.series = series;
    }

    public ArrayList<Integer> getNumerosGanadores() {
        return numerosGanadores;
    }
    public ArrayList<Integer> getSeries() {
        return series;
    }
}
