package com.OpenCart;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Register extends BaseClass {

    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        open_website("https://demo.opencart.com/");

        Register_Valid_TestCase01();
        Thread.sleep(2000);

        //close_browser();
    }
    public static void Register_Valid_TestCase01() throws InterruptedException {
        /*
        If we want to go to the register page from the home page.
        Now it is necessary to write action code immediately for a current page,
        suppose if I use MyAccount.click(); and Register.click(); at the end of
        web element commands it will not work since the home page don't have
        any first name, it has only the click option to take me to the register page.
         */

        WebElement MyAccount = driver.findElement(By.linkText("My Account"));
        MyAccount.click();

        WebElement Register = driver.findElement(By.linkText("Register"));
        Register.click();

        WebElement FirstName = driver.findElement(By.id("input-firstname"));
        WebElement LastName = driver.findElement(By.id("input-lastname"));
        WebElement Email = driver.findElement(By.id("input-email"));
        WebElement Telephone = driver.findElement(By.id("input-telephone"));
        WebElement Password = driver.findElement(By.id("input-password"));
        WebElement PasswordConfirm = driver.findElement(By.id("input-confirm"));
        WebElement SubscribeYes = driver.findElement(By.name("newsletter"));
        //WebElement SubscribeNo = driver.findElement(By.name("newsletter"));
        WebElement PrivacyPolicy = driver.findElement(By.name("agree"));
        WebElement Continue = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));

        FirstName.sendKeys("John");
        LastName.sendKeys("Cena");
        Email.sendKeys(Generate_Random_Email() + "@Gmail.com");
        Thread.sleep(3000);
        Telephone.sendKeys("8801962459826");
        Password.sendKeys("abcd1234");
        PasswordConfirm.sendKeys("abcd1234");
        SubscribeYes.click();
        //SubscribeNo.click();
        PrivacyPolicy.click();

        Thread.sleep(2000); //to wait for n sec before continue

        Continue.submit();

        //Verify confirmation/error message by text
        /*String Expected_Message = "Your Account Has Been Created!";
        WebElement Success_Message = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        String Actual_Message = Success_Message.getText();

        if (Expected_Message.equalsIgnoreCase(Actual_Message)){
            System.out.println("Test Passed");
        }
        else{
            System.out.println("Test Failed, a bug has been found");
        }*/

        // press ctrl + shift + / to make or reset a group comment

        //Verify confirmation/error message by title
        String Expected_Title = "Your Account Has Been Created!";
        String Actual_Title = driver.getTitle();

        if (Expected_Title.equalsIgnoreCase(Actual_Title)){
            System.out.println("Test Passed, Account successfully created");
        }
        else{
            System.out.println("Test Failed, a bug has been found, Actual title is: "+Actual_Title);
        }
    }
    // for email ID
    public static String Generate_Random_Email() {

        String saltChar = "abcdefABCDEF123";
        StringBuilder randomString = new StringBuilder();
        Random rnd = new Random();

        while (randomString.length() < 10) {
            // Here 10 is the index value, not number
            int index = (int) (rnd.nextFloat() * saltChar.length()); //formula
            randomString.append(saltChar.charAt(index));
        }
        String newString = randomString.toString();
        return newString;
    }

}
