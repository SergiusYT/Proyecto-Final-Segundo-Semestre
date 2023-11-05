package co.edu.unbosque.model.persistence;

import java.io.*;


public class Loteria_DAO {
    private String archivo; // Ruta del archivo .dat

    public Loteria_DAO() {
    	
        archivo = "Archives// loteria.dat";
    }

    public void guardarNumerosGanadores(Loteria_DTO  dto) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Loteria_DTO cargarNumerosGanadores() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Loteria_DTO ) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null; // Devuelve null si no se puede cargar el DTO
    }
}