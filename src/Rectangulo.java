
import java.awt.Color;

public class Rectangulo extends FiguraGeometrica{
    private static final int MAX_LADO=1000;

    
    private int lado1;
    private int lado2;

    // Falta definir los constructures
    public Rectangulo (int lado1, int lado2 ) {
        setLado1(lado1);
        setLado2(lado2);
        determinarColor();
        
    }

    /**
     * Este metodo establece el color del Rectangulo segun
     * la superficie configurada.
     * 
     * Si superficie <   500 -> tiene color azul (Color.BLUE)
     * Si superficie <  1000 -> tiene color verde (Color.GREEN)
     * Si superficie <  1500 -> tiene color amarillo (Color.YELLOW)
     * Si superficie <  2000 -> tiene color naranja (Color.ORANGE)
     * Si superficie <  2500 -> tiene color rojo (Color.RED)
     * Si superficie >= 2500 -> tiene color magenta (Color.MAGENTA)
     */
    private void determinarColor() {

        if (getSuperficie() < 500) {
            setColor(Color.blue);
        }
        else if (getSuperficie() < 1000) {
            setColor(Color.green);
        }
        else if (getSuperficie() < 1500) {
            setColor(Color.YELLOW);
        }
        else if (getSuperficie() < 2000) {
            setColor(Color.orange);
        }
        else if (getSuperficie() < 2500) {
            setColor(Color.red);
        }
        else if (getSuperficie() >= 2500) {
            setColor(Color.MAGENTA);
        }
        
    }
    public double getPerimetro () {
        return 0.0;
    }

    public double getSuperficie () {
        return 0.0;
    }
    public int getLado1() {
        return lado1;
    }

    public void setLado1(int lado1) {
        if (0<lado1 && lado1<MAX_LADO ){
            this.lado1 = lado1;
            determinarColor();
        }
        
        
    }

    public int getLado2() {
        return lado2;
    }

    public void setLado2(int lado2) {
        if (0<lado2 && lado2<MAX_LADO ){
        this.lado2 = lado2;
        determinarColor();
    }
}
    
}

