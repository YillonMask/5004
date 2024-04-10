import java.util.ArrayList;
import java.util.List;
public class SnakeGameModel implements GameModel{
    private Coordinate apple_loc;
    private List<Coordinate> snake_loc;
    private int direction;

    // Constructor and other methods go here

    public SnakeGameModel(){
        this.snake_loc = new ArrayList<>();
        this.snake_loc.add(new Coordinate(0,0));
    }
    @Override
    public void updateDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public void updateGame() {
        // Update the game state here
        moveSnake();
    }

    private void moveSnake(){
        Coordinate head = snake_loc.getFirst();
        Coordinate newHead = switch (direction) {
            case 1 -> new Coordinate(head.getX(), head.getY() - 1);
            case 2 -> new Coordinate(head.getX() + 1, head.getY());
            case 3 -> new Coordinate(head.getX(), head.getY() + 1);
            case 4 -> new Coordinate(head.getX() - 1, head.getY());
            default -> throw new IllegalArgumentException("Invalid direction");
        };
        snake_loc.addFirst(newHead);
        snake_loc.removeLast();
    }
    @Override
    public Coordinate getAppleLocation() {
        return apple_loc;
    }

    @Override
    public List<Coordinate> getSnakeLocation() {
        return snake_loc;
    }
}
