package co.edu.unbosque.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import com.toedter.calendar.*;


public class LoteriaPanel extends JPanel {


	private static final long serialVersionUID = 1L;
	private JLabel texto1, texto2, texto3, texto4, texto5, texto6, texto7, texto8, texto9;
    private JTextField  numero;
    private JComboBox<Integer> valorApuesta;
	private JComboBox<String> serie;
	private JCalendar nacimiento;
    private JButton cancelar,apostar;

    public LoteriaPanel() {
    	
    	//---------------------------- Inicializacion de cada componente ---------------------------------------
    	
    	// manejaremos  los componente acorde a lo que necesitamos
        setLayout(null);

        // JLabels
        
        texto1 = new JLabel();
        texto2 = new JLabel();
        texto3 = new JLabel("Elija un numero de 4 digitos");
        texto4 = new JLabel();
        texto5 = new JLabel("Sede de casa de apuesta donde jugara:");
        texto6 = new JLabel("Direccion de residencia:");
        texto7 = new JLabel("Numero de celular:");
        texto8 = new JLabel("Crea un nombre de usuario:");
        texto9 = new JLabel("Crea una Contraseña:");
        
        
        // JCalendar

        nacimiento = new JCalendar();

        // JTextFields

        numero = new JTextField(); 



   
        
        
        // JButtons

        cancelar = new JButton("Cancelar");
        apostar = new JButton("Realizar apuesta");
        
        // JComboBox
        
        valorApuesta = new JComboBox<Integer>();
        valorApuesta.addItem(1);
        valorApuesta.addItem(2);
        valorApuesta.addItem(3);

        serie = new JComboBox<String>();



       //--------------------------------- Propiedades para los componentes --------------------------------- 
        
        // JCalendar
        
        nacimiento.setBounds(40, 260, 500, 400); 
        nacimiento.setDecorationBackgroundColor(Color.white); // cambia el Color del fondo del JCalendar
        nacimiento.setDecorationBordersVisible(true); // establece unos bordes al calendario para dejar mejor la distribucion de este
        nacimiento.setWeekdayForeground(Color.BLUE); // poner un color a los dias de la semana
        nacimiento.setForeground(Color.black); // cambiara el color del texto que tenemos en el calendario
        nacimiento.setFont(new Font("Arial", Font.ITALIC, 15)); // Cambiar la fuente y tamaño
     
        // JComboBox
        
     
        
        
        // JButtons

        cancelar.setBounds(1000,700,120,80);
        apostar.setBounds(1200,700,120,80);
        

        // JLabels
        
        texto1.setBounds(610,20,700,300);
        texto1.setForeground(Color.black);
		texto1.setFont(new Font("Arial" , Font.ITALIC,32));
		
        texto2.setBounds(610,500,700,300);
        texto2.setForeground(Color.black);
		texto2.setFont(new Font("Arial" , Font.ITALIC,32));
		
		texto3.setBounds(30,210,300,50);
	    texto3.setForeground(Color.black);
        texto3.setFont(new Font("Arial" , Font.BOLD,20));
        
        texto4.setBounds(30,450,300,600);
	    texto4.setForeground(Color.black);
        texto4.setFont(new Font("Arial" , Font.BOLD,20));
        
        texto5.setBounds(100,450,300,600);
	    texto5.setForeground(Color.black);
        texto5.setFont(new Font("Arial" , Font.BOLD,20));
        
     
		
        // JTextFields

		
		numero.setBounds(40,140,350,50);
		numero.setFont(new Font("Arial", Font.PLAIN, 18));	

		serie.setBounds(40,720,350,50);
		serie.setFont(new Font("Arial", Font.PLAIN, 18));	
		
		
        
        
        
        
     //------------- agregar los componenetes al JPanel Register -------------------------------------------

        add(texto1);
        add(texto2);
        add (texto3);
        add(texto4);
        add(texto5);
        add(numero);
        add(valorApuesta);
        add(serie);

      
    }

   
    
//-----------------------------------------getters y setters -------------------------------------------
    
    
    public JLabel getTexto1() {
		return texto1;
	}

	public void setTexto1(JLabel texto1) {
		this.texto1 = texto1;
	}
    
    public JLabel getTexto2() {
		return texto2;
	}

	public void setTexto2(JLabel texto1) {
		this.texto2 = texto1;
	}
     public JLabel getTexto4() {
    	 return texto4;
	}

	 public void setTexto4(JLabel texto4) {
 		this.texto4 = texto4;
 	}		
    
    
    
    
    
 
	
	
    public JLabel getTexto3() {
		return texto3;
	}



	public void setTexto3(JLabel texto3) {
		this.texto3 = texto3;
	}



	public JLabel getTexto5() {
		return texto5;
	}



	public void setTexto5(JLabel texto5) {
		this.texto5 = texto5;
	}



	public JComboBox<Integer> getValorApuesta() {
		return valorApuesta;
	}



	public void setValorApuesta(JComboBox<Integer> valorApuesta) {
		this.valorApuesta = valorApuesta;
	}



	public JComboBox<String> getSerie() {
		return serie;
	}



	public void setSerie(JComboBox<String> ubicaciones) {
		this.serie = ubicaciones;
	}



	public JCalendar getFecha() {
	    return nacimiento;
	}
    
	
	
    public JTextField getNumero() {
		return numero;
	}



	public void setNumero(JTextField numero) {
		this.numero = numero;
	}



	public JButton getButton_Cancel() {
        return cancelar;
    }
    public JButton getButton_Create_User() {
        return apostar;
    }
}


