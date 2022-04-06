package com.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test(description = "Email and password valid")
    public static void testCase_valid_001(){
        System.out.println("Test case 1 Executed");

    }
    @Test(description = "Email valid and password invalid")
    public static void testCase_invalid_002(){
        System.out.println("Test case 1 Executed");

    }
    @Test(description = "Email invalid and password valid")
    public static void testCase_invalid_003(){
        System.out.println("Test case 1 Executed");

    }
    @Test(description = "Email invalid and password invalid")
    public static void testCase_invalid_004(){
        System.out.println("Test case 1 Executed");

    }

}