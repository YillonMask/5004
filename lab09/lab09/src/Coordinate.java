/**
 * Coordinate class to represent a point in the grid.
 */
public class Coordinate {
  /**
   * Constructor for the Coordinate class.
   * @param x the x coordinate
   * @param y the y coordinate
   */
  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  int x;
  int y;

  /**
   * Equals method to compare two coordinates.
   * @param obj the object to compare
   * @return true if the coordinates are equal, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Coordinate) {
      Coordinate other = (Coordinate) obj;
      return other.x == this.x && other.y == this.y;
    }

    return false;
  }
}
