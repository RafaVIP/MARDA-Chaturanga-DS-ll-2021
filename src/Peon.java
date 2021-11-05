public class Peon extends PiezaAbstracta {

    public String nombre;
  
    public String color;
  
    public Peon(final String color){
      this.nombre = "Peon";
      this.color = color;
    }
  
    @Override
    public boolean movimiento() {
      return true;
    }
  
    @Override
    public String getImageFilePath() {
      String path = "src/Chatu/images/"; //Img directory path
      path += this.nombre + "_" + color + ".png";
      return path;
    }
    @Override
    public String to_String() {
      return this.nombre + "_" + this.color;
    }
  }
  