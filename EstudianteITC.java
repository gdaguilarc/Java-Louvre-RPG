import java.io.Serializable;

public class EstudianteITC extends Heroe implements Serializable {
	private static final long serialVersionUID = 1L;

	public EstudianteITC(String nombre) {
		super("inteligencia", nombre);
		setBaseHp(60);
		setBaseAttack(90);
		setBaseDefensa(70);
		setBaseSpeed(100);
		setNivel(5);
	}

	public void ataque() {
		// ataque ITC
	}
}
