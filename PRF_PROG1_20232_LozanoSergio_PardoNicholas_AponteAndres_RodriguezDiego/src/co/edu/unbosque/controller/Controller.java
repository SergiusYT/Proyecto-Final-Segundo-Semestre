package co.edu.unbosque.controller;

import co.edu.unbosque.model.*;
import co.edu.unbosque.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// son para recibir los eventos de los jcalendars implementados en el programa
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.util.*;





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
				    	 
		    	if (model.getUsuarios().validarInicioSesion(username, password)) {
		    		
		    		
		    		model.setDatosNecesariosApostador(username); // poner los datos necesesarios para usos posteriores
		    		
		    		view.mensajeInformativo("Inicio de sesion Exitoso", "Bienvenido a Gold Magic");
		    		
		    		view.getLogin().getUsername().setText("");

		    		view.setPrincipal();

		    	}else {
		    		
		    		view.mensajeError("Verifique lo ingresado mi estimado usuario :3", "ERROR 439 'Inicio de sesion Fallido.'");
		    		
		    		
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
		         String nombre_Completo = view.getRegister().getFull_Name().getText();
		    	 
		     
		      //en esta seccion tomaremos la fecha que seleccione el usuario y manejaremos logica en este   
		         view.getRegister().getFecha().addPropertyChangeListener(new PropertyChangeListener() {
		             @Override
		             public void propertyChange(PropertyChangeEvent evt) {
		                 if ("calendar".equals(evt.getPropertyName())) {
		                   Date fechaSeleccionada = view.getRegister().getFecha().getDate(); // tomara la fecha que seleccione el usuario
		                     model.getUsuarios().calcularEdad(fechaSeleccionada);		                 }
		             }
		         });
		    	 
		         String cedula = view.getRegister().getCedula().getText();
		 //    String sedeQueJugara = view.getRegister().getSede_Casa_Apuestas().gettex;  es un combo box toca ver eso
                                 
                 String direccion = view.getRegister().getDireccion().getText();		
                 String celular = view.getRegister().getCelular().getText();
 
            
                 
                 
                 
		    	 
                 if (nombre_Completo.isEmpty() || cedula.isEmpty() || direccion.isEmpty() || celular.isEmpty()) {
                     view.mensajeAdvertencia("Por favor, complete todos los campos.", "¡Ey!, así como dificil no?");
                     
                 }else if (nuevousername.isEmpty()){
                     
                     view.mensajeAdvertencia("Ingrese un nombre de usuario para su cuenta. Porfavor :>", "¡Ups! te hace falta algo nuestro futuro usuario");

                 }else if (nuevopassword.isEmpty()){
                     
                     view.mensajeAdvertencia("Ingrese una contraseña para su cuenta. Porfavor :>", "¡Ups! te hace falta algo nuestro futuro usuario");
                     
                  } else {
                     // traer  la edad seleccionada por el usuario
                     int edad =  model.getUsuarios().getEdad();

                     // Verificar si la edad es mayor de 18 años
                     if (edad >= 18) {
                    	 
                    	 if (!celular.isEmpty()) {
                        	 try {
                        		 System.out.println(celular);
                        	 
                        		 model.validarNumeroDigitos(celular);
                        
                        	 }catch(IllegalArgumentException e){ 
                        		 System.out.println("Error autentico");
                        		 view.mensajeError("Por favor ingrese su número de celular (recuerde que un número de celular contiene 10 digitos", "ERROR 508 'no es un número de celuco.'");
                                 return; 
            
     //Se interrumpe la ejecución del método actual, evitando que el código siguiente al bloque try-catch se ejecute en caso de que haya una excepción.               
                        	 }
                        	 
                         }	 
                          if (!cedula.isEmpty()) {
                        	 
                        	 try {
                        		 System.out.println(cedula);
                        	 
                        		 model.validarSiesNumero(cedula);
                        
                        	 }catch(IllegalArgumentException e){ 
                                 e.getMessage();                  
                            	 view.mensajeError("La cédula debe contener solo números.", "¡Ups!");
                                 return; 
        //Se interrumpe la ejecución del método actual, evitando que el código siguiente al bloque try-catch se ejecute en caso de que haya una excepción.               
                        
                        	 }
                              
                         }
                         // Resto del código para agregar el usuario
                         if (model.getUsuarios().agregarUsuario(nuevousername, nuevopassword, nombre_Completo, edad, cedula,"sede", direccion, celular)) {
                             // Registro exitoso
                             view.mensajeInformativo("¡en hora buena!. Dejanos darte la bienvenida "+ nombre_Completo +" a nuestra alucinante y controvercial casa de apuestas Gold Magic.\n\n( Ya eres un nueva alma, ¡perdon! ''integrante'' que pertence a esta familia"+ nombre_Completo +" :) )", "Registro Exitoso");
                             // Limpiar los campos
                             view.getRegister().getNewUsername().setText("");
                             view.getRegister().getNewPassword().setText("");
                             view.getRegister().getFull_Name().setText("");
                             view.getRegister().getCedula().setText("");
                             view.getRegister().getDireccion().setText("");
                             view.getRegister().getCelular().setText("");
                             view.getRegister().getSede_Casa_Apuestas().setSelectedIndex(-1); // Establecer ninguna opción seleccionada por defecto
                             view.setLogin();
                             
                         } else {
                             view.mensajeError("El nombre de usuario ya está en uso. Elija otro", "ERROR 203 'Sea un poquito más original :D'");
                             view.getRegister().getNewUsername().setText("");
                             view.getRegister().getNewPassword().setText("");
                         }
                     } else {
                         view.mensajeAdvertencia("Usted es menor de edad, debe tener al menos 18 años para registrarse.", "¡Oye! Estas muy joven para dañarte la vida rapido :/");
                      // Limpiar los campos
                         view.getRegister().getNewUsername().setText("");
                         view.getRegister().getNewPassword().setText("");
                         view.getRegister().getFull_Name().setText("");
                         view.getRegister().getCedula().setText("");
                         view.getRegister().getDireccion().setText("");
                         view.getRegister().getCelular().setText("");
                         view.getRegister().getSede_Casa_Apuestas().setSelectedIndex(-1); // Establecer ninguna opción seleccionada por defecto
                         view.setLogin();
                     }
              /*       
                      if (!celular.isEmpty()) {
                    	 try {
                    		 System.out.println(celular);
                    	 
                    		 model.validarNumeroDigitos(celular);
                    
                    	 }catch(IllegalArgumentException e){ 
                    		 System.out.println("Error autentico");
                    		 view.mensajeError("Por favor ingrese su número de celular (recuerde que un número de celular contiene 10 digitos", "ERROR 508 'no es un número de celuco.'");
                    	 }
                    	 
                     }	 
                      if (!cedula.isEmpty()) {
                    	 
                    	 try {
                    		 System.out.println(cedula);
                    	 
                    		 model.validarSiesNumero(cedula);
                    
                    	 }catch(IllegalArgumentException e){ 
                             e.getMessage();                  
                        	 view.mensajeError("La cédula debe contener solo números.", "¡Ups!");
                    	 }
                          
                     }
                     
                    	 */
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
		    	
		    	 view.setLoteriaPanel();
		    	 
		    	 Scanner scanner = new Scanner(System.in);

		         int x = 2121;
		         
   model.getLoteria().generarNumerosGanadores(x);


		    	// System.out.println(		         model.getLoteria().getConsultarSorteo());

		    	 System.out.println("Ingrese el premio: ");
		         double premio = scanner.nextDouble();
		         
		         model.gestionarPropiedades(2, premio);

		         System.out.println("Ingrese la cantidad de fracciones: ");
		         int fracciones = scanner.nextInt();
		         System.out.println("Ingrese la cantidad de digitos: ");
		         int numero = scanner.nextInt();

		         System.out.println("Ingrese la cantidad de fracciones: ");
		         String serie = scanner.next();
		         
		      
		         

		         
		        String num = Integer.toString(numero);
		         
		         model.getLoteria().setcantidadFraccion(fracciones);
		         

		         Double premioGanado = model.getLoteria().realizarSorteo("LoteriaBogota", "Loteria" , serie, num);


		         
		         
		         if (premioGanado != null) {
		             System.out.println("¡Felicidades! Has ganado: $" + premioGanado);
		             
		             view.getLoteriaPanel().getTexto1().setText(model.getLoteria().obtenerUltimoSorteo());
		             
			    	// System.out.println("Consulta del sorteo: "); model.getLoteria().getConsultarSorteo();
//			    	 System.out.println("\n\nConsulta de la apuesta: "); model.getLoteria().getConsultarApuesta();
		             view.getLoteriaPanel().getTexto2().setText(model.getLoteria().obtenerUltimaApuesta());

		             view.getLoteriaPanel().getTexto4().setText(model.getLoteria().getConsultarSorteo());

		             System.out.println(model.getLoteria().getConsultarSorteo());

		         } else {
		             System.out.println("Lo siento, no has ganado. Premio acumulado: $" + model.getLoteria().getPremioAcumulado());
		             
		             view.getLoteriaPanel().getTexto1().setText(model.getLoteria().obtenerUltimoSorteo());
		             
//		             System.out.println("Consulta del sorteo: ");  model.getLoteria().getConsultarSorteo();
//			    	 System.out.println("\n\nConsulta de la apuesta: ");  model.getLoteria().getConsultarApuesta();
		             view.getLoteriaPanel().getTexto2().setText(model.getLoteria().obtenerUltimaApuesta());
		             view.getLoteriaPanel().getTexto4().setText(model.getLoteria().getConsultarSorteo());
		             System.out.println(model.getLoteria().getConsultarSorteo());


		         }
		  
		    	
		
		     break;
		
		     case "superastro_button":  
		    	 
		    		view.setLogin();
		    	    view.getLogin().getUsername().setText("");
		    		view.getLogin().getPassword().setText("");
		    	 
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
