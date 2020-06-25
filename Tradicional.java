
public class Tradicional {
	Tablero tnuevo;

	public Tablero evolucion(Tablero tablero) {
		tnuevo = new Tablero(tablero.size());
	
		for (int i = 0; i < tablero.size(); i++) {
			for (int j = 0; j < tablero.size(); j++) {

				if (contvivos(i, j, tablero) == 3) {// si hay 3 vive da igual vivo o muerto
					tnuevo.setCasilla(i, j, Tablero.VIVO);
				}

				else if (tablero.getCasilla(i, j) == Tablero.VIVO && contvivos(i, j, tablero) == 2) {// si esta viva y hay
																								// dos vivas, vive
					tnuevo.setCasilla(i, j, Tablero.VIVO);

				} else {
					tnuevo.setCasilla(i, j, Tablero.VACIO);
				}
			}
		}

		return tnuevo;
	}

	private int contvivos(int i, int j, Tablero tablero) {
		int contvivos = 0;
		if (i - 1 >= 0) {// arriba dentro de rango
			if (tablero.getCasilla(i - 1, j) == Tablero.VIVO) // arriba
				contvivos++;
			if (j - 1 >= 0) {
				if (tablero.getCasilla(i, j - 1) == Tablero.VIVO) // izquierda
					contvivos++;
				if (tablero.getCasilla(i - 1, j - 1) == Tablero.VIVO) // arriba iz
					contvivos++;
			}
			if (j + 1 < tablero.size()) {
				if (tablero.getCasilla(i - 1, j + 1) == Tablero.VIVO)// arriba dcha
					contvivos++;
			}
		}
		if (i + 1 < tablero.size()) {
			if (tablero.getCasilla(i +1, j) == Tablero.VIVO)// abajo
				contvivos++;
			if (j + 1 < tablero.size()) {
				if (tablero.getCasilla(i, j + 1) == Tablero.VIVO) // dcha
					contvivos++;
				if (tablero.getCasilla(i + 1, j + 1) == Tablero.VIVO) // abajo dcha
					contvivos++;
			}
			if(j-1>=0)
				if (tablero.getCasilla(i + 1, j -1) == Tablero.VIVO) // abajo iz
					contvivos++;

		}		

		return contvivos;

	}
}
