package co.edu.unbosque.model;

import java.util.*;

import co.edu.unbosque.model.persistence.*;

public class Loteria implements Interface{
	
    private Loteria_DAO loteria_DAO;
	
    private ArrayList<Integer> numerosGanadores, fraccionesCompradas; 
    private ArrayList<String> series_Disponibles;

    private int nuevoNumeroGanador, nuevoSerieGanadora  ; 
    
    private String numeroGanador, serieGanadora; 

    
    private double premioPrincipal, premioAcumulado, costoBoleto ; // Monto del premio principal
    private Random random;

    
    
    public Loteria() {
        
    	loteria_DAO = new Loteria_DAO();
    	random = new Random();
    	
    	
        numerosGanadores = new ArrayList<>();
        
        fraccionesCompradas = new ArrayList<>();


    }
    
// ---------------------------      METODOS PARA NUMEROS GANADORES GENERADOS EN UN SORTEO ----------------------------------------     

   
    
    
   
    

 
    public void calcularPremiosYRepartir() {
        double premioTotal = premioPrincipal + premioAcumulado;
        int totalFracciones = fraccionesCompradas.size();
        double premioPorFraccion = premioTotal / totalFracciones;

        for (int fraccion : fraccionesCompradas) {
            if (esGanadora(fraccion, serieGanadora, numerosGanadores)) {
                // Reparte el premio por fracción
                premioPrincipal -= premioPorFraccion;
            }
        }

        premioAcumulado += premioPrincipal;
        premioPrincipal = 0.0;
    }

    public boolean esGanadora(int fraccion, String serie, ArrayList<Integer> numerosGanadores) {
        // Implementa la lógica para verificar si una fracción es ganadora
        // Puedes comparar la serie y los números de la fracción con los ganadores
        return true; // Cambia esto según tu lógica de verificación
    }
    
    
    
    
    
    
 //----------------------------------------------  METODOS NECESARIOS DE LOTERIA ---------------------------------------   
    
    
          /*--------------------- METODOS PARA QUE GENERES UN NUMERO DE 4 DIGITOS Y UN SERIE GANADORA ------------------------*/

    
    public void generarNumerosGanadores() {

        // Generar nuevos números ganadores
      
            nuevoNumeroGanador = random.nextInt(10000); // Genera números entre 0 y 9999
           
         // Convierte el número en una cadena (String) con ceros a la izquierda si es necesario
             numeroGanador = String.format("%04d", nuevoNumeroGanador);

            
            nuevoSerieGanadora = random.nextInt(1000); // Genera números entre 0 y 999
            
            // Convierte el número en una cadena (String) con ceros a la izquierda si es necesario
             serieGanadora = String.format("%03d", nuevoSerieGanadora);
            
        // Guardar la lista completa en el archivo
        loteria_DAO.guardarNumerosGanadores(numeroGanador, serieGanadora);
    }
    
    
             /*--------------------------- METODOS PARA LA SERIES GENERADAS -----------------------------------*/
    
    
    public ArrayList<String> generarSeriesUnicas() {
    	
    	    series_Disponibles = new ArrayList<>();

    	    for (int i = 0; i < 24; i++) {
    	    	
    	            int numero = random.nextInt(1000); // Genera un número entre 000 y 999
    	            String serieConCeros = String.format("%03d", numero); // Formatear con ceros a la izquierda
    	      
    	            
    	       // En una posición aleatoria, se agregara el número ganador de serie para dar una mayor probabilidad de ganar por parte de la serie
    	            if (i == random.nextInt(24)) {
    	                serieConCeros = String.format("%03d", nuevoSerieGanadora);
    	            }
    	            
    	            series_Disponibles.add(serieConCeros);
    	    }

    	    return series_Disponibles;
    }
    
    

    
    /*--------------------------- METODOS PARA LA SERIES GENERADAS -----------------------------------*/

    public void cantidadFraccion(int fraccion) {
    	
        fraccionesCompradas.add(fraccion);
    }

    
    
 //....................................................................................................................   
    
    
    

    
    public boolean comprobarGanador(ArrayList<Integer> numerosElegidos) {
        return numerosGanadores.equals(numerosElegidos);
    }
    
    
    
   
//----------------------------------------------  METODO PARA COMENZAR EL JUEGO o SORTEO ---------------------------------------   

    
    public void realizarSorteo() {
        // Genera números ganadores
       generarNumerosGanadores();
       
        // Verifica si hay ganadores
        boolean hayGanador = false;
        for (int fraccion : fraccionesCompradas) {
            if (esGanadora(fraccion, serieGanadora, numerosGanadores)) {
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
    
    
    
    
    
    
    
    public ArrayList<Loteria_DTO> getConsultarNumerosGanadores() {
    	return loteria_DAO.cargarNumerosGanadores();
    }
    

    

    public Double getCostoBoleto() {
        return costoBoleto;
    }

    public void setCostoBoleto(int costoBoleto) {
        this.costoBoleto = costoBoleto;
    }


}
   

    

