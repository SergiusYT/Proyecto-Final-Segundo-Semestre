package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import co.edu.unbosque.model.persistence.BetPlay_DAO;

public class BetPlay {

    private BetPlay_DAO betPlay_DAO;
	
    private ArrayList<String> equipos;

    private int NumeroGolesLocal, NumeroGolesVisitante;  
    
    private String marcador;
    
    private double premioTOTAL, premioAcumulado, costoBoleto ; // Monto del premio principal
    private double presupuestoDelJuego; // Almacenar el presupuesto por juego

    
    private String usernameDelApostador, nombreRealApostador, cedula, sede;
    
    private Random random;

    
    
    public BetPlay() {
        
    	betPlay_DAO = new BetPlay_DAO();
    	random = new Random();
    	
    	
    	 // Inicializa la lista de signos zodiacales con todos los signos
    	equipos = new ArrayList<>();
    	equipos.add("Atletico Nacional");
    	equipos.add("Millonarios");
    	equipos.add("America de Cali");
        equipos.add("Junior de Barranquilla");
        equipos.add("Independiente Santa Fe");
        equipos.add("Independiente Medellin");
        equipos.add("Deportivo Cali");
        equipos.add("Deportes Tolima");
        equipos.add("Once Caldas");
        equipos.add("Alianza Petrolera");
        equipos.add("Atletico Bucaramanga");
        equipos.add("Deportivo Pasto");
        equipos.add("Envigado");
        equipos.add("Jaguares");
        equipos.add("La Equidad");
        equipos.add("Rionegro Aguilas");
        equipos.add("Deportivo Pereira");
        equipos.add("Union Magdalena");
        equipos.add("Boyaca Chico");
        equipos.add("Atletico Huila");
        equipos.add("Bogota F.C.");
        equipos.add("Fortaleza");
        equipos.add("Deportivo Cucuta");
        equipos.add("Llaneros F.C.");
        equipos.add("Patriotas");
        equipos.add("Leones");
        equipos.add("Real Cartagena");
        equipos.add("Real San Andres");

    }
    
    
 //----------------------------------------------  METODOS NECESARIOS DE LOTERIA ---------------------------------------   
    
    
          /*--------------------- METODOS PARA QUE GENERES UN NUMERO DE 4 DIGITOS Y UN SERIE GANADORA ------------------------*/

    
    public void generarEquiposGanadores() {
    
    // daremos la probabilidad 50/50 para que este pueda ganar el premio con los 4 digitos
    	
    	int totalProbabilidad = 100 + 1;

    	// Define las probabilidades para cada número
    	int probabilidad0a3 = 60; // Probabilidad acumulada de obtener 0, 1, 2 o 3
    	int probabilidad4a6 = 30; // Probabilidad acumulada de obtener 4, 5 o 6

    	int numeroAleatorio = random.nextInt(totalProbabilidad);

    	// Aplica las probabilidades y establece el número
    	if (numeroAleatorio < probabilidad0a3) {
    	    // Probabilidad de 0, 1, 2, o 3
    	    NumeroGolesLocal = random.nextInt(4);
    	    NumeroGolesVisitante = random.nextInt(4);
    	    
    	} else if (numeroAleatorio < probabilidad0a3 + probabilidad4a6) {
    	    // Probabilidad de 4, 5, o 6
    	    NumeroGolesLocal = random.nextInt(3) + 4;
    	    NumeroGolesVisitante = random.nextInt(3) + 4;

    	} else {
    	    // Probabilidad del resto (7 a 15)
    	    NumeroGolesLocal = random.nextInt(9) + 7;
    	    NumeroGolesVisitante = random.nextInt(9) + 7;

    	} 

            

    }
    
    
    
    public double generarValorEquipo() {
        double totalProbabilidad = 100.0;

        // Define las probabilidades para cada rango
        double probabilidad0a3 = 70.0; // Probabilidad de obtener un número entre 0 y 3

        double numeroAleatorio = random.nextDouble() * totalProbabilidad;

        // Aplica las probabilidades y establece el número
        if (numeroAleatorio < probabilidad0a3) {
            // Probabilidad de obtener un número entre 0 y 3
            return random.nextDouble() * 3.0;
        } else {
            // Probabilidad del resto (4 a 7)
            return random.nextDouble() * 4.0 + 4.0;
        }
    }
    
    public void generarPartidos() {
    	ArrayList<String> equiposDisponibles = new ArrayList<>(equipos); // Copia de la lista original

        for (int i = 0; i < 14; i++) {
            // Elegir aleatoriamente dos equipos
            Collections.shuffle(equiposDisponibles); // Mezcla la lista para seleccionar aleatoriamente
            String equipoLocal = equiposDisponibles.get(0);
            String equipoVisitante = equiposDisponibles.get(1);

            // Generar los goles para cada equipo
            generarEquiposGanadores();

            // Determinar el resultado (gano o empate) basado en los goles
            if (NumeroGolesLocal > NumeroGolesVisitante) {
            	marcador = "Local";
            }else if(NumeroGolesLocal < NumeroGolesVisitante) {            	
            	marcador = "Visitante";
            }
            else {
            	marcador = "Empate";
            }

            // Mostrar o almacenar el resultado
            System.out.println("Partido " + (i + 1) + ": " + equipoLocal + " vs " + equipoVisitante + " - " + marcador);

            // Retirar los equipos seleccionados para evitar repeticiones
            equiposDisponibles.remove(equipoLocal);
            equiposDisponibles.remove(equipoVisitante);
        }
    
    }
    
    /*--------------------------- METODOS PARA COMPROBAR SI GANO Y  LA CANTINDAD DE DINERO DEPENDIENDO LAS CIFRAS-----------------------------------*/

    
    	public double calcularPremio(String equipoApostado, double valorApostado) {


    
	    	setCostoBoleto(valorApostado);  // en el set pondra el valorApostado con IVA incluido 

	    	switch (equipoApostado) {
	    	
	    	case "Local":
	    		
	    		premioTOTAL = valorApostado * generarValorEquipo();
	    		
	    		break;
	    		
	    	case "Visitante":
	    		
	    		premioTOTAL = valorApostado * generarValorEquipo();
	    		
	    		break;
	    		
	    	case "Empate":
	    		
	    		premioTOTAL = valorApostado * generarValorEquipo();

	    		
	    		break;
	    	}

	    	
       	        return premioTOTAL;

    	    }
    	    
    	    
	    	
    	   
    	
    	 public void setCostoBoleto(double costoBoleto) {
    	        this.costoBoleto = costoBoleto;
    	    }
    
    
 //....................................................................................................................   
    
    
    

    

    
    
    
   
//----------------------------------------------  METODO PARA COMENZAR EL JUEGO o SORTEO ---------------------------------------   

    
    	


		public Double realizarSorteo(String nombreJuego ,String tipoJuego, String equipoApostado, double valorApostado) {
    	    
	    	
			premioAcumulado = betPlay_DAO.cargarPremioAcumulado();
	    	
	    	double premioReal = presupuestoDelJuego + premioAcumulado; // se suma el premio del argumento con el premioacumulado que se lleva implementado 

    		setCostoBoleto(valorApostado);
	    	
    		generarPartidos();
    		
    	    // Verificar si hay ganadores
    		 
    		 if(equipoApostado.equals(marcador)) {
    		
    	            // Hay al menos un ganador
    	            calcularPremio(equipoApostado, valorApostado);

    	            premioAcumulado =  premioReal - premioTOTAL; // acumula lo descontado del premio total y se suma eso para los proximos premios

    	            // Guardar números ganadores, series y premio acumulado
    	            betPlay_DAO.guardarJuego(nombreJuego,tipoJuego,marcador,NumeroGolesLocal , NumeroGolesVisitante ,premioAcumulado);
    	            betPlay_DAO.guardarApuestaSuperAstro(usernameDelApostador,nombreRealApostador, sede, cedula , "", costoBoleto, equipoApostado);

    	        		
    	            return premioTOTAL;
    	        	
    	    } else {
    	        // Si no hay ganador, acumula el premio principal
    	        
    	    	
    	        premioTOTAL = premioAcumulado += presupuestoDelJuego;

    	        betPlay_DAO.guardarJuego(nombreJuego,tipoJuego,marcador,NumeroGolesLocal , NumeroGolesVisitante , premioTOTAL);
    	        betPlay_DAO.guardarApuestaSuperAstro(usernameDelApostador,nombreRealApostador, sede,cedula , "", costoBoleto, equipoApostado);

    	        
    	        return premioTOTAL;
    	    }
    	}

    
  
    
    
    
//------------------------- GETTER Y SETTERS ---------------------------------------------------------   
    

    
    
    public String getConsultarSorteo() {
    	return betPlay_DAO.cargarJuego();
    }
    
    public String getConsultarApuesta() {
    	return betPlay_DAO.cargarApuestaSuperAstro();
    }
    
    public String obtenerUltimoSorteo() {
    	return betPlay_DAO.obtenerUltimoSorteo();
    }
    
    public String obtenerUltimaApuesta() {
    	return betPlay_DAO.obtenerUltimaApuesta();
    }
    
    // para establecer el presupuesto que tendra el juego
    public void setPresupuestoParaSuperAstro(double presupuestoDelJuego) {
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




    public Double getPremioAcumulado() {	
        return premioAcumulado; 
    }
    
    public ArrayList<String> getEquipos() {
    	return equipos;
    }
    
    
    public Double getCostoBoleto() {
        return costoBoleto;
    }

  
    public double getPremioTOTAL() {
		return premioTOTAL;
	}


	public void setPremioTOTAL(double premioTOTAL) {
		this.premioTOTAL = premioTOTAL;
	}


	
	
	
	
}