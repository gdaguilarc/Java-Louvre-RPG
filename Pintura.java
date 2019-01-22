import java.io.Serializable;

public class Pintura extends Personaje implements Serializable {
	private static final long serialVersionUID = 1L;

	public Pintura() {
		super("pintura", "Obra de arte", 120, 60, 130, 40);
		setBaseXp(140);
	}

	public void ataque() {
		// ataque
	}

	public void levelUp() {
	}

	public void levelUp(Heroe heroe) {
	}
}
