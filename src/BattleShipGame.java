import javax.swing.*;
import java.awt.*;

public class BattleShipGame extends JFrame {
    //other classes
    private GameBoard gameBoard;
    private StatusPanel statusPanel;
    private GameController gameController;
    private MissileTracker missileTracker;
    private ShipPlacer shipPlacer;
    //game stuff
    public BattleShipGame() {
        setTitle("BattleShip Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        missileTracker = new MissileTracker(this);
        statusPanel = new StatusPanel(missileTracker);
        gameBoard = new GameBoard(10, 10, missileTracker);
        shipPlacer = new ShipPlacer(gameBoard);
        gameController = new GameController(gameBoard, missileTracker, this);

        // Add components to the frame
        add(statusPanel, BorderLayout.NORTH);
        add(gameBoard, BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
        shipPlacer.placeShips();
        setVisible(true);
    }
//reset
public void resetGame() {
    getContentPane().removeAll();
    missileTracker.reset();
    gameBoard.resetBoard();
    shipPlacer.placeShips();
    add(statusPanel, BorderLayout.NORTH);
    add(gameBoard, BorderLayout.CENTER);
    add(createButtonPanel(), BorderLayout.SOUTH);
    revalidate();
    repaint();
}
    public BoardCell getCell(int row, int col) {
        return gameBoard.getCell(row, col);
    }

    public void updateStatus() {
        statusPanel.update();
    }
private JPanel createButtonPanel() {
        JPanel panel = new JPanel();

        JButton playAgainButton = new JButton ("Play Again");
        playAgainButton.addActionListener(e -> gameController.playAgain());

    JButton quitButton = new JButton("Quit");
    quitButton.addActionListener(e -> gameController.quitGame());

    panel.add(playAgainButton);
    panel.add(quitButton);

    return panel;

}
    }





