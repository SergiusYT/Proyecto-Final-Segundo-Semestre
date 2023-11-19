package co.edu.unbosque.model;

import java.util.Set;

import co.edu.unbosque.model.persistence.Sede_DAO;

public class Sedes {
	
	private Sede_DAO sede_DAO;

    public Sedes() {
    	sede_DAO = new Sede_DAO();
    }


	// Método para agregar una nueva sede si no existe
    public void agregarNuevaSede(String ubicacion, int numeroDeEmpleados) {
    	
        if (!sede_DAO.sedeExistente(ubicacion)) {
        	sede_DAO.guardarSedes(ubicacion, numeroDeEmpleados);
        }
    }
    
    public String obtenerSedes() {
    	return sede_DAO.cargarSedes();
    }
    
    public String sedeEspecifica(String sede) {
    	return sede_DAO.obtenerSede(sede);
    }
    
    public Set<String> todasUbicacionesSedes() {
    	return sede_DAO.obtenerUbicacionTodasSedes();
    }
}
