import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {

        int minNo = 1;
        int maxNo = 100;


        Random random = new Random();
        int secretNumber = random.nextInt(maxNo - minNo + 1) + minNo;


        int maxAttempts = 10;
        int attemptsLeft = maxAttempts;


        int score = 0;

        Scanner scanner = new Scanner(System.in);

        while (attemptsLeft > 0) {
            System.out.println("Guess the number (" + minNo + " to " + maxNo + "): ");
            int userGuess = scanner.nextInt();


            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You guessed the correct number " + secretNumber + "!");
                score++;
                break;
            } else if (userGuess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }


            attemptsLeft--;
            System.out.println("Attempts left: " + attemptsLeft);
        }


        System.out.println("Your score: " + score);

        System.out.print("Do you want to play again? (yes/no): ");
        String playAgain = scanner.next().toLowerCase();
        if (playAgain.equals("yes")) {
            playGame();
        } else {
            System.out.println("Thanks for playing!");
        }


        scanner.close();
    }
}