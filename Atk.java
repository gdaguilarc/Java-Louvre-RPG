import java.io.Serializable;

public interface Atk {
	// interfaz ataque para que cada quien la defina diferente
	public void ataque(Personaje personaje) throws MuerteEnemigoException, MuerteHeroeException;
}