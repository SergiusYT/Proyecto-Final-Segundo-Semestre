package co.edu.unbosque.model;

import java.util.*;

public class Loteria {

    private ArrayList<Integer> numerosGanadores; // Combinación de números ganadores
    private int costoBoleto; // Costo del boleto

    public Loteria() {
        this.numerosGanadores = new ArrayList<>(); // Inicializa la lista, pero no genera los números aquí
    }

    
    public void generarNumerosGanadores() {
        numerosGanadores.clear(); // Limpia la lista actual

        Random random = new Random();

        for (int i = 0; i < 4; i++) { // 4 cifras
            int numero = random.nextInt(10); // Genera un número entre 0 y 9
            numerosGanadores.add(numero);
        }
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
        return numerosGanadores;
    }
}
   

    

