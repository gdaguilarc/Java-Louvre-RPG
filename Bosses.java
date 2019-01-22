import java.io.Serializable;

public class Bosses extends Personaje {

	private static final long serialVersionUID = 1L;

	public Bosses(int baseHp, int baseAttack, int baseDefensa, int baseSpeed) {
		super("inteligencia", "Bosses");
		setBaseXp(200);
		setBaseHp(baseHp);
		setBaseAttack(baseAttack);
		setBaseDefensa(baseDefensa);
		setBaseSpeed(baseSpeed);
	}

	public void levelUp() {

	}

	public void levelUp(Heroe heroe) {

	}
}
