package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;


public class Loteria_DAO {
	
	private ArrayList<Loteria_DTO> datos;
    private String archivoCasa, archivoApuestas; // Ruta del archivo .dat
    private Loteria_DTO loteria_DTO;

    public Loteria_DAO() {
    	
    	datos = new ArrayList<>() ;
    	archivoCasa = "Archives//Juego// juegos.dat";
    	archivoApuestas = "Archives//Apuestas// apuestas-loteria.dat";
    }

    
 //---------------------- METODOS PARA EL HISTORICO DE LOS JUEGOS ---------------------------------------   
    
    public void guardarJuego(String nombreJuego, String tipoJuego, String numerosGanadores, String series, double presupuesto) {
    	
    	cargarJuego(); // para comprobar 

    	
        loteria_DTO = new Loteria_DTO(nombreJuego, tipoJuego ,numerosGanadores, series, presupuesto);

        // Agregar el nuevo número ganador a la lista existente
        datos.add(loteria_DTO);

        // Guardar la lista completa en el archivo
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivoCasa))) {
            outputStream.writeObject(datos); // Serializar y guardar el ArrayList de números ganadores
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
    
    

 // Método para cargar los juegos desde el archivo .dat
    @SuppressWarnings("unchecked")
	public ArrayList<Loteria_DTO> cargarJuego() {
    	try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivoCasa))) {
    		datos = (ArrayList<Loteria_DTO>) inputStream.readObject(); // Deserializar el ArrayList de números ganadores
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error al cargar, simplemente continuamos con la lista vacía
        	datos = new ArrayList<>();

        }
        return datos;

    }
	
	
	
/* Método que servira para que el premio acumulado despues del cierre 
	del programa no se pierda dicho premio y asignarlo denuevo para hacer la devidas operaciones con este */
	
	public Double cargarPremioAcumulado() {
		cargarJuego();

	    if (!datos.isEmpty()) {
	        // Obtener el último Loteria_DTO de la lista
	        Loteria_DTO ultimoDTO = datos.get(datos.size() - 1);
	        return ultimoDTO.getPremio();
	    }

	    return 0.0; // Devolver 0 si la lista está vacía
	}
    
	
	
//---------------------- METODOS PARA LAS APUESTAS HECHAS EN LA LOTERIA ---------------------------------------   

public void guardarApuestaLoteria(String nombreApostador, String nombreSede, int cedula, String fecha , double valorApuesta, String numeroApostador, String serieApostador, int fraccion) {
    	
	    cargarApuestaLoteria(); // para comprobar 

    	
        loteria_DTO = new Loteria_DTO(nombreApostador, nombreSede ,cedula, fecha, valorApuesta, numeroApostador, serieApostador, fraccion );

        // Agregar el nuevo número ganador a la lista existente
        datos.add(loteria_DTO);

        // Guardar la lista completa en el archivo
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivoApuestas))) {
            outputStream.writeObject(datos); // Serializar y guardar el ArrayList de números ganadores
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
    
    

 // Método para cargar los juegos desde el archivo .dat
    @SuppressWarnings("unchecked")
	public ArrayList<Loteria_DTO> cargarApuestaLoteria() {
    	try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivoApuestas))) {
    		datos = (ArrayList<Loteria_DTO>) inputStream.readObject(); // Deserializar el ArrayList de números ganadores
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error al cargar, simplemente continuamos con la lista vacía
        	datos = new ArrayList<>();

        }
        return datos;

    }

}