package co.edu.unbosque.view;

import javax.swing.*;

public class Principal extends JPanel {


	private static final long serialVersionUID = 1L;
	private JLabel texto1, texto2;
    private JButton loteria,superastro,baloto,betplay,chance;

    public Principal() {
        setLayout(null);

        texto1 = new JLabel("Bienvenido a Gold Magic:");
        texto2 = new JLabel("Casa de apuestas la mejor del pais");

//---------------- implementacion de los botones -------------------------       

        loteria = new JButton("Loteria");
        loteria.setBounds(400,280,120,80);

        superastro = new JButton("SuperAstro");
        superastro.setBounds(800,280,120,80);
        
        baloto = new JButton("Baloto");
        baloto.setBounds(950,280,120,80);
        
        betplay = new JButton("BetPlay");
        betplay.setBounds(800,400,120,80);
        
        chance = new JButton("Chance");
        chance.setBounds(120,500,120,80);
        
        texto1.setBounds(30,40,130,50);
        texto2.setBounds(30,120,130,50);


        
     

        add(texto1);
        add(texto2);
        add(loteria);
        add(superastro);
        add(baloto);
        add(betplay);
        add(chance);   
    
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


