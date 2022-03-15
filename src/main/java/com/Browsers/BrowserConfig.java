package com.Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserConfig {

    //to launch chrome we need to add web driver(similar as class)
    // globally so that every class can access it

    public static WebDriver driver;
    // Here, 'driver' is a reference variable that refers a class
    //similar as object

    public static void main(String[] args) {
        chrome_launch();
        open_website("https://google.com");

    }
    // to launch chrome browser
    public static void chrome_launch(){

        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        // we need to call chrome driver manually, command should be
        //written manually (" ") to the exact format and naming case

        driver = new ChromeDriver();
        // to launch a new browser tab everytime we run the code
    }
    //to launch a website
    public static void open_website(String URL){
        driver.get(URL); // command to launch a website
    }

}
