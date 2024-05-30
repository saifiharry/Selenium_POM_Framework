package org.JavaSelenium.tests;

import org.JavaSelenium.pageObjects.Image;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImagesTestCase extends BaseClass{
    @BeforeMethod
    public void hitURL(){
        navigateToURL(Image_URL);
    }

    @Test(description="TC 2: Broken Images", enabled = true)
    public void findBrokenImages()
    {
        Integer iBrokenImageCount = 0;
        Image image = new Image(driver);
        for (WebElement img : image.getImages()) {
                if (img != null)
                {
                    if (img.getAttribute(image.ImageSize).equals("0"))
                    {
                        System.out.println(img.getAttribute(image.ImageOutcome) + " is broken.");
                        iBrokenImageCount++;
                    }
                } else {
                    System.out.println("No Images on Web Page");
                }
            }
        System.out.println("Number of Broken Images" + iBrokenImageCount + " broken images");
    }
}
