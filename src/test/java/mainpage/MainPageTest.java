package mainpage;

import data.ICityData;
import factory.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AboutMySelfPage;
import pages.AccountPage;
import pages.LoginOtusPage;
import waiters.Waiters;

import javax.swing.*;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.filter;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;


public class MainPageTest {
Logger logger = Logger.getLogger("");

    private final String BASE_URL=System.getProperty("base.url","https://otus.ru");
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
    //Домашнее задание принимается
    // в виде ссылки на GitHub репозиторий


    public void  selectCity (ICityData cityData){
        String locatorCountry = String.format("//div[@title='$s']",cityData.getCountryData().getName());

        //select

        String locatorCity = String.format("//div[@title='$s']",cityData.getName());
    //select

    }









    @BeforeAll
    public static void manager(){

           WebDriverManager.chromedriver().setup();
         //  WebDriverManager.firefoxdriver().setup();
        }



    @BeforeEach
    public void init(){

        driver = new WebDriverFactory().create();
        this.waiters = new Waiters(driver);
    }

    @AfterEach
    public void close(){
        if (driver != null) {
         //   driver.close();
            driver.quit();
        }
    }

    @Test
    public void openingMainPage(){
        driver.get(BASE_URL+"/");
       // driver.manage().window().maximize();
        new LoginOtusPage(driver)
                .loginOtus();//авторизация
        new AccountPage(driver).
                entryLkOtus();//вход в личный кабинет
        new AboutMySelfPage(driver)
                .updateMySelf(); //Обновление данных о себе

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ////h2[text()='Авторские онлайн‑курсы для профессионалов']/ancestor::section/div
        ////div[./h2[text()='Авторские онлайн‑курсы для профессионалов']]
     /*   WebElement header= driver.findElement(By.xpath("//div[./h2[text()='Авторские онлайн‑курсы для профессионалов']]"));
        assertThat(waiters.waitElementVisible(header))
                .as("Header with text should be visible")
                .isTrue();*/


    }

}
