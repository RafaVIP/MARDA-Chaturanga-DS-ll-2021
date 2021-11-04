package Chaturanga;

public class Elefante extends PiezaAbstracta {

  public String nombre;

  public String color;

  public Elefante(final string color){
    this.nombre = "Elefante";
    this.color = color;
  }

  @Override
  public boolean movimiento() {

  }

  @Override
  public string getImageFilePath() {
    string path = "src/Chatu/images/"; //Img directory path
    path += this.nombre + "_" + color + ".png";
    return path;
  }
}
