package co.edu.unbosque.model;

import java.util.Random;

import co.edu.unbosque.model.persistence.Baloto_DAO;

public class Baloto {

    private Baloto_DAO baloto_DAO;
	

    private int nuevoNumeroGanador, nuevonumeroSuperBalotaGanadora;  
    
    private String numeroGanador, numeroSuperBalotaGanadora,ultimosDigitoGanador ,ultimosDosDigitosGanador, ultimosDosDigitosApostado, ultimosTresDigitosGanador,ultimosTresDigitosApostado ; 

    
    private double premioTOTAL, premioAcumulado, premioAcumuladoRenvacha, costoBoleto ; // Monto del premio principal
    private double presupuestoDelJuego; // Almacenar el presupuesto por juego

    
    private String usernameDelApostador, nombreRealApostador, cedula, sede;
    
    private Random random;

    
    
    public Baloto() {
        
    	baloto_DAO = new Baloto_DAO();
    	random = new Random();
    
    
    }
    
    
 //----------------------------------------------  METODOS NECESARIOS DE LOTERIA ---------------------------------------   
    
    
          /*--------------------- METODOS PARA QUE GENERES UN NUMERO DE 4 DIGITOS Y UN SERIE GANADORA ------------------------*/

    
    public void generarNumerosGanadores(String numeroApostador, int superBalota) {
    
    // daremos la probabilidad 50/50 para que este pueda ganar el premio con los 4 digitos
    	
    	// Generar un número aleatorio entre 1 y 100
        int probabilidadNumero = random.nextInt(100) + 1;

        if (probabilidadNumero <= 50) {
            // Si la probabilidad es 1-50%, elige el número del apostador
        	numeroGanador = numeroApostador;
        } else {
            // Si la probabilidad es 51-100%, elige un número aleatorio de 5 digitos cualquiera
        	 int numero = 0;
             for (int i = 0; i < 5; i++) {
                 int digito = random.nextInt(45) + 1; // Números entre 1 y 45
                 String digitoConCeros = String.format("%02d", digito);
                 numero = numero * 100 + Integer.parseInt(digitoConCeros);
                 }
             nuevoNumeroGanador = numero;
             // Convierte el número en una cadena (String) con ceros a la izquierda si es necesario
             numeroGanador = String.format("%05d", nuevoNumeroGanador);
        }

       
            
        int probabilidadSuperBalota = random.nextInt(100) + 1;

        if (probabilidadSuperBalota <= 50) {
            // Si la probabilidad es 1-50%, elige el número del apostador
        	nuevonumeroSuperBalotaGanadora = superBalota;
        } else {
            // Si la probabilidad es 51-100%, elige un número aleatorio de 5 digitos cualquiera
        
             int numero = random.nextInt(16) + 1; // Números entre 1 y 45
             
             nuevonumeroSuperBalotaGanadora = numero;
        }
        numeroSuperBalotaGanadora = String.format("%02d", nuevonumeroSuperBalotaGanadora);
            
    }
    
    
public void asignarDigitos(String numeroApostado) {
	
	ultimosDigitoGanador = numeroGanador.substring(numeroGanador.length() - 1);
	ultimosDigitoGanador = numeroApostado.substring(numeroApostado.length() - 1);
	
    // Obtener los últimos 2 dígitos del número ganador y del número apostado
    ultimosDosDigitosGanador = numeroGanador.substring(numeroGanador.length() - 2);
    ultimosDosDigitosApostado = numeroApostado.substring(numeroApostado.length() - 2);

   // Obtener los últimos 3 dígitos del número ganador y del número apostado
    ultimosTresDigitosGanador = numeroGanador.substring(numeroGanador.length() - 3);
    ultimosTresDigitosApostado = numeroApostado.substring(numeroApostado.length() - 3);
}
    
    
    
    /*--------------------------- METODOS PARA COMPROBAR SI GANO Y  LA CANTINDAD DE DINERO DEPENDIENDO LAS CIFRAS-----------------------------------*/

    
    	public double calcularPremio(double premio, String numeroApostado, String tipoDeBaloto) {


    	    
    		asignarDigitos(numeroApostado);
    	    
    	    double premioPorCifra = 0;
    	    double premioDescontado = 0;
    	
	    	setCostoBoleto(tipoDeBaloto);  // en el set pondra el valorApostado con IVA incluido 


    	    // Verificar si el ultimo dígito coinciden
    	    if (ultimosDigitoGanador.equals(ultimosDigitoGanador)) {

    	    	
    	    	premioAcumulado += premio - costoBoleto ; // gana lo mismo invertido 
    	    	
    	    	premioTOTAL = costoBoleto;
    	    	
    	    	return premioTOTAL;
    	    }

    	    // Verificar si los últimos 3 dígitos coinciden
    	    if (ultimosTresDigitosGanador.equals(ultimosTresDigitosApostado)) {

    	    	premioPorCifra = costoBoleto * 1000; // se gana cien veces lo apostado si acierta los 2 ultimos digitos 
    	    	premioDescontado = premioPorCifra * 0.8 ;  // el 20 % del superastro que se queda 
    	    	
    	    	premioAcumulado += premioPorCifra - premioDescontado;
    	    	
    	    	premioTOTAL = premio - premioDescontado;
    	    	
    	    	return premioTOTAL;
    	    }
    	    
    	 // Verificar si todos los dígitos son iguales
    	    if (numeroApostado.equals(numeroGanador)) {
    	    	
    	        premioPorCifra = costoBoleto * 42000; // Se gana cuarenta y dos mil veces lo apostado si todos los dígitos son iguales
    	        premioDescontado = premioPorCifra * 0.8;  // El 20 % del superastro que se queda

    	        premioAcumulado += premioPorCifra - premioDescontado;
    	        premioTOTAL = premio - premioDescontado;

    	        return premioTOTAL;
    	        
    	    }else {
    	        // cuenta  la cantidad de dígitos iguales
    	        double digitosIguales = numeroApostado.chars().distinct().filter(c -> c == numeroGanador.charAt(0)).count();

    	        // Verificar si no tiene ningún dígito igual o solo tiene un digito 
    	        if (digitosIguales == 0 || digitosIguales == 1) {

    	        	premioAcumulado += premio;
    	        	
    	        	return premioAcumulado;
    	        	
    	        }
    	    }
			return 0;
    	    	   
    	}
    	
    
    

    	  public void setCostoBoleto(String Baloto) {
    		  
    		  switch (Baloto) {
    		     
    		  case "Baloto":
    		
      		        this.costoBoleto = 5700; 
    			  
    			  break;
    		  case "Revancha":

        		    this.costoBoleto = 7800; 
    			  
    			  break;
    			  
    		  
    		  }
    		                          
    		 
    		}

    
    
 //....................................................................................................................   
    
    
    

    

    
    
    
   
//----------------------------------------------  METODO PARA COMENZAR EL JUEGO o SORTEO ---------------------------------------   

    
    	


		public Double realizarSorteo(String nombreJuego ,String tipoJuego, String superBalotaApostador, String numeroApostado, String TipodeBaloto) {
    	    
	    	premioAcumulado = baloto_DAO.cargarPremioAcumulado();
	    	
	    	double premioReal = presupuestoDelJuego + premioAcumulado; // se suma el premio del argumento con el premioacumulado que se lleva implementado 

    		asignarDigitos(numeroApostado);
    		setCostoBoleto(TipodeBaloto);
	    	
    		
    	    // Verificar si hay ganadores
    	        if (this.numeroSuperBalotaGanadora.equals(superBalotaApostador) && this.numeroGanador.equals(numeroApostado) && ultimosDosDigitosGanador.equals(ultimosDosDigitosApostado) && ultimosTresDigitosGanador.equals(ultimosTresDigitosApostado)) {
    	            // Hay al menos un ganador
    	            calcularPremio(premioReal, numeroApostado, TipodeBaloto);

    	            premioAcumulado +=  premioReal - premioTOTAL; // acumula lo descontado del premio total y se suma eso para los proximos premios

    	            // Guardar números ganadores, series y premio acumulado
    	            baloto_DAO.guardarJuego(nombreJuego,tipoJuego,numeroGanador, numeroSuperBalotaGanadora, premioAcumulado);
    	            baloto_DAO.guardarApuestaSuperAstro(usernameDelApostador,nombreRealApostador, sede, cedula , "", costoBoleto, numeroApostado, superBalotaApostador);

    	            return premioTOTAL;
    	        
    	    } else {
    	        // Si no hay ganador, acumula el premio principal
    	        
    	    	
    	        premioTOTAL = premioAcumulado += presupuestoDelJuego;

    	        baloto_DAO.guardarJuego(nombreJuego,tipoJuego,numeroGanador, numeroSuperBalotaGanadora, premioTOTAL);
    	        baloto_DAO.guardarApuestaSuperAstro(usernameDelApostador,nombreRealApostador, sede,cedula , "", costoBoleto, numeroApostado, superBalotaApostador);

    	        
    	        return premioTOTAL;
    	    }
    	}

    
  
    
    
    
//------------------------- GETTER Y SETTERS ---------------------------------------------------------   
    

    
    
    public String getConsultarSorteo() {
    	return baloto_DAO.cargarJuego();
    }
    
    public String getConsultarApuesta() {
    	return baloto_DAO.cargarApuestaSuperAstro();
    }
    
    public String obtenerUltimoSorteo() {
    	return baloto_DAO.obtenerUltimoSorteo();
    }
    
    public String obtenerUltimaApuesta() {
    	return baloto_DAO.obtenerUltimaApuesta();
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
