package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;


public class Loteria_DAO {
	
	private ArrayList<Loteria_DTO> numeros;
    private String archivo; // Ruta del archivo .dat
    private Loteria_DTO loteria_DTO;

    public Loteria_DAO() {
    	
    	numeros = new ArrayList<>() ;
        archivo = "Archives// apuestas-loteria.dat";
    }

    
 //---------------------- METODOS PARA EL HISTORICO DE LOS NUMEROS GANADORES ---------------------------------------   
    
    public void guardarNumerosGanadores(String numerosGanadores, String series) {
    	
         cargarNumerosGanadores();

    	
        loteria_DTO = new Loteria_DTO(numerosGanadores, series);

        // Agregar el nuevo número ganador a la lista existente
        numeros.add(loteria_DTO);

        // Guardar la lista completa en el archivo
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivo))) {
            outputStream.writeObject(numeros); // Serializar y guardar el ArrayList de números ganadores
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    

 // Método para cargar usuarios desde el archivo .dat
    @SuppressWarnings("unchecked")
	public ArrayList<Loteria_DTO> cargarNumerosGanadores() {
    	try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivo))) {
    		numeros = (ArrayList<Loteria_DTO>) inputStream.readObject(); // Deserializar el ArrayList de números ganadores
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error al cargar, simplemente continuamos con la lista vacía
        }
        return numeros;

    }

    

    
    

}