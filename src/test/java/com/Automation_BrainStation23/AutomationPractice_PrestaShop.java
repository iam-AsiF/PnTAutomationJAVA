package com.Automation_BrainStation23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AutomationPractice_PrestaShop {
    static WebDriver driver;

    @BeforeClass
    @Parameters("browsers")
    public static void init_setup(String browser_names) {

        if (browser_names.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if (browser_names.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        else if (browser_names.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        else {
            System.out.println("Please enter valid browser name - firefox, chrome, or edge");
        }
    }

    @AfterClass
    public static void tearDown(){

        driver.quit();
    }

    /*
    Special note - Don't forget to change both email addresses after completing
    registration with the current two.
    */

    @Test(description = "for first user")
    public  void first_user() throws InterruptedException {

        //First user creation
        driver.get("http://automationpractice.com/index.php");
        Reporter.log("Opening Automation Practice home page");
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
        signIn.click();
        Reporter.log("Opening account creation page");

        //email field only page
        WebElement emailAddress = driver.findElement(By.id("email_create"));
        emailAddress.sendKeys("bluhbluh20@gmail.com");
        Reporter.log("Email entered");

        WebElement createAnAccount = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
        createAnAccount.click();
        Reporter.log("User creation page opened");
        Thread.sleep(3000);

        //Actual registration page
        WebElement title_Mr = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[1]/div[1]/label"));
        WebElement firstName = driver.findElement(By.id("customer_firstname"));
        WebElement lastName = driver.findElement(By.id("customer_lastname"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement dateOfBirthDay = driver.findElement(By.id("days"));
        WebElement dateOfBirthMonth = driver.findElement(By.id("months"));
        WebElement dateOfBirthYear = driver.findElement(By.id("years"));
        WebElement newsletter = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[7]/label"));
        WebElement specialOffers = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[8]/label"));
        WebElement addressCompany = driver.findElement(By.id("company"));
        WebElement addressAddress1 = driver.findElement(By.id("address1"));
        WebElement addressAddress2 = driver.findElement(By.id("address2"));
        WebElement city = driver.findElement(By.id("city"));
        WebElement state = driver.findElement(By.id("id_state"));
        WebElement zip = driver.findElement(By.id("postcode"));
        WebElement addiInfo = driver.findElement(By.id("other"));
        WebElement phone = driver.findElement(By.id("phone"));
        WebElement mobile = driver.findElement(By.id("phone_mobile"));
        WebElement register = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span"));


        title_Mr.click();
        Reporter.log("title selected");

        firstName.sendKeys("Atif");
        Reporter.log("First name entered");

        lastName.sendKeys("Khan");
        Reporter.log("Last name entered");

        password.sendKeys("abc123");
        Reporter.log("Password entered");

        Select slt1 = new Select(dateOfBirthDay);
        slt1.selectByIndex(10);
        Select slt2 = new Select(dateOfBirthMonth);
        slt2.selectByValue("4");
        Select slt3 = new Select(dateOfBirthYear);
        slt3.selectByValue("1995");

        newsletter.click();
        Reporter.log("Newsletter offer in mail accepted");

        specialOffers.click();
        Reporter.log("Special offer in mail accepted");

        addressCompany.sendKeys("863-409-4849");
        Reporter.log("Company name entered");

        addressAddress1.sendKeys("317 Pierce Avenue");
        Reporter.log("Address entered");

        addressAddress2.sendKeys("FL 32818");
        Reporter.log("Address line 1 entered");

        city.sendKeys("LAKELAND");
        Reporter.log("City name entered");

        Select slt = new Select(state);
        slt.selectByIndex(9);

        zip.sendKeys("32818");
        Reporter.log("Zip/Postal code entered");

        addiInfo.sendKeys("Nothing");
        Reporter.log("Additional info entered");

        phone.sendKeys("863-409-5895");
        Reporter.log("Phone number entered");

        mobile.sendKeys("863-409-4849");
        Reporter.log("Mobile number entered");

        register.click();
        Reporter.log("Account created successfully");

        //Dress to Casual dress section
        //here we need to use mouse to hover method because of floating menu
        // Actions is the class, and action is the object
        WebElement dresses = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
        WebElement casualDresses   = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a"));

        Actions action = new Actions(driver);
        action.moveToElement(dresses).perform();
        Thread.sleep(2000);
        action.click(casualDresses).perform();
        Reporter.log("Casual dresses option selected");

        //Add to cart
        WebElement printedDress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a"));
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span"));

        action.moveToElement(printedDress).perform();
        Thread.sleep(2000);
        action.click(addToCart).perform();
        Reporter.log("Add to cart option clicked");
        Thread.sleep(2000);

        //continue shopping
        //since it is also a floating tab, we can use mouse hover method
        WebElement continueShopping = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span"));
        action.click(continueShopping).perform();
        Reporter.log("Continue shopping option clicked");

        // Selecting t-shirt tab
        WebElement tShirt = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a"));
        tShirt.click();
        Reporter.log("T-Shirt option selected");

        //Selecting a t-Shirt
        WebElement fadedShortSleeveTShirt = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a"));
        WebElement more = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span"));

        action.moveToElement(fadedShortSleeveTShirt).perform();
        action.click(more).perform();
        Reporter.log("Faded Short Sleeve t-Shirt selected");

        // choosing Blue color
        WebElement blueColor = driver.findElement(By.id("color_14"));
        blueColor.click();
        Reporter.log("t-Shirt color blue selected");

        //Adding blue t-shirt to the cart
        WebElement addToCartB = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
        addToCartB.click();
        Reporter.log("Blue t-shirt added to the cart");
        Thread.sleep(2000);

        WebElement proceedToCheckout = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
        action.click(proceedToCheckout).perform();

        //Cart summery page
        WebElement proceedCheckoutSu = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
        proceedCheckoutSu.click();
        Reporter.log("Proceed checkout option in Summery clicked");

        //Address summery
        WebElement proceedCheckoutA = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span"));
        proceedCheckoutA.click();
        Reporter.log("Proceed checkout option in Address clicked");

        //Shipping summery
        WebElement termsService = driver.findElement(By.id("cgv"));
        WebElement proceedCheckoutSh = driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span"));

        termsService.click();
        Reporter.log("Terms of services agreed");

        proceedCheckoutSh.click();
        Reporter.log("Proceed checkout option in Shipping clicked");

        //Payment option
        WebElement payByCheck = driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a/span"));
        payByCheck.click();
        Reporter.log("Pay by check option selected");

        //Placing order
        WebElement confirmOrder = driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span"));
        confirmOrder.click();
        Reporter.log("Order confirmed");

        //Signing off
        WebElement signOut = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a"));
        signOut.click();
        Reporter.log("Signed out");

    }

    @Test(description = "for second user")
    public  void second_user() throws InterruptedException {

        //First user creation
        driver.get("http://automationpractice.com/index.php");
        Reporter.log("Opening Automation Practice home page");
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
        signIn.click();
        Reporter.log("Opening account creation page");

        //email field only page
        WebElement emailAddress = driver.findElement(By.id("email_create"));
        emailAddress.sendKeys("bluhbluh21@gmail.com");
        Reporter.log("Email entered");

        WebElement createAnAccount = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
        createAnAccount.click();
        Reporter.log("User creation page opened");
        Thread.sleep(3000);

        //Actual registration page
        WebElement title_Mr = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[1]/div[1]/label"));
        WebElement firstName = driver.findElement(By.id("customer_firstname"));
        WebElement lastName = driver.findElement(By.id("customer_lastname"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement dateOfBirthDay = driver.findElement(By.id("days"));
        WebElement dateOfBirthMonth = driver.findElement(By.id("months"));
        WebElement dateOfBirthYear = driver.findElement(By.id("years"));
        WebElement newsletter = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[7]/label"));
        WebElement specialOffers = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[8]/label"));
        WebElement addressCompany = driver.findElement(By.id("company"));
        WebElement addressAddress1 = driver.findElement(By.id("address1"));
        WebElement addressAddress2 = driver.findElement(By.id("address2"));
        WebElement city = driver.findElement(By.id("city"));
        WebElement state = driver.findElement(By.id("id_state"));
        WebElement zip = driver.findElement(By.id("postcode"));
        WebElement addiInfo = driver.findElement(By.id("other"));
        WebElement phone = driver.findElement(By.id("phone"));
        WebElement mobile = driver.findElement(By.id("phone_mobile"));
        WebElement register = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span"));


        title_Mr.click();
        Reporter.log("title selected");

        firstName.sendKeys("Atik");
        Reporter.log("First name entered");

        lastName.sendKeys("Khan");
        Reporter.log("Last name entered");

        password.sendKeys("abc123");
        Reporter.log("Password entered");

        Select slt1 = new Select(dateOfBirthDay);
        slt1.selectByIndex(10);
        Select slt2 = new Select(dateOfBirthMonth);
        slt2.selectByValue("5");
        Select slt3 = new Select(dateOfBirthYear);
        slt3.selectByValue("1996");

        newsletter.click();
        Reporter.log("Newsletter offer in mail accepted");

        specialOffers.click();
        Reporter.log("Special offer in mail accepted");

        addressCompany.sendKeys("863-409-4849");
        Reporter.log("Company name entered");

        addressAddress1.sendKeys("317 Pierce Avenue");
        Reporter.log("Address entered");

        addressAddress2.sendKeys("FL 32818");
        Reporter.log("Address line 1 entered");

        city.sendKeys("LAKELAND");
        Reporter.log("City name entered");

        Select slt = new Select(state);
        slt.selectByIndex(9);

        zip.sendKeys("32818");
        Reporter.log("Zip/Postal code entered");

        addiInfo.sendKeys("Nothing");
        Reporter.log("Additional info entered");

        phone.sendKeys("863-409-5898");
        Reporter.log("Phone number entered");

        mobile.sendKeys("863-409-4846");
        Reporter.log("Mobile number entered");

        register.click();
        Reporter.log("Account created successfully");

        //Dress to Casual dress section
        //here we need to use mouse to hover method because of floating menu
        // Actions is the class, and action is the object
        WebElement dresses = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
        WebElement casualDresses   = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a"));

        Actions action = new Actions(driver);
        action.moveToElement(dresses).perform();
        Thread.sleep(2000);
        action.click(casualDresses).perform();
        Reporter.log("Casual dresses option selected");

        //Add to cart
        WebElement printedDress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a"));
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span"));

        action.moveToElement(printedDress).perform();
        Thread.sleep(2000);
        action.click(addToCart).perform();
        Reporter.log("Add to cart option clicked");
        Thread.sleep(2000);

        //continue shopping
        //since it is also a floating tab, we can use mouse hover method
        WebElement continueShopping = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span"));
        action.click(continueShopping).perform();
        Reporter.log("Continue shopping option clicked");

        // Selecting t-shirt tab
        WebElement tShirt = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a"));
        tShirt.click();
        Reporter.log("T-Shirt option selected");

        //Selecting a t-Shirt
        WebElement fadedShortSleeveTShirt = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a"));
        WebElement more = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span"));

        action.moveToElement(fadedShortSleeveTShirt).perform();
        action.click(more).perform();
        Reporter.log("Faded Short Sleeve t-Shirt selected");

        // choosing Blue color
        WebElement blueColor = driver.findElement(By.id("color_14"));
        blueColor.click();
        Reporter.log("t-Shirt color blue selected");

        //Adding blue t-shirt to the cart
        WebElement addToCartB = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
        addToCartB.click();
        Reporter.log("Blue t-shirt added to the cart");
        Thread.sleep(2000);

        WebElement proceedToCheckout = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
        action.click(proceedToCheckout).perform();

        //Cart summery page
        WebElement proceedCheckoutSu = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
        proceedCheckoutSu.click();
        Reporter.log("Proceed checkout option in Summery clicked");

        //Address summery
        WebElement proceedCheckoutA = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span"));
        proceedCheckoutA.click();
        Reporter.log("Proceed checkout option in Address clicked");

        //Shipping summery
        WebElement termsService = driver.findElement(By.id("cgv"));
        WebElement proceedCheckoutSh = driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span"));

        termsService.click();
        Reporter.log("Terms of services agreed");

        proceedCheckoutSh.click();
        Reporter.log("Proceed checkout option in Shipping clicked");

        //Payment option
        WebElement payByCheck = driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a/span"));
        payByCheck.click();
        Reporter.log("Pay by check option selected");

        //Placing order
        WebElement confirmOrder = driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span"));
        confirmOrder.click();
        Reporter.log("Order confirmed");

        //Signing off
        WebElement signOut = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a"));
        signOut.click();
        Reporter.log("Signed out");

    }

}
