package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Baloto_DAO {

	private ArrayList<Baloto_DTO> datos;
    private String archivoCasa, archivoApuestas; // Ruta del archivo .dat
    private Baloto_DTO baloto_DTO;

    public Baloto_DAO() {
    	
    	datos = new ArrayList<>() ;
    	archivoCasa = "Archives//Juego// juegos.dat";
    	archivoApuestas = "Archives//Apuestas// apuestas-baloto.dat";
    }

    
 //---------------------- METODOS PARA EL HISTORICO DE LOS JUEGOS ---------------------------------------   
    
    public void guardarJuego(String nombreJuego, String tipoJuego, String numerosGanadores, String superBalotaGanadora, double presupuesto) {
    	
    	cargarJuego(); // para comprobar 

    	
    	baloto_DTO = new Baloto_DTO(nombreJuego, tipoJuego ,numerosGanadores, superBalotaGanadora, presupuesto);

        // Agregar el nuevo número ganador a la lista existente
        datos.add(baloto_DTO);

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
            datos = (ArrayList<Baloto_DTO>) inputStream.readObject(); // Deserializar el ArrayList de números ganadores
            String resultado = "";
            // se recorre toda la lista de objetos 
            for (Object juego : datos) {
            	
/* es para evitar choques o malentendidos con los datos de los juegos , porque si
   no especificamos que objetos pertenecen a que instancia DTO de cada juego va haber errores de tipo 
   Exception in thread "AWT-EventQueue-0" java.lang.ClassCastException: ya que este error se genera porque nosotros manejamos 
   todos los sorteos y esta informacion en el mismo archivo juegos.dat donde se encuentran datos de cualquier instancia dto de cualquier juego
    por eso se tiene que saber que objetos pertenecen a que instancia DTO*/ 
            	
                // Verificar si el juego es una instancia de SuperAstro_DTO            	
                if (juego instanceof Baloto_DTO) {
                	
                    // Realizar un casting seguro a SuperAstro_DTO
                	Baloto_DTO baloto_DTO = (Baloto_DTO) juego;
                    resultado += baloto_DTO.toStringJuego();
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
	             if (datos.get(i) instanceof Baloto_DTO) {
	                 // Realizar un casting seguro a SuperAstro_DTO
	            	 Baloto_DTO ultimoDTO = (Baloto_DTO) datos.get(i);
	                 return ultimoDTO.getPremio();
	             }
	         }
	    }

	    return 0.0; // Devolver 0 si la lista está vacía
	}
    
    
	
	
//---------------------- METODOS PARA LAS APUESTAS HECHAS EN LA LOTERIA ---------------------------------------   

public void guardarApuestaSuperAstro(String usernameApostador, String nombreApostador, String nombreSede, String cedula, String fecha , double valorApuesta, String numeroApostador, String signoZodiacoApostado) {
    	
	    cargarApuestaSuperAstro(); // para comprobar 

    	
	    baloto_DTO = new Baloto_DTO(usernameApostador,nombreApostador, nombreSede ,cedula, fecha, valorApuesta, numeroApostador, signoZodiacoApostado );

        // Agregar el nuevo número ganador a la lista existente
        datos.add(baloto_DTO);

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
            datos = (ArrayList<Baloto_DTO>) inputStream.readObject(); // Deserializar el ArrayList de números ganadores
            String resultado = "";
            for (Baloto_DTO juego : datos) {
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
		    	baloto_DTO = datos.get(datos.size() - 1); // se toma el ultimo elemento de la arraylist
		        return baloto_DTO.toStringJuego(); // se utiliza el metodo del dto para convertir los datos en un string para que puedan ser leidos
		    } else {
		        return "no hay ningun juego"; // mensaje predeterminado
		    }
		}
   
   
   
    public String obtenerUltimaApuesta() {
		
	       cargarApuestaSuperAstro();
		    if (!datos.isEmpty()) {
		    	baloto_DTO = datos.get(datos.size() - 1);// se toma el ultimo elemento de la arraylist
		        return baloto_DTO.toStringApostador();// se utiliza el metodo del dto para convertir los datos en un string para que puedan ser leidos
		    } else {
		        return "no hay ninguna apuesta"; // mensaje predeterminado
		    }
		}  
	
//_---------------------------------------------------------------------------------------------------------------	
	


	

}

	

