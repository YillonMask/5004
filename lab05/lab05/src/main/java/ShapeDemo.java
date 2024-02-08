import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ShapeDemo {

  public static void main(String[] args) {
    List<Shape> shapes = new LinkedList<>(); // Use LinkedList

    // Add shapes to the list
    shapes.add(new Circle(5.0, 6.0, 15.0));
    shapes.add(new Rectangle(4.0, 6.0, 3.0, 4.0));
    shapes.add(new Triangle(1.0, 2.0, 0.0, 3, -1.0, 0.0));

    // Sort shapes based on area (using Comparable)
    Collections.sort(shapes);

    // Print the sorted list by area
    System.out.println("Sorted by area:");
    for (Shape shape : shapes) {
      System.out.println("Area: " + shape.area());
    }

    // Sort shapes based on perimeter (using Comparator)
    //Collections.sort(shapes, new PerimeterComparator());

    // Print the sorted list by perimeter
    System.out.println("\nSorted by perimeter:");
    for (Shape shape : shapes) {
      System.out.println("Perimeter: " + shape.perimeter());

    }
    for (Shape shape : shapes) {
      System.out.println(shape);
    }
  }
}
