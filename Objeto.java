import java.io.Serializable;

public abstract class Objeto implements Serializable {
  private String nombre, tipo;

  public Objeto() {
    nombre = "Sin nombre";
  }

  public Objeto(String nombre, String tipo) {
    this.tipo = tipo;
    this.nombre = nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public abstract int totalPoder(String type);
}
