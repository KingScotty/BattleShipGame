import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardCell extends JButton {
    private int row;
    private int col;
    private boolean hasShip;
    private boolean clicked;
    private boolean isHit;
    private MissileTracker missileTracker;
    private Ship ship;
    public BoardCell (int row, int col, MissileTracker missileTracker) {
        this.row = row;
        this.col = col;
        this.missileTracker = missileTracker;
        this.hasShip = false;
        this.clicked = false;
        // this.isHit = false;

        //background color
        setBackground(Color.BLUE);
        setText("~"); //~ should represent water. I hope
        setFont(new Font("Arial", Font.BOLD, 20));

        addActionListener(new ActionListener (){
                              @Override
                              public void actionPerformed(ActionEvent e) {
                                  fireMissile();
                              }
                          });
    }

    //fire missile
    private void fireMissile () {
        if (clicked) {
            return; // already clicked
        }
        clicked = true;
        setEnabled(false);

        if (hasShip) {
            setBackground(Color.RED);
            setText("X");
            isHit = true;
            missileTracker.registerHit(row, col);
        } else {
            setBackground(Color.WHITE);
            setText("O");
            missileTracker.registerMiss(row, col);
        }
    }
    public void setShip(Ship ship){
        this.hasShip = true;
       this.ship = ship;
    }
    public boolean hasShip() {
        return hasShip;
    }
    public Ship getShip() {
        return ship;
    }
    //reset
    public void reset() {
        this.hasShip = false;
        this.ship = null;
        this.clicked = false;
        setEnabled(true);
        setBackground(Color.CYAN);
        setText("~");
    }

}
