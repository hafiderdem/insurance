package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.browserUtils;

import java.util.List;

public class _11_selectEngine {
    public _11_selectEngine() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "engine")
    WebElement element;

    @FindBy(name = "engine")
   List<WebElement> list;



    public void select(){
        element.click();

    }


    public void selectEngine(String engine){
        if (list.size()>=2){
        browserUtils.clickListElement(list,engine);
        }else
            element.click();
    }
}
