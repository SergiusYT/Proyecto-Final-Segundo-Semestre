package co.edu.unbosque.view;

import javax.swing.*;

public class Login extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton jugador;
	private JButton juegos;
    private JButton partidas;
    private JButton torneos;

	
	public Login() {
		
	        setLayout(null);	
  		
		    jugador = new JButton("Jugadores");	     
	        juegos = new JButton("Juegos");
	        partidas = new JButton("Partidas");
	        torneos = new JButton("Torneos");
	        
	        
	        
	        jugador.setBounds(20, 20, 250, 115);
	        juegos.setBounds(315, 20, 250, 115);
	        partidas.setBounds(20, 200, 250, 115);
	        torneos.setBounds(315, 200, 250, 115);
	   
	     add(jugador);
	     add(juegos);
	     add(partidas);
	     add(torneos);
	}


	public JButton getJugador() {
		return jugador;
	}


	public void setJugador(JButton jugador) {
		this.jugador = jugador;
	}


	public JButton getJuegos() {
		return juegos;
	}


	public void setJuegos(JButton juegos) {
		this.juegos = juegos;
	}


	public JButton getPartidas() {
		return partidas;
	}


	public void setPartidas(JButton partidas) {
		this.partidas = partidas;
	}


	public JButton getTorneos() {
		return torneos;
	}


	public void setTorneos(JButton torneos) {
		this.torneos = torneos;
	}
}


