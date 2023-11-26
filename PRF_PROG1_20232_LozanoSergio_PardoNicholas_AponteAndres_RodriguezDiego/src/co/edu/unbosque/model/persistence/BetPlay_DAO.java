package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BetPlay_DAO {

	private ArrayList<BetPLay_DTO> datos;
    private String archivoCasa, archivoApuestas; // Ruta del archivo .dat
    private BetPLay_DTO betPLay_DTO;

    public BetPlay_DAO() {
    	
    	datos = new ArrayList<>() ;
    	archivoCasa = "Archives//Juego// juegos.dat";
    	archivoApuestas = "Archives//Apuestas// apuestas-betplay.dat";
    }

    
 //---------------------- METODOS PARA EL HISTORICO DE LOS JUEGOS ---------------------------------------   
    
    public void guardarJuego(String nombreJuego, String tipoJuego,String resultado, int numeroGolesLocal, int numeroGolesVisitante, double presupuesto) {
    	
    	cargarJuego(); // para comprobar 

    	
    	betPLay_DTO = new BetPLay_DTO(nombreJuego, tipoJuego ,resultado,numeroGolesLocal,numeroGolesVisitante , presupuesto);

        // Agregar el nuevo número ganador a la lista existente
        datos.add(betPLay_DTO);

        // Guardar la lista completa en el archivo
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivoCasa))) {
            outputStream.writeObject(datos); // Serializar y guardar el ArrayList de números ganadores
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
    
    

	
    // Método para cargar los juegos desde el archivo .dat
    @SuppressWarnings("unchecked")
	public String cargarJuego() {
    	try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivoCasa))) {
            datos = (ArrayList<BetPLay_DTO>) inputStream.readObject(); // Deserializar el ArrayList de números ganadores
            String resultado = "";
            // se recorre toda la lista de objetos 
            for (Object juego : datos) {
            	
/* es para evitar choques o malentendidos con los datos de los juegos , porque si
   no especificamos que objetos pertenecen a que instancia DTO de cada juego va haber errores de tipo 
   Exception in thread "AWT-EventQueue-0" java.lang.ClassCastException: ya que este error se genera porque nosotros manejamos 
   todos los sorteos y esta informacion en el mismo archivo juegos.dat donde se encuentran datos de cualquier instancia dto de cualquier juego
    por eso se tiene que saber que objetos pertenecen a que instancia DTO*/ 
            	
                // Verificar si el juego es una instancia de SuperAstro_DTO            	
                if (juego instanceof BetPLay_DTO) {
                	
                    // Realizar un casting seguro a SuperAstro_DTO
                	BetPLay_DTO betplay_DTO = (BetPLay_DTO) juego;
                    resultado += betplay_DTO.toStringJuego();
                }
            }
            return resultado;
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error al cargar, simplemente continuamos con la lista vacía
            datos = new ArrayList<>();
            return "Error al cargar el historial de juegos.";
        }

    }
	
    
    
/* Método que servira para que el premio acumulado despues del cierre 
	del programa no se pierda dicho premio y asignarlo denuevo para hacer la devidas operaciones con este */
	
	public Double cargarPremioAcumulado() {
		cargarJuego();

	    if (!datos.isEmpty()) {
	        // Obtener el último objeto de SuperAstro_DTO de la lista
	    	 for (int i = datos.size() - 1; i >= 0; i--) {
	    		 
	             // Verificar si el elemento en la posición actual es una instancia de SuperAstro_DTO
	             if (datos.get(i) instanceof BetPLay_DTO) {
	                 // Realizar un casting seguro a SuperAstro_DTO
	            	 BetPLay_DTO ultimoDTO = (BetPLay_DTO) datos.get(i);
	                 return ultimoDTO.getPremio();
	             }
	         }
	    }

	    return 0.0; // Devolver 0 si la lista está vacía
	}
    
	
	
//---------------------- METODOS PARA LAS APUESTAS HECHAS EN LA LOTERIA ---------------------------------------   

public void guardarApuestaSuperAstro(String usernameApostador, String nombreApostador, String nombreSede, String cedula, String fecha , double valorApuesta, String equipoApostado) {
    	
	    cargarApuestaSuperAstro(); // para comprobar 

    	
	    betPLay_DTO = new BetPLay_DTO(usernameApostador,nombreApostador, nombreSede ,cedula, fecha, valorApuesta, equipoApostado );

        // Agregar el nuevo número ganador a la lista existente
        datos.add(betPLay_DTO);

        // Guardar la lista completa en el archivo
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivoApuestas))) {
            outputStream.writeObject(datos); // Serializar y guardar el ArrayList de números ganadores
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
    
    

 // Método para cargar los juegos desde el archivo .dat
    @SuppressWarnings("unchecked")
	public String cargarApuestaSuperAstro() {
 
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivoApuestas))) {
            datos = (ArrayList<BetPLay_DTO>) inputStream.readObject(); // Deserializar el ArrayList de números ganadores
            String resultado = "";
            for (BetPLay_DTO juego : datos) {
                resultado += juego.toStringApostador();
            }
            return resultado;
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error al cargar, simplemente continuamos con la lista vacía
            datos = new ArrayList<>();
            return "Error al cargar el historial de juegos.";
        }
        
    }	
	
	
	//................................. metodos que mostraran los ultimos datos ...............................................
   
	public String obtenerUltimoSorteo() {
		
    	cargarJuego();
		    if (!datos.isEmpty()) {
		    	betPLay_DTO = datos.get(datos.size() - 1); // se toma el ultimo elemento de la arraylist
		        return betPLay_DTO.toStringJuego(); // se utiliza el metodo del dto para convertir los datos en un string para que puedan ser leidos
		    } else {
		        return "no hay ningun juego"; // mensaje predeterminado
		    }
		}
   
   
   
    public String obtenerUltimaApuesta() {
		
	       cargarApuestaSuperAstro();
		    if (!datos.isEmpty()) {
		    	betPLay_DTO = datos.get(datos.size() - 1);// se toma el ultimo elemento de la arraylist
		        return betPLay_DTO.toStringApostador();// se utiliza el metodo del dto para convertir los datos en un string para que puedan ser leidos
		    } else {
		        return "no hay ninguna apuesta"; // mensaje predeterminado
		    }
		}  
	
//_---------------------------------------------------------------------------------------------------------------	
	


	
}
