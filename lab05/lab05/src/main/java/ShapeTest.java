import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class contains all the unit tests for various kinds of shapes
 */
public class ShapeTest {

  Shape circle1,circle2,circle3,rect1,rect2;

  @Before
  public void setup() {
    circle1 = new Circle(3,4,5);
    circle2 = new Circle(10.32,10.43,10);
    circle3 = new Circle(20);

    rect1 = new Rectangle(5,6,2.5,2);
    rect2 = new Rectangle(2,3,10,10);
  }

  /**
   * Tests whether objects have been created with the correct numbers or not.
   * It does this by using their toString methods
   */
  @Test
  public void testObjectData() {
    assertEquals("Circle: center (3.000,4.000) radius 5.000",circle1.toString
            ());
    assertEquals("Circle: center (10.320,10.430) radius 10.000",circle2.toString
            ());
    assertEquals("Circle: center (0.000,0.000) radius 20.000",circle3
            .toString
            ());
    assertEquals("Rectangle: LL corner (5.000,6.000) width 2.500 height 2.000",
            rect1.toString());
    assertEquals("Rectangle: LL corner (2.000,3.000) width 10.000 height 10" +
            ".000",rect2
            .toString());
  }

  /**
   * Tests whether the area methods work correctly for all shapes
   */
  @Test
  public void testArea() {
    assertEquals(Math.PI*25,circle1.area(),0.001);
    assertEquals(Math.PI*100,circle2.area(),0.001);
    assertEquals(Math.PI*400,circle3.area(),0.001);
    assertEquals(5,rect1.area(),0.001);
    assertEquals(100,rect2.area(),0.001);
  }

  /**
   * Tests whether the perimeter methods work correctly for all shapes
   */
  @Test
  public void testPerimeter() {
    assertEquals(2*Math.PI*5,circle1.perimeter(),0.001);
    assertEquals(2*Math.PI*10,circle2.perimeter(),0.001);
    assertEquals(2*Math.PI*20,circle3.perimeter(),0.001);
    assertEquals(9,rect1.perimeter(),0.001);
    assertEquals(40,rect2.perimeter(),0.001);
  }

  @Test
  public void testResizes() {
    Shape resizedCircle1,resizedCircle2,resizedCircle3,resizedRect1,
            resizedRect2;

    resizedCircle1 = circle1.resize(2.5);
    resizedCircle2 = circle2.resize(0);
    resizedCircle3 = circle3.resize(10);
    resizedRect1 = rect1.resize(12.5);
    resizedRect2 = rect2.resize(0.001);

    assertEquals(2.5*circle1.area(),resizedCircle1.area(),0.001);
    assertEquals(0*circle2.area(),resizedCircle2.area(),0.001);
    assertEquals(10*circle3.area(),resizedCircle3.area(),0.001);
    assertEquals(12.5*rect1.area(),resizedRect1.area(),0.001);
    assertEquals(0.001*rect2.area(),resizedRect2.area(),0.001);
  }



}