package co.edu.unbosque.view;

import javax.swing.*;

public class Login extends JPanel {


	private static final long serialVersionUID = 1L;
	private JLabel texto1, texto2;
    private JTextField entrada1 , entrada2;
    private JButton iniciar_sesion,registrar,salir;

    public Login() {
        setLayout(null);

        texto1 = new JLabel("Usuario:");
        texto2 = new JLabel("Contraseña:");

        entrada1 = new JTextField(20); 
        entrada2 = new JTextField(30); 

        iniciar_sesion = new JButton("Iniciar Sesión");
        iniciar_sesion.setBounds(400,280,120,80);

        registrar = new JButton("Registrar");
        registrar.setBounds(800,280,120,80);
        
        salir = new JButton("Salir");
        salir.setBounds(800,390,120,80);
        
        texto1.setBounds(30,40,130,50);
        texto2.setBounds(30,120,130,50);

        entrada1.setBounds(130,40,200,50);
        entrada2.setBounds(130,120,200,50);
        
     

        add(texto1);
        add(texto2);
        add(entrada1);
        add(entrada2);
        add(iniciar_sesion);
        add(registrar);
        add(salir);
    }

   


	public JTextField getUsername() {
        return entrada1;
    }

	public JTextField getPassword() {
		return entrada2;
	}
	
    public JButton getButton_Login() {
        return iniciar_sesion;
    }
    public JButton getButton_Register() {
        return registrar;
    }
    public JButton getButton_Salir() {
        return salir;
    }
}


