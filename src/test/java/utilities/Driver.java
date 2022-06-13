package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static  ThreadLocal<WebDriver> driverpool= new ThreadLocal<>();

    public static WebDriver getDriver(){
        if (driverpool.get()==null){

            synchronized (Driver.class){

                String br= conReader.getProperty("browser");
                switch (br) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverpool.set(new ChromeDriver());
                        driverpool.get().manage().window().maximize();
                        driverpool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        break;

                    case"chromeSL":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions capability = new ChromeOptions();
                        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
                        capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
                        driverpool.set(new ChromeDriver());
                        driverpool.get().manage().window().maximize();
                        driverpool.get().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
                        break;
                }

            }
        }
        return driverpool.get();
    }

    public static void closeDriver(){
        if (driverpool.get()!=null){
            driverpool.get().manage().deleteAllCookies();
            driverpool.get().quit();
            driverpool.remove();
        }
    }

}
