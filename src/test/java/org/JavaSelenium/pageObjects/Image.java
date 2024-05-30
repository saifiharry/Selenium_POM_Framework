package org.JavaSelenium.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Image {
    WebDriver driver;

    public String ImageSize = "naturalWidth";
    public String ImageOutcome = "outerHTML";
    public Image(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how= How.TAG_NAME, using="img")
    private List<WebElement> images;
    public List<WebElement> getImages()
    {
        return images;
    }



}
