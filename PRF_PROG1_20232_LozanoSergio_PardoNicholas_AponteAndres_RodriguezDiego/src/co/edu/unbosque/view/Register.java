package co.edu.unbosque.view;

import javax.swing.*;

import com.toedter.calendar.JCalendar;

public class Register extends JPanel {


	private static final long serialVersionUID = 1L;
	private JLabel texto1, texto2;
    private JTextField  nombre, cedula, direccion, celular, username , password;
    private JComboBox<String> sede_apuesta;
	private JCalendar nacimiento;
    private JButton cancelar,registrar;

    public Register() {
        setLayout(null);

        texto1 = new JLabel("Crea un Usuario:");
        texto2 = new JLabel("Crea una Contraseña:");
        
        nacimiento = new JCalendar();
        nacimiento.setBounds(40, 440, 500, 400); 

        username = new JTextField(20); 
        password = new JTextField(30); 

        cancelar = new JButton("Cancelar");
        cancelar.setBounds(400,280,120,80);

        registrar = new JButton("Crear Usuario");
        registrar.setBounds(800,280,120,80);
        
        texto1.setBounds(30,40,130,50);
        texto2.setBounds(30,120,130,50);

        username.setBounds(400,40,200,50);
        password.setBounds(400,120,200,50);
        
     // cambio

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


