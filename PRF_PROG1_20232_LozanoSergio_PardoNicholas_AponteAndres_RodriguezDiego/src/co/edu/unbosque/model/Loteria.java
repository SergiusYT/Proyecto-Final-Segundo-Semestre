package co.edu.unbosque.model;

import java.util.*;

import co.edu.unbosque.model.persistence.*;

public class Loteria {
	
    private ArrayList<Integer> numerosGanadores; // Combinación de números ganadores
    private int costoBoleto; // Costo del boleto
    private Loteria_DAO loteria_DAO;
    private String serie; // Serie de tres dígitos no repetibles
    private double premioPrincipal, premioAcumulado ; // Monto del premio principal
    private ArrayList<String> fraccionesCompradas; // Registro de fracciones compradas
    private Random random;

    
    
    public Loteria() {
        
    	loteria_DAO = new Loteria_DAO();
    	random = new Random();
        numerosGanadores = new ArrayList<>();
        fraccionesCompradas = new ArrayList<>();


    }
    
// ---------------------------      METODOS PARA NUMEROS GANADORES GENERADOS EN UN SORTEO ----------------------------------------     

    public void generarNumerosGanadores() {
    	// Cargar números ganadores existentes
        ArrayList<Integer> dtoExistente = loteria_DAO.cargarNumeroGanador();
        ArrayList<Integer> numerosGanadoresExistentes = (dtoExistente != null) ? dtoExistente.getNumerosGanadores() : new ArrayList<>();
        
        // Generar nuevos números ganadores
        random = new Random();
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
    
    
    
   //------------------------------------ METODOS PARA LA SERIES, FRACCIONES -----------------------------------
    
    
    public ArrayList<String> generarSeriesUnicas() {
    	
        ArrayList<String> series = new ArrayList<>();
         random = new Random();

        for (int i = 0; i < 12; i++) {
            StringBuilder serie = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                int numero = random.nextInt(10); // Genera un número entre 0 y 9
                serie.append(numero);
            }
            series.add(serie.toString());
        }

        return series;
    }

    

    public void comprarFraccion(String fraccion) {
        fraccionesCompradas.add(fraccion);
    }

    public void calcularPremiosYRepartir() {
        double premioTotal = premioPrincipal + premioAcumulado;
        int totalFracciones = fraccionesCompradas.size();
        double premioPorFraccion = premioTotal / totalFracciones;

        for (String fraccion : fraccionesCompradas) {
            if (esGanadora(fraccion, serie, numerosGanadores)) {
                // Reparte el premio por fracción
                premioPrincipal -= premioPorFraccion;
            }
        }

        premioAcumulado += premioPrincipal;
        premioPrincipal = 0.0;
    }

    public boolean esGanadora(String fraccion, String serie, ArrayList<Integer> numerosGanadores) {
        // Implementa la lógica para verificar si una fracción es ganadora
        // Puedes comparar la serie y los números de la fracción con los ganadores
        return true; // Cambia esto según tu lógica de verificación
    }
    
    
    
    
    
    
 //----------------------------------------------  METODO PARA COMENZAR EL JUEGO ---------------------------------------   
    
    
    public void realizarSorteo() {
        // Genera números ganadores
       generarNumerosGanadores();
       
        // Verifica si hay ganadores
        boolean hayGanador = false;
        for (String fraccion : fraccionesCompradas) {
            if (esGanadora(fraccion, serie, numerosGanadores)) {
                // Hay al menos un ganador
                hayGanador = true;
                break;
            }
        }

        if (hayGanador) {
            // Si hay ganador, reparte los premios
            calcularPremiosYRepartir();
        } else {
            // Si no hay ganador, acumula el premio principal
            premioAcumulado += premioPrincipal;
            premioPrincipal = 0.0;
        }
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
   

    

