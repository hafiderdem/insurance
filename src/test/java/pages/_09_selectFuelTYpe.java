package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.browserUtils;

import java.util.List;

public class _09_selectFuelTYpe {
    public _09_selectFuelTYpe() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name="fuelType")
    List<WebElement> list;

    public void selectFuelType(String Type){
        browserUtils.clickListElement(list,Type);
    }
}
