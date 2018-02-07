import java.io.Serializable;
public class LibroDeHistoria extends Objeto implements Serializable{

  public LibroDeHistoria(){
  	super("Libro de Historia", "historia");
  }
  public int totalPoder(String type){
    if(type.equals(getTipo())){
			return (int)((Math.random()*10)+1);	
		}else{
			return (int)((Math.random()*5)+1);
		}
  } 

}
