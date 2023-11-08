package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobject.AbsPageObject;
import waiters.Waiters;


public abstract class GeneralPage extends AbsPageObject{

    public GeneralPage(WebDriver driver, Waiters waiters)
    {super(driver);
     super(waiters);

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
}
