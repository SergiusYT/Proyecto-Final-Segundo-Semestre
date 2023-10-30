package co.edu.unbosque.view;

import javax.swing.*;

public class Register extends JPanel {


	private static final long serialVersionUID = 1L;
	private JLabel texto1, texto2;
    private JTextField entrada1 , entrada2;
    private JButton cancelar,registrar;

    public Register() {
        setLayout(null);

        texto1 = new JLabel("Crea un Usuario:");
        texto2 = new JLabel("Crea una Contraseña:");

        entrada1 = new JTextField(20); 
        entrada2 = new JTextField(30); 

        cancelar = new JButton("Cancelar");
        cancelar.setBounds(400,280,120,80);

        registrar = new JButton("Crear Usuario");
        registrar.setBounds(800,280,120,80);
        
        texto1.setBounds(30,40,130,50);
        texto2.setBounds(30,120,130,50);

        entrada1.setBounds(130,40,200,50);
        entrada2.setBounds(130,120,200,50);
        
     

        add(texto1);
        add(texto2);
        add(entrada1);
        add(entrada2);
        add(cancelar);
        add(registrar);
    }

   


	public JTextField getNewUsername() {
        return entrada1;
    }

	public JTextField getNewPassword() {
		return entrada2;
	}
	
    public JButton getButton_Cancel() {
        return cancelar;
    }
    public JButton getButton_Create_User() {
        return registrar;
    }
}


