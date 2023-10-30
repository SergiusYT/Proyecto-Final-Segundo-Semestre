package co.edu.unbosque.view;



import java.awt.*;

import javax.swing.*;

public class View extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	private JPanel cardPanel;
    private CardLayout cardLayout;
	private Login login;
	private Register register;
	
	
	
	public View() {
		
		//------------------- propiedades y caracteristica que contendra el JFrame -----------------------------------
		
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400); // tamaño del jframe
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Establece el JFrame en modo pantalla completa
      //  setUndecorated(true); // Elimina la barra de título y bordes
        setResizable(false); // Evita que el usuario redimensione la ventana
        
        
       //----------------------Inicializacion de objetos ------------------------------------------------------------
        
                login = new Login();
                register = new Register();
        
        
       //------------------------ Actualizacion de paneles en el mismo JFrame----------------------------------------
        
                
                
        cardPanel = new JPanel();
        cardLayout = new CardLayout(); // esto me permitira cambiar los paneles cuando necesite de manera mas comoda 
        cardPanel.setLayout(cardLayout);
        
    
		// estructura de paneles que usare en el JFrame( el panel que quiero poner, "nombre que que quiero que reconzca ese panel )"
		 
		 cardPanel.add(login, "login"); // "login" es el nombre de la tarjeta   
		 cardPanel.add(register, "register"); // "register" es el nombre de la tarjeta   

	     
	     add(cardPanel);


     
	}
	
	//-------------------------------------- Getters y Setters --------------------------------------------------------
	
	
	
	public void setLogin() {
		
        cardLayout.show(cardPanel, "login"); // Cambia a la tarjeta de jugadores
	}
	
    public void setRegister() {
		
        cardLayout.show(cardPanel, "register"); // Cambia a la tarjeta de jugadores
	}
	
	public Login getLogin() {
        return login;
    }
	
	public Register getRegister() {
        return register;
    }
	


}
