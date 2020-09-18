import java.awt.Color;

public class Triangulo extends FiguraGeometrica {
    private static final int MAX_ALTURA = 1000;
    private int base;
    private int altura;

    public Triangulo (int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public Triangulo(int base, int altura, int x, int y) {
        super(x,y);
        this.base = base;
        this.altura = altura;
    }
 public double getPerimetro () {
        return 0.0;
    }
    
    public double getSuperficie(){
        return base * altura / 2.0;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }



} 