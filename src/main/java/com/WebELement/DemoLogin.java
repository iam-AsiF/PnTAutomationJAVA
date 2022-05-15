package com.WebELement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoLogin {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        open_website("https://demo.opencart.com/index.php?route=account/login");
        loginTestCase01();
        Thread.sleep(2000);
        browser_quit();
    }

    public static void chrome_launch() {
        /*System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();*/

        // Or, using Boni Garcia's driver installer
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }
    public static void open_website(String URL){
        driver.get(URL);
    }
    public static void loginTestCase01(){
        //default command driver.findElement(By.)
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        //considered Xpath for login field

        //sendKeys() to put input values
        email.sendKeys("BlahBlah@Blah.com");
        password.sendKeys("abc123");
        loginButton.click();
    }

    public static void browser_quit(){
        driver.quit();
    }

}