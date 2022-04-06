package com.Screenshot;

import com.Base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class PageScreenshot extends BaseClass {

    public static void main(String[] args) throws IOException {

        chrome_launch();
        open_website("https://www.google.com/");
        screenshot();
        close_browser();
    }
    public static void screenshot() throws IOException {

        //Capture
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //Save
        FileUtils.copyFile(scrFile,new File("./Screenshots/Google.png"), true);
    }
}
