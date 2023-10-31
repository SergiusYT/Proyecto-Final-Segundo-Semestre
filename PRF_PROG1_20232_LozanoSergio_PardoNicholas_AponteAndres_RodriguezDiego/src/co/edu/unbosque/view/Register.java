package co.edu.unbosque.view;

import javax.swing.*;

import com.toedter.calendar.JCalendar;

public class Register extends JPanel {


	private static final long serialVersionUID = 1L;
	private JLabel texto1, texto2, texto3, texto4, texto5, texto6, texto7, texto8, texto9;
    private JTextField  nombre, cedula, direccion, celular, username , password;
    private JComboBox<String> sede_apuesta;
	private JCalendar nacimiento;
    private JButton cancelar,registrar;

    public Register() {
    	
    	//---------------------------- Inicializacion de cada componente ---------------------------------------
    	
    	// manejaremos  los componente acorde a lo que necesitamos
        setLayout(null);

        // JLabels
        
        texto1 = new JLabel("Formulario de registro");
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

        username = new JTextField(20); 
        password = new JTextField(30); 
        
        // JButtons

        cancelar = new JButton("Cancelar");
        registrar = new JButton("Crear Usuario");

       //--------------------------------- Propiedades para los componentes --------------------------------- 
        
        // JCalendar
        
        nacimiento.setBounds(40, 440, 500, 400); 

       
        // JButtons

        cancelar.setBounds(400,280,120,80);
        registrar.setBounds(800,280,120,80);
        

        // JLabels
        texto1.setBounds(30,40,130,50);
        texto2.setBounds(30,120,130,50);
        
        // JTextFields
        username.setBounds(400,40,200,50);
        password.setBounds(400,120,200,50);
        
     //------------- agregar los componenetes -------------------------------------------

        add(texto1);
        add(texto2);
        add(username);
        add(password);
        add(cancelar);
        add(registrar);
        add(nacimiento);
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


