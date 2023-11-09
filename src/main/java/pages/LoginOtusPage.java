package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.AbsPageObject;
import waiters.Waiters;


public class LoginOtusPage extends GeneralPage {
    private final String LOGIN="oxilqrxobfqlrd@hldrive.com";//System.getProperty("login");
    private final String PASSWORD="Opera-324";//System.getProperty("password");

    public LoginOtusPage(WebDriver driver) {
        super(driver);
    }


    public void loginOtus() {
        driver.findElement(By.xpath("//button[text()='Войти']")).click();
        new LoginOtusPage(driver).cleanAndEnter(By.xpath("//div/input[@name='email']"),LOGIN);
        new LoginOtusPage(driver).cleanAndEnter(By.xpath("//input[@type='password']"),PASSWORD);
        driver.findElement(By.xpath("//button/div[text()='Войти']")).click();
    }

}
