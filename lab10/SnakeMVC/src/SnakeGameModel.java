import java.util.List;

public class SnakeGameModel implements GameModel{
    private Coordinate apple_loc;
    private List<Coordinate> snake_loc;
    private int direction;

    // Constructor and other methods go here

    @Override
    public void updateDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public void updateGame() {
        // Update the game state here
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
