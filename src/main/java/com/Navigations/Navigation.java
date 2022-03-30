package com.Navigations;

import com.Base.BaseClass;

public class Navigation extends BaseClass {

    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        open_website("https://www.google.com/");
        Thread.sleep(2000);
        Navigate_To();
        Thread.sleep(2000);
        Navigate_Backward();
        Thread.sleep(2000);
        Navigate_Forward();
        Thread.sleep(2000);
        Navigate_Reload();
        Thread.sleep(2000);

        close_browser();
    }
    public static void Navigate_To(){
        driver.navigate().to("https://demo.opencart.com/");
    }
    public static void Navigate_Backward(){
        driver.navigate().back();
    }
    public static void Navigate_Forward(){
        driver.navigate().forward();
    }
    public static void Navigate_Reload(){
        driver.navigate().refresh();
    }

}
