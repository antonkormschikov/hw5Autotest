package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobject.AbsPageObject;
import java.time.Duration;

public class AccountPage extends GeneralPage {
    private static final Logger logger = (Logger) LogManager.getLogger(AccountPage.class);
    public AccountPage (WebDriver driver){
        super(driver);
    }
    public void entryLkOtus(){
        logger.info("----Вхход в ЛК ОТУС----");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement raskr= driver.findElement(By.cssSelector("section>div:nth-child(2)>span"));
        waiters.waitElementVisible(raskr);
        new Actions(driver).moveToElement(raskr)
                .perform();
        driver.findElement(By.xpath("//a[text()='Мой профиль']")).click();
    }
}
