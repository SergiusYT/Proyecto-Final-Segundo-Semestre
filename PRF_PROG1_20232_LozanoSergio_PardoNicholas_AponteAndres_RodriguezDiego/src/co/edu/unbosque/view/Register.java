package co.edu.unbosque.view;

import javax.swing.*;

public class Register extends JPanel {


	private static final long serialVersionUID = 1L;
	private JLabel texto1, texto2;
    private JTextField  nombre, nacimiento, cedula, direccion, celular, username , password;
    private JComboBox<String> sede_apuesta;
    private JButton cancelar,registrar;

    public Register() {
        setLayout(null);

        texto1 = new JLabel("Crea un Usuario:");
        texto2 = new JLabel("Crea una Contraseña:");

        username = new JTextField(20); 
        password = new JTextField(30); 

        cancelar = new JButton("Cancelar");
        cancelar.setBounds(400,280,120,80);

        registrar = new JButton("Crear Usuario");
        registrar.setBounds(800,280,120,80);
        
        texto1.setBounds(30,40,130,50);
        texto2.setBounds(30,120,130,50);

        username.setBounds(130,40,200,50);
        password.setBounds(130,120,200,50);
        
     

        add(texto1);
        add(texto2);
        add(username);
        add(password);
        add(cancelar);
        add(registrar);
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


