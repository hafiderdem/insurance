package pages;


import com.google.common.base.Function;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.Driver;
import utilities.browserUtils;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class _12_firstRegAndRegDate {
    public _12_firstRegAndRegDate() {
        PageFactory.initElements(Driver.getDriver(),this);
    }






    @FindBy(name = "monthYearFirstRegistered")
    WebElement firstRegistered;


/*
        Wait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);

        WebElement ownerRegistered1 = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver ) {
                return driver.findElement(By.name("monthYearOwnerRegistered"));
            }
        });

 */






    public void setRegistrationDate(String date1, String date2) {

            firstRegistered.clear();
            firstRegistered.sendKeys(date1);

            browserUtils.waitFor(2);

          if (!date2.equals("N/A")){
             WebElement a = Driver.getDriver().findElement(By.name("monthYearOwnerRegistered"));
             a.clear();
             a.sendKeys(date2);
            }

    }

}
