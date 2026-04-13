
package com.mycompany.textingapp;

import java.util.Scanner;

public class RegistrationLoginApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Login loginSystem = new Login();
            
            System.out.println("==================================================");
            System.out.println("WELCOME TO REGISTRATION & LOGIN SYSTEM");
            System.out.println("==================================================");
            
            // REGISTRATION
            System.out.print("Enter your first name: ");
            loginSystem.setFirstName(scanner.nextLine());
            
            System.out.print("Enter your last name: ");
            loginSystem.setLastName(scanner.nextLine());
            
            String username;
            do {
                System.out.print("Create username (max 5 chars, must have _): ");
                username = scanner.nextLine();
                loginSystem.setUsername(username);
                if (!loginSystem.checkUserName(username)) {
                    System.out.println(" Invalid Username format.");
                }
            } while (!loginSystem.checkUserName(username));
            
            String password;
            do {
                System.out.print("Create password: ");
                password = scanner.nextLine();
                loginSystem.setPassword(password);
                if (!loginSystem.checkPasswordComplexity(password)) {
                    System.out.println(" Password too weak.");
                }
            } while (!loginSystem.checkPasswordComplexity(password));
            
            String cell;
            do {
                System.out.print("Enter cell (+27...): ");
                cell = scanner.nextLine();
                loginSystem.setCellPhoneNumber(cell);
                if (!loginSystem.checkCellPhoneNumber(cell)) {
                    System.out.println(" Invalid SA phone format.");
                }
            } while (!loginSystem.checkCellPhoneNumber(cell));
            
            System.out.println("\n" + loginSystem.registerUser());
            
            // LOGIN
            System.out.println("\n--- LOGIN PHASE ---");
            System.out.print("Username: ");
            String lUser = scanner.nextLine();
            System.out.print("Password: ");
            String lPass = scanner.nextLine();
            
            System.out.println(loginSystem.returnLoginStatus(lUser, lPass));
        }
    }
}