package co.edu.unbosque.model;

import java.util.*;

import co.edu.unbosque.model.persistence.*;

public class Loteria{
	
    private Loteria_DAO loteria_DAO;
	
    private ArrayList<String> series_Disponibles;

    private int nuevoNumeroGanador, nuevoSerieGanadora, fraccionesCompradas;  
    
    private String numeroGanador, serieGanadora; 

    
    private double premioTOTAL, premioAcumulado, costoBoleto ; // Monto del premio principal
    private double presupuestoDelJuego; // Almacenar el presupuesto por juego

    
    private String usernameDelApostador, nombreRealApostador, cedula, sede;
    
    private Random random;

    
    
    public Loteria() {
        
    	loteria_DAO = new Loteria_DAO();
    	random = new Random();
    
    }
    
    
 //----------------------------------------------  METODOS NECESARIOS DE LOTERIA ---------------------------------------   
    
    
          /*--------------------- METODOS PARA QUE GENERES UN NUMERO DE 4 DIGITOS Y UN SERIE GANADORA ------------------------*/

    
    public void generarNumerosGanadores(int numeroApostador) {
    
    // daremos la probabilidad 50/50 para que este pueda ganar el premio con los 4 digitos
    	
    	// Generar un número aleatorio entre 1 y 100
        int probabilidad = random.nextInt(100) + 1;

        if (probabilidad <= 50) {
            // Si la probabilidad es 1-50%, elige el número del apostador
            nuevoNumeroGanador = numeroApostador;
        } else {
            // Si la probabilidad es 51-100%, elige un número aleatorio como de 4 digitos cualquiera
            nuevoNumeroGanador = random.nextInt(10000);
        }

        // Convierte el número en una cadena (String) con ceros a la izquierda si es necesario
        numeroGanador = String.format("%04d", nuevoNumeroGanador);

            
            nuevoSerieGanadora = random.nextInt(1000); // Genera números entre 0 y 999
            
            // Convierte el número en una cadena (String) con ceros a la izquierda si es necesario
             serieGanadora = String.format("%03d", nuevoSerieGanadora);
             
	       //   loteria_DAO.guardarJuego("", "", numeroGanador, serieGanadora, loteria_DAO.cargarPremioAcumulado());

            
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
    
    
    
    /*--------------------------- METODOS PARA COMPROBAR SI GANO Y  LA CANTINDAD DE DINERO DEPENDIENDO LA FRACCION -----------------------------------*/

    
    	public double calcularPremio(double premio) {
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
    	    

    	    premioAcumulado = 0 ; // se pone como valor 0 porque el premioacumulado se va a repatir 
    	    
    	    return premioTOTAL;
    	}
    
    
  //------------------------------- Metodo donde dira que dependiendo de la fraccion tendra un precio diferente -----------------------------  	

    	public void setCantidadFraccion(int fraccion) {
    	    this.fraccionesCompradas = fraccion;

    	    switch (fraccionesCompradas) {  // precio por fraccion 
    	        case 1:
    	            setCostoBoleto(5000);
    	            break;
    	        case 2:
    	            setCostoBoleto(10000);
    	            break;
    	        case 3:
    	            setCostoBoleto(15000);
    	            break;
    	        // Agregar más casos según sea necesario
    	        default:
    	            // Establecer un valor predeterminado si no coincide con ningún caso
    	            setCostoBoleto(0.0);
    	            break;
    	    }
    	}


    
    
 //....................................................................................................................   
    
    
    

    

    
    
    
   
//----------------------------------------------  METODO PARA COMENZAR EL JUEGO o SORTEO ---------------------------------------   

    
    	


		public Double realizarSorteo(String nombreJuego ,String tipoJuego, String serieApostada, String numeroApostado) {
    	    
	    	premioAcumulado = loteria_DAO.cargarPremioAcumulado();
	    	double premioReal = presupuestoDelJuego + premioAcumulado; // se suma el premio del argumento con el premioacumulado que se lleva implementado 

    		
    	    // Verificar si hay ganadores
    	        if (this.serieGanadora.equals(serieApostada) && this.numeroGanador.equals(numeroApostado)) {
    	            // Hay al menos un ganador
    	            calcularPremio(premioReal);

    	            premioAcumulado +=  premioReal - premioTOTAL; // acumula lo descontado del premio total y se suma eso para los proximos premios

    	            // Guardar números ganadores, series y premio acumulado
    	            loteria_DAO.guardarJuego(nombreJuego,tipoJuego,numeroGanador, serieGanadora, premioAcumulado);
    	            loteria_DAO.guardarApuestaLoteria(usernameDelApostador,nombreRealApostador, sede, cedula , "", costoBoleto, numeroApostado, serieApostada, fraccionesCompradas);

    	            return premioTOTAL;
    	        
    	    } else {
    	        // Si no hay ganador, acumula el premio principal
    	        
    	    	
    	        premioTOTAL = premioAcumulado += presupuestoDelJuego;

	            loteria_DAO.guardarJuego(nombreJuego,tipoJuego,numeroGanador, serieGanadora, premioTOTAL);
	            loteria_DAO.guardarApuestaLoteria(usernameDelApostador,nombreRealApostador, sede,cedula , "", costoBoleto, numeroApostado, serieApostada, fraccionesCompradas);

    	        
    	        return null;
    	    }
    	}

    
  
    
    
    
//------------------------- GETTER Y SETTERS ---------------------------------------------------------   
    

    
    
    public String getConsultarSorteo() {
    	return loteria_DAO.cargarJuego();
    }
    
    public String getConsultarApuesta() {
    	return loteria_DAO.cargarApuestaLoteria();
    }
    
    public String obtenerUltimoSorteo() {
    	return loteria_DAO.obtenerUltimoSorteo();
    }
    
    public String obtenerUltimaApuesta() {
    	return loteria_DAO.obtenerUltimaApuesta();
    }
    
    // para establecer el presupuesto que tendra el juego
    public void setPresupuestoParaLoteria(double presupuestoDelJuego) {
        this.presupuestoDelJuego = presupuestoDelJuego;
    }
    
    public String getUsuarioEnSesion() {
        return usernameDelApostador;
    }
    
    // para establecer el nombre de usuario del apostador
    public void setUsuarioEnSesion(String usernameDelApostador) {
        this.usernameDelApostador = usernameDelApostador;
    }
    
    public String getNombreRealApostador() {
		return nombreRealApostador;
	}

    // para establecer el nombre de usuario del apostador
	public void setNombreRealApostador(String nombreRealApostador) {
		this.nombreRealApostador = nombreRealApostador;
	}
	public String getCedula() {
		return cedula;
	}

    // para establecer el nombre de usuario del apostador
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public String getSede() {
		return sede;
	}


	public void setSede(String sede) {
		this.sede = sede;
	}


	public int getcantidadFraccion() {	
        return fraccionesCompradas; 
    }
    
    

    public Double getPremioAcumulado() {	
        return premioAcumulado; 
    }
    
    public ArrayList<String> getSeriesAutomaticas() {
    	return series_Disponibles;
    }
    
    
    public Double getCostoBoleto() {
        return costoBoleto;
    }

    public void setCostoBoleto(double costoBoleto) {
        this.costoBoleto = costoBoleto;
    }

    public double getPremioTOTAL() {
		return premioTOTAL;
	}


	public void setPremioTOTAL(double premioTOTAL) {
		this.premioTOTAL = premioTOTAL;
	}


	
	

}
   

    

