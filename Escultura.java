import java.io.Serializable;
public class Escultura extends Personaje implements Serializable{
	private int baseXp;
	public Escultura(){
		super("fotografia", "Escultura", 80, 120, 120, 30);
		setBaseXp(150);
	}
	public void ataque(){
    	//ataque
  	}
	public void levelUp(){

	}
	public void levelUp(Heroe heroe){

	} 
}
