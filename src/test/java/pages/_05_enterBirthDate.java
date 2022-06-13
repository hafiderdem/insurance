package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class _05_enterBirthDate {
    public _05_enterBirthDate() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name="birthDate")
    WebElement birthdate;

    public void setBirthdate(String BD){
        birthdate.sendKeys(BD);
    }

}
