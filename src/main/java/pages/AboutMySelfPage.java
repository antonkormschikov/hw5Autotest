package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pageobject.AbsPageObject;
import waiters.Waiters;

import java.time.Duration;


public class AboutMySelfPage extends GeneralPage {
    private String nameLat="Vladimir";
    private String surname="Жириновский";
    private String surnameLat="Jirinovsky";
    private String nickName="VVJ";
    private String birthDay="02.11.1946";
    private String country="Россия";
    private String city="Москва";
    private String englishLevel="Начальный уровень (Beginner)";
    private String readyToMove="Нет";
    private int[] jobFormat= new int[]{0,0,0};
    private String email="oxilqrxobfqlrd@hldrive.com";
    private String phone="+79998887766";
    private String sex="Мужской";
    private String company="Кремль";
    private String jobTitle="Депутат";

    public AboutMySelfPage (WebDriver driver){
        super(driver);
    }
    public void updateMySelf() throws InterruptedException {
        new AboutMySelfPage(driver).cleanAndEnter(By.id("id_fname_latin"), nameLat);
        new AboutMySelfPage(driver).cleanAndEnter(By.id("id_lname"), surname);
        new AboutMySelfPage(driver).cleanAndEnter(By.id("id_lname_latin"), surnameLat);
        new AboutMySelfPage(driver).cleanAndEnter(By.id("id_blog_name"), nickName);

        //cleanAndEnter(By.name("date_of_birth"),birthDay);
        WebElement dob = driver.findElement(By.name("date_of_birth"));
        dob.clear();
        dob.sendKeys(birthDay);
        new Actions(driver).moveToLocation(1500, 500)
                .click()
                .perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;


        js.executeScript("window.scrollBy(0,700)");
/*
        WebElement countryElement = driver.findElement(By.xpath("//div[label/input[@name='country']]"));
        waiters.waitElementVisible(countryElement);
        new Actions(driver).moveToElement(countryElement)
                .build()
                .perform();
        countryElement.click();
       // waiters.waitElementVisible(driver.findElement(By.xpath(String.format("//button[@title=%s]",country))));
        driver.findElement(By.xpath(String.format("//button[@title='%s']",country))).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement cityElement = driver.findElement(By.xpath("//div[label/input[@name='city']]"));
        waiters.waitElementVisible(cityElement);
        cityElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement cityButton = driver.findElement(By.xpath(String.format("//button[@title='%s']",city)));
        waiters.waitElementVisible(cityButton);
        cityButton.click();

        WebElement englishLevelElement = driver.findElement(By.xpath("//div[label/input[@name='english_level']]"));
        waiters.waitElementVisible(englishLevelElement);
        englishLevelElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@title='"+englishLevel+"']")).click();*/

        //готов к переезду

      /*  driver.findElement(By.xpath(String.format("//label[span[text()=%s]]", "" + readyToMove + "")));
        if (readyToMove.equals("Нет")) {
            driver.findElement(By.xpath("//label[input[@name='ready_to_relocate and @value='false']]"));
        }
        if (readyToMove.equals("Да")) {
            driver.findElement(By.xpath("//label[input[@name='ready_to_relocate and @value='True']]"));
        }*/

        if (jobFormat[0] == 1) {
            if (!driver.findElement(By.xpath("//div/label[input[@name='work_schedule' and @value='full']]")).isEnabled()) {
                driver.findElement(By.xpath("//div/label[input[@name='work_schedule' and @value='full']]")).click();
            }
        } else if (jobFormat[0]==0){
            if (driver.findElement(By.xpath("//div/label[input[@name='work_schedule' and @value='full']]")).isEnabled()) {
                driver.findElement(By.xpath("//div/label[input[@name='work_schedule' and @value='full']]")).click();
            }
        }
        if (jobFormat[1] == 1) {
            if (!driver.findElement(By.xpath("//div/label[input[@name='work_schedule' and @value='flexible']]")).isEnabled()) {
                driver.findElement(By.xpath("//div/label[input[@name='work_schedule' and @value='flexible']]")).click();
            }
        } else if (jobFormat[1]==0){
            if (driver.findElement(By.xpath("//div/label[input[@name='work_schedule' and @value='flexible']]")).isEnabled()) {
                driver.findElement(By.xpath("//div/label[input[@name='work_schedule' and @value='flexible']]")).click();
            }
        }
        if (jobFormat[2] == 1) {
            if (!driver.findElement(By.xpath("//div/label[input[@name='work_schedule' and @value='remote']]")).isEnabled()) {
                driver.findElement(By.xpath("//div/label[input[@name='work_schedule' and @value='remote']]")).click();
            }
        } else if (jobFormat[2]==0){
            if (driver.findElement(By.xpath("//div/label[input[@name='work_schedule' and @value='remote']]")).isEnabled()) {
                driver.findElement(By.xpath("//div/label[input[@name='work_schedule' and @value='remote']]")).click();
            }
        }


            driver.findElement(By.xpath("//button[@name='continue']")).click();

        }


    }

