package org.JavaSelenium.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.JavaSelenium.pageObjects.Form;
import org.JavaSelenium.testData.Constant;

public class FormTestCase extends BaseClass{

    @BeforeMethod
    public void hitURL(){
        navigateToURL(Form_URL);
    }

    @Test(description="TC:1 - Login Form", enabled=true)
    public void submitLoginForm(){
        Form form = new Form (driver);
        enterText(form.getFirstNameTextBox(),Constant.Fisrt_Name);
        enterText(form.getLastNameTextBox(),Constant.Last_Name);
        selectFromDropdown(form.getGenderDropdown(),Constant.Gender);
        click(form.getFavouriteRed());
        enterText(form.getDescriptionTextArea(),Constant.Description);
        click(form.getEmailCheckBox());
        selectFromDropdown(form.getCountryDropdown(),Constant.Country);
        click(form.getSubmitButton());
    }

}
