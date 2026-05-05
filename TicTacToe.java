public class TicTacToe {

    static char[][] board = {
        {'X', 'X', 'X'},
        {'-', 'O', '-'},
        {'O', '-', '-'}
    };

    public static void main(String[] args) {
        System.out.println(hasWon('X'));
    }

    // UC9: Check winning condition
    static boolean hasWon(char symbol) {

        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol) {
                return true;
            }
        }

        // check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == symbol &&
                board[1][i] == symbol &&
                board[2][i] == symbol) {
                return true;
            }
        }

        // check diagonals
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {
            return true;
        }

        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) {
            return true;
        }

        return false;
    }
}