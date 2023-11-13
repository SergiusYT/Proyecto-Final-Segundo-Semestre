package co.edu.unbosque.model.persistence;

import java.io.*;

import java.util.*;

public class ConfiguracionCasaApuestas {

		private Properties prop;
		private String archivoconfig = "Archives//Configuracion// config.properties";
		
		public ConfiguracionCasaApuestas() {
			prop = new Properties();
		}
		
		public int escribirPropiedades(int numeroSedes, double presupuestoTotal) {
			try {
				  prop.setProperty("nombreCasa", "Gold Magic"); // (clave, valor)
		          prop.setProperty("numeroSedes", String.valueOf(numeroSedes));
		          prop.setProperty("presupuestoTotal", String.valueOf(presupuestoTotal));
		          
		           double presupuestoPorJuego = presupuestoTotal / 5; // el presupuesto total se dividira equitativamente a los 5 juegos de la casa
		          
		          prop.setProperty("presupuestoPorJuego", String.valueOf(presupuestoPorJuego));

	       
				prop.store(new FileOutputStream(archivoconfig), null);
				// store almacenara la ruta que dije
			}catch (IOException e) {
				return -1;
			}
			return 0;
		}
		
		public  String leerPropiedades() {
			String linea= "";
			
			try {
				prop.load(new FileInputStream(archivoconfig));
						
			prop.list(System.out);
			
			linea += "Nombre de la Casa de Apuestas :" + prop.getProperty("nombreCasa")+"\n"; //llamamos la clave para traer el valor de esta propiedad
			linea += "Número de Sedes: " + prop.getProperty("numeroSedes")+"\n";
			linea += "Presupuesto Total: " + prop.getProperty("presupuestoTotal")+"\n";
            linea += "Presupuesto por Juego: " + prop.getProperty("presupuestoPorJuego");
			
		}catch (IOException e) {
			return null;
		}
			
		return linea;
		
	  }
		
		
		// Nuevo método para obtener el presupuesto por juego
	    public double getPresupuestoPorJuego() {
	        return Double.parseDouble(prop.getProperty("presupuestoPorJuego", "0"));
	    }	
		
}


