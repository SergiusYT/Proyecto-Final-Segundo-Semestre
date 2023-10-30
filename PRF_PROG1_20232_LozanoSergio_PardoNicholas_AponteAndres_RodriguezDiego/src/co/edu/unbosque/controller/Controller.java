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
	  
	  view.getRegister().getButton_Create_User().addActionListener(this);
	  view.getRegister().getButton_Create_User().setActionCommand("create_user");
	 
   //--------------------------------------------------------------------------	
	 

   }

// --------------------- CREACIÓN Y IMPLEMENTACION DE EVENTOS---------------------------------------------------
  
  
  //-------------------------------- Eventos del inicio de sesión --------------------------------------
  
  
  public void Events_Login(ActionEvent E_login) {
		
		
		switch(E_login.getActionCommand()) {
		
		     case "validate_session":   // caso donde asignaremos el evento para iniciar sesion 
		 
		    	 String username = view.getLogin().getUsername().getText();
		    	 String password = view.getLogin().getPassword().getText();     // se trae el texto escrito por el usuario  
				    	 
		    	if (model.buscarUsuario(username) != null && model.usuario(username, password).getPassword().equals(password)) {
		    		
		    		
		    	}else {
		    		
		    		
		    	}
		    	 
		     break;
		
		     case "sign_in":  // caso para dar un evento que permita el usuario entrar a un formulario y poder registrase
			
		    	 view.setRegister();
		    	 
		     break;
		
		     case "create_user": // caso donde permitira al usuario crear definitivamente el usuario en el software
			
		    	 String nuevousername = view.getLogin().getUsername().getText();
		    	 String nuevopassword = view.getLogin().getPassword().getText();     // se trae el texto escrito por el usuario
		    	 
		    	 if(model.agregarUsuario(model.usuario(nuevousername, nuevopassword))) {  
		    		 
		    	   
		    	 }else {
		    		 
		    	 }
			
		     break;	
			
		}
		
  }
  
  //--------------------------------------------------------------------------
  
  
//-----------------------------------------------------------------------------------------------------------------------------  
  
  @Override
  public void actionPerformed(ActionEvent e) {
	  
	// Activacion de los eventos 
               Events_Login(e);
  	
  }
	
 }
