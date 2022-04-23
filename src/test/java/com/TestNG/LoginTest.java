package com.TestNG;

import org.testng.annotations.Test;

public class LoginTest {

    @Test(priority = 4, description = "Email and password valid")
    public void testCase_valid_001(){
        System.out.println("Test case 1 Executed");

    }
    @Test(priority = 3, description = "Email valid and password invalid")
    public void testCase_invalid_002(){
        System.out.println("Test case 1 Executed");

    }
    @Test(priority = 2, description = "Email invalid and password valid")
    public void testCase_invalid_003(){
        System.out.println("Test case 1 Executed");

    }
    @Test(enabled = false, priority = 1, description = "Email invalid and password invalid")
    public void testCase_invalid_004(){
        System.out.println("Test case 1 Executed");

    }

}