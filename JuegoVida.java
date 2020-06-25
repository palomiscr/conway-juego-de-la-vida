import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JuegoVida {
	private ModeloJV modelo;
	/*creamos PropertyChangeSupport supportmodelo
	 * instanciamos el modelo con constructor como minimo con el supportmodelo
	 * creamos vista
	 * las propiedades del modelo van a ser escuchadas por la vista
	 * creamos frame
	 * le añadimos la vista
	 * size, visible, background
	 * addWindowListener
	 * */
	public JuegoVida() {
		PropertyChangeSupport supportmodelo= new PropertyChangeSupport(this);
		
	    JFrame frame1 = new JFrame("InputDialog Example #1");
	    String aux = JOptionPane.showInputDialog(frame1, "Introduce cantidad de celulas vivas");
	    int vidas=Integer.parseInt(aux);
	    
	    JFrame frame2 = new JFrame("InputDialog Example #2");
	    String aux2 = JOptionPane.showInputDialog(frame2, "Introduce el tamaño del tablero");
	    int size=Integer.parseInt(aux2);
	    
	    this.modelo=new ModeloJV(supportmodelo, vidas, size);
	    VistaJV vista= new VistaJV();
	    supportmodelo.addPropertyChangeListener(vista);
	    Frame frame = new Frame("Hola mundo");
		frame.add(vista);
		frame.setSize(16*size, 18*size);
		frame.setVisible(true);
		frame.setBackground(Color.BLACK);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
	}
	public ModeloJV getmodelo() {
		return this.modelo;
	}
	public void start() {
		modelo.start();
	}
	
	public static void main(String[] args) {
		JuegoVida juego=new JuegoVida();
		juego.start();
		
	}
}
