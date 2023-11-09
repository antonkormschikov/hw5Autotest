package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.AbsPageObject;
import waiters.Waiters;


public abstract class GeneralPage extends AbsPageObject{
    //protected Waiters waiters;
private final String BASE_URL=System.getProperty("base.url","https://otus.ru");
    public GeneralPage(WebDriver driver)
    {super(driver);

    }

    public void cleanAndEnter(By by, String sendedKey){
        WebElement element = driver.findElement(by);
           waiters.waitElementVisible(element);
        new Actions(driver).moveToElement(element)
                .click()
                .perform();
        waiters.waitElementVisible(element);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        element.clear();
        element.sendKeys(sendedKey);
    }
    public void openPage(String path){
        driver.get(BASE_URL+path);
    }
}
