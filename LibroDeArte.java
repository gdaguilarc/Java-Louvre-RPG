import java.io.Serializable;

public class LibroDeArte extends Objeto implements Serializable {
  private static final long serialVersionUID = 1L;

public LibroDeArte() {
    super("Libro de Arte", "Salud");
  }

  public int totalPoder(String type) {
    return (int) (Math.random() * 10) + 1;
  }

}
