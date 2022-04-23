package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenCartLoginTest2 {
    public static WebDriver driver;

    @BeforeMethod
    public void browser_config(){

        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        Reporter.log("Chrome Launch Successful");
        driver.manage().window().maximize();
        System.out.println("Browser launched successfully");
    }
    //since we need to test only the log in function so, we will use @test only here
    @Test(priority = 1, description = "Email and Password are invalid")
    public void login_test_invalid_001() throws InterruptedException {

        driver.get("https://demo.opencart.com/");
        Reporter.log("Opening Opencart");
        WebElement MyAccount = driver.findElement(By.linkText("My Account"));
        MyAccount.click();

        WebElement Login = driver.findElement(By.linkText("Login"));
        Login.click();
        Reporter.log("Opening Login page");

        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        //considered Xpath for login field

        //sendKeys() to put input values
        email.sendKeys("BlahBlah09@Blah.com");
        Reporter.log("Typing email");
        password.sendKeys("abc123");
        Reporter.log("Typing password");
        Thread.sleep(3000);
        loginButton.click();
        Reporter.log("Login button clicked");
        Thread.sleep(3000);

        System.out.println("Login invalid test passed");
    }
    @AfterMethod
    public void browser_close(){

        driver.close();
        System.out.println("Test complete: Browser closed successfully");
    }

}
