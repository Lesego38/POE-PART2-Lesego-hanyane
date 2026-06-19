/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.regandlogin2;

/**
 *
 * @author Lesego Hanyane
 */
import java.util.Random; 
public class MESSAGE {
    
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;

    private static int totalMessages = 0;

    public MESSAGE(String recipient, String messageText, int messageNumber) {

        this.recipient = recipient;
        this.messageText = messageText;
        this.messageNumber = messageNumber;

        generateMessageID();
        createMessageHash();
    }

    // Generate random 10-digit Message ID
    private void generateMessageID() {

        Random random = new Random();
        long number = 1000000000L + (long)(random.nextDouble() * 9000000000L);
        messageID = String.valueOf(number);
    }

    // Check Message ID length
    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }

    // Check recipient number format
    public String checkRecipientCell() {

        if (recipient.startsWith("+") && recipient.length() <= 13) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    // Check message length
    public String checkMessageLength() {

        if (messageText.length() <= 250) {
            return "Message ready to send.";
        } else {
            int excess = messageText.length() - 250;
            return "Message exceeds 250 characters by " + excess + ". Please reduce the size.";
        }
    }

    // Create Message Hash
    public String createMessageHash() {

        String[] words = messageText.split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        messageHash = messageID.substring(0, 2)
                + ":"
                + messageNumber
                + ":"
                + firstWord
                + lastWord;

        return messageHash;
    }

    // Send, store or delete message
    public String sentMessage(int choice) {

        switch (choice) {

            case 1:
                totalMessages++;
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete the message.";

            case 3:
                storeMessage();
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    // Store message in JSON format
    public void storeMessage() {

        String json = "{\n"
                + "  \"MessageID\": \"" + messageID + "\",\n"
                + "  \"MessageHash\": \"" + messageHash + "\",\n"
                + "  \"Recipient\": \"" + recipient + "\",\n"
                + "  \"Message\": \"" + messageText + "\"\n"
                + "}";

        System.out.println("\nStored JSON Message:");
        System.out.println(json);
    }

    // Print message details
    public String printMessages() {

        return "Message ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + messageText;
    }

    // Return total messages sent
    public static int returnTotalMessages() {
        return totalMessages;
    }
}

