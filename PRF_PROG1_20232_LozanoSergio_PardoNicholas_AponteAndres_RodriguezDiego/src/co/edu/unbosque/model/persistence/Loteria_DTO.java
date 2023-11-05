package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.*;

public class Loteria_DTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private ArrayList<Integer> numerosGanadores;

    public Loteria_DTO(ArrayList<Integer> numerosGanadores) {
        this.numerosGanadores = numerosGanadores;
    }

    public ArrayList<Integer> getNumerosGanadores() {
        return numerosGanadores;
    }
}
