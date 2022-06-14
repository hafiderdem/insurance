package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.browserUtils;

public class _01_selectPrecondition {

    public _01_selectPrecondition() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//label[@id='custom-radio'])[1]")
    WebElement keepingCar;

    @FindBy(xpath = "(//label[@id='custom-radio'])[2]")
    WebElement buyingCar;

    @FindBy(name="inceptionDate")
    WebElement inceptionDate;


    @FindBy(xpath = "//button[@data-testid='button']")
    WebElement continueButton;


    public void setPreCondition(String condition){
        String con1="The car is already insured";
        String con2="The car will still be registered";

        if (condition.equals(con1))
        {this.keepingCar.click(); }
        else
            this.buyingCar.click();


        browserUtils.waitFor(2);
    }

    public void setInceptionDate(String inceptionDate){
        this.inceptionDate.clear();
        this.inceptionDate.sendKeys(inceptionDate);
        browserUtils.waitFor(2);
    }

    public void clickContinue(){
        continueButton.click();
        browserUtils.waitFor(2);
    }

    public void continueButtonIsEnabled(){
        Assert.assertFalse(continueButton.isEnabled());
    }


}
