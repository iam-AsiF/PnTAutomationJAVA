package com.Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.PanelUI;

public class BrowserConfig {

    //to launch chrome we need to add web driver(similar as class)
    // globally so that every class can access it

    public static WebDriver driver;
    // Here, 'driver' is a reference variable that refers a class
    //similar as object

    public static void main(String[] args) {
        chrome_launch();
        //open_website("https://facebook.com");
        //closeBrowser();
        //quitBrowser();

        browserMaximumSize(); //ans: Max width = 1552 & Max height = 880

    }

    public static void chrome_launch(){

        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        // we need to call chrome driver manually, command should be
        //written manually (" ") to the exact format and naming case

        driver = new ChromeDriver();
        // to launch a new browser tab everytime we run the code

        //Browser maximize
        driver.manage().window().maximize();
    }
    public static void open_website(String URL){
        driver.get(URL);
        // command to launch a website
    }
    public static void closeBrowser(){
        driver.close();
    }
    public static void quitBrowser(){
        driver.quit();
    }
    public static void browserMaximumSize(){
        int maxWidth = driver.manage().window().getSize().getWidth();
        int maxHeight = driver.manage().window().getSize().getHeight();
        System.out.println("Max width = "+maxWidth+" & Max height = "+maxHeight);
    }

}
