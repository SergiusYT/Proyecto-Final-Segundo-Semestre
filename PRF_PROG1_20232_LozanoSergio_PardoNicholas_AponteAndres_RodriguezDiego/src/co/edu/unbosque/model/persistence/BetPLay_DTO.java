package co.edu.unbosque.model.persistence;


public class BetPLay_DTO extends Juegos_DTO implements  Juegos_DTOS {

	private static final long serialVersionUID = 1L;

	// juego
		private String resultado ;

		private int marcadorLocal, marcadorVisitante;
	    // apostador
		private String usernameApostador, nombreApostador, EquipoApostado,cedula, nombreSede;
		private double valorApuesta;
	
	
	
	public BetPLay_DTO(String nombre, String tipoJuego, String resultado, int numeroGolesLocal, int numeroGolesVisitante, double presupuesto) {
		super(nombre, tipoJuego, presupuesto);
		
		this.marcadorLocal = numeroGolesLocal;
		this.marcadorVisitante= numeroGolesVisitante;
		this.resultado= resultado;
	}

	public BetPLay_DTO(String usernameApostador, String nombreApostador, String nombreSede, String cedula, String fecha , double valorApuesta, String EquipoApostado) {
	

   	 this.usernameApostador = usernameApostador; 
   	 this.nombreApostador = nombreApostador;
        this.nombreSede = nombreSede;
        this.cedula = cedula;
        this.valorApuesta = valorApuesta;
        this.EquipoApostado = EquipoApostado;
		
	}


	@Override
	public String toStringJuego() {
		return "<html>Nombre del juego: " + getNombre() +
                "<br>Tipo de juego: " + getTipoJuego() +
                "<br>Resultado del partido: " + resultado +
                "<br>Marcador del partido: " + marcadorLocal + " - "+marcadorVisitante+
                "<br>Premio acumulado: " + getPresupuesto() +
                "</html>";
		}



	@Override
	public String toStringApostador() {
		 return  "<html>Nombre de usuario del apostador: "+ usernameApostador +
	        		"<br>Nombre del apostador: " + nombreApostador +
	                "<br>Numero de cedula: "+ cedula +
	                "<br>Sede en la que juega: "+ nombreSede +
	        		"<br>Equipo apostado: " + EquipoApostado +
	                "<br>Valor de la apuesta: " + valorApuesta +
	                "</html>";	
		 }
	
	
	public Double getPremio() {
		return getPresupuesto();
	}


}
