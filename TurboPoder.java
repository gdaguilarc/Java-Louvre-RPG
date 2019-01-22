import java.io.Serializable;

public class TurboPoder extends Arma implements Serializable {
	public TurboPoder() {
		super("TurboPoder", "max");
	}

	public int totalPoder(String type) {
		return 1;
	}

}
