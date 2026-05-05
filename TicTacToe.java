import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    static boolean isHumanTurn = true;
    static boolean gameOver = false;

    static char humanSymbol = 'X';
    static char computerSymbol = 'O';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (!gameOver) {

            printBoard();

            if (isHumanTurn) {
                System.out.print("Enter slot (1-9): ");
                int slot = sc.nextInt();

                int row = (slot - 1) / 3;
                int col = (slot - 1) % 3;

                if (isValidMove(row, col)) {
                    board[row][col] = humanSymbol;

                    if (checkWin(humanSymbol)) {
                        printBoard();
                        System.out.println("You win!");
                        gameOver = true;
                    } else if (isBoardFull()) {
                        printBoard();
                        System.out.println("Draw!");
                        gameOver = true;
                    } else {
                        isHumanTurn = false;
                    }
                } else {
                    System.out.println("Invalid move, try again.");
                }

            } else {
                computerMove();

                if (checkWin(computerSymbol)) {
                    printBoard();
                    System.out.println("Computer wins!");
                    gameOver = true;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("Draw!");
                    gameOver = true;
                } else {
                    isHumanTurn = true;
                }
            }
        }

        sc.close();
    }

    // UC5 logic reused
    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 &&
               col >= 0 && col < 3 &&
               board[row][col] == '-';
    }

    // UC7 logic reused
    static void computerMove() {
        Random rand = new Random();

        while (true) {
            int slot = rand.nextInt(9) + 1;

            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            if (isValidMove(row, col)) {
                board[row][col] = computerSymbol;
                System.out.println("Computer chose: " + slot);
                break;
            }
        }
    }

    static boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
                return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)
                return true;
        }

        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
            return true;

        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
            return true;

        return false;
    }

    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }

    static void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}