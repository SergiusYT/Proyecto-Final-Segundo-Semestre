package co.edu.unbosque.model;

import java.util.*;

import co.edu.unbosque.model.persistence.*;

public class Loteria implements Interface{
	
    private ArrayList<Integer> numerosGanadores; // Combinación de números ganadores
    private int costoBoleto; // Costo del boleto
    private Loteria_DAO loteria_DAO;
    private Loteria_DTO loteria_DTO;
    private double premioPrincipal, premioAcumulado ; // Monto del premio principal
    private ArrayList<String> fraccionesCompradas; // Registro de fracciones compradas
    private Random random;
    private String numeroGanador, serieGanadora; // Serie de tres dígitos no repetibles

    
    
    public Loteria() {
        
    	loteria_DAO = new Loteria_DAO();
    	random = new Random();
        numerosGanadores = new ArrayList<>();
        fraccionesCompradas = new ArrayList<>();


    }
    
// ---------------------------      METODOS PARA NUMEROS GANADORES GENERADOS EN UN SORTEO ----------------------------------------     

   
    
    
   //------------------------------------ METODOS PARA LA SERIES, FRACCIONES -----------------------------------
    
    
    public ArrayList<String> generarSeriesUnicas() {
    	
    	 ArrayList<String> series = new ArrayList<>();

    	    for (int i = 0; i < 12; i++) {
    	    	
    	            int numero = random.nextInt(1000); // Genera un número entre 000 y 999
    	            String serieConCeros = String.format("%03d", numero); // Formatear con ceros a la izquierda
    	       
    	            series.add(serieConCeros);
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
            if (esGanadora(fraccion, serieGanadora, numerosGanadores)) {
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
    
    
    
    
    
    
 //----------------------------------------------  METODOs PARA COMENZAR EL JUEGO ---------------------------------------   
    
    
    public void generarNumerosGanadores() {
    	 // Cargar números ganadores existentes si hay
        ArrayList<Loteria_DTO> numerosGanadoresExistentes = loteria_DAO.cargarNumerosGanadores();

        // Generar nuevos números ganadores
      

           int nuevoNumeroGanador = random.nextInt(10000); // Genera números entre 0 y 9999
           
         // Convierte el número en una cadena (String) con ceros a la izquierda si es necesario
             numeroGanador = String.format("%04d", nuevoNumeroGanador);

            
            int nuevoSerieGanadora = random.nextInt(1000); // Genera números entre 0 y 999
            
            // Convierte el número en una cadena (String) con ceros a la izquierda si es necesario
                serieGanadora = String.format("%03d", nuevoSerieGanadora);
            
            
            

        // Crear un nuevo objeto Loteria_DTO para los nuevos números ganadores
        loteria_DTO = new Loteria_DTO(numeroGanador, serieGanadora); // Supongo que la serie es 0

        // Agregar el nuevo número ganador a la lista existente (o crear una nueva lista si no había)
        if (numerosGanadoresExistentes == null) {
            numerosGanadoresExistentes = new ArrayList<>();
        }
        numerosGanadoresExistentes.add(loteria_DTO);

        // Guardar la lista completa en el archivo
        loteria_DAO.guardarNumerosGanadores(numerosGanadoresExistentes);
    }
    

    
    public boolean comprobarGanador(ArrayList<Integer> numerosElegidos) {
        return numerosGanadores.equals(numerosElegidos);
    }
    
    
    
   
    
    
    public void realizarSorteo() {
        // Genera números ganadores
       generarNumerosGanadores();
       
        // Verifica si hay ganadores
        boolean hayGanador = false;
        for (String fraccion : fraccionesCompradas) {
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
    

    

    public int getCostoBoleto() {
        return costoBoleto;
    }

    public void setCostoBoleto(int costoBoleto) {
        this.costoBoleto = costoBoleto;
    }


}
   

    

