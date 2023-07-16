package ru.yandex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class OrderPageTest {

    private WebDriver driver;

    private final String name;
    private final String surname;
    private final String address;
    private final String subwayStation;
    private final String phone;
    private final String date;
    private final String rentDuration;



    public OrderPageTest(String name, String surname, String address, String subwayStation, String phone, String date, String rentDuration ) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phone = phone;
        this.date = date;
        this.rentDuration = rentDuration;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {"Марс" ,"Собакин", "Пушкино, дом Колотушкина 1", "Бибилиотека имени Ленина","99999994546", "05.07.2023", "сутки"},
                {"Леня" ,"Голубков", "Морская, дом 1", "Сокол","89999994546", "05.03.2025", "семеро суток"},

        };
    }

    @Before
    public void openPage() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }


    @Test
    public void placeOrderHeaderButton() {

        OrderPage objFAQPage = new OrderPage(driver);
        objFAQPage.clickOrderButtonHeader();
        objFAQPage.waitForLoad(objFAQPage.nameField);
        objFAQPage.fillFirstPage(name,surname,address,subwayStation,phone);
        objFAQPage.clickNextButtonForm();
        objFAQPage.waitForLoad(objFAQPage.rentDropdown);
        objFAQPage.fillSecondPage(date, rentDuration);
        objFAQPage.clickOrderButtonForm();
        objFAQPage.waitForLoad(objFAQPage.confirmButtonForm);
        objFAQPage.clickConfirmButtonForm();
    }

    @Test
    public void placeOrderHowToButton() {

        OrderPage objFAQPage = new OrderPage(driver);
        objFAQPage.clickOrderButtonHowTo();
        objFAQPage.waitForLoad(objFAQPage.nameField);
        objFAQPage.fillFirstPage(name,surname,address,subwayStation,phone);
        objFAQPage.clickNextButtonForm();
        objFAQPage.waitForLoad(objFAQPage.rentDropdown);
        objFAQPage.fillSecondPage(date, rentDuration);
        objFAQPage.clickOrderButtonForm();
        objFAQPage.waitForLoad(objFAQPage.confirmButtonForm);
        objFAQPage.clickConfirmButtonForm();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}