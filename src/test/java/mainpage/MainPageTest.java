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

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.filter;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;


public class MainPageTest {
Logger logger = Logger.getLogger("");

    private final String BASE_URL=System.getProperty("base.url","https://otus.ru");
    private final String LOGIN="oxilqrxobfqlrd@hldrive.com";//System.getProperty("login");
    private final String PASSWORD="Opera-324";//System.getProperty("password");

    private String nameLat="Vladimir";
    private String surname="Жириновский";
    private String surnameLat="Jirinovsky";
    private String nickName="VVJ";
    private String birthDay="02.11.1946";
    private String country="Россия";
    private String city="Москва";
    private String englishLevel="Начальный уровень (Beginner)";
    private String readyToMove="Нет";
    private int[] jobFormat= new int[]{1,1,1};
    private String email="oxilqrxobfqlrd@hldrive.com";
    private String phone="+79998887766";
    private String sex="Мужской";
    private String company="Кремль";
    private String jobTitle="Депутат";


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
    public void cleanAndEnter(By by,String sendedKey){
        WebElement element = driver.findElement(by);
     //   waiters.waitElementVisible(element);
        new Actions(driver).moveToElement(element)
                .click()
                .perform();
        waiters.waitElementVisible(element);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        element.clear();
        element.sendKeys(sendedKey);
    }

    public void loginOtus(String login, String password) {
        driver.findElement(By.xpath("//button[text()='Войти']")).click();
        cleanAndEnter(By.xpath("//div/input[@name='email']"),login);
        cleanAndEnter(By.xpath("//input[@type='password']"),password);
        driver.findElement(By.xpath("//button/div[text()='Войти']")).click();
    }

    public void entryLkOtus(){
        //waiters.waitElementVisible(driver.findElement(By.cssSelector(".sc-199a3eq-0")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     //  waiters.waitElementVisible(driver.findElement(By.xpath("//div[span[text()='Владимир']]")));
        WebElement raskr= driver.findElement(By.xpath("//div[span[text()='Владимир']]"));
      //  WebElement raskr= driver.findElement(By.cssSelector(".sc-199a3eq-0"));
        waiters.waitElementVisible(raskr);
        new Actions(driver).moveToElement(raskr)
                           .perform();

        waiters.waitElementVisible(driver.findElement(By.xpath("//a[text()='Личный кабинет']")));
            driver.findElement(By.xpath("//a[text()='Мой профиль']")).click();




    }
    public void updateMySelf(){
        cleanAndEnter(By.id("id_fname_latin"),nameLat);
        cleanAndEnter(By.id("id_lname"),surname);
        cleanAndEnter(By.id("id_lname_latin"),surnameLat);
        cleanAndEnter(By.id("id_blog_name"),nickName);

       //cleanAndEnter(By.name("date_of_birth"),birthDay);
       WebElement dob = driver.findElement(By.name("date_of_birth"));
       dob.clear();
       dob.sendKeys(birthDay);
       new Actions(driver).moveToLocation(1500,500)
                           .click()
                           .perform();


        WebElement countryElement=driver.findElement(By.xpath("//label/input[@name='country']"));
        waiters.waitElementVisible(countryElement);
        new Actions(driver).moveToElement(countryElement).build()
                        .perform();
        countryElement.click();

      driver.findElement(By.xpath(String.format("//button[@title=%s]",country)));

      //  driver.findElement(By.cssSelector("js-lk-cv-dependent-master")).click();

        /*driver.findElement(By.xpath("//input[@name='city']")).click();
        driver.findElement(By.xpath("//button[@title='"+city+"']")).click();

        driver.findElement(By.xpath("//input[@name='english_level']")).click();
        driver.findElement(By.xpath("//button[@title='"+englishLevel+"']")).click();

        driver.findElement(By.xpath("//button[@name='continue']")).click();*/

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

            loginOtus(LOGIN,PASSWORD);//авторизация
            entryLkOtus();//вход в личный кабинет
            updateMySelf();
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
