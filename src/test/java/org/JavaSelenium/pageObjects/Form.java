package org.JavaSelenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Form {
    WebDriver driver;
    public Form(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how= How.ID, using="firstname")
    private WebElement firstNameTextBox;
    public WebElement getFirstNameTextBox()
    {
        return firstNameTextBox;
    }

    @FindBy(how= How.ID, using="surname")
    private WebElement lastNameTextBox;
    public WebElement getLastNameTextBox()
    {
        return lastNameTextBox;
    }

    @FindBy(how= How.ID, using="gender")
    private WebElement genderDropdown;
    public WebElement getGenderDropdown()
    {
        return genderDropdown;
    }

    @FindBy(how= How.ID, using="red")
    private WebElement favouriteRed;
    public WebElement getFavouriteRed()
    {
        return favouriteRed;
    }

    @FindBy(how= How.ID, using="checkbox1")
    private WebElement emailCheckBox;
    public WebElement getEmailCheckBox() {return emailCheckBox;}

    @FindBy(how= How.CSS, using="[placeholder='Tell us some fun stuff!']")
    private WebElement descriptionTextArea;
    public WebElement getDescriptionTextArea() {return descriptionTextArea;}

    @FindBy(how= How.ID, using="continent")
    private WebElement countryDropdown;
    public WebElement getCountryDropdown() {return countryDropdown;}

    @FindBy(how= How.ID, using="submitbutton")
    private WebElement submitButton;
    public WebElement getSubmitButton() {return submitButton;}

}
