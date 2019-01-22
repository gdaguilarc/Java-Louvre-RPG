import java.io.Serializable;

public class Momia extends Personaje implements Serializable {
	private static final long serialVersionUID = 1L;

	public Momia() {
		super("historia", "Momia", 50, 150, 110, 40);
		setBaseXp(160);
	}

	public void levelUp() {
	}

	public void levelUp(Heroe heroe) {
	}
}
