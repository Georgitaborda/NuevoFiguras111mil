import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class App {
    // Campos para su funcionamiento
    // Canvas es la ventana para graficar
     private Canvas miVentana;
     private Random aleatorio;
     
    // Mas informacion sobre ArrayList en la API de Java
    // API - Application Programming Interface
    //       Interface para Programacion de Aplicaciones
    //private ArrayList<Circulo> circulos;
    //private ArrayList<Rectangulo> rectangulos;
    //private ArrayList<Triangulo> triangulo; 
    //private ArrayList<FiguraGeometrica>figuras;
    private int ancho = 800;
    private int alto = 600;

    /**
     * Constructor sin parametros por defe tcto
     */
    public App () {
        aleatorio = new Random();
        circulos = new ArrayList<>();
        rectangulos = new ArrayList<>();
        //figuras = new ArrayList<>(); (nosesiva)
        miVentana = new Canvas("Hola Ventana", ancho, alto);
        miVentana.setVisible(true);
        
    }

    /**
     * Solo lanza la aplicacion
     * @param args Los del Sistema Operativo
     * @throws Exception En caso de fallo
     */
    public static void main(String[] args) throws Exception {
        App miAplicacion = new App();
       //miAplicacion.ejecutar();
       //miAplicacion.imagenes();
       miAplicacion.triangulos();
    }
    public void imagenes () {
        Dibujo dibujo = new Dibujo();
        miVentana.dibujarImagen(dibujo.getImagen(), dibujo.getAncho(), dibujo.getAlto());
    }

    public void triangulos () {
        Triangulo t1 = new Triangulo(200, 100);
        t1.setX(200);
        t1.setY(200);
        t1.setColor(Color.RED);
        miVentana.setColorDeLapiz(t1.getColor());
        miVentana.rellenarTriangulo(t1.getX(), t1.getY(), t1.getBase(), t1.getAltura());
        Triangulo t2 = new Triangulo(100, 250);
        t2.setX(500);
        t2.setY(300);
        t1.setColor(Color.BLUE);
        miVentana.setColorDeLapiz(t2.getColor());
        miVentana.rellenarTriangulo(t2.getX(), t2.getY(), t2.getBase(), t2.getAltura());
    }
    /**
     * Metodo para ejecutar las diferentes actividades
     */
    public void ejecutar () {
        
      //CrearFigurasGeometricas(); //lo sacamos para usar el de abajo nomas
      CrearFigurasAleatorias(30);
      MostrarSuperficies();
      //variable local para un subconjunto de los circulos 
     // ArrayList<Circulo> enRango;
      //ArrayList<Circulo> enArea;
      // selecciona los circulos qu cumplen la condicion de radio
      //enRango = CirculosConRadioEnRango(40, 70);
     // enArea= CirculosEnUnArea (0, 300);
      //establece el color de los circulos de la coleccion
     //PintarCirculos(enRango,  Color.BLUE);
     //PintarCirculos (enArea, Color.PINK);
      // selecciona los circulos qu cumplen la condicion de radio
      //enRango = CirculosConRadioEnRango(70, 100);
      //establece el color de los circulos de la coleccion
      //PintarCirculos(enRango,  Color.RED);

      //miVentana.espera(1500);
        //PrimerosEjemplos();
        // Metodo para movimiento de circulo
        //PelotaRebotando();
        //miVentana.espera(1500);
        //RectanguloRebotando();
        //GraficarCirculosColeccionados();
        //GraficarRectangulosColeccionados();
       /** 
        for (int i = 0; i < 100 ; i++) {
            miVentana.espera(500);
            BorrarCirculosColeccionados();
            BorrarRectangulosColeccionados();
            ActualizarPosicionCirculos();
            if (i==50){
                PintarCirculos(circulos, Color.MAGENTA);
            }
            ActualizarPosicionRectangulos();
            GraficarCirculosColeccionados();
            GraficarRectangulosColeccionados();
           
        }
        */
        
    }

    public void MostrarSuperficies(){
        for (FiguraGeometrica f : figuras) {
            // f -> tipo estatico FiguraGeometrica -> verifica el compilador
            System.out.println(f.getSuperficie());
            // dado el polimorfismo en la herencia
            // en ejecucion -> f -> tipo dinamico -> verifica la JVM
        }
    }

    /**
     * Genera los objetos graficos en forma aleatoria y los agrega a la coleccion
     * correspondiente
     * 
     * @param cantidad Cantidad de figuras a crear
     */
    public void CrearFigurasGeometricas (int cantidad) {
        for (int c = 0; c < cantidad; c++) {
            Circulo circulo = new Circulo (aleatorio.nextInt(91) + 10,
                                           aleatorio.nextInt( getAncho() ),
                                           aleatorio.nextInt( getAlto() ) );
            circulo.getPos().setDespX( aleatorio.nextInt( 31 ) - 15 );
            circulo.getPos().setDespY( aleatorio.nextInt( 31 ) - 15 );
            // Lo agrego en la coleccion
            // circulos.add(circulo);
            figuras.add(circulo);
            Triangulo triangulo = new Triangulo (aleatorio.nextInt(91) + 10,
                                        aleatorio.nextInt(91) + 10,
                                        aleatorio.nextInt( getAncho() ),
                                        aleatorio.nextInt( getAlto() ) );
            triangulo.getPos().setDespX( aleatorio.nextInt( 31 ) - 15 );
            triangulo.getPos().setDespY( aleatorio.nextInt( 31 ) - 15 );
            figuras.add(triangulo);
            // TODO - Repetir lo mismo para Rectangulo
        }
    }
    public void CrearFigurasAleatorias (int cantidad) {
        for (int c=0; c < cantidad; c++){
            Circulo circulo = new Circulo ( aleatorio.nextInt(91) + 10 ); //por si el menor numero que quiero no es 100
            Rectangulo rectangulo = new Rectangulo ( aleatorio.nextInt (91) + 10 ,  aleatorio.nextInt (91) + 10);
            
            circulo.getPos().setDespX( aleatorio.nextInt( 31 ) - 15 );
            circulo.getPos().setDespY( aleatorio.nextInt( 31 ) - 15 );

        rectangulo.setX(aleatorio.nextInt ( getAncho() ) );
        rectangulo.setY(aleatorio.nextInt ( getAlto() ) );;
        triangulo.getPos().setDespX( aleatorio.nextInt( 31 ) - 15 );
        triangulo.getPos().setDespY( aleatorio.nextInt( 31 ) - 15 );

        // Lo agrego en la coleccion
        circulos.add(circulo);
        rectangulos.add (rectangulo);
        } 

    
    // selecciona los circulos qu cumplen la condicion de radio

    public ArrayList <Circulo> CirculosConRadioEnRango(int min, int max){
        //creo la nueva lista
        ArrayList<Circulo> lista= new ArrayList<>();
        for(Circulo c : circulos){
            //si esta en ragngo
            if ((min<=c.getRadio ( ) ) && (c.getRadio() <= max ) ){
                //lo agrego a la nueva lista
                lista.add(c);
            }       
        }
        //devuelvo los circulos que cumplen la condicion
        return lista;
    }
    //TODO : REctangulosConSuperficieEnRango()
    // hecho.toma los circulos que se encuentran en las posiciones entre 0 y 300 en x y entre 0 y 300 en y

    public ArrayList <Circulo> CirculosEnUnArea(int min, int max ){
        ArrayList<Circulo>Listaxy = new ArrayList<>();
        for (Circulo c : circulos){
            if ((min<=c.getX()) && (c.getX() <=max) && (min<=c.getY()) && (c.getY() <=max)){
                Listaxy.add(c);
            }
            
        }
        return Listaxy;
     
    } 

    //TODO RectangulosEnUnArea()
    //establece el color de los circulos de la coleccion
 
    //TODO: PintarRectangulos()

    public void PintarCirculos(ArrayList<Circulo> lista, Color color){
    for (Circulo c : lista){
        c.setColor(color);

        }
    }

     /** 
     * Genera los objetos graficos en forma aleatoria y los agrega a la
     * coleccion correspondiente
     * @param Cantidad de figuras a crear
     */
    
    }
    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }
    /**
     * Genera los objetos graficos y los agrega a la
     * coleccion correspondiente
     */
    public void CrearFigurasGeometricas () {
        System.out.println("Hay " + circulos.size() + " circulos creados");
        // Creo el primer objeto circulo
        Circulo circulo = new Circulo (100);
        circulo.setX(150);
        circulo.setY(150);
        circulo.setDespX(5);
        circulo.setDespY(5);
        // Lo agrego en la coleccion
        circulos.add(circulo);
        System.out.println("Hay " + circulos.size() + " circulos creados");

        // Creo el segundo objeto circulo
        circulo = new Circulo (50);
        circulo.setX(300);
        circulo.setY(250);
        circulo.setDespX(-15);
        circulo.setDespY(5);
        circulo.setColor(Color.RED);
        // Lo agrego en la coleccion
        circulos.add(circulo);
        System.out.println("Hay " + circulos.size() + " circulos creados");

        // Creo el tercer objeto circulo
        circulo = new Circulo (150);
        circulo.setX(400);
        circulo.setY(350);
        circulo.setDespX(5);
        circulo.setDespY(-15);
        circulo.setColor(Color.BLUE);
        // Lo agrego en la coleccion
        circulos.add(circulo);
        System.out.println("Hay " + circulos.size() + " circulos creados");


        System.out.println("Hay" + rectangulos.size()+ "rectángulos creados");
        //creo el primer rectangulo
        Rectangulo rectangulo = new Rectangulo (60,100);
        rectangulo.setX(70);
        rectangulo.setY(70);
        rectangulo.setDespX(7);
        rectangulo.setDespY(7);
        rectangulo.setColor(Color.ORANGE);
        //lo agrego en la coleccion
        rectangulos.add(rectangulo);
        System.out.println("Hay"+ rectangulos.size()+ "rectangulos creados");

        //Creo el segundo rectangulo
        rectangulo= new Rectangulo (50,30);
        rectangulo.setX(500);
        rectangulo.setY(450);
        rectangulo.setDespX(-17);
        rectangulo.setDespY(15);
        rectangulo.setColor(Color.LIGHT_GRAY);
        //lo agrego en la coleccion
        rectangulos.add(rectangulo);
        System.out.println("Hay" + rectangulos.size() + "rectangulos creados");

        //Creo el tercer rectangulo
        rectangulo=new Rectangulo(170,120);
        rectangulo.setX(150);
        rectangulo.setY(150);
        rectangulo.setDespX(7);
        rectangulo.setDespY(20);
        rectangulo.setColor(Color.MAGENTA);
        //lo agrego a la coleccion
        rectangulos.add(rectangulo);
        System.out.println("Hay" + rectangulos.size() + "rectangulos creados");

    }

    /**
     *  * Toma uno a uno los circulos de la coleccion y los
     * grafica en el canvas
     */
    public void GraficarCirculosColeccionados () {
        // Con colecciones puedo usar for-each (para cada elemento)
        for (Circulo c : circulos) {
            miVentana.setColorDeLapiz(c.getColor());
            miVentana.rellenarCirculo(c.getX(), c.getY(), c.getDiametro());
        }
    }

    /**
     * Toma uno a uno los circulos de la coleccion y los
     * grafica en el canvas
     */    
    public void BorrarCirculosColeccionados () {
        // Con colecciones puedo usar for-each (para cada elemento)
        for (Circulo c : circulos) {
            miVentana.borrarCirculo(c.getX(), c.getY(), c.getDiametro());
        }
    }

    /**
     * Toma uno a uno los circulos de la coleccion y les
     * pide que actualicen su posicion
     */    
    public void ActualizarPosicionCirculos () {
        // Con colecciones puedo usar for-each (para cada elemento)
        for (Circulo c : circulos) {
            c.actualizarPosicion();
        }
    }

    /**
     * Toma uno a uno los rectangulos de la coleccion y los
     * grafica en el canvas
     */    
    public void GraficarRectangulosColeccionados () {
        for (Rectangulo r : rectangulos){
        miVentana.setColorDeLapiz(r.getColor());
        miVentana.rellenarRectangulo(r.getX(), r.getY(), r.getLado1() , r.getLado2());
        }
   }

   public void BorrarRectangulosColeccionados () {
    // Con colecciones puedo usar for-each (para cada elemento)
    for (Rectangulo r : rectangulos) {
        miVentana.borrarRectangulo(r.getX(), r.getY(), r.getLado1(), r.getLado2());
    }
}

    public void ActualizarPosicionRectangulos () {
    // Con colecciones puedo usar for-each (para cada elemento)
    for (Rectangulo r : rectangulos) {
        r.actualizarPosicion();
    }
}
    /**
     * Simula el rebote de una pelota en los bordes de la ventana
     */
    public void PelotaRebotando () {
        int desplazamiento = 10;
        Circulo circulo = new Circulo (20);
        circulo.setX(150);
        circulo.setY(350);
        miVentana.setColorDeLapiz(circulo.getColor());
        miVentana.rellenarCirculo(circulo.getX(), circulo.getY(), circulo.getDiametro());
        miVentana.espera(5000);
        for ( int repeticiones = 0 ; repeticiones < 600 ; repeticiones++ ) {
            miVentana.borrarCirculo(circulo.getX(), circulo.getY(), circulo.getDiametro());
            // Verifica rebote en los bordes
            if ((circulo.getX() + circulo.getDiametro() >= getAncho()) || 
                    (circulo.getX() <= 0)) {
                desplazamiento = - desplazamiento;
            }
            circulo.setX( circulo.getX() + desplazamiento );

            // Agreguen movimiento vertical

            // circulo.setY( circulo.getY() - 5 );
            miVentana.rellenarCirculo(circulo.getX(), circulo.getY(), circulo.getDiametro());
            miVentana.espera(75);
        }
        
    }

    public void RectanguloRebotando () {
        int desplazamiento = 15;
        Rectangulo rectangulo = new Rectangulo (50,70);
        rectangulo.setX (100);
        rectangulo.setY(150);
        miVentana.setColorDeLapiz (rectangulo.getColor());
        miVentana.rellenarRectangulo(rectangulo.getX(), rectangulo.getY(), rectangulo.getLado1(), rectangulo.getLado2());
        miVentana.espera(5000);
        for (int repeticiones= 0 ; repeticiones <600; repeticiones++){
            miVentana.borrarRectangulo(rectangulo.getX(), rectangulo.getY(), rectangulo.getLado1(), rectangulo.getLado2());
            if ((rectangulo.getX() + rectangulo.getLado1() >= getAncho() ) ||
            (rectangulo.getX() <=0 )) {
                desplazamiento= - desplazamiento;

            }
            rectangulo.setX(rectangulo.getX() + desplazamiento);

            miVentana.rellenarRectangulo(rectangulo.getX(), rectangulo.getY(), rectangulo.getLado1(), rectangulo.getLado2());
            miVentana.espera(75);
        }
        
    }

    public void PrimerosEjemplos () {
        Circulo circulo1 = new Circulo (200);
        Circulo circulo2 = new Circulo (500);
        Circulo circulo3 = new Circulo (60);
        Rectangulo rectangulo1 = new Rectangulo (30, 60); 
        Rectangulo rectangulo2 = new Rectangulo (10, 80); 
        Rectangulo rectangulo3 = new Rectangulo (30,150); 

        // Codificar acciones parecidas para la 
        // clase Rectangulo
        // Rectangulo ...

        circulo1.setX(700);
        circulo1.setY(520);

        circulo2.setX(500);
        circulo2.setY(80);

        circulo3.setX(100);
        circulo3.setY(50);

        rectangulo1.setX(700);
        rectangulo1.setY(700);

        rectangulo2.setX(10);
        rectangulo2.setY(10);

        rectangulo2.setX(500);
        rectangulo2.setY(550);


        // Dibujamos el primer Circulo
        // miVentana.setColorDeLapiz(Color.GREEN);
        miVentana.setColorDeLapiz(circulo3.getColor());
        miVentana.rellenarCirculo(circulo3.getX(), circulo3.getY(), circulo3.getDiametro());

        miVentana.setColorDeLapiz(circulo2.getColor());
        miVentana.rellenarCirculo(circulo2.getX(), circulo2.getY(), circulo2.getDiametro());

        miVentana.setColorDeLapiz(circulo1.getColor());
        miVentana.rellenarCirculo(circulo1.getX(), circulo1.getY(), circulo1.getDiametro());


        // Dibujar un rectangulo de color ROJO (RED)
        // Rectangulo r = new Rectangulo();
        // rellenarRectangulo(int xPos, int yPos, int ancho, int alto)
        // miVentana.rellenarRectangulo(r.getX(), r.getY(), 400, 300);

        miVentana.setColorDeLapiz(rectangulo1.getColor());
        miVentana.rellenarRectangulo(rectangulo1.getX(), rectangulo1.getY(), rectangulo1.getLado1(), rectangulo1.getLado2());

        miVentana.setColorDeLapiz(rectangulo2.getColor());
        miVentana.rellenarRectangulo(rectangulo2.getX(), rectangulo2.getY(), rectangulo2.getLado1(), rectangulo2.getLado2());

        miVentana.setColorDeLapiz(rectangulo3.getColor());
        miVentana.rellenarRectangulo(rectangulo3.getX(), rectangulo3.getY(), rectangulo3.getLado1(), rectangulo3.getLado2());

        /**
         * Ciclos de repeticion -> permiten iterar
         * 
         * while -> (hacer mientras) -> repeticion indefinida
         * 
         * for -> (para) -> repeticion definida
         */
        miVentana.espera(10000);
        // int repeticiones = 0;
        // while (repeticiones < 5) {
        //     miVentana.borrarCirculo(circulo1.getX(), circulo1.getY(), circulo1.getDiametro());
        //     circulo1.setX( circulo1.getX() + 10 );
        //     miVentana.rellenarCirculo(circulo1.getX(), circulo1.getY(), circulo1.getDiametro());
        //     repeticiones = repeticiones + 1;
        //     miVentana.espera(500);
        // }
        /**for ( int repeticiones = 0 ; repeticiones < 100 ; repeticiones++ ) {
            miVentana.borrarCirculo(circulo1.getX(), circulo1.getY(), circulo1.getDiametro());
            circulo1.setX( circulo1.getX() + 10 );
            circulo1.setY( circulo1.getY() - 5 );
            miVentana.rellenarCirculo(circulo1.getX(), circulo1.getY(), circulo1.getDiametro());
            miVentana.espera(250);

            miVentana.borrarRectangulo(rectangulo1.getX(), rectangulo1.getY(), rectangulo1.getLado1(), rectangulo1.getLado2());
            rectangulo1.setX( rectangulo1.getX() + 50);
            rectangulo1.setY( rectangulo1.getY() - 20 );
            miVentana.rellenarRectangulo(rectangulo1.getX(), rectangulo1.getY(), rectangulo1.getLado1(), rectangulo1.getLado2());
            miVentana.espera(250);
        }
        */

        // DESAFIO
        // Hacer que un circulo crezca de tamaño, por ej. comenzar con
        //  radio = 50 y que llegue a radio = 400

    }
/**
 * Devuelve el ancho y el alto de la ventana
 * @return
 */
    public int getAncho () {
        return ancho;
    }

    public int getAlto () {
        return alto;
    }

}