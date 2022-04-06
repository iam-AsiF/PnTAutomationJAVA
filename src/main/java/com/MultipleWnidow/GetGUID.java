package com.MultipleWnidow;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class GetGUID extends BaseClass {

    public static void main(String[] args) {

        chrome_launch();
        open_website("https://the-internet.herokuapp.com/windows");
        get_GUID();

        quit_browser();
    }
    public static void get_GUID(){

        String parent_GUID = driver.getWindowHandle();
        System.out.println(parent_GUID);

        WebElement child_window =  driver.findElement(By.linkText("Click Here"));
        child_window.click();
        Set<String> all_GUIDs = driver.getWindowHandles();
        System.out.println(all_GUIDs);

    }

}
