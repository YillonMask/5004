public class SnakeGameController {
    private GameModel model;
    private GameView view;

    public SnakeGameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        while (true) {
            view.displayGame(model);
            int direction = view.getUserInput();
            model.updateDirection(direction);
            model.updateGame();
        }
    }
}


