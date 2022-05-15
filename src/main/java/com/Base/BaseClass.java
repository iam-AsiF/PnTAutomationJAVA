package com.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
    public static WebDriver driver;
    public static void chrome_launch() {

        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void firefox_launch(){

        System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }
    public static void edge_launch() {

        System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
    public static void open_website(String URL){
        driver.get(URL);
    }
    public static void close_browser(){
        driver.close();
    }
    public static void quit_browser(){
        driver.quit();
    }
}
