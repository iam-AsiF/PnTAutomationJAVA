package com.Navigations;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class InputFiledCheck extends BaseClass {
    /*Here, it will be checked whether all the given inputs are there and
    matches with the previous given input after reloading the register page.*/

    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        open_website("https://demo.opencart.com/");

        Register_Valid_TestCase01();
        Thread.sleep(3000);

        Navigate_Backward();
        Thread.sleep(3000);

        Navigate_Forward();
        Thread.sleep(3000);

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
        //WebElement Continue = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));

        String first_Name = "John";
        FirstName.sendKeys(first_Name);
        String last_Name = "Cena";
        LastName.sendKeys(last_Name);
        String email = Generate_Random_Email() + "Gmail.com";
        Email.sendKeys(email);
        Thread.sleep(3000);
        String telephone = "8801962459826";
        Telephone.sendKeys(telephone);
        String password = "abcd1234";
        Password.sendKeys(password);
        String password_Confirm = "abcd1234";
        PasswordConfirm.sendKeys(password_Confirm);
        SubscribeYes.click();
        //SubscribeNo.click();
        PrivacyPolicy.click();

        Thread.sleep(2000); //to wait for n sec before continue

        //Continue.submit();

        //Verify all the inputs by text after navigation

        //first name
        String Expected_first_Name = "John";
        WebElement first_name = driver.findElement(By.id("input-firstname"));
        String Actual_first_name = first_name.getText();

        if (Expected_first_Name.equalsIgnoreCase(Actual_first_name)){
            System.out.println("Test Passed for the first name field");
        }
        else{
            System.out.println("Test Failed, a bug has been found in the first name field");
        }
        //last name
        String Expected_last_Name = "Cena";
        WebElement last_name = driver.findElement(By.id("input-lastname"));
        String Actual_last_name = last_name.getText();

        if (Expected_last_Name.equalsIgnoreCase(Actual_last_name)){
            System.out.println("Test Passed for the last name field");
        }
        else{
            System.out.println("Test Failed, a bug has been found in the last name field");
        }
        //email
        String Expected_email = email;
        WebElement present_email = driver.findElement(By.id("input-email"));
        String Actual_email = present_email.getText();

        if (Expected_email.equalsIgnoreCase(Actual_email)){
            System.out.println("Test Passed for the email field");
        }
        else{
            System.out.println("Test Failed, a bug has been found in the email field");
        }
        //telephone
        String Expected_telephone = "8801962459826";
        WebElement present_telephone = driver.findElement(By.id("input-telephone"));
        String Actual_telephone = present_telephone.getText();

        if (Expected_telephone.equalsIgnoreCase(Actual_telephone)){
            System.out.println("Test Passed for the telephone field");
        }
        else{
            System.out.println("Test Failed, a bug has been found in the telephone field");
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
    public static void Navigate_Backward(){
        driver.navigate().back();
    }
    public static void Navigate_Forward(){
        driver.navigate().forward();
    }


}
