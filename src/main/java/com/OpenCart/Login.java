package com.OpenCart;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login extends BaseClass {

    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        open_website("https://demo.opencart.com/");

        //Login_Invalid_TestCase01();

        Login_Valid_TestCase01();
        Thread.sleep(3000);

        close_browser();
    }
    public static void Login_Invalid_TestCase01() throws InterruptedException {
        //default command driver.findElement(By.)
        // starting from home page then to the login page

        WebElement MyAccount = driver.findElement(By.linkText("My Account"));
        MyAccount.click();

        WebElement Login = driver.findElement(By.linkText("Login"));
        Login.click();

        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        //considered Xpath for login field

        //sendKeys() to put input values
        email.sendKeys("BlahBlah09@Blah.com");
        password.sendKeys("abc123");
        Thread.sleep(3000);
        loginButton.click();

        // Verify error message
        String Expected_Message = "Warning: No match for E-Mail Address and/or Password.";
        WebElement Error_Message = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]"));
        String Actual_Message = Error_Message.getText();

        if (Expected_Message.equalsIgnoreCase(Actual_Message)){
            System.out.println("Test Passed");
        }
        else{
            System.out.println("Test Failed, a bug has been found");
        }

    }
    public static void Login_Valid_TestCase01() throws InterruptedException {
        //default command driver.findElement(By.)
        // starting from home page then to the login page

        WebElement MyAccount = driver.findElement(By.linkText("My Account"));
        MyAccount.click();

        WebElement Login = driver.findElement(By.linkText("Login"));
        Login.click();

        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        //considered Xpath for login field

        //sendKeys() to put input values
        email.sendKeys("BlahBlah15@Blah.com");
        password.sendKeys("abcd123");

        Thread.sleep(3000);

        loginButton.click();

        // verify message by URL
        String Expected_Login_Page_Url = "https://demo.opencart.com/index.php?route=account/account";
        String Login_Page_Url = driver.getCurrentUrl();

        if (Expected_Login_Page_Url.equalsIgnoreCase(Login_Page_Url)){
            System.out.println("Test Passed, Login Successfull");
        }
        else {
            System.out.println("Test failed, a Bug has been found");
        }
    }

}