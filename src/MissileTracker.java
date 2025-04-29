import javax.swing.*;

public class MissileTracker {
    private int missCounter;
    private int strikeCounter;
    private int totalMissCounter;
    private int totalHitCounter;

    private BattleShipGame game;

    public MissileTracker(BattleShipGame game) {
        this.game = game;
        this.missCounter = 0;
        this.strikeCounter = 0;
        this.totalMissCounter = 0;
        this.totalHitCounter = 0;

    }

    //check if ship is sunk
    public void registerHit(int row, int col) {
        totalHitCounter++;
        missCounter = 0;
    BoardCell hitCell = game.getCell(row, col);
    Ship ship = hitCell.getShip();
    if(ship !=null)

    {
        ship.hit();
        if (ship.isSunk()) {
            JOptionPane.showMessageDialog(game, "You sunk a enemy ship!");

        }
    }
    game.updateStatus();
}
public void registerMiss(int row, int col) {
    missCounter++;
    totalMissCounter++;

    if (missCounter >= 5){
        strikeCounter++;
        missCounter = 0;
    }
    if (strikeCounter >= 3) {
        JOptionPane.showMessageDialog(game, "You have 3 strikes! Game Over!");
        int choice = JOptionPane.showConfirmDialog(game, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            game.resetGame();
        } else {
            System.exit(0);
        }
    }
    if (totalHitCounter >= 17) {
        JOptionPane.showMessageDialog(game, "You WIN! Congratulations!");
        int choice = JOptionPane.showConfirmDialog(game, "Play Again?", "Victory!", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            game.resetGame();
        } else {
            System.exit(0);
        }
    }
    game.updateStatus();
    }
    public void reset () {
        missCounter = 0;
        strikeCounter = 0;
        totalMissCounter = 0;
        totalHitCounter = 0;
    }

    // getters for status panel

public int getMissCounter() {
    return missCounter;

}
public int getStrikeCounter() {
    return strikeCounter;
}
public int getTotalMissCounter() {
    return totalMissCounter;
}
public int getTotalHitCounter() {
    return totalHitCounter;
}

}
