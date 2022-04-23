package com.DataDriven;

import com.DataDriven.Utils.Xls_Reader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class DD_LoginTest {

    WebDriver driver;

    @BeforeClass
    @Parameters("browsers")
    public void init_setup(String browser_name) {

        if (browser_name.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browser_name.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if (browser_name.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        else {

            System.out.println("Please provide a browser name (Chrome, Firefox, or Edge)");
        }

    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void TC_Invalid_001() throws InterruptedException {

        //Excel Implementation
        Xls_Reader reader = new Xls_Reader("./src/test/java/com/DataDriven/Login_data.xlsx");
        String sheetName = "Login_invalid";
        int rowCount = reader.getRowCount(sheetName);
        /*
        here, first we need to mention the reader class name and mention the Excel
        files location. then the sheet name we want to use. here, getRowCount will
        calculate the row number of the Excel file. And now we need to run a loop
        to read every row wise data. getCellData brings every data from the file.
         */

        for (int rowNum=2; rowNum<=rowCount; rowNum++){
            String DD_email = reader.getCellData(sheetName, "Email", rowNum);
            String DD_pass = reader.getCellData(sheetName, "Password", rowNum);

            driver.get("https://demo.opencart.com/");
            Reporter.log("Opening Opencart");
            WebElement MyAccount = driver.findElement(By.linkText("My Account"));
            MyAccount.click();

            WebElement Login = driver.findElement(By.linkText("Login"));
            Login.click();
            Reporter.log("Opening Login page");

            WebElement email = driver.findElement(By.id("input-email"));
            WebElement password = driver.findElement(By.id("input-password"));
            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
            //considered Xpath for login field

            //sendKeys() to put input values
            email.sendKeys(DD_email);
            Reporter.log("Typing email");
            password.sendKeys(DD_pass);
            Reporter.log("Typing password");
            Thread.sleep(2000);
            loginButton.click();
            Reporter.log("Login button clicked");
            Thread.sleep(2000);

            System.out.println("Login invalid test passed");
        }

    }

}