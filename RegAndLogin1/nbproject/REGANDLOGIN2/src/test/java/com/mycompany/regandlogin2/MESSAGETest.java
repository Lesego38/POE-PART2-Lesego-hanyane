/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.regandlogin2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lesego Hanyane
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MESSAGETest {

    // Test valid recipient number
    @Test
    public void testCheckRecipientCellSuccess() {

        MESSAGE msg = new MESSAGE(
                "+27831234567",
                "Hello there",
                1
        );

        String expected =
                "Cell phone number successfully captured.";

        assertEquals(expected, msg.checkRecipientCell());
    }

    // Test invalid recipient number
    @Test
    public void testCheckRecipientCellFail() {

        MESSAGE msg = new MESSAGE(
                "0831234567",
                "Hello there",
                1
        );

        String expected =
                "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";

        assertEquals(expected, msg.checkRecipientCell());
    }

    // Test message length success
    @Test
    public void testCheckMessageLengthSuccess() {

        MESSAGE msg = new MESSAGE(
                "+27831234567",
                "Short message",
                1
        );

        String expected = "Message ready to send.";

        assertEquals(expected, msg.checkMessageLength());
    }

    // Test message length failure
    @Test
    public void testCheckMessageLengthFail() {

        String longMessage = "A".repeat(260);

        MESSAGE msg = new MESSAGE(
                "+27831234567",
                longMessage,
                1
        );

        String expected =
                "Message exceeds 250 characters by 10. Please reduce the size.";

        assertEquals(expected, msg.checkMessageLength());
    }

    // Test Message ID
    @Test
    public void testCheckMessageID() {

        MESSAGE msg = new MESSAGE(
                "+27831234567",
                "Testing ID",
                1
        );

        assertTrue(msg.checkMessageID());
    }

    // Test Message Hash creation
    @Test
    public void testCreateMessageHash() {

        MESSAGE msg = new MESSAGE(
                "+27831234567",
                "Hello World",
                1
        );

        String hash = msg.createMessageHash();

        assertNotNull(hash);
        assertTrue(hash.contains(":1:"));
    }

    // Test sent message
    @Test
    public void testSentMessage() {

        MESSAGE msg = new MESSAGE(
                "+27831234567",
                "Hello",
                1
        );

        String expected = "Message successfully sent.";

        assertEquals(expected, msg.sentMessage(1));
    }

    // Test stored message
    @Test
    public void testStoredMessage() {

        MESSAGE msg = new MESSAGE(
                "+27831234567",
                "Store this message",
                1
        );

        String expected = "Message successfully stored.";

        assertEquals(expected, msg.sentMessage(3));
    }

    // Test disregard message
    @Test
    public void testDisregardMessage() {

        MESSAGE msg = new MESSAGE(
                "+27831234567",
                "Delete this",
                1
        );

        String expected = "Press 0 to delete the message.";

        assertEquals(expected, msg.sentMessage(2));
    }
}