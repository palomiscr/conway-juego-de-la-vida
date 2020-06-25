
public class Tablero {
	public static int VACIO=0 ;
	public static int VIVO=1; 
	private int size;
	int [][]tablero;
	public Tablero(int size) {
		this.size=size;
		tablero=new int[size][size];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j]=VACIO;
			}
		}
	}
	public Tablero clone() {
		return this;
	}
	
	public int	getCasilla(int x, int y) {
		return tablero[x][y];
	}
	public void	initRandom(int numCasillas, int estado) {

    	for (int i = 0; i < numCasillas; i++) {//inicializo tntas vidas de manera random
			int x=(int) Math.floor(Math.random()*size);//excluido N
			int y=(int) Math.floor(Math.random()*size);//excluido N
			tablero[x][y]=VIVO;
		}
		
	}
	public void	set(Tablero tablero) {
		for (int i = 0; i < this.tablero.length; i++) {
			for (int j = 0; j< this.tablero.length; j++) {
				this.tablero[i][j]=tablero.getCasilla(i, j);

			}
		}
	}
	public void	setCasilla(int x, int y, int estado) {
		if(estado==VIVO)
			this.tablero[x][y]=VIVO;
		else
			this.tablero[x][y]=VACIO;
	}
	public int	size() {
		return this.size;
	}
	public int	size(int estado) {
		int cont=0;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if(tablero[i][j]==estado)
					cont++;
			}
		}
		return cont;
		
	}
}
