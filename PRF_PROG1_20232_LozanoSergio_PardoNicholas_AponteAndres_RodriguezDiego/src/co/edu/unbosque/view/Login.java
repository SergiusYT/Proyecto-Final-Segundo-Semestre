package co.edu.unbosque.view;

import javax.swing.*;

public class Login extends JPanel {


	private static final long serialVersionUID = 1L;
	private JLabel texto1, texto2;
    private JTextField entrada1 , entrada2, entrada3;
    private JButton agregar,registrar;

    public Login() {
        setLayout(null);

        texto1 = new JLabel("Usuario:");
        texto2 = new JLabel("Contraseña:");

        entrada1 = new JTextField(20); 
        entrada2 = new JTextField(30); 

        agregar = new JButton("Agregar");
        agregar.setBounds(400,280,120,80);

        registrar = new JButton("Registrar");
        registrar.setBounds(800,280,120,80);
        
        texto1.setBounds(30,40,130,50);
        texto2.setBounds(30,120,130,50);

        entrada1.setBounds(130,40,200,50);
        entrada2.setBounds(130,120,200,50);
        
     

        add(texto1);
        add(texto2);
        add(entrada1);
        add(entrada2);
        add(agregar);
        add(registrar);
    }

   


	public JTextField getUsername() {
        return entrada1;
    }

	public JTextField getPassword() {
		return entrada2;
	}
	
    public JButton getButton_Login() {
        return agregar;
    }
    public JButton getButton_Register() {
        return registrar;
    }
}

