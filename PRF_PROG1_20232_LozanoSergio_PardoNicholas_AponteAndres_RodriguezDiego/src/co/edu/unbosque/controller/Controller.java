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
	  
	  view.getLogin().getButton_Register().addActionListener(this);
	  view.getLogin().getButton_Register().setActionCommand("sign_in");
	  
	  view.getLogin().getButton_Salir().addActionListener(this);
	  view.getLogin().getButton_Salir().setActionCommand("salir_Login");

	  
	//---------------------- Registro -------------------------------- 
	  
	  
	  view.getRegister().getButton_Cancel().addActionListener(this);
	  view.getRegister().getButton_Cancel().setActionCommand("cancel");
	  
	  view.getRegister().getButton_Create_User().addActionListener(this);
	  view.getRegister().getButton_Create_User().setActionCommand("create_user");
	  
    //---------------------- Ventana principal  -------------------------------- 
  
	  view.getPrincipal().getButton_Loteria().addActionListener(this);
	  view.getPrincipal().getButton_Loteria().setActionCommand("lotery_button");
	  
	  view.getPrincipal().getButton_SuperAstro().addActionListener(this);
	  view.getPrincipal().getButton_SuperAstro().setActionCommand("superastro_button");

	  view.getPrincipal().getButton_Baloto().addActionListener(this);
	  view.getPrincipal().getButton_Baloto().setActionCommand("baloto_button");
	  
	  view.getPrincipal().getButton_BetPlay().addActionListener(this);
	  view.getPrincipal().getButton_BetPlay().setActionCommand("betplay_button");
	  
	  view.getPrincipal().getButton_Chance().addActionListener(this);
	  view.getPrincipal().getButton_Chance().setActionCommand("chance_button");
	  
   //--------------------------------------------------------------------------	
	 

   }

// --------------------- CREACIÓN Y IMPLEMENTACION DE EVENTOS---------------------------------------------------
  
  
  //-------------------------------- Eventos del inicio de sesión --------------------------------------
  
  
  public void Events_Login(ActionEvent E_login) {
		
		
		switch(E_login.getActionCommand()) {
		
		     case "validate_session":   // caso donde asignaremos el evento para iniciar sesion 
		 
		    	 String username = view.getLogin().getUsername().getText();
		    	 String password = view.getLogin().getPassword().getText();     // se trae el texto escrito por el usuario  
				    	 
		    	if (model.validarInicioSesion(username, password)) {
		    		
		    		view.mensaje("Inicio de sesion Exitoso");
		    		
		    		view.getLogin().getUsername().setText("");

		    		view.setPrincipal();

		    	}else {
		    		
		    		view.mensaje("Inicio de sesion Fallido. Verifique lo ingresado");
		    		
		    		
		    		view.getLogin().getUsername().setText("");
		    		view.getLogin().getPassword().setText("");
		    	}
		    	 
		     break;
		
		     case "sign_in":  // caso para dar un evento que permita el usuario entrar a un formulario y poder registrase
			
		    	 view.setRegister();
		    	 view.getLogin().getPassword().setText("");

		    	 
		     break;
		
		     case "create_user": // caso donde permitira al usuario crear definitivamente el usuario en el software
			
		    	 String nuevousername = view.getRegister().getNewUsername().getText();
		    	 String nuevopassword = view.getRegister().getNewPassword().getText();     // se trae el texto escrito por el usuario
		    	 
		    	 if(model.agregarUsuario(model.usuario(nuevousername, nuevopassword))) {  
		    		 
			    		view.mensaje("Registro Exitoso");

			    		view.getRegister().getNewUsername().setText("");
			    		view.getRegister().getNewPassword().setText("");
			    		view.getRegister().getFull_Name().setText("");
			    		view.getRegister().getCedula().setText("");
			    		view.getRegister().getDireccion().setText("");
			    		view.getRegister().getCelular().setText("");
			    		view.getRegister().getSede_Casa_Apuestas().setSelectedIndex(-1); // Establecer ninguna opción seleccionada por defecto

			    		view.setLogin();
		    	   
		    	 }else {
		    		 
			    		view.mensaje("El nombre de usuario ya está en uso. Elija otro");
			    		
			    		view.getRegister().getNewUsername().setText("");
			    		view.getRegister().getNewPassword().setText("");

		    	 }
			
		     break;	
		     
		     case "cancel":  // caso donde devolvera al usuario al login si cancela la operacion de registro
					
		    		view.setLogin();
		    		view.getRegister().getNewUsername().setText("");
		    		view.getRegister().getNewPassword().setText("");
		    		view.getRegister().getFull_Name().setText("");
		    		view.getRegister().getCedula().setText("");
		    		view.getRegister().getDireccion().setText("");
		    		view.getRegister().getCelular().setText("");
		    		view.getRegister().getSede_Casa_Apuestas().setSelectedIndex(-1); // Establecer ninguna opción seleccionada por defecto
		    	 
		     break;
		     
		     case "salir_Login":

					System.exit(0); // con esto se cerrara el programa 
		     
		     break;
			
		}
		
  }
  
  //-------------------------------- Eventos de la Pantalla De Inicio --------------------------------------

  
  public void Events_Pantalla_Inicio(ActionEvent E_inicio) {
		
		
		switch(E_inicio.getActionCommand()) {
		
		     case "lotery_button":
		    	
		   

		
		     break;
		
		     case "superastro_button":  
			
		   
		    	 
		     break;
		
		     case "baloto_button": 
			
		    	
			
		     break;	
		     
		     case "betplay_button":  
					
		    	
		    	 
		     break;
		     
		     case "chance_button":
		    	 
		     
		     break;
			
		}
		
}
  
  
  
  //--------------------------------------------------------------------------
  
  
//-----------------------------------------------------------------------------------------------------------------------------  
  
  @Override
  public void actionPerformed(ActionEvent e) {
	  
	// Activacion de los eventos 
               Events_Login(e);
               
               Events_Pantalla_Inicio(e);
  	
  }
	
 }
