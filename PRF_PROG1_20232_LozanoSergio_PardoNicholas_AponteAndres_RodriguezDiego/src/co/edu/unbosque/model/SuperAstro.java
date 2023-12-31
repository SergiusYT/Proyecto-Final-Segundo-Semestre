package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Random;

import co.edu.unbosque.model.persistence.SuperAstro_DAO;

public class SuperAstro {

    private SuperAstro_DAO superAstro_DAO;
	
    private ArrayList<String> signosZodiacos;

    private int nuevoNumeroGanador;  
    
    private String numeroGanador, signosZodiacosGanador, ultimosDosDigitosGanador, ultimosDosDigitosApostado, ultimosTresDigitosGanador,ultimosTresDigitosApostado ; 

    
    private double premioTOTAL, premioAcumulado, costoBoleto ; // Monto del premio principal
    private double presupuestoDelJuego; // Almacenar el presupuesto por juego

    
    private String usernameDelApostador, nombreRealApostador, cedula, sede;
    
    private Random random;

    
    
    public SuperAstro() {
        
    	superAstro_DAO = new SuperAstro_DAO();
    	random = new Random();
    	
    	
    	 // Inicializa la lista de signos zodiacales con todos los signos
        signosZodiacos = new ArrayList<>();
        signosZodiacos.add("Aries");
        signosZodiacos.add("Tauro");
        signosZodiacos.add("Géminis");
        signosZodiacos.add("Cáncer");
        signosZodiacos.add("Leo");
        signosZodiacos.add("Virgo");
        signosZodiacos.add("Libra");
        signosZodiacos.add("Escorpio");
        signosZodiacos.add("Sagitario");
        signosZodiacos.add("Capricornio");
        signosZodiacos.add("Acuario");
        signosZodiacos.add("Piscis");
    
    }
    
    
 //----------------------------------------------  METODOS NECESARIOS DE LOTERIA ---------------------------------------   
    
    
          /*--------------------- METODOS PARA QUE GENERES UN NUMERO DE 4 DIGITOS Y UN SERIE GANADORA ------------------------*/

    
    public void generarNumerosGanadores(int numeroApostador, String signoApostador) {
    
    // daremos la probabilidad 50/50 para que este pueda ganar el premio con los 4 digitos
    	
        // Probabilidad para el Numero
        int probabilidadNumero = random.nextInt(100) + 1;

        if (probabilidadNumero <= 50) {
            // Si la probabilidad es 1-50%, elige el número del apostador
            nuevoNumeroGanador = numeroApostador;
        } else {
            // Si la probabilidad es 51-100%, elige un número aleatorio como de 4 digitos cualquiera
            nuevoNumeroGanador = random.nextInt(10000);
        }

        // Convierte el número en una cadena (String) con ceros a la izquierda si es necesario
        numeroGanador = String.format("%04d", nuevoNumeroGanador);

            
     // Probabilidad para el signo zodiacal
        int probabilidadSigno = random.nextInt(100) + 1;

        // Aumentar la probabilidad de que salga el signo seleccionado por el usuario
        if (probabilidadSigno <= 50 ) {
            // Aumentar la probabilidad en un 50%
        	signosZodiacosGanador = "";
        	
        	signosZodiacosGanador.equals(signoApostador);
        }else {
        	 // Generar un índice aleatorio para seleccionar un signo zodiacal
            int indiceSigno = random.nextInt(signosZodiacos.size());
            signosZodiacosGanador = signosZodiacos.get(indiceSigno);

        }
          
    }
    
    
public void asignarDigitos(String numeroApostado) {
    // Obtener los últimos 2 dígitos del número ganador y del número apostado
    ultimosDosDigitosGanador = numeroGanador.substring(numeroGanador.length() - 2);
    ultimosDosDigitosApostado = numeroApostado.substring(numeroApostado.length() - 2);

   // Obtener los últimos 3 dígitos del número ganador y del número apostado
    ultimosTresDigitosGanador = numeroGanador.substring(numeroGanador.length() - 3);
    ultimosTresDigitosApostado = numeroApostado.substring(numeroApostado.length() - 3);
}
    
    
    
    /*--------------------------- METODOS PARA COMPROBAR SI GANO Y  LA CANTINDAD DE DINERO DEPENDIENDO LAS CIFRAS-----------------------------------*/

    
    	public double calcularPremio(double premio, String numeroApostado, double valorApostado) {


    	    
    		asignarDigitos(numeroApostado);
    	    
    	    double premioPorCifra = 0;
    	    double premioDescontado = 0;
    	
	    	setCostoBoleto(valorApostado);  // en el set pondra el valorApostado con IVA incluido 


	    	// Verificar si todos los dígitos son iguales
    	    if (numeroApostado.equals(numeroGanador)) {
    	    	
    	        premioPorCifra = costoBoleto * 42000; // Se gana cuarenta y dos mil veces lo apostado si todos los dígitos son iguales

    	    	if (premioPorCifra > premio) {
    	    	 
    	    	 premioDescontado = premio * 0.2;
    	    	 
    	    	 premioTOTAL = 	premio - premioDescontado;
    	    		
    	    	}else {	
    	    		

    	        premioTOTAL = premioPorCifra - premioDescontado;

    	    	}
       	        return premioTOTAL;

    	    }
    	    
    	    // Verificar si los últimos 3 dígitos coinciden
    	    if (ultimosTresDigitosGanador.equals(ultimosTresDigitosApostado)) {

    	    	premioPorCifra = costoBoleto * 1000; // se gana cien veces lo apostado si acierta los 2 ultimos digitos 
    	    	
    	    	if (premioPorCifra > premio) {
       	    	 
       	    	 premioDescontado = premio * 0.2;
       	    	 
       	    	 premioTOTAL = 	premio - premioDescontado;
       	    		
       	    	}else {	
       	    		

       	        premioTOTAL = premioPorCifra - premioDescontado;

       	    	}
    	    	
       	        return premioTOTAL;

    	    }
    	    
    	    
	    	
    	    // Verificar si los últimos 2 dígitos coinciden
    	    if (ultimosDosDigitosGanador.equals(ultimosDosDigitosApostado)) {

    	    	premioPorCifra = costoBoleto * 100; // se gana cien veces lo apostado si acierta los 2 ultimos digitos 
    	    	
    	    	if (premioPorCifra > premio) {
       	    	 
       	    	 premioDescontado = premio * 0.2;
       	    	 
       	    	 premioTOTAL = 	premio - premioDescontado;
       	    		
       	    	}else {	
       	    		

       	        premioTOTAL = premioPorCifra - premioDescontado;

       	    	}
       	        return premioTOTAL;

    	    }
    /*
    	    else {
    	        // cuenta  la cantidad de dígitos iguales
    	        double digitosIguales = numeroApostado.chars().distinct().filter(c -> c == numeroGanador.charAt(0)).count();

    	        // Verificar si no tiene ningún dígito igual o solo tiene un digito 
    	        if (digitosIguales == 0 || digitosIguales == 1) {

    	        	premioAcumulado += premio;
    	        	
    	        	return premioAcumulado;
    	        	
    	        }
    	    }  */
   	        return premioTOTAL;
    	    	   
    	}
    	
    
    

    	  public void setCostoBoleto(double valorApuesta) {
    		                          
    		  double valorSinIVA = valorApuesta / 1.19; // Se le aplica el IVA al valor (19%)

    		    // Redondear el valorSinIVA al entero más cercano
    		    double valorRedondeado = Math.round(valorSinIVA);

    		    this.costoBoleto = valorRedondeado;
    		}

    
    
 //....................................................................................................................   
    
    
    

    

    
    
    
   
//----------------------------------------------  METODO PARA COMENZAR EL JUEGO o SORTEO ---------------------------------------   

    
    	


		public Double realizarSorteo(String nombreJuego ,String tipoJuego, String signoApostador, String numeroApostado, double valorApostado) {
    	    
	    	
			premioAcumulado = superAstro_DAO.cargarPremioAcumulado();
	    	
	    	double premioReal = presupuestoDelJuego + premioAcumulado; // se suma el premio del argumento con el premioacumulado que se lleva implementado 

    		asignarDigitos(numeroApostado);
    		setCostoBoleto(valorApostado);
	    	
    		signosZodiacosGanador = signoApostador;
    		numeroGanador = numeroApostado;
    		
    	    // Verificar si hay ganadores
    	        if (this.signosZodiacosGanador.equals(signoApostador)) {
    	        	if (this.numeroGanador.equals(numeroApostado) || ultimosDosDigitosGanador.equals(ultimosDosDigitosApostado) || ultimosTresDigitosGanador.equals(ultimosTresDigitosApostado)) {
    	            // Hay al menos un ganador
    	            calcularPremio(premioReal, numeroApostado, valorApostado);

    	            premioAcumulado =  premioReal - premioTOTAL; // acumula lo descontado del premio total y se suma eso para los proximos premios

    	            // Guardar números ganadores, series y premio acumulado
    	            superAstro_DAO.guardarJuego(nombreJuego,tipoJuego,numeroGanador, signosZodiacosGanador, premioAcumulado);
    	            superAstro_DAO.guardarApuestaSuperAstro(usernameDelApostador,nombreRealApostador, sede, cedula , "", costoBoleto, numeroApostado, signoApostador);

    	        	}
    	            return premioTOTAL;
    	        	
    	    } else {
    	        // Si no hay ganador, acumula el premio principal
    	        
    	    	
    	        premioTOTAL = premioAcumulado += presupuestoDelJuego;

    	        superAstro_DAO.guardarJuego(nombreJuego,tipoJuego,numeroGanador, signosZodiacosGanador, premioTOTAL);
	            superAstro_DAO.guardarApuestaSuperAstro(usernameDelApostador,nombreRealApostador, sede,cedula , "", costoBoleto, numeroApostado, signoApostador);

    	        
    	        return premioTOTAL;
    	    }
    	}

    
  
    
    
    
//------------------------- GETTER Y SETTERS ---------------------------------------------------------   
    

    
    
    public String getConsultarSorteo() {
    	return superAstro_DAO.cargarJuego();
    }
    
    public String getConsultarApuesta() {
    	return superAstro_DAO.cargarApuestaSuperAstro();
    }
    
    public String obtenerUltimoSorteo() {
    	return superAstro_DAO.obtenerUltimoSorteo();
    }
    
    public String obtenerUltimaApuesta() {
    	return superAstro_DAO.obtenerUltimaApuesta();
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
    
    public ArrayList<String> getSignosZodiacos() {
    	return signosZodiacos;
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