package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobject.AbsPageObject;
import waiters.Waiters;


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
    private int[] jobFormat= new int[]{1,1,1};
    private String email="oxilqrxobfqlrd@hldrive.com";
    private String phone="+79998887766";
    private String sex="Мужской";
    private String company="Кремль";
    private String jobTitle="Депутат";

    public AboutMySelfPage (WebDriver driver){
        super(driver);
    }
    public void updateMySelf(){
        new AboutMySelfPage(driver).cleanAndEnter(By.id("id_fname_latin"),nameLat);
        new AboutMySelfPage(driver).cleanAndEnter(By.id("id_lname"),surname);
        new AboutMySelfPage(driver).cleanAndEnter(By.id("id_lname_latin"),surnameLat);
        new AboutMySelfPage(driver).cleanAndEnter(By.id("id_blog_name"),nickName);

        //cleanAndEnter(By.name("date_of_birth"),birthDay);
        WebElement dob = driver.findElement(By.name("date_of_birth"));
        dob.clear();
        dob.sendKeys(birthDay);
        new Actions(driver).moveToLocation(1500,500)
                .click()
                .perform();


        driver.findElement(By.xpath("//div[@name='country']")).click();
        //waiters.waitElementVisible(countryElement);
       /* new Actions(driver).moveToElement(countryElement).build()
                        .perform();
        countryElement.click();*/
       // waiters.waitElementVisible(driver.findElement(By.xpath(String.format("//button[@title=%s]",country))));
        driver.findElement(By.xpath(String.format("//button[@title=%s]",country))).click();

        //  driver.findElement(By.cssSelector("js-lk-cv-dependent-master")).click();

        /*driver.findElement(By.xpath("//input[@name='city']")).click();
        driver.findElement(By.xpath("//button[@title='"+city+"']")).click();

        driver.findElement(By.xpath("//input[@name='english_level']")).click();
        driver.findElement(By.xpath("//button[@title='"+englishLevel+"']")).click();

        driver.findElement(By.xpath("//button[@name='continue']")).click();*/

    }



}
