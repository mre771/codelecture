package solutions._08;

import java.util.ArrayList;
import java.util.HashMap;

public class Shapes
{
    // Oppgave #7 og #8
    //# Main-metode
    public static void main(String[] args) {
        Circle shape01 = new Circle();
        Circle shape02 = new Circle();
        Circle shape03 = new Circle("green", false, 2.0);

        Rectangle shape04 = new Rectangle();
        Rectangle shape05 = new Rectangle();
        Rectangle shape06 = new Rectangle();

        Square shape07 = new Square();
        Square shape08 = new Square();
        Square shape09 = new Square();
        Square shape10 = new Square();

        HashMap<Integer, Shape> shapes = new HashMap<>();

        shapes.put(shape01.id, shape01);
        shapes.put(shape02.id, shape02);
        shapes.put(shape03.id, shape03);
        shapes.put(shape04.id, shape04);
        shapes.put(shape05.id, shape05);
        shapes.put(shape06.id, shape06);
        shapes.put(shape07.id, shape07);
        shapes.put(shape08.id, shape08);
        shapes.put(shape09.id, shape09);
        shapes.put(shape10.id, shape10);

        // Oppgave #8
        for (Shape shape : shapes.values()) {
            System.out.println(shape);
        }

        // Oppgave #9
        System.out.println("Informasjon om figur #3: ");
        System.out.println(shapes.get(3));

        // Ekstra utfordringer er løst i bunnen av den alternative main-metoden under
    }

    public static void alternativeMainMethod() {
        ArrayList<Shape> shapesList = new ArrayList<>();

        shapesList.add(new Circle(3.14));
        shapesList.add(new Circle(2.01));
        shapesList.add(new Circle(7.21));

        shapesList.add(new Rectangle(3.0, 4.0));
        shapesList.add(new Rectangle(6.0, 2.0));
        shapesList.add(new Rectangle(4.0, 8.0));

        shapesList.add(new Square(1.0));
        shapesList.add(new Square(2.0));
        shapesList.add(new Square(4.0));
        shapesList.add(new Square(8.0));

        HashMap<Integer, Shape> shapesMap = new HashMap<>();

        for (Shape shape : shapesList) {
            shapesMap.put(shape.getId(), shape);

            // getId() kan også brukes istedenfor id-feltet direkte
            // shapesMap.put(shape.getId(), shape);
        }

        //# Ekstra utfordring a)

        // Greit å huske hvordan et HashMap settes opp med tanke på typene her:
        //
        // HashMap<KeyType, ValueType> = HashMap<Integer, Shape>
        //

        System.out.println("\nLoop igjennom nøklene lagret:");
        for (int id : shapesMap.keySet()) {
            System.out.println("- Det finnes en figur med nøkkel \"" + id + "\" som kan hentes ut slikt:");
            System.out.println("  - shapesMap.get(" + id + ");");
            System.out.println();
        }

        System.out.println("Loop igjennom verdiene lagret:");
        for (Shape shape : shapesMap.values()) {
            System.out.println(shape);
        }

        //# Ekstra utfordring b)

        double areaLimit = 12.0;

        System.out.println("\nAlternativ 1) Følgende figurer har areal større enn: " + areaLimit);

        for (Shape shape : shapesMap.values()) {
            if (shape.getArea() > areaLimit) {
                System.out.printf("%s => getArea() returnerer %f%n", shape, shape.getArea());
            }
        }

        System.out.println("\nAlternativ 2) Følgende figurer har areal større enn: " + areaLimit);

        shapesMap.values().stream().filter(shape -> shape.getArea() > areaLimit).forEach(shape -> {
            System.out.printf("%s => getArea() returnerer %f%n", shape, shape.getArea());
        });

        System.out.println("\nAlternativ 3) Følgende figurer har areal større enn: " + areaLimit);

        shapesMap.entrySet().stream().filter(entry -> entry.getValue().getArea() > areaLimit).forEach(entry -> {
            System.out.printf("%d %s", entry.getKey(), entry.getValue());
        });
    }
}
