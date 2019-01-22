import java.io.Serializable;

public class Casilla extends Mapa implements Serializable {
	private static final long serialVersionUID = 1L;
	private Personaje enemigo;
	private Objeto objeto;

	public Casilla(int aleatorio, int aleatorio2) {
		switch (aleatorio) {
		case 1:
			this.enemigo = new Momia();
			break;
		case 2:
			this.enemigo = new Pintura();
			break;
		case 3:
			this.enemigo = new Escultura();
			break;
		}
		switch (aleatorio2) {
		case 1:
			this.objeto = new LibroDeArte();
			break;
		case 2:
			this.objeto = new LibroDeHistoria();
			break;
		case 3:
			this.objeto = new Camara();
			break;
		case 4:
			this.objeto = new Pincel();
			break;
		case 5:
			this.objeto = new Pc();
			break;
		}
	}

	public Casilla(int contador) {
		switch (contador) {
		case 1:
			this.enemigo = new ElHamurabi();
			break;
		case 4:
			this.enemigo = new LaGioconda();
			break;
		case 2:
			this.enemigo = new LaLibertadGuiandoAlPueblo();
			break;
		case 3:
			this.enemigo = new LaVenusDeMilo();
			break;
		}
		this.objeto = new TurboPoder();
	}

	public Casilla() {
		this.objeto = objeto;
		this.enemigo = enemigo;
	}

	public Personaje getEnemigo() {
		return enemigo;
	}

	public Personaje getEnemigoVivo() throws ZombieException {
		if (enemigo.getVida() <= 0) {
			throw new ZombieException();
		} else {
			return enemigo;
		}

	}

	public Objeto getObjeto() {
		return objeto;
	}

}
