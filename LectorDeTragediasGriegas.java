import java.io.Serializable;

public class LectorDeTragediasGriegas extends Heroe implements Serializable {
	private static final long serialVersionUID = 1L;

	public LectorDeTragediasGriegas(String nombre) {
		super("historeador", nombre);
		setBaseHp(70);
		setBaseAttack(75);
		setBaseDefensa(90);
		setBaseSpeed(85);
		setNivel(5);
	}
}
