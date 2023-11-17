package mainpage;

import data.ICityData;
import factory.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.AboutMySelfPage;
import pages.AccountPage;
import pages.LoginOtusPage;
import waiters.Waiters;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.LogManager;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.filter;


public class UpdateAboutMySelfInfo_Test {
private static final Logger logger = (Logger) LogManager.getLogger(UpdateAboutMySelfInfo_Test.class);

   
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
           WebDriverManager.firefoxdriver().setup();
        }



    @BeforeEach
    public void init(){

        driver = new WebDriverFactory().create();
        this.waiters = new Waiters(driver);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void close(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void checkUpdateInfo() throws InterruptedException {
        
        driver.manage().window().maximize();

        new LoginOtusPage(driver).openPage("/"); //переход на главную страницу
        new LoginOtusPage(driver).loginOtus();//авторизация
        new AccountPage(driver).entryLkOtus();//вход в личный кабинет
        new AboutMySelfPage(driver).updateMySelf(); //Обновление данных о себе
        close();//закрываем браузер
        init();//открываем браузер снова
        new LoginOtusPage(driver).openPage("/");//переход на главную страницу
        new LoginOtusPage(driver).loginOtus();//авторизация
        new AccountPage(driver).entryLkOtus();//вход в личный кабинет
        new AboutMySelfPage(driver).assertMySelfData();

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

     }

}
