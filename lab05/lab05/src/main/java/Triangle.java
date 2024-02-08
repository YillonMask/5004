public class Triangle extends AbstractShape {
    private final double x1;
    private final double x2;
    private final double y1;
    private final double y2;

    public Triangle(double x, double y, double x1, double y1, double x2, double y2) throws IllegalArgumentException {
        super(new Point2D(x,y));
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        if(x1 == x2 && y1 == y2){
            throw new IllegalArgumentException("Two points should be unique");
        }
    }

    @Override
    public double area(){
        double x = reference.getX();
        double y = reference.getY();
        return Math.abs((x * (y1 - y2) + x1 * (y2 - y) + x2 * (y - y1)) / 2.0);
    }

    @Override
    public double perimeter(){
        double x = reference.getX();
        double y = reference.getY();
        // Calculate the lengths of the sides of the triangle
        double sideA = distance(x, y, x1, y1);
        double sideB = distance(x1, y1, x2, y2);
        double sideC = distance(x2, y2, x, y);

        // Sum the lengths of the sides to get the perimeter
        return sideA + sideB + sideC;
    }

    public static double distance(double x, double y, double x1, double y1) {
        return Math.sqrt(Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2));
    }

    @Override
    public Shape resize(double factor){
        double sqrtFactor = Math.sqrt(factor);

        double new_x1 = reference.getX() + sqrtFactor * (x1 - reference.getX());
        double new_y1 = reference.getY() + sqrtFactor * (y1 - reference.getY());
        double new_x2 = reference.getX() + sqrtFactor * (x2 - reference.getX());
        double new_y2 = reference.getY() + sqrtFactor * (y2 - reference.getY());

        return new Triangle(reference.getX(),reference.getY(),new_x1,new_y1,new_x2,new_y2);
    }

    public String toString(){
        return String.format("The reference point is (%.3f, %.3f), the other two points are " +
                "(%.3f, %.3f),(%.3f,%.3f)",reference.getX(),reference.getY(),x1,y1,x2,y2);
    }

}