package pages;

//import org.assertj.*;

import data.EnglishLevelData;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.assertj.*;
import java.time.Duration;
import java.util.NoSuchElementException;

import static org.assertj.core.api.FactoryBasedNavigableIterableAssert.assertThat;


public class AboutMySelfPage extends GeneralPage {

    //////////исходные данные
    private final String nameLat="Vladimir";
    private final String surname="Жириновский";
    private final String surnameLat="Jirinovsky";
    private final String nickName="VVJ";
    private final String birthDay="02.11.1946";
    private final String country="Россия";
    private final String city="Москва";
    private final String englishLevel="ELEMENTARY";
    private final boolean readyToMove=true;
    private final boolean[] jobFormat= new boolean[]{true,true,false};
    /*private String email="oxilqrxobfqlrd@hldrive.com";
    private String phone="+79998887766";*/
    private final String sex="m";
    private final String company="Кремль";
    private final String jobTitle="Депутат";
    private final String[] communicationМethod1= new String[]{"VK","vk.com/test"};
    private final String[] communicationМethod2= new String[]{"OK","ok.com/test"};

    //////////локаторы
    private final String jobFormatFullInpulLocator ="//input[@name='work_schedule' and @value='full']";
    private final String jobFormatFullDivLocator ="//div/label[input[@name='work_schedule' and @value='full']]";
    private final String jobFormatFlexibleInpulLocator ="//input[@name='work_schedule' and @value='flexible']";
    private final String jobFormatFlexibleDivLocator ="//div/label[input[@name='work_schedule' and @value='flexible']]";
    private final String jobFormatRemoteInpulLocator ="//input[@name='work_schedule' and @value='remote']";
    private final String jobFormatRemoteDivLocator ="//div/label[input[@name='work_schedule' and @value='remote']]";
    private final String communicationMethodTypeLocator="div/label/div[contains(text(),'%s')]";
    private final String communicationMethodStringLocator="//div[div/label/div[contains(text(),'%s')]]/input";

    //////////////////////

    public AboutMySelfPage (WebDriver driver){
        super(driver);
    }
    public void addCommunicationMethod(String[] communicationМethod, int i){

        driver.findElement(By.xpath("//div[label/div/span[text()='Способ связи']]")).click();
        WebElement element=driver.findElement(By.xpath(String.format("//div[not(contains(@class,'hide'))]/div/button[@title='%s']",communicationМethod[0])));
        waiters.waitElementVisible(element);
        element.click();
        waiters.waitElementVisible(driver.findElement(By.xpath(String.format("//input[@name='contact-%d-value']",i))));
        cleanAndEnter(By.xpath(String.format("//input[@name='contact-%d-value']",i)),communicationМethod[1]);
        driver.findElement(By.xpath("//button[text()='Добавить']")).click();

    }
    public void updateMySelf() throws NoSuchElementException {
  /*      cleanAndEnter(By.id("id_fname_latin"), nameLat);
        cleanAndEnter(By.id("id_lname"), surname);
        cleanAndEnter(By.id("id_lname_latin"), surnameLat);
        cleanAndEnter(By.id("id_blog_name"), nickName);
        cleanAndEnter(By.name("date_of_birth"),birthDay);
        new Actions(driver).moveToLocation(1500, 500)
                .click()
                .perform();*/

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
        ///выбор страны
  /*      WebElement countryElement = driver.findElement(By.xpath("//div[label/input[@name='country']]"));
        waiters.waitElementVisible(countryElement);
        new Actions(driver).moveToElement(countryElement)
                .build()
                .perform();
        countryElement.click();

        WebElement countryButton =driver.findElement(By.xpath(String.format("//button[@title='%s']",country)));
        waiters.waitElementVisible(countryButton);
        new Actions(driver).moveToElement(countryButton)
                .build()
                .perform();
        countryButton.click();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ////////выбор города
        WebElement cityElement = driver.findElement(By.xpath("//div[label/input[@name='city']]"));
        waiters.waitElementVisible(cityElement);
        cityElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement cityButton = driver.findElement(By.xpath(String.format("//button[@title='%s']",city)));
        waiters.waitElementVisible(cityButton);
        cityButton.click();
    /////////уровень английского
        EnglishLevelData englishLevelData = EnglishLevelData.valueOf(englishLevel);
        WebElement englishLevelElement = driver.findElement(By.xpath("//div[label/input[@name='english_level']]"));
        waiters.waitElementVisible(englishLevelElement);
        englishLevelElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath(String.format("//button[@title='%s']",englishLevelData.getName()))).click();

        //готов к переезду

        if (readyToMove) {
            driver.findElement(By.xpath("//label[input[@id='id_ready_to_relocate_1']]")).click();
        } else {
            driver.findElement(By.xpath("//label[input[@id='id_ready_to_relocate_0']]")).click();
        }
        ////формат работы
        checkStateAndClickCheckbox(jobFormat[0], jobFormatFullInpulLocator, jobFormatFullDivLocator);
        checkStateAndClickCheckbox(jobFormat[1], jobFormatFlexibleInpulLocator, jobFormatFlexibleDivLocator);
        checkStateAndClickCheckbox(jobFormat[2], jobFormatRemoteInpulLocator, jobFormatRemoteDivLocator);*/
        ///добавление контактов
      //  addCommunicationMethod(communicationМethod1,0);
        js.executeScript("window.scrollBy(0,700)");
   //     addCommunicationMethod(communicationМethod2,1);

        ///пол
        //
        //webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("id_gender")));
       /* waiters.waitElementVisible(driver.findElement(By.id("id_gender")));
        driver.findElement(By.xpath(String.format("//option[@value='%s']",sex))).click();
        cleanAndEnter(By.id("id_company"),company);
        cleanAndEnter(By.id("id_work"),jobTitle);*/

            //сoхраняемся
        driver.findElement(By.xpath("//button[@name='continue']")).click();

        }

        public void assertMySelfData(){


            Assertions.assertEquals(nameLat,driver.findElement(By.id("id_fname_latin")).getAttribute("value"),"nameLat is right");
            Assertions.assertEquals(surname,driver.findElement(By.id("id_lname")).getAttribute("value"),"surname is right");
            Assertions.assertEquals(surnameLat,driver.findElement(By.id("id_lname_latin")).getAttribute("value"),"surnameLat is right");
            Assertions.assertEquals(nickName,driver.findElement(By.id("id_blog_name")).getAttribute("value"),"nickName is right");
            Assertions.assertEquals(birthDay,driver.findElement(By.name("date_of_birth")).getAttribute("value"),"birthDay is right");
            Assertions.assertEquals(country,driver.findElement(By.xpath("//label[input[@name='country']]/div")).getText(),"Country is correct");
            Assertions.assertEquals(city,driver.findElement(By.xpath("//label[input[@name='city']]/div")).getText(),"City is correct");
            EnglishLevelData englishLevelData = EnglishLevelData.valueOf(englishLevel);
   //         Assertions.assertEquals(englishLevelData.getName(),driver.findElement(By.xpath("//label[input[@name='english_level']]/div")).getText(),"English level is correct");
            if (readyToMove){
                Assertions.assertTrue(driver.findElement(By.xpath("//label[input[@id='id_ready_to_relocate_1']]")).isEnabled(),"readyToMove is correct");
            } else {Assertions.assertTrue(driver.findElement(By.xpath("//label[input[@id='id_ready_to_relocate_0']]")).isEnabled(),"readyToMove is correct");}

           boolean[] jobFormatActual= new boolean[]{driver.findElement(By.xpath(jobFormatFullInpulLocator)).isSelected(),
                                                             driver.findElement(By.xpath(jobFormatFlexibleInpulLocator)).isSelected(),
                                                             driver.findElement(By.xpath(jobFormatRemoteInpulLocator)).isSelected()
                                                    };
            Assertions.assertArrayEquals(jobFormat,jobFormatActual, "jobFormat is correct");

            Assertions.assertTrue(driver.findElement(By.xpath(String.format(communicationMethodTypeLocator,communicationМethod1[0]))).isDisplayed());
            Assertions.assertEquals(communicationМethod1[1],
                    driver.findElement(By.xpath(String.format(communicationMethodStringLocator,communicationМethod1[0]))));
            Assertions.assertTrue(driver.findElement(By.xpath(String.format(communicationMethodTypeLocator,communicationМethod2[0]))).isDisplayed());
            Assertions.assertEquals(communicationМethod2[1],
                    driver.findElement(By.xpath(String.format(communicationMethodStringLocator,communicationМethod2[0]))));



            Assertions.assertEquals(sex,driver.findElement(By.xpath("//select[@id='id_gender']/option[@selected='']")).getAttribute("value"),"Sex is correct");
            Assertions.assertEquals(company,driver.findElement(By.id("id_company")).getAttribute("value"),"Company is correct");
            Assertions.assertEquals(jobTitle,driver.findElement(By.id("id_work")).getAttribute("value"),"Work is correct");
            SoftAssertions softAssertions = new SoftAssertions();

        }


    }

