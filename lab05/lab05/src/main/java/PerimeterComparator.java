import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2){
        double perimeter1 = s1.perimeter();
        double perimeter2 = s2.perimeter();
        return Double.compare(perimeter1,perimeter2);
    }
}
