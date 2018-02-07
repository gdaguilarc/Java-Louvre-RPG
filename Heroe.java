import java.io.Serializable;
public class Heroe extends Personaje implements Serializable{
  private Objeto [] objetos;
  public static int numeroObjetos = 0;
  public static int contador = 5;

  public Heroe(){
    super();
    objetos = new Objeto [10];
  }
  public Heroe(String tipo, String nombre)throws NullPointerException{
    super();
    setTipo(tipo);
    if(nombre.equals("")){
      throw new NullPointerException();
    }else{  
      setNombre(nombre);
    }
    
    objetos = new Objeto [10];
  }
  public Objeto getObjeto(int index){
    return objetos[index];
  }
  public void searchObjeto(String search)throws NoObjetoException{
    for(int i = 0; i < objetos.length; i++){
      if(objetos[i] != null){
        if(objetos[i].getNombre().equals(search)){
          if(search.equals("Pc")){
          setAttack(getAttack()+objetos[i].totalPoder(getTipo()));
          }
          else if(search.equals("Pincel")){
            setAttack(getAttack()+objetos[i].totalPoder(getTipo()));
          }
          else if(search.equals("Camara")){
            setAttack(getAttack()+objetos[i].totalPoder(getTipo()));
          }
          else if(search.equals("Libro de Historia")){
            setDefensa(getDefensa()+objetos[i].totalPoder(getTipo()));
            objetos[i] = null;
            numeroObjetosMenos();
          }
          else if(search.equals("Libro de Arte")){
            setVida(getVida()+objetos[i].totalPoder(getTipo()));
            objetos[i] = null;
            numeroObjetosMenos();
          }
          else{
            throw new NoObjetoException();
          }
        }
      }  
    }
  } 
  public void setObjeto(Objeto objeto)throws MochilaFullException, ArmaExistenteException{
    for(int i = 0; i < objetos.length; i++){
      if(objetos[i] == null){
        if(objeto.getNombre().equals("TurboPoder")){
          contadorTurbosMore();
          break;
        }else{
          objetos[i] = objeto;
          numeroObjetosMas();
          break; 
        }
      }else if(i == objetos.length-1){
        if(objetos[i] != null){
          throw new MochilaFullException();
        }else{
          objetos[i] = objeto;
          numeroObjetosMas();
        }
      }else if(objeto.getNombre().equals(objetos[i].getNombre())){
        if(objeto.getNombre().equals("Pc") || objeto.getNombre().equals("Pincel") || objeto.getNombre().equals("Camara")){
          throw new ArmaExistenteException();
        }
      }
    }
  }
  public void ataqueTurbo(Personaje personaje, int contador)throws MuerteEnemigoException, SinTurboException{
    if(contador == 0){
      throw new SinTurboException();
    }
    personaje.setVida(personaje.getVida()-(int)(0.01*2*((int)(Math.random()*15)+85)*(((0.2*getNivel()+1)*getAttack()*80/(25*personaje.getDefensa()))+2)));
    if(personaje.getVida()<=0){ 
      throw new MuerteEnemigoException();
    }
  }
  public void ataqueFisico(Personaje personaje)throws MuerteEnemigoException{
    personaje.setVida(personaje.getVida()-(int)(0.01*2*((int)(Math.random()*15)+85)*(((0.2*getNivel()+1)*getAttack()*63/(25*personaje.getDefensa()))+2)));
    setVida(getVida()-7);
    if(personaje.getVida()<=0){ 
      throw new MuerteEnemigoException();
    }
  }
  public void levelUp(int xp){
    setXp(0);
    int levels = 0;
    int suma = 0;
    for(int i = 0; i < xp; i++){
      suma ++;
      if(suma == (Math.pow(getNivel()+1,3)-Math.pow(getNivel(),3))){
        levels = levels + 1;
        setXp(0);
        suma = 0;
      }
      else if(i == xp-1){ 
        setXp(getXp()+suma);
      }
    }
    if(levels>0){
        setNivel(getNivel()+levels);
        setStatsRefresh(getBaseHp(),getBaseHp(),getBaseSpeed(),getBaseSpeed(),getNivel());
      }
  }
  public static void numeroObjetosMas(){
    numeroObjetos++;
  }
  public static void numeroObjetosMenos(){
    numeroObjetos--;
  }

  public static void contadorTurbosMore(){
    contador++;
  }
  public static void contadorTurbosLess()throws SinTurboException{
    if(contador <= 0){
      throw new SinTurboException();
    }else{
      contador--;
    }
  }

}
