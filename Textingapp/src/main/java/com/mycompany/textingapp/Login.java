
package com.mycompany.textingapp;

import java.util.regex.Pattern;
// The Login class handles user registration validation,  credential storage, and login authentication logic.
public class Login {
    // Private fields to store user information
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;
// Default constructor initializing all fields to empty strings.
    public Login() {
        this.username = "";
        this.password = "";
        this.cellPhoneNumber = "";
        this.firstName = "";
        this.lastName = "";
    }
//Validates the username format.Criteria: Must contain an underscore (_) and be no more than 5 characters long.
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }
// Validates password complexity. Criteria: 8+ characters, at least one capital letter, one number, and one special character.
    public boolean checkPasswordComplexity(String password) {
        boolean hasMinLength = password.length() >= 8;
        boolean hasCapital = !password.equals(password.toLowerCase());
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecial = !password.matches("[A-Za-z0-9]*");
        return hasMinLength && hasCapital && hasNumber && hasSpecial;
    }
// Validates South African phone numbers using Regex.Format: Starts with +27 followed by exactly 9 digits.
    public boolean checkCellPhoneNumber(String phoneNumber) {
        String regex = "^\\+27[0-9]{9}$";
        return Pattern.matches(regex, phoneNumber);
    }
// Checks if all current user details meet the validation requirements. @return A success or failure message based on validation results.
    public String registerUser() {
        if (checkUserName(username) && checkPasswordComplexity(password) && checkCellPhoneNumber(cellPhoneNumber)) {
            return "Registration successful!";
        } else {
            return "Registration failed. Please ensure all details are correct.";
        }
    }
// Verifies if the provided credentials match the stored user details.
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }
// Generates a status message for the login attempt. @return A personalized welcome message or an error notification.
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // Setters- to assign values to private fields
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setCellPhoneNumber(String cellPhoneNumber) { this.cellPhoneNumber = cellPhoneNumber; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
}