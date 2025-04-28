import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {
    private BoardCell[][] board;
    private int rows;
    private int cols;
    private MissileTracker missileTracker;

    public GameBoard(int rows, int cols, MissileTracker missileTracker) {
        this.rows = rows;
        this.cols = cols;
        this.missileTracker = missileTracker;
        board = new BoardCell[rows][cols];
        setLayout(new GridLayout(rows, cols));
        initializeBoard();
    }

    private void initializeBoard(){
        for (int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                BoardCell cell = new BoardCell(row, col);
                cells[row][col] = cell;
                add(cell);
            }
        }
    }
//reset board
    public void resetBoard() {
        removeAll();
        initializeBoard();
        revalidate();
        repaint();

    }

    public BoardCell getCell(int row, int col){
        return cells[row][col];
    }
}
