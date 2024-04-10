package edu.northeastern.sv.khoury.ttt;

/**
 * This interface represents the model for a Tic Tac Toe game.
 * It defines the necessary methods that the controller will interact with.
 * This interface adheres to the MVC design pattern, ensuring separation of the game logic
 * (model) from the user interface (view).
 */
public interface TicTacToeModel {
    /**
     * Places a mark for the current player at the specified location.
     * @param x the x-coordinate of the location
     * @param y the y-coordinate of the location
     * @throws IllegalArgumentException if the coordinates are out of bounds
     * @throws IllegalStateException if the position is already occupied or the game has ended.
     */
    void move(int x, int y) throws IllegalArgumentException, IllegalStateException;

    /**
     * Resets the game to a starting state.
     */
    void resetGame();

    /**
     * Returns the player whose turn it is.
     * @return the current player
     */
    Player getCurrentPlayer();

    /**
     * Return whether the game is over or not.
     * @return true if the game is over, false otherwise.
     */
    boolean isGameOver();

    /**
     * Returns the winner of the game.
     * @return the winner of the game. NOBODY if the game is a draw or not yet finished.
     */
    Player getWinner();

    /**
     * Retrieves the board state at the specified position.
     * @param x the x-coordinate of the location
     * @param y the y-coordinate of the location
     * @return the player who has the marked the position, or player.NOBODY if it unmarked
     * @throws IllegalArgumentException if the coordinates are out of bounds
     */
    Player getMarkAt(int x, int y) throws IllegalArgumentException;
}
