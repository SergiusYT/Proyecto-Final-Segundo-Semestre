package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class Principal extends JPanel {


	private static final long serialVersionUID = 1L;
	private JLabel texto1, texto2, asistente;
    private JButton loteria,superastro,baloto,betplay,chance;
    
    


    public Principal() {
        setLayout(null);

        texto1 = new JLabel("Bienvenido a Gold Magic:");
        texto2 = new JLabel("Casa de apuestas la mejor del pais");

//---------------- implementacion de los botones -------------------------       

        
        loteria= new JButton();
        loteria.setBounds(250,180,200,200);
		Image img1= new ImageIcon("Resources/Imagenes/Loteria.jpg").getImage();
		ImageIcon dimenciones1 =new ImageIcon(img1.getScaledInstance(loteria.getWidth(), loteria.getHeight(), Image.SCALE_SMOOTH)); 
		loteria.setIcon(dimenciones1);
		loteria.setBorderPainted(false); 
		loteria.setContentAreaFilled(false); // con esto no mostrara el fondo del boton 
		loteria.setFocusPainted(false); 
        
       
        
        superastro= new JButton();
        superastro.setBounds(250,500,200,200);
		Image img2= new ImageIcon("Resources/Imagenes/SuperAstro.png").getImage();
		ImageIcon dimenciones2 =new ImageIcon(img2.getScaledInstance(superastro.getWidth(), superastro.getHeight(), Image.SCALE_SMOOTH)); 
		superastro.setIcon(dimenciones2);
		superastro.setBorderPainted(false); 
		superastro.setContentAreaFilled(false); // con esto no mostrara el fondo del boton 
		superastro.setFocusPainted(false); 
		
		baloto= new JButton();
		baloto.setBounds(1000,180,200,200);
		Image img3= new ImageIcon("Resources/Imagenes/Baloto.jpg").getImage();
		ImageIcon dimenciones3 =new ImageIcon(img3.getScaledInstance(baloto.getWidth(), baloto.getHeight(), Image.SCALE_SMOOTH)); 
		baloto.setIcon(dimenciones3);
		baloto.setBorderPainted(false); 
		baloto.setContentAreaFilled(false); // con esto no mostrara el fondo del boton 
		baloto.setFocusPainted(false); 
	        
		betplay= new JButton();
		betplay.setBounds(1000,500,200,200);
		Image img4= new ImageIcon("Resources/Imagenes/BetPLay.jpg").getImage();
		ImageIcon dimenciones4 =new ImageIcon(img4.getScaledInstance(betplay.getWidth(), betplay.getHeight(), Image.SCALE_SMOOTH)); 
		betplay.setIcon(dimenciones4);
		betplay.setBorderPainted(false); 
		betplay.setContentAreaFilled(false); // con esto no mostrara el fondo del boton 
		betplay.setFocusPainted(false); 
	        
        
		chance= new JButton();
		chance.setBounds(630,580,200,200);
		Image img5= new ImageIcon("Resources/Imagenes/Chance.jpg").getImage();
		ImageIcon dimenciones5 =new ImageIcon(img5.getScaledInstance(chance.getWidth(), chance.getHeight(), Image.SCALE_SMOOTH)); 
		chance.setIcon(dimenciones5);
		chance.setBorderPainted(false); 
		chance.setContentAreaFilled(false); // con esto no mostrara el fondo del boton 
		chance.setFocusPainted(false); 
     
		asistente = new JLabel();
		asistente.setBounds(1200,600,300,290);
		Image img6 = new ImageIcon("Resources/Imagenes/Animacion.gif").getImage(); 
		ImageIcon dimenciones6 =new ImageIcon(img6.getScaledInstance(asistente.getWidth(), asistente.getHeight(), Image.SCALE_FAST)); 
		// se deja scale default para que el gif reprodusca de manera nativa
		asistente.setIcon(dimenciones6);	
        
       
        texto1.setBounds(30,40,130,50);
        texto2.setBounds(30,120,130,50);


      
        
     

        add(texto1);
        add(texto2);
        add(asistente);
        add(loteria);
        add(superastro);
        add(baloto);
        add(betplay);
        add(chance);   
        
 
    
    }

   

    @Override
    public void paintComponent(Graphics img)	{ // se hace un metodo no retornable donde se le asigna que es tipo graphics y tiene como nombre img

       Image fondo = new ImageIcon("Resources/Imagenes/Fondo_Inicio.gif").getImage(); //se crea un objeto de fondo tipo imagen para el llamado del gif


       img.drawImage(fondo, 0, 0, getWidth(),getHeight(), this/* el this es obligatorio para este caso ya que indicamos que es esta clase para que se ver la animacion del gif */ ); 


//el drawaImage es de la parte Graphics que se llama con img que fue el nombre asigando para esta, donde ayudara para asignarle las dimensiones 


       setOpaque(false); // para que sea tranparente y se pueda vizualisar la imagen

       super.paintComponent(img); // pintara con los parametros que le dimos

  } 

	




	public JButton getButton_Loteria() {
        return loteria;
    }
    public JButton getButton_SuperAstro() {
        return superastro;
    }
    public JButton getButton_Baloto() {
        return baloto;
    }
    public JButton getButton_BetPlay() {
        return betplay;
    }
    public JButton getButton_Chance() {
        return chance;
    }
   
}


