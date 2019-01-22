import java.io.Serializable;

public class ElHamurabi extends Bosses implements Serializable {
	private static final long serialVersionUID = 1L;

	public ElHamurabi() {
		super(120, 60, 200, 20);
		setNombre("ElHamurabi");
	}

	public void ataque() {
		// ataque
	}
}
