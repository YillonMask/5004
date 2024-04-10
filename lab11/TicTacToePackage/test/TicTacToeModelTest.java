import static org.junit.Assert.*;

import edu.northeastern.sv.khoury.ttt.Player;
import edu.northeastern.sv.khoury.ttt.TicTacToeModel;
import org.junit.Before;
import org.junit.Test;


public class TicTacToeModelTest {
    private TicTacToeModel model;

    @Before
    public void setUp() {
        model = new TicTacToeModelImpl(); // Assume this is a concrete implementation of TicTacToeModel
    }

    @Test
    public void testMove_NormalCondition() {
        model.move(0, 0);
        assertEquals("Expected X to be at position (0,0)", Player.X, model.getMarkAt(0, 0));
    }

    @Test(expected = IllegalStateException.class)
    public void testMove_OccupiedPosition() {
        model.move(0, 0);
        model.move(0, 0); // This should throw an exception
    }

    @Test
    public void testResetGame() {
        model.move(0, 0);
        model.resetGame();
        assertEquals("Expected NOBODY to be at position (0,0) after reset", Player.NOBODY, model.getMarkAt(0, 0));
    }

    @Test
    public void testGetCurrentPlayer_AfterMove() {
        model.move(0, 0);
        assertEquals("Expected O to be the next player", Player.O, model.getCurrentPlayer());
    }

    @Test
    public void testIsGameOver_NotYetFinished() {
        model.move(0, 0);
        assertFalse("Expected game not to be over", model.isGameOver());
    }

    @Test
    public void testGetWinner_Draw() {
        // Assuming a sequence of moves that leads to a draw
        // model.move(...) calls to fill the board with no winner
        assertFalse("Expected game to be over", model.isGameOver());
        assertEquals("Expected NOBODY to be the winner in a draw", Player.NOBODY, model.getWinner());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMarkAt_InvalidPosition() {
        model.getMarkAt(3, 3); // Assuming a 3x3 board, thisshould throw an exception
    }

    @Test
    public void testGetWinner_WinningCondition() {
        // Assuming a sequence of moves that leads to player X winning
        model.move(0, 0); // X
        model.move(1, 0); // O
        model.move(0, 1); // X
        model.move(1, 1); // O
        model.move(0, 2); // X wins
        assertTrue("Expected game to be over after a win", model.isGameOver());
        assertEquals("Expected X to be the winner", Player.X, model.getWinner());
    }

}
