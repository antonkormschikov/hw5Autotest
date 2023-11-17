package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.AbsPageObject;
import waiters.Waiters;


public class LoginOtusPage extends GeneralPage {
    private static final Logger logger = (Logger) LogManager.getLogger(LoginOtusPage.class);
    private final String LOGIN=System.getProperty("login");
    private final String PASSWORD=System.getProperty("password");
    private String enterButtonLocator="//button[text()='Войти']";
    private String inputEmailLocator="//div/input[@name='email']";
    private String inputPassLocator="//input[@type='password']";
    private String enterButtonLocator2= "//button/div[text()='Войти']";

    public LoginOtusPage(WebDriver driver) {
        super(driver);
    }


    public void loginOtus() {
        logger.info("----Login OTUS----");
        try {
            driver.findElement(By.xpath(enterButtonLocator)).click();
            cleanAndEnter(By.xpath(inputEmailLocator), LOGIN);
            cleanAndEnter(By.xpath(inputPassLocator), PASSWORD);
            driver.findElement(By.xpath(enterButtonLocator2)).click();
        } catch (Exception e){logger.info(e.getMessage());}
    }

}
