package co.edu.unbosque.controller;

import co.edu.unbosque.model.*;
import co.edu.unbosque.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class Controller implements ActionListener{
	 
	  private View view;
	  private Model model;

		
	  
  public Controller(){
	  
	  view= new View();   
	  model= new Model();

	  add_components();  
	  ejecutar();
  }
	  
	  

  public void ejecutar() {
		
     view.setVisible(true);
	  
  }
  
  
  //--------------------------- metodo donde manejaremos los alias para tomar y luego asignarle eventos a un objeto ------------------
  
  public void add_components() {           
	  
	//---------------------- Inicio de sesion -------------------------------- 
	  
	  view.getLogin().getButton_Login().addActionListener(this);
	  view.getLogin().getButton_Login().setActionCommand("validate_session");
	 
   //--------------------------------------------------------------------------	
	 

   }

  
  public void Eventos(ActionEvent Eventos_Inicio) {
		
		
		switch(Eventos_Inicio.getActionCommand()) {
		
		case "validate_session":
		
                
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
