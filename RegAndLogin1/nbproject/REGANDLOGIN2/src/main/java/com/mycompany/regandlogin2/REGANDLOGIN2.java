/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.regandlogin2;

/**
 *
 * @author Lesego Hanyane
 */

import java.util.Scanner;

public class REGANDLOGIN2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LOGIN login;

        String result;

        System.out.println("=== REGISTRATION ===");

        while (true) {

            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            System.out.print("Enter phone (+27...): ");
            String phone = scanner.nextLine();

            login = new LOGIN(username, password, phone);

            result = login.registerUser();
            System.out.println(result);

            if (result.contains("successful")) {
                break;
            }

            System.out.println("Please try again...\n");
        }

        System.out.println("\n=== LOGIN ===");

        LOGIN loginAttempt = new LOGIN();

        boolean loggedIn = false;

        while (true) {

            System.out.print("Enter username: ");
            String enteredUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String enteredPassword = scanner.nextLine();

            boolean success = loginAttempt.loginUser(enteredUsername, enteredPassword);

            if (success) {
                System.out.print("Enter first name: ");
                String firstName = scanner.nextLine();

                System.out.print("Enter last name: ");
                String lastName = scanner.nextLine();

                System.out.println(loginAttempt.returnLoginStatus(success, firstName, lastName));

                loggedIn = true;
                break;
            } else {
                System.out.println("Incorrect details, try again.\n");
            }
        }

        // QUICKCHAT FEATURES
        if (loggedIn) {

            System.out.println("\nWelcome to QuickChat");

            int totalMessages;

            System.out.print("How many messages would you like to send? ");
            totalMessages = Integer.parseInt(scanner.nextLine());

            int messageCounter = 0;

            while (true) {

                System.out.println("\n===== MENU =====");
                System.out.println("1. Send Messages");
                System.out.println("2. Show recently sent messages");
                System.out.println("3. Quit");
                System.out.print("Choose an option: ");

                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {

                    case 1:

                        while (messageCounter < totalMessages) {

                            System.out.println("\nMESSAGE " + (messageCounter + 1));

                            System.out.print("Enter recipient number: ");
                            String recipient = scanner.nextLine();

                            System.out.print("Enter your message: ");
                            String text = scanner.nextLine();

                            MESSAGE msg = new MESSAGE(recipient, text, messageCounter + 1);

                            System.out.println(msg.checkRecipientCell());

                            if (msg.checkMessageID()) {

                                String messageResult = msg.checkMessageLength();
                                System.out.println(messageResult);

                                if (messageResult.equals("Message ready to send.")) {

                                    System.out.println("\nChoose what to do with the message:");
                                    System.out.println("1. Send Message");
                                    System.out.println("2. Disregard Message");
                                    System.out.println("3. Store Message");
                                    System.out.print("Select option: ");

                                    int choice = Integer.parseInt(scanner.nextLine());

                                    System.out.println(msg.sentMessage(choice));

                                    if (choice == 1) {
                                        System.out.println("\nFULL MESSAGE DETAILS");
                                        System.out.println(msg.printMessages());
                                    }

                                    messageCounter++;
                                }
                            }
                        }

                        System.out.println("\nTotal messages sent: " + MESSAGE.returnTotalMessages());
                        break;

                    case 2:
                        System.out.println("Coming Soon.");
                        break;

                    case 3:
                        System.out.println("Goodbye!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            }
        }

        scanner.close();
    }
}
