package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class Login extends JPanel {


	private static final long serialVersionUID = 1L;
	private JLabel texto1, texto2, Logo;
    private JTextField entrada1 , entrada2;
    private JButton iniciar_sesion,registrar,salir;

    public Login() {
        setLayout(null);

        Logo = new JLabel();
        Logo.setBounds(340,0,900,600);
		Image img = new ImageIcon("Resources/Imagenes/Titulo.png").getImage(); // creacion de un objeto llamando la imagen 
		ImageIcon dimenciones =new ImageIcon(img.getScaledInstance(Logo.getWidth(), Logo.getHeight(), Image.SCALE_SMOOTH)); 
		// el scale_smooth es para ajustar la imagen y que tenga en cuenta el ancho y el alto en la escala de la imagen
		Logo.setIcon(dimenciones);	
        
        
        texto1 = new JLabel("Usuario:");
        texto1.setForeground(Color.white);
		texto1.setFont(new Font("Arial" , Font.BOLD,20));
		
        texto2 = new JLabel("Contraseña:");
        texto2.setForeground(Color.white);
		texto2.setFont(new Font("Arial" , Font.BOLD,20));
		
		
        entrada1 = new JTextField(); 
        entrada1.setBounds(600,220,350,50);
        entrada1.setFont(new Font("Arial", Font.PLAIN, 18));	
		
		
        entrada2 = new JTextField();
        entrada2.setBounds(600,350,350,50);
        entrada2.setFont(new Font("Arial", Font.PLAIN, 18));	

        iniciar_sesion = new JButton("Iniciar Sesión");
        iniciar_sesion.setBounds(890,490,120,80);

        registrar = new JButton("Registrar");
        registrar.setBounds(520,490,120,80);
        
        salir = new JButton("Salir");
        salir.setBounds(0,780,120,80);
        
        texto1.setBounds(640,180,130,50);
        texto2.setBounds(640,300,130,50);

     
        
     

        add(texto1);
        add(texto2);
        add(entrada1);
        add(entrada2);
        add(Logo);
        add(iniciar_sesion);
        add(registrar);
        add(salir);
    }

   
    @Override
    public void paintComponent(Graphics img)	{ // se hace un metodo no retornable donde se le asigna que es tipo graphics y tiene como nombre img

       Image fondo = new ImageIcon("Resources/Imagenes/Fondo_Menu.gif").getImage(); //se crea un objeto de fondo tipo imagen para el llamado del gif


       img.drawImage(fondo, 0, 0, getWidth(),getHeight(), this/* el this es obligatorio para este caso ya que indicamos que es esta clase para que se ver la animacion del gif */ ); 


//el drawaImage es de la parte Graphics que se llama con img que fue el nombre asigando para esta, donde ayudara para asignarle las dimensiones 


       setOpaque(false); // para que sea tranparente y se pueda vizualisar la imagen

       super.paintComponent(img); // pintara con los parametros que le dimos

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


