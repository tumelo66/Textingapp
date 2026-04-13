
package com.mycompany.textingapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
    
    public LoginTest() {
    }

    /**
     * Test of checkUserName method.
     * Requirement: Max 5 chars and must contain "_"
     */
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        Login instance = new Login();
        
        // Test valid username
        assertTrue(instance.checkUserName("kyl_1"));
        
        // Test invalid username (too long)
        assertFalse(instance.checkUserName("kyle_long"));
        
        // Test invalid username (no underscore)
        assertFalse(instance.checkUserName("kyle1"));
    }

    /**
     * Test of checkPasswordComplexity method.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        Login instance = new Login();
        
        // Test strong password (8+ chars, Capital, Number, Special)
        assertTrue(instance.checkPasswordComplexity("Ch3ck!pass"));
        
        // Test weak password
        assertFalse(instance.checkPasswordComplexity("password"));
    }

    /**
     * Test of checkCellPhoneNumber method.
     */
    @Test
    public void testCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        Login instance = new Login();
        
        // Test valid SA number
        assertTrue(instance.checkCellPhoneNumber("+27123456789"));
        
        // Test invalid number
        assertFalse(instance.checkCellPhoneNumber("0123456789"));
    }

    /**
     * Test of loginUser method.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        Login instance = new Login();
        
        // Setup credentials
        instance.setUsername("kyl_1");
        instance.setPassword("Ch3ck!pass");
        
        // Test successful login
        assertTrue(instance.loginUser("kyl_1", "Ch3ck!pass"));
        
        // Test failed login
        assertFalse(instance.loginUser("wrong", "wrong"));
    }

    /**
     * Test of returnLoginStatus method.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        Login instance = new Login();
        instance.setFirstName("John");
        instance.setLastName("Doe");
        instance.setUsername("admin");
        instance.setPassword("Password123!");

        String result = instance.returnLoginStatus("admin", "Password123!");
        assertEquals("Welcome John, Doe it is great to see you again.", result);
    }
}