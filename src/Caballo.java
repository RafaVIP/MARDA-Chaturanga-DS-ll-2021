public class Caballo extends PiezaAbstracta {

    public String nombre;
  
    public String color;
  
    public Caballo(final String color){
      this.nombre = "Caballo";
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
  