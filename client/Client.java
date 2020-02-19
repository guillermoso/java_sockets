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
                    
                    break;
                case 2:
                    exitFlag = true;
                default:
                    System.out.println("Invalid option.");
                    sleep();
                    continue;
            }
        }
    }

    private int mainMenu() throws Exception {
        clearConsole();
        System.out.println("\t*** Query movie's data ***");
        System.out.println("");
        System.out.println("Select an option:");
        System.out.println("1. Make a query");
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

    private static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
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
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}