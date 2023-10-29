package co.edu.unbosque.controller;

import co.edu.unbosque.model.*;
import co.edu.unbosque.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class Controller implements ActionListener{
	 
	  private View vista;
	  private Model modelo;

		
	  
  public Controller(){
	  
	  vista= new View();   
	  modelo= new Model();

	  add_components();  
	  ejecutar();
  }
	  
	  

  public void ejecutar() {
		

  }
  
  
  
  public void add_components() {           
	  
/*	 
	  
	 vista.getPanelInicio().getJugador().addActionListener(this);
	 vista.getPanelInicio().getJugador().setActionCommand("jugador");
	 
	 vista.getPanelJugadores().getButton().addActionListener(this);
	 vista.getPanelJugadores().getButton().setActionCommand("validar");
*/	 
	 

   }

  
  public void Eventos(ActionEvent Eventos_Inicio) {
		
		
		switch(Eventos_Inicio.getActionCommand()) {
		
		case "jugador":
		
                
		break;
		
		
		
	
		
		}
		
  }
  
  
//-----------------------------------------------------------------------------------------------------------------------------  
  
  @Override
  public void actionPerformed(ActionEvent e) {
	  
	// Activacion de los eventos 
               Eventos(e);
  	
  }
	
 }
