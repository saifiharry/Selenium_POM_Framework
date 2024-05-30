package org.JavaSelenium.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.JavaSelenium.utils.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.NoSuchElementException;

public class BaseClass {
    public static WebDriver driver;

    static String Form_URL;
    static String Image_URL;

    @BeforeClass
    public void setup(){
        ConfigFileReader read = new ConfigFileReader();
        Form_URL = read.getFormURL();
        Image_URL = read.getImageURL();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void navigateToURL(String URL) {
        try {
            driver.get(URL);
            System.out.println(driver.getCurrentUrl() + " is opened");

        } catch (Exception exp) {
            System.out.println("Exception Occurred: "+exp.getMessage()+" --> openURL <-- method of Base Class" + URL);
        }
    }

    public static void waitForElementExplicitly(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element) {
        try {
            waitForElementExplicitly(element);
            element.click();
            System.out.println("Clicked on this element ---> " + element);

        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println("Exception Occurred: "+exp.getMessage()+" --> click <--  method of Base Class");

        }
    }

    public static void selectFromDropdown(WebElement element, String visibleText) {
        try {
            Select select = new Select(element);
            System.out.println("Selecting " + visibleText + " from Dropdown");
            select.selectByVisibleText(visibleText);
        } catch (Exception exp) {
            System.out.println("Exception Occurred: "+exp.getMessage()+" --> selectFromDropdown <--  method of Base Class");
        }
    }
    public static void selectFromDropBoxByIndex(WebElement element, int index) {
        try {
            Select select = new Select(element);
            System.out.println("Selecting option at index " + index + " from dropdown");
            select.selectByIndex(index);
        } catch (NoSuchElementException exp) {
            System.out.println("Exception Occurred: "+exp.getMessage()+" --> selectFromDropBoxByIndex <-- method of Base Class");
        }
    }


    public static void enterText(WebElement element, String inputData) {
        try {
            waitForElementExplicitly(element);

            if (element.isDisplayed()) {
                System.out.println("Entering :" + inputData);
                element.clear();
                element.sendKeys(inputData);
            } else {
                System.out.println("Element is not Displayed ..");
            }
        } catch (Exception exp) {
            System.out.println("Exception Occurred: "+exp.getMessage()+" --> passTextToWebelement <--  method of Base Class");

        }

    }
}
