package edu.northeastern.sv.khoury.ttt;

import java.util.ArrayList;
import java.util.List;

public class SnakeGameModel implements GameModel{
    private Coordinate apple_loc;
    private List<Coordinate> snake_loc;
    private int direction;

    // Constructor and other methods go here

    public SnakeGameModel(){
        this.snake_loc = new ArrayList<>();
        this.snake_loc.add(new Coordinate(0, 0));
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

    private void moveSnake() {
        // Get the head of the snake
        Coordinate head = snake_loc.get(0);

        // Create a new head based on the direction
        Coordinate newHead;
        switch (direction) {
            case 1: // Up
                newHead = new Coordinate(head.getX(), head.getY() - 1);
                break;
            case 2: // Right
                newHead = new Coordinate(head.getX() + 1, head.getY());
                break;
            case 3: // Down
                newHead = new Coordinate(head.getX(), head.getY() + 1);
                break;
            case 4: // Left
                newHead = new Coordinate(head.getX() - 1, head.getY());
                break;
            default:
                throw new IllegalArgumentException("Invalid direction");
        }

        // Add the new head to the snake
        snake_loc.add(0, newHead);

        // Remove the tail of the snake
        snake_loc.remove(snake_loc.size() - 1);
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
