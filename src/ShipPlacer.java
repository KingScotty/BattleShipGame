import java.util.Random;

public class ShipPlacer {
    private GameBoard board;
    private Random random = new Random();
    //maybe were pretend 5 is a Aircraft carrier, 4 is a battleship, 3 is a cruiser, 3 is a submarine, and 2 is a destroyer
    private final int[] SHIP_SIZES = {5, 4, 3, 3, 2}; // biggest to smallest

    public ShipPlacer(GameBoard board) {
        this.board = board;
    }

    public void placeShips () {
        for (int size : SHIP_SIZES){
            boolean placed = false;

            while (!placed) {
                boolean horizontal = random.nextBoolean();
                int row = random.nextInt(10);
                int col = random.nextInt(10);

                if (canPlaceShip(row, col, size, horizontal)){
                    placeShip(row, col, size, horizontal);
                    placed = true;
                }
            }
        }
    }
private boolean canPlaceShip (int row, int col, int size, boolean horizontal){
        if  (horizontal){
            if (col + size > 10) return false;
            for (int i = 0; i < size; i++) {
                if (board.getCell(row, col + i).getShip() != null) {
                    return false;
                }

            }
        } else {
            if (row + size > 10) return false;
            for (int i = 0; i < size; i++) {
                if (board.getCell(row + i, col).getShip() != null) {
                    return false;
                }
            }
        }
        return true;
}
//more constructors
    private void placeShip (int row, int col, int size, boolean horizontal) {
        if (horizontal) {
            for (int i = 0; i < size; i++) {
                board.getCell(row, col + i).setShip(new Ship(size));
            }
        } else {
            for (int i = 0; i < size; i++) {
                board.getCell(row + i, col).setShip(new Ship(size));
            }
        }
    }

}
