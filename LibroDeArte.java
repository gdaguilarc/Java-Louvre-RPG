import java.io.Serializable;

public class LibroDeArte extends Objeto implements Serializable {
  public LibroDeArte() {
    super("Libro de Arte", "Salud");
  }

  public int totalPoder(String type) {
    return (int) (Math.random() * 10) + 1;
  }

}
