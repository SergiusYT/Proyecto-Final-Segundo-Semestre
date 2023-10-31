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

        
        
        
        // JButtons

        cancelar.setBounds(600,280,120,80);
        registrar.setBounds(800,280,120,80);
        

        // JLabels
        
        texto1.setBounds(610,40,400,50);
        texto1.setForeground(Color.black);
		texto1.setFont(new Font("Arial" , Font.ITALIC,32));
		
        texto2.setBounds(30,90,300,50);
        texto2.setForeground(Color.black);
		texto2.setFont(new Font("Arial" , Font.BOLD,20));
		
		texto3.setBounds(30,210,300,50);
	    texto3.setForeground(Color.black);
        texto3.setFont(new Font("Arial" , Font.BOLD,20));
        
        // JTextFields
        nombre.setBounds(40,140,350,50);
		nombre.setFont(new Font("Arial", Font.PLAIN, 18));	


        username.setBounds(400,40,200,50);
        password.setBounds(400,120,200,50);
        
     //------------- agregar los componenetes al JPanel Register -------------------------------------------

        add(texto1);
        add(texto2);
        add(texto3);

        add(nombre);
        add(username);
        add(password);
        add(cancelar);
        add(registrar);
        add(nacimiento);
    }

   
    public JTextField getFull_Name() {
        return nombre;
    }


	public JTextField getNewUsername() {
        return username;
    }

	public JTextField getNewPassword() {
		return password;
	}
	
    public JButton getButton_Cancel() {
        return cancelar;
    }
    public JButton getButton_Create_User() {
        return registrar;
    }
}


