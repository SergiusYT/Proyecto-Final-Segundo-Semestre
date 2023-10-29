package co.edu.unbosque.view;



import java.awt.*;

import javax.swing.*;

public class View extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel cardPanel;
    private CardLayout cardLayout;
	private Login login;
	
	public View() {
		
		setTitle("Sistema de información de juegos de mesa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); 
        
        
        // Actualizacion de paneles en el mismo JFrame
        
        cardPanel = new JPanel();
        cardLayout = new CardLayout(); // esto me permitira cambiar los paneles cuando necesite de manera mas comoda 
        cardPanel.setLayout(cardLayout);
        
        //------------------------------------
        
    	login = new Login();
		
		
		// estructura de paneles que usare en el JFrame( el panel que quiero poner, "nombre que que quiero que reconzca ese panel )"
		 
		 cardPanel.add(login, "login"); // "login" es el nombre de la tarjeta   

	     
	     add(cardPanel);


     
	}
	
	public void jugadores() {
		
        cardLayout.show(cardPanel, "jugadores"); // Cambia a la tarjeta de jugadores
	}
	
	public Login getPanelInicio() {
        return login;
    }
	
	


}
