import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        int slot = getUserSlot();
        System.out.println("Slot entered: " + slot);
    }

    // Method to take user input
    static int getUserSlot() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter slot (1-9): ");
        int slot = input.nextInt();

        return slot;
    }
}