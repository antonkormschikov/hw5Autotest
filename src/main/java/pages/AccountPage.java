package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobject.AbsPageObject;
import java.time.Duration;

public class AccountPage extends GeneralPage {

    public AccountPage (WebDriver driver){
        super(driver);
    }
    public void entryLkOtus(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement raskr= driver.findElement(By.cssSelector("section>div:nth-child(2)>span"));
        waiters.waitElementVisible(raskr);
        new Actions(driver).moveToElement(raskr)
                .perform();
        driver.findElement(By.xpath("//a[text()='Мой профиль']")).click();
    }
}
