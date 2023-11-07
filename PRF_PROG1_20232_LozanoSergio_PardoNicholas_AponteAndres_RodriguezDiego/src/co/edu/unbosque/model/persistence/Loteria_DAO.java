package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;


public class Loteria_DAO {
	
	private ArrayList<Loteria_DTO> numeros;
    private String archivo; // Ruta del archivo .dat

    public Loteria_DAO() {
    	
    	numeros = new ArrayList<>() ;
        archivo = "Archives// loteria.dat";
    }

    
 //---------------------- METODOS PARA EL HISTORICO DE LOS NUMEROS GANADORES ---------------------------------------   
    
    public void guardarNumerosGanadores(ArrayList<Loteria_DTO>  numerosGanadoresExistentes) {
        // Guardar usuarios en archivo
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivo))) {
            outputStream.writeObject(numerosGanadoresExistentes); // Serializar y guardar el ArrayList de usuarios
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

 // Método para cargar usuarios desde el archivo .dat
    @SuppressWarnings("unchecked")
	public ArrayList<Loteria_DTO> cargarNumerosGanadores() {
    	try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivo))) {
    		
            numeros = (ArrayList<Loteria_DTO>) inputStream.readObject(); // Deserializar el ArrayList de usuarios
            return numeros;
            
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error al cargar, simplemente continuamos con la lista vacía
        	return null;
        }
    }

    

    
    
//---------------------- METODOS PARA LOS NUMEROS DE LA SERIE -----------------------------------------------------
    

}