package com.CrossBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CB_LoginTest {

    WebDriver driver;

    @BeforeClass
    @Parameters("browsers")
    public void init_setup(String browser_name){

        if (browser_name.equalsIgnoreCase("firefox")){

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browser_name.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if (browser_name.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        else {

            System.out.println("Please provide a browser name (Chrome, Firefox, or Edge)");
        }

    }

    @Test(description = "Invalid Email and Pass")
    public void TC_Invalid_001() throws InterruptedException {

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
        email.sendKeys("BlahBlah19@Blah.com");
        Reporter.log("Typing email");
        password.sendKeys("abc123");
        Reporter.log("Typing password");
        Thread.sleep(2000);
        loginButton.click();
        Reporter.log("Login button clicked");
        Thread.sleep(2000);

        System.out.println("Login invalid test passed");
    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }

}