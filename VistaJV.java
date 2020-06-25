import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VistaJV  extends Canvas implements PropertyChangeListener{
	private Graphics2D g2d;
	private int size;
	private Tablero tablero;
	
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getPropertyName().equals("juego")) {
			tablero=(Tablero) evt.getNewValue();
			this.size=tablero.size();
		}
		repaint();
		
	}
	public void paint(Graphics g) {
		g2d=(Graphics2D) g;
		
		int intervalo=15;
		
		g2d.setColor(Color.MAGENTA);
	
		for (int i = 0; i < tablero.size(); i++) {
			for (int j = 0; j < tablero.size(); j++) {
				
				if(tablero.getCasilla(i, j)==Tablero.VIVO) {
					g2d.fillRect(intervalo*j, intervalo*i, intervalo, intervalo);
				}

			}
		}
		g2d.setColor(Color.WHITE);
		for (int i = 0; i < size+1; i++) {// procurar que el tablero sea cuadrado para poder hacerlo todo en un for
			g2d.drawLine(0, intervalo*i, 15*size ,  intervalo*i);// -
			g2d.drawLine( intervalo*i, 0,  intervalo*i, 15*size);// |			
			
		}
	}

	
}
