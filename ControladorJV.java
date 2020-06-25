
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeSupport;
import java.awt.Point;
public class ControladorJV implements MouseListener {
    private PropertyChangeSupport supportRaton;
    
    public ControladorJV (PropertyChangeSupport supportRaton) {
        this.supportRaton = supportRaton; 
  	}
    
    public void mouseClicked(MouseEvent e) {
  	  Point nuevo= e.getPoint();
  	  supportRaton.firePropertyChange("raton", 0, nuevo); // Datos enviados al Modelo
      }
    public void mouseEntered(MouseEvent e) {};
    public void  mouseExited(MouseEvent e) {};
    public void	mousePressed(MouseEvent e) {};
    public void mouseReleased(MouseEvent e) {};
}
