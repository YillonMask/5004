import java.util.Scanner;

public class SnakeGameView implements GameView {
    private Scanner scanner;

    public SnakeGameView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayGame(GameModel model) {
        // Display the game state
        // For simplicity, we just print out the apple and snake's coordinates
        System.out.println("Apple is at: " + model.getAppleLocation());
        System.out.println("Snake is at: " + model.getSnakeLocation());
    }

    @Override
    public int getUserInput() {
        // Get user input for the snake's direction
        // For simplicity, we just get the input from the console
        System.out.println("Enter direction (1 - up, 2 - down, 3 - left, 4 - right): ");
        return scanner.nextInt();
    }
}