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
    
    @SuppressWarnings("unchecked")
   	public String cargarSedes() {
       	try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivosedes))) {
       		sedes = (ArrayList<Sede_DTO>) inputStream.readObject(); // Deserializar el ArrayList de números ganadores
               String resultado = "";
               for (Sede_DTO sede : sedes) {
                   resultado += sede.toString();
               }
               return resultado;
           } catch (IOException | ClassNotFoundException e) {
               // Si hay un error al cargar, simplemente continuamos con la lista vacía
        	   sedes = new ArrayList<>();
               return "Error al cargar los usuarios.";
           }

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
	
	
	public void eliminarSede(String ubicacion) {
	    cargarSedes(); // Cargar las sedes existentes

	    // Buscar la sede que se va a eliminar
	    Iterator<Sede_DTO> iterator = sedes.iterator();
	    while (iterator.hasNext()) { //hasNext es para que el bucle salga hasta que retorne false cuando ya no haya mas elementos en el archivo
	        sede_DTO = iterator.next(); // para que devuelva el siguiente elemento y susesivamente 
	        if (sede_DTO.getUbicacion().equals(ubicacion)) {
	            iterator.remove(); // Eliminar la sede de la lista
	        }
	    }

	    // Guardar la lista actualizada en el archivo
	    for (Sede_DTO sede : sedes) {
	        guardarSedes(sede.getUbicacion(), sede.getNumeroDeEmpleados());
	    }
	}
	

//------------------------------- Metodo para verificar si ya existe una sede con la ubicación dada	--------------------
	
	
    public boolean sedeExistente(String ubicacion) {
        cargarSedes();

        for (Sede_DTO sede : sedes) {
            if (sede.getUbicacion().equals(ubicacion)) {
                return true; // La sede ya existe
            }
        }
        return false; // La sede no existe
    }
    
    public String obtenerSede(String nombreSede) {
        for (Sede_DTO sede : sedes) {
            if (sede.getUbicacion().equals(nombreSede)) { // como dependende del usuario en el que este retornara el nombre de ese usuario especificamente
                return sede.getUbicacion();
            }
        }
        return null;
    }
    
    public Set<String> obtenerUbicacionTodasSedes() {
        cargarSedes();
  	
        Set<String> ubicaciones = new HashSet<>();
        for (Sede_DTO sede : sedes) {
            ubicaciones.add(sede.getUbicacion());
        }
        return ubicaciones.isEmpty() ? null : ubicaciones;
    }
}
