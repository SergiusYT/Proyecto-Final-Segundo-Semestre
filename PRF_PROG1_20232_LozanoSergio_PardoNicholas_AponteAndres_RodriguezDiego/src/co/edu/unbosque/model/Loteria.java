package co.edu.unbosque.model;

import java.util.*;

import co.edu.unbosque.model.persistence.*;

public class Loteria {
	
    private ArrayList<Integer> numerosGanadores; // Combinación de números ganadores
    private int costoBoleto; // Costo del boleto
    private Loteria_DAO loteria_DAO;

    public Loteria() {
        
    	loteria_DAO = new Loteria_DAO();

    }

    public void generarNumerosGanadores() {
    	// Cargar números ganadores existentes
        Loteria_DTO dtoExistente = loteria_DAO.cargarNumerosGanadores();
        ArrayList<Integer> numerosGanadoresExistentes = (dtoExistente != null) ? dtoExistente.getNumerosGanadores() : new ArrayList<>();
        
        // Generar nuevos números ganadores
        Random random = new Random();
        ArrayList<Integer> nuevosNumeros = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int numero = random.nextInt(10); //numeros entre 0 a 9
            nuevosNumeros.add(numero);
        }
        
        // Agregar los nuevos números a la lista existente
        numerosGanadoresExistentes.addAll(nuevosNumeros);
        
        // Guardar la lista completa en el archivo
        Loteria_DTO dto = new Loteria_DTO(numerosGanadoresExistentes);
        loteria_DAO.guardarNumerosGanadores(dto);
    }

    
    public boolean comprobarGanador(ArrayList<Integer> numerosElegidos) {
        return numerosGanadores.equals(numerosElegidos);
    }

    public int getCostoBoleto() {
        return costoBoleto;
    }

    public void setCostoBoleto(int costoBoleto) {
        this.costoBoleto = costoBoleto;
    }

    public ArrayList<Integer> getNumerosGanadores() {
        Loteria_DTO dto = loteria_DAO.cargarNumerosGanadores();
        if (dto != null) {
            return dto.getNumerosGanadores();
        }
        return new ArrayList<>(); // Devuelve una lista vacía si no se puede cargar el DTO
    }
}
   

    

