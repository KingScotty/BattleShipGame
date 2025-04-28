import javax.swing.*;

public class GameController {
    private GameBoard gameBoard;
    private MissileTracker missileTracker;
    private BattleShipGame game;

public GameController(GameBoard gameBoard, MissileTracker missileTracker, BattleShipGame game) {
    this.gameBoard = gameBoard;
    this.missileTracker = missileTracker;
    this.game = game;
}
    public void playAgain() {
        int choice = JOptionPane.showConfirmDialog(game, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            game.resetGame();
        }
    }
        public void quitGame () {
            int choice = JOptionPane.showConfirmDialog(game, "Are you sure you want to quit?", "Quit Game", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }