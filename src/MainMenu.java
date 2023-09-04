import java.io.*;
import java.util.Scanner;

public class MainMenu {

    public static void mainMenu() {
        //loads the title splash
        try {
            Scanner fileReader = new Scanner(new File("ASCII_TitleSplash.txt"));
            while(fileReader.hasNextLine()) {
                System.out.println(fileReader.nextLine());
            }
            fileReader.close();
        } catch(FileNotFoundException e) {
            System.out.println("Error. File not found.");
            e.printStackTrace();
        }


        System.out.println("Welcome to Cascadia!\n");

        while(true) {

            System.out.println("Would you like to...\n");
            System.out.println("1. Play the game?");
            System.out.println("2. Read the game rules?");
            System.out.println("3. View the game credits?");
            System.out.println("4. Quit the game?");

            //prompts the user to input their choice
            Scanner userChoiceIn = new Scanner(System.in);
            System.out.print("Please input your choice: ");
            int userChoice = -1;
            while (userChoice == -1) {
                if (userChoiceIn.hasNextInt()) {
                    userChoice = userChoiceIn.nextInt();
                    if (userChoice < 1 || userChoice > 4) {
                        System.out.print("Error. Please input your choice (1-4): ");
                        userChoice = -1;
                        userChoiceIn = new Scanner(System.in);
                    }
                } else {
                    System.out.print("Error. Please input your choice (1-4): ");
                    userChoiceIn.next();
                    userChoiceIn = new Scanner(System.in);
                }
            }

            if (userChoice == 1) {
                System.out.println("\nLoading the game, please wait...\n");
                break;
            } else if (userChoice == 2) {
                System.out.println("\nLoading the game rules, please wait...");
                gameRules();
                System.out.println("");
            } else if (userChoice == 3) {
                System.out.println("\nLoading the credits, please wait...\n");
                credits();
            } else if (userChoice == 4) {
                Main.exit();
            }
        }
    }

    public static void gameRules() {
        System.out.println("");
        try {
            Scanner fileReader = new Scanner(new File("HOWTOPLAY.md"));
            while(fileReader.hasNextLine()) {
                System.out.println(fileReader.nextLine());
            }
            fileReader.close();
        } catch(FileNotFoundException e) {
            System.out.println("Error. File not found.");
            e.printStackTrace();
        }
        System.out.println("\nYou may enter 'quit' any time input is required to terminate the program.");
    }

    public static void credits() {
        System.out.println("CREDITS:\n");
        System.out.println("Cascadia Board Game in Java was created by Michael Astran.\n");
        System.out.println("Thank you for playing!\n");
    }
}