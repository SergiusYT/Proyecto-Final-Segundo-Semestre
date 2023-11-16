package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.*;

public class Sede_DAO {
	
	private ArrayList<Sede_DTO> sedes;
	private Sede_DTO sede_DTO;
	private String archivosedes;
	
	public Sede_DAO() {
		
		archivosedes= "Archives//Sedes// sedes.dat";
		
		sedes = new ArrayList<>(); 
	}
	
//---------------------- METODOS PARA EL CRUD DE LAS SEDES ---------------------------------------   
    
    public void guardarSedes(String ubicacion, int numeroDeEmpleados) {
    	
    	cargarSedes(); // para comprobar 

    	
        sede_DTO = new Sede_DTO(ubicacion, numeroDeEmpleados);

        // Agregar el nuevo número ganador a la lista existente
        sedes.add(sede_DTO);

        // Guardar la lista completa en el archivo
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivosedes))) {
            outputStream.writeObject(sedes); // Serializar y guardar el ArrayList de números ganadores
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
    
    

 // Método para cargar los juegos desde el archivo .dat
    @SuppressWarnings("unchecked")
	public ArrayList<Sede_DTO> cargarSedes() {
    	try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivosedes))) {
            sedes = (ArrayList<Sede_DTO>) inputStream.readObject(); // Deserializar el ArrayList de números ganadores
            
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error al cargar, simplemente continuamos con la lista vacía
        }
      return sedes;
    }
	
	
	
	public void modificarSede(String ubicacion, int nuevoNumeroDeEmpleados) {
		cargarSedes();

		// Buscar la sede que se va a modificar
		for (Sede_DTO sede : sedes) {
			if (sede.getUbicacion().equals(ubicacion)) {
				
				/// Modificar el número de empleados
                sede.setNumeroDeEmpleados(nuevoNumeroDeEmpleados);
                // Se guarda la modificación para guardar los cambios
                guardarSedes(sede.getUbicacion(), sede.getNumeroDeEmpleados());
              
				return; // Terminar el método después de la modificación
			}
		}

	}
	

}
