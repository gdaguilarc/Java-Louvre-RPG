import java.io.Serializable;

public class FotografoDeEsculturas extends Heroe implements Serializable {
	private static final long serialVersionUID = 1L;

	public FotografoDeEsculturas(String nombre) {
		super("fotografia", nombre);
		setBaseHp(60);
		setBaseAttack(60);
		setBaseDefensa(120);
		setBaseSpeed(80);
		setNivel(5);
	}

	public void ataque() {
		// ataque ITC
	}
}
