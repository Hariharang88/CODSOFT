import java.util.Scanner;

public class Number_Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxRange = 100;
        int numberOfAttempts = 10;
        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = (int) (Math.random() * maxRange) + 1;
            int userGuess;
            int attemptsRemaining = numberOfAttempts;

            System.out.println("Welcome to the guessing game!");
            System.out.println("You have " + attemptsRemaining + " attempts to guess the number.");

            while (attemptsRemaining > 0) {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                attemptsRemaining--;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in "
                            + (numberOfAttempts - attemptsRemaining) + " attempts.");
                    break;
                } else if (userGuess > randomNumber) {
                    System.out.println("Your guess is too high. Try again.");
                } else {
                    System.out.println("Your guess is too low. Try again.");
                }
            }

            if (attemptsRemaining == 0) {
                System.out.println("Sorry, you ran out of attempts. The correct number was " + randomNumber + ".");
            }

            System.out.print("Would you like to play again? (Enter 'Yes' or 'No'): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("Yes");
        }

        scanner.close();
    }
}