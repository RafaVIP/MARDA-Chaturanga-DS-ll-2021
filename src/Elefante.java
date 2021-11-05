public class Elefante extends PiezaAbstracta {

  public String nombre;

  public String color;

  public Elefante(final String color){
    this.nombre = "Elefante";
    this.color = color;
  }

  @Override
  public boolean movimiento() {
    return true;
  }

  @Override
  public String getImageFilePath() {
    return "imgs/" + this.nombre + "_" + color + ".png";
  }
  @Override
  public String to_String() {
    return this.nombre + "_" + this.color;
  }
}
