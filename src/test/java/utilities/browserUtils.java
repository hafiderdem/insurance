package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class browserUtils {

    public static void waitForPageLoad(long timeUnitInSeconds) throws InterruptedException {

        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        };

        //  HOW DOES THIS WORK ???
        try{
            System.out.println("waiting for page loading");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeUnitInSeconds));
            wait.until(expectation);
        }catch (Throwable error){
            System.out.println(
                    "time out waiting for page load request to complete after "+ timeUnitInSeconds+" seconds");
        }
    }

    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void acceptCookies(){

    }

    public static void clickListElement(List<WebElement> list, String str){

        for (WebElement item:list
        ) {
            if (item.getText().equalsIgnoreCase(str)){
                item.click();
                break;
            }
        }
    }

}
