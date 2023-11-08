package pageobject;

import org.openqa.selenium.WebDriver;
import waiters.Waiters;

public class AbsPageObject {
    protected WebDriver driver;
    protected Waiters waiters;


    public AbsPageObject(WebDriver driver, Waiters waiters) {
        this.driver = driver;
        this.waiters = waiters;
    }
}
