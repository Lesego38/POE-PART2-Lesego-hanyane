/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.regandlogin2;

/**
 *
 * @author Lesego Hanyane
 */
public class LOGIN {
    
private String username;
    private String password;
    private String cellPhoneNumber;

    private static String registeredUsername = "";
    private static String registeredPassword = "";

    public LOGIN(String username, String password, String cellPhoneNumber) {
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public LOGIN() {}

    
    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        if (password.length() < 8) return false;

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasCapital = true;
            else if (Character.isDigit(c)) hasNumber = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        return hasCapital && hasNumber && hasSpecial;
    }

    public boolean checkCellPhoneNumber() {
        return cellPhoneNumber.matches("^\\+\\d{10,12}$");
    }

    

    public String registerUser() {

        if (!checkUserName()) {
            return " Username must contain '_' and be max 5 characters.";
        }

        if (!checkPasswordComplexity()) {
            return " Password must be at least 8 characters, include a capital letter, number, and special character.";
        }

        if (!checkCellPhoneNumber()) {
            return " Cell phone must include international code (e.g. +27821234567).";
        }

        registeredUsername = this.username;
        registeredPassword = this.password;

        return " Registration successful!";
    }

   

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return registeredUsername.equals(enteredUsername) &&
               registeredPassword.equals(enteredPassword);
    }

    public String returnLoginStatus(boolean loginSuccess, String firstName, String lastName) {
        if (loginSuccess) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return " Username or password incorrect.";
        }
    }
}
