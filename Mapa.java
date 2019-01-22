import java.io.Serializable;

public class Mapa implements Serializable {
	private static final long serialVersionUID = 1L;
	private Casilla[] casillas;
	private Heroe heroe;
	private int posicion;

	public Mapa(Heroe heroe) throws NullPointerException {
		posicion = 0;
		casillas = new Casilla[24];
		if (heroe.getNombre().equals("")) {
			throw new NullPointerException();
		} else {
			this.heroe = heroe;
		}

	}

	public Mapa() {
		posicion = 0;
		casillas = new Casilla[24];
		this.heroe = heroe;
	}

	public Heroe getHeroe() {
		return heroe;
	}

	public int aleatorioUno() {
		int valor = (int) (Math.random() * 3) + 1;
		return valor;
	}

	public int aleatorioDos() {
		int valor = (int) (Math.random() * 5) + 1;
		return valor;
	}

	public void setCasillas() {
		int valor;
		for (int i = 0; i < casillas.length; i++) {
			casillas[i] = new Casilla(aleatorioUno(), aleatorioDos());
			casillas[i].getEnemigo().setNivel(3);
			casillas[i].getEnemigo().setStats(casillas[i].getEnemigo().getBaseHp(),
					casillas[i].getEnemigo().getBaseAttack(), casillas[i].getEnemigo().getBaseDefensa(),
					casillas[i].getEnemigo().getBaseSpeed(), casillas[i].getEnemigo().getNivel());

		}
		for (int j = 1; j < 5; j++) {
			valor = (int) (Math.random() * 23) + 1;
			casillas[valor] = new Casilla(j);
			casillas[valor].getEnemigo().setNivel(4);
			casillas[valor].getEnemigo().setStats(casillas[valor].getEnemigo().getBaseHp(),
					casillas[valor].getEnemigo().getBaseAttack(), casillas[valor].getEnemigo().getBaseDefensa(),
					casillas[valor].getEnemigo().getBaseSpeed(), casillas[valor].getEnemigo().getNivel());
		}
	}

	public void imprimirCasillas() {
		for (int i = 0; i < casillas.length; i++) {
			System.out.println(casillas[i].getEnemigo().getNombre() + " tipo: " + casillas[i].getEnemigo().getTipo()
					+ " Objeto: " + casillas[i].getObjeto().getNombre() + " vida: " + casillas[i].getEnemigo().getVida()
					+ " speed: " + casillas[i].getEnemigo().getSpeed());
		}
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int getPosicion() {
		return posicion;
	}

	public Casilla[] getCasilla() {
		return casillas;
	}

	public Casilla getCasilla(int index) {
		return casillas[index];
	}

	public Casilla getCasilla2(int index) throws GanarException {
		if (index == 23) {
			throw new GanarException();
		} else {
			return casillas[index];
		}

	}
}
