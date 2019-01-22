import java.io.Serializable;

public class Personaje implements Atk, Serializable {
	private String nombre, tipo;
	private int vida, defensa, velocidad, speed;
	private int nivel;
	private int attack;
	private int xp;
	private int baseHp, baseAttack, baseDefensa, baseSpeed, baseXp;

	public Personaje() {
		nombre = "Sin nombre";
		tipo = "Sin tipo";
		baseHp = 0;
		baseAttack = 0;
		baseDefensa = 0;
		baseSpeed = 0;
		baseXp = 0;
		vida = 0;
		defensa = 0;
		attack = 0;
		velocidad = 0;
		xp = 0;
		nivel = 1;
	}

	public Personaje(String tipo, String nombre) {
		this.tipo = tipo;
		this.nombre = nombre;
		baseHp = 0;
		baseXp = 0;
		baseAttack = 0;
		baseDefensa = 0;
		baseSpeed = 0;
		vida = 0;
		defensa = 0;
		attack = 0;
		velocidad = 0;
		xp = 0;
		nivel = 1;
	}

	public Personaje(String tipo, String nombre, int baseHp, int baseAttack, int baseDefensa, int baseSpeed) {
		this.tipo = tipo;
		this.nombre = nombre;
		this.baseHp = baseHp;
		this.baseAttack = baseAttack;
		this.baseDefensa = baseDefensa;
		this.baseSpeed = baseSpeed;
		nivel = 1;
		baseXp = 0;
		xp = 0;
	}

	public int getBaseXp() {
		return baseXp;
	}

	public void setBaseXp(int baseXp) {
		this.baseXp = baseXp;
	}

	public int gainXp(Personaje personaje) {
		double bonificacion = 1.5;
		return (int) ((personaje.getBaseXp() * personaje.getNivel() * bonificacion) * 0.07);
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getXp() {
		return xp;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setVida(int baseHp, int nivel) {
		this.vida = setStatHp(baseHp, nivel);
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getVida() {
		return vida;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getNivel() {
		return nivel;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public void setAttack(int baseAttack, int nivel) {
		this.attack = setStat(baseAttack, nivel);
	}

	public int getAttack() {
		return attack;
	}

	public void setBaseHp(int baseHp) {
		this.baseHp = baseHp;
	}

	public int getBaseHp() {
		return baseHp;
	}

	public void setBaseAttack(int baseAttack) {
		this.baseAttack = baseAttack;
	}

	public int getBaseAttack() {
		return baseAttack;
	}

	public void setBaseSpeed(int baseSpeed) {
		this.baseSpeed = baseSpeed;
	}

	public int getBaseSpeed() {
		return baseSpeed;
	}

	public void setSpeed(int baseSpeed, int nivel) {
		this.speed = setStat(baseSpeed, nivel);
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}

	public void setBaseDefensa(int baseDefensa) {
		this.baseDefensa = baseDefensa;
	}

	public int getBaseDefensa() {
		return baseDefensa;
	}

	public void setDefensa(int baseDefensa, int nivel) {
		this.defensa = setStat(baseDefensa, nivel);
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setVelocidad(int baseSpeed, int nivel) {
		this.velocidad = setStat(baseSpeed, nivel);
	}

	public int getVelocidad() {
		return velocidad;
	}

	public int setStatHp(int stat, int nivel) {
		return (int) (2 * stat * (nivel * 0.01) + 10 + nivel);
	}

	public int setStat(int stat, int nivel) {
		return (int) (2 * stat * (nivel * 0.01) + 5);
	}

	public void setStatsRefresh(int baseHp, int baseAttack, int baseDefensa, int baseSpeed, int nivel) {
		setVida(setStatHp(baseHp, nivel) - (getVida() - setStatHp(baseHp, nivel - 1)));
		setAttack(setStat(baseAttack, nivel));
		setDefensa(setStat(baseDefensa, nivel));
		setSpeed(setStat(baseHp, nivel));
	}

	public void refresh() {
		setAttack(baseAttack, nivel);
		setDefensa(baseDefensa, nivel);
		setSpeed(baseSpeed, nivel);
	}

	public void setStats(int baseHp, int baseAttack, int baseDefensa, int baseSpeed, int nivel) {
		setVida(baseHp, nivel);
		setAttack(baseAttack, nivel);
		setDefensa(baseDefensa, nivel);
		setSpeed(baseSpeed, nivel);
	}

	public void setBases(int baseHp, int baseAttack, int baseDefensa, int baseSpeed) {
		this.baseHp = baseHp;
		this.baseAttack = baseAttack;
		this.baseDefensa = baseDefensa;
		this.baseSpeed = baseSpeed;
	}

	public void ataque(Personaje personaje) throws MuerteEnemigoException, MuerteHeroeException {
		if (personaje.getNombre().equals("Momia") || personaje.getNombre().equals("Obra de arte")
				|| personaje.getNombre().equals("Escultura") || personaje.getNombre().equals("LaGioconda")
				|| personaje.getNombre().equals("LaGioconda") || personaje.getNombre().equals("LaVenusDeMilo")
				|| personaje.getNombre().equals("ElHamurabi")
				|| personaje.getNombre().equals("LaLibertadGuiandoAlPueblo")) {
			if (personaje.getTipo().equals(this.tipo)) {
				personaje.setVida(personaje.getVida() - (int) (0.01 * 2 * ((int) (Math.random() * 15) + 85)
						* (((0.2 * nivel + 1) * getAttack() * 60 / (25 * personaje.getDefensa())) + 2)));
				if (personaje.getVida() <= 0) {
					throw new MuerteEnemigoException();
				}
			} else {
				personaje.setVida(personaje.getVida() - (int) (0.01 * .5 * ((int) (Math.random() * 15) + 85)
						* (((0.2 * nivel + 1) * getAttack() * 60 / (25 * personaje.getDefensa())) + 2)));
				if (personaje.getVida() <= 0) {
					throw new MuerteEnemigoException();
				}
			}
		} else {
			if (personaje.getTipo().equals(this.tipo)) {
				personaje.setVida(personaje.getVida() - (int) (0.01 * 2 * ((int) (Math.random() * 15) + 85)
						* (((0.2 * nivel + 1) * getAttack() * 60 / (25 * personaje.getDefensa())) + 2)));
				if (personaje.getVida() <= 0) {
					throw new MuerteHeroeException();
				}
			} else {
				personaje.setVida(personaje.getVida() - (int) (0.01 * .5 * ((int) (Math.random() * 15) + 85)
						* (((0.2 * nivel + 1) * getAttack() * 60 / (25 * personaje.getDefensa())) + 2)));
				if (personaje.getVida() <= 0) {
					throw new MuerteHeroeException();
				}
			}
		}
	}

}