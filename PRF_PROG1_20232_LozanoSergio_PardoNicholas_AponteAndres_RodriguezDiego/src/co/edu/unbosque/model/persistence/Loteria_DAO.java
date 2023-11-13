package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;


public class Loteria_DAO {
	
	private ArrayList<Loteria_DTO> numeros;
    private String archivoCasa, archivoApuestas; // Ruta del archivo .dat
    private Loteria_DTO loteria_DTO;

    public Loteria_DAO() {
    	
    	numeros = new ArrayList<>() ;
    	archivoCasa = "Archives//Juego// juegos.dat";
    	archivoApuestas = "Archives//Apuestas// apuestas-loteria.dat";
    }

    
 //---------------------- METODOS PARA EL HISTORICO DE LOS NUMEROS GANADORES ---------------------------------------   
    
    public void guardarNumerosGanadores(String numerosGanadores, String series, double prmeioAcumulado) {
    	
        cargarNumerosGanadores(); // para comprobar 

    	
        loteria_DTO = new Loteria_DTO(numerosGanadores, series, prmeioAcumulado);

        // Agregar el nuevo número ganador a la lista existente
        numeros.add(loteria_DTO);

        // Guardar la lista completa en el archivo
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivoCasa))) {
            outputStream.writeObject(numeros); // Serializar y guardar el ArrayList de números ganadores
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    

 // Método para cargar usuarios desde el archivo .dat
    @SuppressWarnings("unchecked")
	public ArrayList<Loteria_DTO> cargarNumerosGanadores() {
    	try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivoCasa))) {
    		numeros = (ArrayList<Loteria_DTO>) inputStream.readObject(); // Deserializar el ArrayList de números ganadores
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error al cargar, simplemente continuamos con la lista vacía
            numeros = new ArrayList<>();

        }
        return numeros;

    }
	
	
	
/* Método que servira para que el premio acumulado despues del cierre 
	del programa no se pierda dicho premio y asignarlo denuevo para hacer la devidas operaciones con este */
	
	public Double cargarPremioAcumulado() {
	    cargarNumerosGanadores();

	    if (!numeros.isEmpty()) {
	        // Obtener el último Loteria_DTO de la lista
	        Loteria_DTO ultimoDTO = numeros.get(numeros.size() - 1);
	        return ultimoDTO.getPremio_Acumulado();
	    }

	    return 0.0; // Devolver 0 si la lista está vacía
	}
    
    

}