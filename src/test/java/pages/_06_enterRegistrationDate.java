package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class _06_enterRegistrationDate {
    public _06_enterRegistrationDate() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "monthYearOwnerRegistered")
    WebElement registeredDate;

    @FindBy(xpath = "//input[@placeholder='MM.YYYY']")
    WebElement firstRegistered;

    public void setRegisteredDate(String date){
        registeredDate.clear();
        registeredDate.sendKeys(date);
    }


}
