package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.browserUtils;

public class _07_selectModel {
    public _07_selectModel() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name="modelFilter")
    WebElement modelFilter;

    @FindBy (name = "model")
    WebElement model;

    public  void selectModel(String model){
        modelFilter.sendKeys(model);
        browserUtils.waitFor(1);
        this.model.click();
        browserUtils.waitFor(3);
    }

}
