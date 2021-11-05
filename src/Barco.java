public class Barco extends PiezaAbstracta {

    public String nombre;
  
    public String color;
  
    public Barco(final String color){
      this.nombre = "Barco";
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
  