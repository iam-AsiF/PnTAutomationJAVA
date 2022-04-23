package com.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGBasic {

    @Test(dependsOnMethods = {"testCase_003", "testCase_002"})
    public void testCase_001(){
        System.out.println("Test case 1 Executed");

    }
    @Test(description = "Email valid and password invalid")
    public void testCase_002(){
        System.out.println("Test case 1 Executed");
        String Expected_title = "Google";
        Assert.assertEquals("facebook", Expected_title);
    }
    @Test(description = "Email invalid and password valid")
    public void testCase_003(){
        System.out.println("Test case 1 Executed");

    }
    @Test(description = "Email invalid and password invalid")
    public void testCase_004(){
        System.out.println("Test case 1 Executed");

    }

}
