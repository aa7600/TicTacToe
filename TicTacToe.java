public class TicTacToe {

    static char[][] board = new char[3][3];

    public static void main(String[] args) {

        initializeBoard();

        // Example move
        placeMove(0, 0, 'X');

        // Print the updated cell
        System.out.println(board[0][0]); // Output: X
    }

    // Initialize board with '-'
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // UC6: Place symbol on board
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }
}