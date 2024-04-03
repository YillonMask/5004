public class MainGame {
    public static void main(String[] args) {
        GameModel model = new SnakeGameModel();
        GameView view = new SnakeGameView();
        SnakeGameController controller = new SnakeGameController(model, view);
        controller.startGame();
    }
}
