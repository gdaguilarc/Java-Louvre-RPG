import java.io.Serializable;

public class Arma extends Objeto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int poder;

	public Arma() {
		super("arma", "weapon");
		poder = 0;
	}

	public Arma(String nombre, String tipo) {
		super(nombre, tipo);
		poder = 0;
	}

	public double multiplicador() {
		return (Math.random() * 2) + 1;
	}

	public void setPoder(int poder) {
		this.poder = poder;
	}

	public int totalPoder(String type) {
		if (type.equals(getTipo())) {
			return (int) (multiplicador() * (Math.random() * 10) + 1);
		} else {
			return (int) (multiplicador() * (Math.random() * 5) + 1);
		}
	}

	public int getPoder() {
		return poder;
	}
}
