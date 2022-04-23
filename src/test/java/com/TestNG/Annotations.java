package com.TestNG;

import org.testng.annotations.*;

public class Annotations {

    @BeforeTest
    public void browser_config(){
        System.out.println("Browser launched successfully");
    }
    public void open_url(){
        System.out.println("Url opened successfully");
    }
    //since we need to test only the log in function so, we will use @test only here
    @Test(priority = -1)
    public void login_test_valid_001(){
        System.out.println("Login valid test passed");
    }
    @Test(priority = 1)
    public void login_test_invalid_002(){
        System.out.println("Login invalid test passed");
    }
    @AfterTest
    public void browser_close(){
        System.out.println("Test complete: Browser closed successfully");
    }

}
