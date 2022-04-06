package com.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Annotations {

    @BeforeClass
    public void browser_config(){
        System.out.println("Browser launch successful");
    }
    @Test(priority = -1)
    public void login_test_valid_001(){
        System.out.println("Login valid test passed");
    }
    @Test(priority = 1)
    public void login_test_invalid_002(){
        System.out.println("Login invalid test passed");
    }

    @AfterClass
    public void browser_close(){
        System.out.println("Test complete, Browser closed");
    }

}
