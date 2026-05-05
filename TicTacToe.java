import java.util.Random;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static char computerSymbol = 'O';

    public static void main(String[] args) {

        initializeBoard();

        computerMove();

        // Print board after move
        printBoard();
    }

    // Initialize board with '-'
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // UC6 reused: place move
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC5 reused: check if move is valid
    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 &&
               col >= 0 && col < 3 &&
               board[row][col] == '-';
    }

    // UC4 reused: slot → row
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    // UC4 reused: slot → column
    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    // UC7: Computer makes random valid move
    static void computerMove() {
        Random rand = new Random();

        while (true) {
            int slot = rand.nextInt(9) + 1; // 1–9

            int row = getRowFromSlot(slot);
            int col = getColFromSlot(slot);

            if (isValidMove(row, col)) {
                placeMove(row, col, computerSymbol);
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    // Print board nicely
    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}