public class TicTacToe {

    static char[][] board = {
        {'X', 'O', 'X'},
        {'X', 'O', 'O'},
        {'O', 'X', 'X'}
    };

    public static void main(String[] args) {
        System.out.println(isDraw());
    }

    // UC10: Detect draw condition
    static boolean isDraw() {

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {

                if (board[r][c] == '-') {
                    return false; // still empty → not draw
                }

            }
        }

        return true; // no empty cells → draw
    }
}