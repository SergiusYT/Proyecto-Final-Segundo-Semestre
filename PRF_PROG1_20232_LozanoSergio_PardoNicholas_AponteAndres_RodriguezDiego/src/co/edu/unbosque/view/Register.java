package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.*;


public class Register extends JPanel {


	private static final long serialVersionUID = 1L;
	private JLabel texto1, texto2, texto3, texto4, texto5, texto6, texto7, texto8, texto9;
    private JTextField  nombre, cedula, direccion, celular, username , password;
    private JComboBox<String> sede_casa_apuesta;
	private JCalendar nacimiento;
    private JButton cancelar,registrar;

    public Register() {
    	
    	//---------------------------- Inicializacion de cada componente ---------------------------------------
    	
    	// manejaremos  los componente acorde a lo que necesitamos
        setLayout(null);

        // JLabels
        
        texto1 = new JLabel("Formulario de Registro");
        texto2 = new JLabel("Digite su Nombre completo:");
        texto3 = new JLabel("Fecha de nacimiento:");
        texto4 = new JLabel("Numero de documento:");
        texto5 = new JLabel("Sede de casa de apuesta donde jugara:");
        texto6 = new JLabel("Direccion de residencia:");
        texto7 = new JLabel("Numero de celular:");
        texto8 = new JLabel("Crea un nombre de usuario:");
        texto9 = new JLabel("Crea una Contraseña:");
        
        
        // JCalendar

        nacimiento = new JCalendar();

        // JTextFields

        nombre = new JTextField(); 
        cedula = new JTextField(); 
        direccion = new JTextField();
        celular = new JTextField(); 


        username = new JTextField(); 
        password = new JTextField(); 
        
        
        // JButtons

        cancelar = new JButton("Cancelar");
        registrar = new JButton("Crear Usuario");
        
        // JComboBox
        
        sede_casa_apuesta = new JComboBox<String>();


       //--------------------------------- Propiedades para los componentes --------------------------------- 
        
        // JCalendar
        
        nacimiento.setBounds(40, 260, 500, 400); 
        nacimiento.setDecorationBackgroundColor(Color.white); // cambia el Color del fondo del JCalendar
        nacimiento.setDecorationBordersVisible(true); // establece unos bordes al calendario para dejar mejor la distribucion de este
        nacimiento.setWeekdayForeground(Color.BLUE); // poner un color a los dias de la semana
        nacimiento.setForeground(Color.black); // cambiara el color del texto que tenemos en el calendario
        nacimiento.setFont(new Font("Arial", Font.ITALIC, 15)); // Cambiar la fuente y tamaño
     
        // JComboBox
        
        sede_casa_apuesta.setBounds(900,140,450,50);
        sede_casa_apuesta.setForeground(Color.black);
        sede_casa_apuesta.setFont(new Font("Arial" , Font.ITALIC,18));
        sede_casa_apuesta.addItem("Bogota");
        sede_casa_apuesta.addItem("Chia");
        sede_casa_apuesta.addItem("Tunja");
        sede_casa_apuesta.addItem("Bucaramanga");
        sede_casa_apuesta.addItem("Cartagena");
        sede_casa_apuesta.addItem("Santa Marta");
        sede_casa_apuesta.addItem("Cucuta");
        sede_casa_apuesta.addItem("Leticia");
        
        
        // JButtons

        cancelar.setBounds(1000,700,120,80);
        registrar.setBounds(1200,700,120,80);
        

        // JLabels
        
        texto1.setBounds(610,20,400,50);
        texto1.setForeground(Color.black);
		texto1.setFont(new Font("Arial" , Font.ITALIC,32));
		
        texto2.setBounds(30,90,300,50);
        texto2.setForeground(Color.black);
		texto2.setFont(new Font("Arial" , Font.BOLD,20));
		
		texto3.setBounds(30,210,300,50);
	    texto3.setForeground(Color.black);
        texto3.setFont(new Font("Arial" , Font.BOLD,20));
        
        texto4.setBounds(30,665,300,50);
	    texto4.setForeground(Color.black);
        texto4.setFont(new Font("Arial" , Font.BOLD,20));
        
        texto5.setBounds(900,90,450,50);
        texto5.setForeground(Color.black);
		texto5.setFont(new Font("Arial" , Font.BOLD,20));
		
		texto6.setBounds(900,210,450,50);
        texto6.setForeground(Color.black);
		texto6.setFont(new Font("Arial" , Font.BOLD,20));
		
		texto7.setBounds(900,320,450,50);
        texto7.setForeground(Color.black);
		texto7.setFont(new Font("Arial" , Font.BOLD,20));
		
		texto8.setBounds(900,430,450,50);
        texto8.setForeground(Color.black);
		texto8.setFont(new Font("Arial" , Font.BOLD,20));
		
		texto9.setBounds(900,540,450,50);
        texto9.setForeground(Color.black);
		texto9.setFont(new Font("Arial" , Font.BOLD,20));
		
        // JTextFields

		
		nombre.setBounds(40,140,350,50);
		nombre.setFont(new Font("Arial", Font.PLAIN, 18));	

	    cedula.setBounds(40,720,350,50);
		cedula.setFont(new Font("Arial", Font.PLAIN, 18));	
		
		direccion.setBounds(900,260,350,50);
		direccion.setFont(new Font("Arial", Font.PLAIN, 18));	

		celular.setBounds(900,370,350,50);
		celular.setFont(new Font("Arial", Font.PLAIN, 18));	
		
		
        username.setBounds(900,480,350,50);
		username.setFont(new Font("Arial", Font.PLAIN, 18));	

        password.setBounds(900,590,350,50);
		password.setFont(new Font("Arial", Font.PLAIN, 18));	
        
        
        
        
     //------------- agregar los componenetes al JPanel Register -------------------------------------------

        add(texto1);
        add(texto2);
        add(texto3);
        add(texto4);
        add(texto5);
        add(texto6);
        add(texto7);
        add(texto8);
        add(texto9);




        add(nombre);
        add(cedula);
        add(direccion);
        add(celular);

        add(username);
        add(password);
        
        
        add(cancelar);
        add(registrar);
        add(nacimiento);
        add(sede_casa_apuesta);
    }

   
    
//-----------------------------------------getters y setters -------------------------------------------
    
    
    public JTextField getFull_Name() {
        return nombre;
    }
	public JTextField getNewUsername() {
        return username;
    }
	public JTextField getNewPassword() {
		return password;
	}
	public JTextField getCedula() {
	    return cedula;
    }
	public JTextField getDireccion() {
	    return direccion;
    }
	public JTextField getCelular() {
		return celular;
	}
	
	
    public JCalendar getFecha() {
	    return nacimiento;
	}
    
    
	public JComboBox<String> getSede_Casa_Apuestas() {
	    return sede_casa_apuesta ;
    }
	
	
    public JButton getButton_Cancel() {
        return cancelar;
    }
    public JButton getButton_Create_User() {
        return registrar;
    }
}


