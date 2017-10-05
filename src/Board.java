public class Board {

    // Makes the board
    private int length;
    private int width;

    private int[][] board = new int[length][width];

    public Board(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int[][] getBoard() {
        return board;
    }

}
