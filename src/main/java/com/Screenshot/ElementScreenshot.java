package com.Screenshot;

import com.Base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.security.PublicKey;

public class ElementScreenshot extends BaseClass {

    public static void main(String[] args) throws IOException {

        chrome_launch();
        open_website("https://www.google.com/");
        element_Screenshot();
        close_browser();
    }
    public static void element_Screenshot() throws IOException {

        WebElement searchBar = driver.findElement(By.name("q"));
        File scrFile = ((TakesScreenshot)searchBar).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,new File("./Screenshots/Google Search Bar.png"), true);
    }

}
