

public class Pieza
{
    String tipo;
    String color;
    int fila;
    int columna;
    
    Pieza(String tipo, String color, int fila, int columna) {
        this.tipo = tipo;
        this.color = color;
        this.fila = fila;
        this.columna = columna;
    }
    
    public void imprimirPieza() {
        System.out.println("\t" + tipo + "_" + color + "\t[" + fila + "] [" + columna + "]");
    }
    
    String getTipo() { return this.tipo; }
    
    String getColor() { return this.color; }
}
