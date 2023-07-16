package ru.yandex;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;



class OrderPage {
    private WebDriver driver;
    OrderPage(WebDriver driver){
        this.driver = driver;
    }

    //Поле ввода Имени
    By nameField = By.cssSelector("[placeholder='* Имя']");

    //Поле ввода Фамилии
    By surnameField = By.cssSelector("[placeholder='* Фамилия']");

    //Поле ввода Адреса
    By addressField = By.cssSelector("[placeholder='* Адрес: куда привезти заказ']") ;

    //Поле ввода Названия станции метро
    By subwayStationField = By.cssSelector("[placeholder='* Станция метро']");

    //Поле ввода телефона
    By phoneField  = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка Далее
    By nextButtonForm = By.cssSelector(".Button_Middle__1CSJM");

    //Поле выбора даты
    By dateField = By.cssSelector("[placeholder='* Когда привезти самокат']");

    //Поле выбора даты
    By rentDropdown = By.cssSelector(".Dropdown-placeholder") ;

    //Выпадающее меню со вариантами длительности аренды
    By dateDropdownMenu  = By.cssSelector(".Dropdown-menu") ;

    //Кнопка заказа на странице, внезапно, заказа
    By orderButtonForm = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Кнопка подтверждения заказа на модальном окне
    By confirmButtonForm = By.xpath("//button[.='Да']");

    public void clickOrderButtonHeader() {
        driver.findElement(HomeFAQPage.orderButtonHeader).click();
    }

    public void clickOrderButtonHowTo() {
        WebElement element = driver.findElement(HomeFAQPage.orderButtonHowTo);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(HomeFAQPage.orderButtonHowTo).click();
    }
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    public void setSubwayStation(String station) {
        driver.findElement(subwayStationField).sendKeys(station);
        driver.findElement(By.className("select-search__select")).click();

    }

    public void setPhone(String phoneNumber) {
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }

    public void clickNextButtonForm() {
        driver.findElement(nextButtonForm).click();
    }

    public void setDate(String date) {
        driver.findElement(dateField).sendKeys(date);

    }

    public void setRentDurationPicker(String rentDuration) {
        driver.findElement(rentDropdown).click();
        waitForLoad(dateDropdownMenu);
        driver.findElement(By.xpath("//div[text()=" + '"' + rentDuration  + "\"]")).click();

    }

    public void clickOrderButtonForm() {
        driver.findElement(orderButtonForm).click();
    }

    public void clickConfirmButtonForm() {
        driver.findElement(confirmButtonForm).click();
    }

    public void waitForLoad(By fieldToAppear) {

        new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(fieldToAppear));
    }

    public void fillFirstPage(String name, String surname,String address, String subwayStation, String phone ){
        setName(name);
        setSurname(surname);
        setAddress(address);
        setSubwayStation(subwayStation);
        setPhone(phone);

    }

    public void fillSecondPage(String date, String duration ){
        setDate(date);
        driver.findElement(dateField).sendKeys(Keys.RETURN);
        setRentDurationPicker(duration);
    }





}





