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
    /**
     * P3: if we want to sort the shapes based on its perimeter
     * we can just modify the compareTo() method
     * change it to perimeter() instead of area()
     */

    // Print the sorted list by area
    System.out.println("Sorted by area:");
    for (Shape shape : shapes) {
      System.out.println("Area: " + shape.area());
    }

    // Sort shapes based on perimeter (using Comparator)
    Collections.sort(shapes, new PerimeterComparator());
    /**
     * Since we are going to use Comparator to sort the shape
     * base on its perimeter. We should create a new class named PerimeterComparator
     * which implements Comparator<T>. and inside the class we have to Override
     * the method by comparing the shape according to its perimeter.
     */

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
