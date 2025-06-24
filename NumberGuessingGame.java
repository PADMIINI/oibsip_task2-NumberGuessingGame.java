import java.util.*;

public class NumberGuessingGame {
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.menu();
    }

    public void menu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("--------------------");
            System.out.println("Welcome to the number game");
            System.out.println("1) Play the Game");
            System.out.println("2) Score Board");
            System.out.println("3) Exit the game");
            System.out.println("--------------------");
            System.out.print("What action would you like to do from the above actions? ");
            try {
                int menuOption = input.nextInt();
                switch (menuOption) {
                    case 1:
                        System.out.print("\nWhat would you like the range of the numbers to be? ");
                        int numberRange = input.nextInt();
                        int randomNumber = randomNumber(numberRange);
                        guessNumber(randomNumber);
                        break;
                    case 2:
                        displayScoreBoard();
                        break;
                    case 3:
                        System.out.println("\nThanks for playing the game!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid number entry. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.err.println("\nInvalid input. Please enter a number.\n");
                input.nextLine(); // clear invalid input
            }
        }
    }

    public static int randomNumber(int numberRange) {
        Random random = new Random();
        return random.nextInt(numberRange) + 1;
    }

    public void guessNumber(int randomNumber) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int guessCount = 0;
        do {
            System.out.print("Enter your guess number: ");
            while (!input.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                input.next();
            }
            userGuess = input.nextInt();
            guessCount++;
            if (userGuess > randomNumber) {
                System.out.println("Lower");
            } else if (userGuess < randomNumber) {
                System.out.println("Higher");
            }
        } while (randomNumber != userGuess);

        System.out.println();
        if (guessCount == 1) {
            System.out.println("You answered number is right in " + guessCount + " try!");
        } else {
            System.out.println("You answered number is right in " + guessCount + " tries!");
        }
        scoreBoard.add(guessCount);
        System.out.println();
    }

    public void displayScoreBoard() {
        System.out.println("--------------------");
        System.out.println("Score Board");
        System.out.println("--------------------");
        if (scoreBoard.isEmpty()) {
            System.out.println("No games played yet.");
        } else {
            Collections.sort(scoreBoard);
            System.out.println("Your fastest games today out of all tries is:\n");
            for (Integer score : scoreBoard) {
                System.out.println("Finished the number game in " + score + " tries");
            }
        }
        System.out.println();
    }
}