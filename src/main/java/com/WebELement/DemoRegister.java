package com.WebELement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoRegister {
    public static WebDriver driver;

    public static void main(String[] args) {
        chrome_launch();
        open_Website("https://demo.opencart.com/index.php?route=account/register");
        RegisterTestCase01();

    }
    public static void chrome_launch(){
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }
    public static void open_Website(String URL){
        driver.get(URL);
    }
    public static void RegisterTestCase01(){
        WebElement FirstName = driver.findElement(By.id("input-firstname"));
        WebElement LastName = driver.findElement(By.id("input-lastname"));
        WebElement Email = driver.findElement(By.id("input-email"));
        WebElement Telephone = driver.findElement(By.id("input-telephone"));
        WebElement Password = driver.findElement(By.id("input-password"));
        WebElement PasswordConfirm = driver.findElement(By.id("input-confirm"));
        WebElement SubscribeYes = driver.findElement(By.name("newsletter"));
        WebElement SubscribeNo = driver.findElement(By.name("newsletter"));
        WebElement PrivacyPolicy = driver.findElement(By.name("agree"));
        WebElement Continue = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));


        FirstName.sendKeys("John");
        LastName.sendKeys("Cena");
        Email.sendKeys("BlahBlah2@Blah.com");
        Telephone.sendKeys("8801952459826");
        Password.sendKeys("abc123");
        PasswordConfirm.sendKeys("abc123");
        SubscribeYes.click();
        SubscribeNo.click();
        PrivacyPolicy.click();
        Continue.submit();
    }
}
