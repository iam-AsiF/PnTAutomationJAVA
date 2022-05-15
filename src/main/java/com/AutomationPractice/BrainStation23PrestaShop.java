package com.AutomationPractice;


import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class BrainStation23PrestaShop extends BaseClass {

    public static void main(String[] args) throws InterruptedException {

        chrome_launch();
        first_user();
        quit_browser();

    }

    public static void first_user() throws InterruptedException {

        //home page
        driver.get("http://automationpractice.com/index.php");
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
        signIn.click();

        //login page
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement sign = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));

        email.sendKeys("bluh10@gmail.com");
        password.sendKeys("abc123");
        sign.click();

        //Casual dress
        //here we need to use mouse to hover method because of floating menu
        // Actions is the class, and action is the object
        WebElement dresses = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
        WebElement casualDresses   = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a"));

        Actions action = new Actions(driver);
        action.moveToElement(dresses).perform();
        Thread.sleep(2000);
        action.click(casualDresses).perform();

        //Add to cart
        WebElement printedDress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a"));
        WebElement addToCartC = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span"));

        action.moveToElement(printedDress).perform();
        Thread.sleep(2000);
        action.click(addToCartC).perform();
        Thread.sleep(2000);

        //continue shopping
        WebElement continueShopping = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span"));
        action.click(continueShopping).perform();

        // choosing t-shirt
        WebElement tShirt = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a"));
        tShirt.click();

        //Selecting a t-Shirt
        WebElement fadedShortSleeveTShirt = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a"));
        WebElement more = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span"));

        action.moveToElement(fadedShortSleeveTShirt).perform();
        action.click(more).perform();

        // choosing Blue color
        WebElement blueColor = driver.findElement(By.id("color_14"));
        blueColor.click();

        //Adding blue t-shirt to the cart
        WebElement addToCartB = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
        addToCartB.click();
        Thread.sleep(2000);

        WebElement proceedToCheckout = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
        action.click(proceedToCheckout).perform();


        //Cart summery page
        WebElement proceedCheckoutSu = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
        proceedCheckoutSu.click();

        //Address summery
        WebElement proceedCheckoutA = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span"));
        proceedCheckoutA.click();

        //Shipping summery
        WebElement termsService = driver.findElement(By.id("cgv"));
        WebElement proceedCheckoutSh = driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span"));

        termsService.click();

        proceedCheckoutSh.click();

        //Payment option
        WebElement payByCheck = driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a/span"));
        payByCheck.click();

        //Placing order
        WebElement confirmOrder = driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span"));
        confirmOrder.click();

        //Signing off
        WebElement signOut = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a"));
        signOut.click();

    }

}
