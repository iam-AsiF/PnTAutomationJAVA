package com.DataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Reporter;
import org.testng.annotations.*;

public class DP_LoginTest {

    WebDriver driver;

    @BeforeClass
    @Parameters("browsers")
    public void init_setup(String browser_name) {

        if (browser_name.equalsIgnoreCase("firefox")) {

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

    @Test(dataProvider = "Login_invalid_data")
    public void TC_Invalid_001(String DP_email, String DP_pass) throws InterruptedException {

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
        email.sendKeys(DP_email);
        Reporter.log("Typing email");
        password.sendKeys(DP_pass);
        Reporter.log("Typing password");
        Thread.sleep(2000);
        loginButton.click();
        Reporter.log("Login button clicked");
        Thread.sleep(2000);

        System.out.println("Login invalid test passed");
    }

    @DataProvider(name = "Login_invalid_data")
    public Object [][] data(){

        Object[][] data = new Object [4][2];

        //Set 1
        data [0][0] = "babatunde16@outlook.com";
        data [0][1] = "abc12345";

        //Set 2
        data [1][0] = "babatunde17@gmail.com";
        data [1][1] = "abc12345";

        //Set 3
        data [2][0] = "babatunde18@gmail.com";
        data [2][1] = "abc12345";

        return data;
    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }

}