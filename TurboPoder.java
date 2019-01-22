import java.io.Serializable;

public class TurboPoder extends Arma implements Serializable {
	private static final long serialVersionUID = 1L;

	public TurboPoder() {
		super("TurboPoder", "max");
	}

	public int totalPoder(String type) {
		return 1;
	}

}
