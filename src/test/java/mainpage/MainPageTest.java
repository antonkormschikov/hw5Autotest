package mainpage;

import factory.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import waiters.Waiters;

import javax.swing.*;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;


public class MainPageTest {
Logger logger = Logger.getLogger("");

    private final String BASE_URL=System.getProperty("base.url","https://otus.ru");
    private final String LOGIN="oxilqrxobfqlrd@hldrive.com";//System.getProperty("login");
    private final String PASSWORD="Opera-324";//System.getProperty("password");

    private WebDriver driver;
    private Waiters waiters;

   // Шаги теста:
//    Открыть https://otus.ru
  //  Авторизоваться на сайте
    //Войти в личный кабинет
    //В разделе "О себе" заполнить все поля "Личные данные" и добавить не менее двух контактов
    //Нажать сохранить
    //Открыть https://otus.ru в "чистом браузере"
    //Авторизоваться на сайе
    //Войти в личный кабинет
    //Проверить, что в разделе "О себе" отображаются указанные ранее данные
    //Домашнее задание принимается в виде ссылки на GitHub репозиторий
    public void loginOtus(String login, String password){
        driver.findElement(new By.ByXPath("//button[text()='Войти']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement loginInput = driver.findElement(new By.ByXPath("//input[@name='email']"));
        //loginInput.click();
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginInput.clear();
        loginInput.sendKeys(login);
        WebElement passInput = driver.findElement(new By.ByXPath("//input[@type='password']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      //  passInput.click();
        passInput.clear();
        passInput.sendKeys(password);
        driver.findElement(new By.ByXPath("//button/div[text()='Войти']")).click();
    }
    public void entryLkOtus(){
        WebElement raskr= driver.findElement(new By.ByXPath("//div[@data-name='user-info' and @style='']"));
        new Actions(driver).moveToElement(raskr)
                           .perform();

        driver.findElement(new By.ByXPath("//a[@href(text(),'Личный кабинет')]"));
    }



    @BeforeAll
    public static void manager(){
    //if (BROWSER_NAME.equals("chrome")) {
           WebDriverManager.chromedriver().setup();
    //} else if (BROWSER_NAME.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
        }



    @BeforeEach
    public void init(){

        this.driver= new WebDriverFactory().create();
        this.waiters = new Waiters(driver);
    }

    @AfterEach
    public void close(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void openingMainPage(){
        driver.get(BASE_URL+"/");
        loginOtus(LOGIN,PASSWORD);

        entryLkOtus();
        ////h2[text()='Авторские онлайн‑курсы для профессионалов']/ancestor::section/div
        ////div[./h2[text()='Авторские онлайн‑курсы для профессионалов']]
     /*   WebElement header= driver.findElement(By.xpath("//div[./h2[text()='Авторские онлайн‑курсы для профессионалов']]"));
        assertThat(waiters.waitElementVisible(header))
                .as("Header with text should be visible")
                .isTrue();*/


    }

}
