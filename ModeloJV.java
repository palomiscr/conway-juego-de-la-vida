import java.beans.*;

public class ModeloJV implements PropertyChangeListener {
	private PropertyChangeSupport supportmodelo; // Support de los datos enviados a la vista
	private Tablero tablero;
	private int vidas;

	public ModeloJV(PropertyChangeSupport supportmodelo, int vidas, int size) {
		this.supportmodelo = supportmodelo;
		this.vidas = vidas;
		tablero = new Tablero(size);

	}

	public void start() {
		tablero.initRandom(vidas, Tablero.VIVO);
		Tradicional t;
		while (tablero.size(Tablero.VIVO)!=0) {
			supportmodelo.firePropertyChange("juego", 0, tablero);// datos enviados a la vista
			t = new Tradicional();
			this.tablero = t.evolucion(tablero).clone();
			try {
				Thread.sleep(1000);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}
}
