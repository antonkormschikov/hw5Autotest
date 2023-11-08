package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobject.AbsPageObject;
import waiters.Waiters;


import java.time.Duration;

public class AccountPage extends GeneralPage {
    private Waiters waiters;
    public AccountPage (WebDriver driver){
        super(driver);
    }
    public void entryLkOtus(){
        //waiters.waitElementVisible(driver.findElement(By.cssSelector(".sc-199a3eq-0")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
          waiters.waitElementVisible(driver.findElement(By.xpath("//div[span[text()='Владимир']]")));
        WebElement raskr= driver.findElement(By.xpath("//div[span[text()='Владимир']]"));
        //  WebElement raskr= driver.findElement(By.cssSelector(".sc-199a3eq-0"));
        waiters.waitElementVisible(raskr);
        new Actions(driver).moveToElement(raskr)
                .perform();

        //waiters.waitElementVisible(driver.findElement(By.xpath("//a[text()='Личный кабинет']")));
        driver.findElement(By.xpath("//a[text()='Мой профиль']")).click();
    }
}
