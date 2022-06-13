package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.browserUtils;

import java.util.Iterator;
import java.util.List;

public class _03_selectVehicle {

    public _03_selectVehicle() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(name="monthYear")
    WebElement firstRegistrationMonthYear;

    @FindBy(name="hsn")
    WebElement hsnNumber;

    @FindBy(name="tsn")
    WebElement tsnNumber;

    @FindBy(name="list")
    WebElement list;

    @FindBy(xpath = "(//div[@class='SingleClickListField__optionGroup--1pULx'])[2]//button")
    List<WebElement> allManufacturer;

    @FindBy(name="makeFilter")
    WebElement searchButton;

    @FindBy(xpath = "//button[@name='make']")
    WebElement make;

    public void setVehicle(String registration,String HSN,String TSN){
        firstRegistrationMonthYear.clear();
        firstRegistrationMonthYear.sendKeys(registration);
        browserUtils.waitFor(1);
        hsnNumber.sendKeys(HSN);
        browserUtils.waitFor(1);
        tsnNumber.sendKeys(TSN);
        browserUtils.waitFor(3);
    }

    public void findByMakeAndModel(){
        list.click();
    }

    public void searchMake(String make){
        searchButton.sendKeys(make);
        browserUtils.waitFor(1);
        this.make.click();
    }

    public void selectManufacturer(String make){

        searchButton.sendKeys(make);
        browserUtils.waitFor(1);
        this.make.click();
        browserUtils.waitFor(1);

//        browserUtils.clickListElement(allManufacturer,make);



//        for (WebElement item:allManufacturer
//             ) {
//            if (item.getText().equalsIgnoreCase(make)){
//
//                item.click();
//            }
//        }


    }



}
