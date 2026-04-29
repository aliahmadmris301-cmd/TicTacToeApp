import java.util.Random;
/**
 * TicTacToe
 * UC7 allows the computer to make a random valid move
 * by reusing slot conversion and validation logic.
 */
public class TicTacToe {
    static char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
    };
    static char computerSymbol = 'O';
    /**
     * Entry point of the program. Triggers the computer move.
     */
    public static void main(String[] args) {
        printBoard();
        computerMove();
        System.out.println("\nAfter computer move:");
        printBoard();
    }
    /**
     * Generates random slot values until a valid move is found,
     * then places the computer symbol on the board.
     */
    static void computerMove() {
        Random random = new Random();
        int row, col;
        while (true) {
            int slot = random.nextInt(9) + 1; // 1 to 9
            row = (slot - 1) / 3;
            col = (slot - 1) % 3;
            if (isValidMove(row, col)) {
                board[row][col] = computerSymbol;
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }
    /**
     * Checks if a move is valid (cell is empty).
     */
    static boolean isValidMove(int row, int col) {
        return board[row][col] == '-';
    }
    /**
     * Prints the current board.
     */
    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}