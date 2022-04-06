package com.MultipleWnidow;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class MultipleTabSwitch extends BaseClass {

    public static void main(String[] args) {

        chrome_launch();
        open_website("https://the-internet.herokuapp.com/windows");
        switch_Window();

        quit_browser();
    }
    public static void switch_Window(){

        String parent_GUID = driver.getWindowHandle();
        WebElement child_window =  driver.findElement(By.linkText("Click Here"));
        child_window.click();
        Set<String> all_GUIDs = driver.getWindowHandles();

        //Switch window to child
        for (String child_GUID:all_GUIDs){

            if (!child_GUID.equals(parent_GUID)){
                driver.switchTo().window(child_GUID);
                driver.get("https://www.google.com/");
            }
        }

        //Switch back to parent window
        for (String child_GUID:all_GUIDs){

            if (!child_GUID.equals(parent_GUID)){
                driver.switchTo().window(parent_GUID);
                driver.get("https://www.BBC.com/");
            }
        }

    }

}
