package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class _02_selectRegisterOwner {

    public _02_selectRegisterOwner() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "(//label[@id='custom-radio'])[1]")
    WebElement Yes;

    @FindBy(xpath = "(//label[@id='custom-radio'])[2]")
    WebElement No;

    @FindBy(xpath = "(//label[@id='custom-radio'])[3]")
    WebElement Used;

    @FindBy(xpath = "(//label[@id='custom-radio'])[4]")
    WebElement New;

    public  void setCarOwner(String YesNo){
        String no="No";
        if (YesNo.equals(no))
            No.click();
    }

    public void theCarIs(String condition){
        String con = "new";
        if (condition.equals(con))
            New.click();
    }

}
