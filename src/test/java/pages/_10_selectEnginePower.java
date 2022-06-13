package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.browserUtils;

import java.util.List;

public class _10_selectEnginePower {

    public _10_selectEnginePower() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(name = "enginePower")
    List<WebElement> list;

    public void selectEnginePower(String enginePower){

        browserUtils.clickListElement(list,enginePower);
    }
}
