public class Coordinate {
  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  int x;
  int y;

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Coordinate) {
      Coordinate other = (Coordinate) obj;
      return other.x == this.x && other.y == this.y;
    }

    return false;
  }
}
