package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.browserUtils;

import java.util.List;

public class _08_selectBodyType {

    public _08_selectBodyType() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name="bodyType")
    List<WebElement> list;

   public void selectBodyType(String bodyType){
       browserUtils.clickListElement(list,bodyType);

   }


}
