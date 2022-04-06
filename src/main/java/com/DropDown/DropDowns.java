package com.DropDown;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDowns extends BaseClass {

    public static void main(String[] args) {

        chrome_launch();
        open_website("https://the-internet.herokuapp.com/dropdown");
        select_Option();
    }
    public static void select_Option(){

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select slt = new Select(dropdown);
        // We use Select class to pick the dropdown values
        slt.selectByIndex(1); //inspect - index value given - 1,2
        slt.selectByValue("2"); //Need to put string value
        slt.selectByVisibleText("Option 1"); //inspect - find the visible text
        // we can use any of the three methods
    }
}
