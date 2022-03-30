package com.OpenCart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public class TitleUrl {
    public static WebDriver driver;
    public static void main(String[] args) {
        chrome_launch();
        open_website("https://demo.opencart.com/");
        Title();
        Url();
        close_browser();
    }

    public static void chrome_launch() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }
    public static void open_website(String URL) {
        driver.get(URL);
    }
    public static void Title(){
        String Title = driver.getTitle();
        System.out.println(Title);
    }
    public static void Url(){
        String Url = driver.getCurrentUrl();
        System.out.println(Url);
    }
    public static void close_browser(){
        driver.close();
    }
}
