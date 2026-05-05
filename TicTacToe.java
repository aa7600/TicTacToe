import java.util.Random;

public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    static char computerSymbol = 'O';

    public static void main(String[] args) {
        computerMove();
        printBoard();
    }

    // UC7: Computer makes random valid move
    static void computerMove() {
        Random rand = new Random();

        while (true) {
            int slot = rand.nextInt(9) + 1; // 1 to 9

            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            // check if empty
            if (board[row][col] == '-') {
                board[row][col] = computerSymbol;
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    // helper to print board
    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}