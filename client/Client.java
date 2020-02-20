package client;

import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;

/**
 * Client
 */
public class Client {
    public static void main(String[] args) {

        Boolean exitFlag = false;
        Client client = new Client();

        while (!exitFlag) {

            int selectedOption;
            try {
                selectedOption = client.mainMenu();
            } catch (Exception e) {
                System.out.println("Please enter the number of the option you choose.");
                sleep();
                continue;
            }

            switch (selectedOption) {
                case 1:
                    client.queryMovie(client.getQueryFromUser());
                    break;
                case 2:
                    exitFlag = true;
                    break;
                default:
                    System.out.println("Invalid option.");
                    sleep();
                    continue;
            }
        }
    }

    private int mainMenu() throws Exception {
        clearConsole();
        System.out.println("\t*** Query a movie's data ***\n");
        System.out.println("Select an option.");
        System.out.println("1. Make a query about a movie");
        System.out.println("2. exit");
        System.out.print("Option:  ");
        String input = System.console().readLine();

        int selectedOption;
        try {
            selectedOption = Integer.parseInt(input);
        } catch (Exception e) {
            throw new Exception("Input is not an integer.");
        }

        return selectedOption;
    }

    private String getQueryFromUser() {
        clearConsole();

        System.out.println("\t*** Query a movie's data **\n");
        System.out.print("Enter the name of the movie you want to query about:  ");
        String moviesName = System.console().readLine();
        System.out.println("\nSelect the option you want to query.");
        System.out.println("1. Genre");
        System.out.println("2. Lead studio");
        System.out.println("3. Audience score");
        System.out.println("4. Profitability");
        System.out.println("5. Rotten tomatoes score");
        System.out.println("6. Worldwide gross");
        System.out.println("7. Year");
        System.out.print("Option:  ");
        String opCode = System.console().readLine();

        return opCode + "|" + moviesName;
    }

    private String queryMovie(String query) {

    }

    private static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e2) {
            System.out.println(e2);
        }
    }

    private static void clearConsole() {
        String OS = System.getProperty("os.name");

        try {
            if (OS.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                // Runtime.getRuntime().exec("clear");
                System.out.print("\033[H\033[2J");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}