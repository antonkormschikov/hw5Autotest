package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.AbsPageObject;
import waiters.Waiters;


public class LoginOtusPage extends GeneralPage {
    private final String LOGIN="oxilqrxobfqlrd@hldrive.com";//System.getProperty("login");
    private final String PASSWORD="Opera-324";//System.getProperty("password");
    private String enterButtonLocator="//button[text()='Войти']";
    private String inputEmailLocator="//div/input[@name='email']";
    private String inputPassLocator="//input[@type='password']";
    private String enterButtonLocator2= "//button/div[text()='Войти']";

    public LoginOtusPage(WebDriver driver) {
        super(driver);
    }


    public void loginOtus() {
        driver.findElement(By.xpath(enterButtonLocator)).click();
        cleanAndEnter(By.xpath(inputEmailLocator),LOGIN);
        cleanAndEnter(By.xpath(inputPassLocator),PASSWORD);
        driver.findElement(By.xpath(enterButtonLocator2)).click();

    }

}
