package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.ArrayList;


public class Loteria_DAO {
    private String archivo; // Ruta del archivo .dat
    private Loteria_DTO loteriaDTO;

    public Loteria_DAO() {
    	
        archivo = "Archives// loteria.dat";
    }

    
 //---------------------- METODOS PARA GUARDAR EL HISTORICO DE LOS NUMEROS GANADORES ---------------------------------------   
    
    public void guardarNumerosGanadores(ArrayList<Integer> numeroGanador, ArrayList<Integer> serie ) {
    	loteriaDTO = new Loteria_DTO(numeroGanador, serie);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(loteriaDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
//---------------------- METODOS PARA EL HISTORICO DE LOS NUMEROS GANADORES ---------------------------------------   
   

    public ArrayList<Integer> cargarNumeroGanador() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
        	
        	loteriaDTO = (Loteria_DTO) in.readObject();
            return loteriaDTO.getNumerosGanadores();
            
        } catch (IOException | ClassNotFoundException e) {
            return null; // Devuelve null si no se puede cargar el DTO

        }
    }
    
    
//---------------------- METODOS PARA LOS NUMEROS DE LA SERIE -----------------------------------------------------
    
    
    public ArrayList<Integer> cargarSerieGanadora() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
        	loteriaDTO = (Loteria_DTO) in.readObject();
        	
            return loteriaDTO.getSeries();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>(); // Devuelve una lista vacía si no se puede cargar el DTO
        }
    }
    
}