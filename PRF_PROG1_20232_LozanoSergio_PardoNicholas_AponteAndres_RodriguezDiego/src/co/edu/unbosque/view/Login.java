package co.edu.unbosque.view;

import javax.swing.*;

public class Login extends JPanel {


	private static final long serialVersionUID = 1L;
	private JLabel texto1, texto2, texto3;
    private JTextField entrada1 , entrada2, entrada3;
    private JButton agregar;

    public Login() {
        setLayout(null);

        texto1 = new JLabel("Documento:");
        texto2 = new JLabel("Nombre:");
        texto3 = new JLabel("Edad:");

        entrada1 = new JTextField(20); 
        entrada2 = new JTextField(30); 
        entrada3 = new JTextField(2); 

        agregar = new JButton("Agregar");
        agregar.setBounds(400,280,120,80);

        
        texto1.setBounds(30,40,130,50);
        texto2.setBounds(30,120,130,50);
        texto3.setBounds(30,200,130,50);

        entrada1.setBounds(130,40,200,50);
        entrada2.setBounds(130,120,200,50);
        entrada3.setBounds(130,200,200,50);
        
     

        add(texto1);
        add(texto2);
        add(texto3);
        add(entrada1);
        add(entrada2);
        add(entrada3);
        add(agregar);
    }

    public JTextField getEntrada2() {
		return entrada2;
	}

	public void setEntrada2(JTextField entrada2) {
		this.entrada2 = entrada2;
	}

	public JTextField getEntrada3() {
		return entrada3;
	}

	public void setEntrada3(JTextField entrada3) {
		this.entrada3 = entrada3;
	}

	public JTextField getEntrada1() {
        return entrada1;
    }

    public JButton getButton_Login() {
        return agregar;
    }
}


