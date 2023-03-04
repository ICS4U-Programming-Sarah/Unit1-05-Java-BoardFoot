import java.util.Scanner;

/**
* This program receives the height & width from the user.
* From information given, it calculates the length of wood,
* per one board.
*
* @author  Sarah Andrew
* @version 1.0
*
* @since   2023-03-04
*/

public final class BoardFoot {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private BoardFoot() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * This function calculates the length of a board per one
    * board foot then returns it to the user.
    *
    * @param args Unused.
    * @param width passed.
    * @param height passed.
    * @return length.
    */
    public static double CalculateBoardFoot(double width, double height) {
        // Declare constant.
        final double ONE_BOARD_LENGTH = 144.0;

        // Calculate the length per one board foot.
        final double length = ONE_BOARD_LENGTH / (width * height);

        // Return users to main function.
        return length;
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        // Declare variables.
        final String userWidth;
        final String userHeight;
        final double boardLength;

        // Create a new scanner
        final Scanner scanner = new Scanner(System.in);

        // Intro.
        System.out.print("This program figures out the length"
            + " of a wooden board. Where one board foot is 144"
            + "^3 inch(es) of wood. \n");

        // Gets user input.
        System.out.println("Enter the width (inches): ");
        userWidth = scanner.nextLine();

        System.out.println("Enter the height (inches): ");
        userHeight = scanner.nextLine();

        // Usage of try catch to detect string input.
        try {
            // Convert string to double.
            final double doubWidth = Double.parseDouble(userWidth);

            try {
                // Convert string to double.
                final double userDoubHeight = Double.parseDouble(userHeight);

                // If statement to determine if user enters
                // a positive or negative value.
                if (doubWidth >= 0 && userDoubHeight >= 0) {
                    // Call function for positive values.
                    boardLength = CalculateBoardFoot(doubWidth, userDoubHeight);

                    // Display results to user.
                    System.out.print("The board length would be ");
                    System.out.format("%.2f", boardLength);
                    System.out.println(" inch(es) of wood.");
                } else {
                    // Display error to user.
                    System.out.println("Please enter positive values.");
                }

            } catch (NumberFormatException error) {
                // Displays error to user.
                System.out.print("Please enter valid input."
                        + error.getMessage());
            }

        } catch (NumberFormatException error) {
            // Displays error to user.
            System.out.print("Invalid.Please enter valid input."
                + error.getMessage());
        }
        // Closes scanner
        scanner.close();
    }
}
