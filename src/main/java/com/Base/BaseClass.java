package com.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    public static WebDriver driver;

    public static void chrome_launch() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }
    public static void open_website(String URL){
        driver.get(URL);
    }
    public static void close_browser(){
        driver.close();
    }
}
