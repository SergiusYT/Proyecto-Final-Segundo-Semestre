package co.edu.unbosque.model;

import java.util.*;

import co.edu.unbosque.model.persistence.*;

public class Loteria implements Interface{
	
    private Loteria_DAO loteria_DAO;
	
    private ArrayList<Integer> numerosGanadores;
    private ArrayList<String> series_Disponibles;

    private int nuevoNumeroGanador, nuevoSerieGanadora, fraccionesCompradas;  
    
    private String numeroGanador, serieGanadora; 

    
    private double premioTOTAL, premioAcumulado, costoBoleto ; // Monto del premio principal
    private Random random;

    
    
    public Loteria() {
        
    	loteria_DAO = new Loteria_DAO();
    	random = new Random();
    	
    	
        numerosGanadores = new ArrayList<>();
        
      

    }
    
// ---------------------------      METODOS PARA NUMEROS GANADORES GENERADOS EN UN SORTEO ----------------------------------------     

   
    
    
   
    

 
    
    
    
    
    
    
    
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
    
    
    
    	public double calcularPremioPorFracciones(double premio) {
    	    double porcentaje = 0;

    	    switch (fraccionesCompradas) {
    	        case 1:
    	            porcentaje = 0.45; // si compra una fraccion tiene un 45% 
    	            break;
    	        case 2:
    	            porcentaje = 0.75; // si compra dos fracciones tiene un 75% 
    	            break;
    	        case 3:
    	            porcentaje = 1.0; // si compra tres fracciones tiene un 100% 
    	            break;
    	    }
    	    double premio_real = premio * (1 - 0.2); // la loteria quita el 20% del total del premio y queda el 80% como premio realmente
    	    
    	    

    	    
    	    premioTOTAL=  premio_real * porcentaje;  // se quitara los porcetajes respectivos al premio total dependiendo las fracciones compradas      
    	    
            premioAcumulado +=  premio - premioTOTAL; // acumula lo descontado del premio total y se suma eso para los proximos premios

    	    
    	    return premioTOTAL;
    	}
    
    

    
    /*--------------------------- METODOS PARA LA SERIES GENERADAS -----------------------------------*/


    
    
 //....................................................................................................................   
    
    
    

    
    public boolean comprobarGanador(ArrayList<Integer> numerosElegidos) {
        return numerosGanadores.equals(numerosElegidos);
    }
    
    
    
   
//----------------------------------------------  METODO PARA COMENZAR EL JUEGO o SORTEO ---------------------------------------   

    
    public void realizarSorteo() {
       
    	
    	
    	
    }
    
    
    
    
    
    
    
    public ArrayList<Loteria_DTO> getConsultarNumerosGanadores() {
    	return loteria_DAO.cargarNumerosGanadores();
    }
    

    
    public int getcantidadFraccion() {	
        return fraccionesCompradas; 
    }
    
    public void setcantidadFraccion(int fraccion) {
        this.fraccionesCompradas = fraccion;
    }
    

    public Double getPremioAcumulado() {	
        return premioAcumulado; 
    }
    
    
    public Double getCostoBoleto() {
        return costoBoleto;
    }

    public void setCostoBoleto(int costoBoleto) {
        this.costoBoleto = costoBoleto;
    }


}
   

    

