package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;
    private final By confirmButton = By.xpath(".//button[text()='Да']");
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By numberOfDaysField = By.className("Dropdown-placeholder");
    private final By dataField = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    private final By nextButton = By.xpath(".//button[text()='Далее']");
    private final By phoneNumberField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    private final By subwayStationField = By.cssSelector("input[placeholder='* Станция метро']");
    private final By selectedSubwayStation = By.xpath(".//div[@class='select-search__select']");
    private final By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    private final By surnameField = By.cssSelector("input[placeholder='* Фамилия']");
    private final By nameField = By.cssSelector("input[placeholder='* Имя']");
    private final By successfulOrder = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    private final String colourCheckboxTemplate = ".//input[@id='%s']";
    private final String numberOfDaysOptionTemplate = ".//div[text()='%s']";
    private final String datePickerDayTemplate = ".//div[@aria-label='Choose %s']";



    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажимаем на кнопку согласия с использованием cookies")
    public OrderPage clickConfirmButton() {
        driver.findElement(confirmButton).click();
        return this;
    }

    @Step("Нажимаем на кнопку оформления заказа")
    public OrderPage clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

    @Step("Выбираем цвет")
    public OrderPage setColour(String colour) {
        By colourLocator = By.xpath(String.format(colourCheckboxTemplate, colour));
        driver.findElement(colourLocator).click();
        return this;
    }

    @Step("Выбираем количество дней")
    public OrderPage setNumberOfDays(String numberOfDays) {
        driver.findElement(numberOfDaysField).click();
        By daysLocator = By.xpath(String.format(numberOfDaysOptionTemplate, numberOfDays));
        driver.findElement(daysLocator).click();
        return this;
    }

    @Step("Выбираем дату")
    public OrderPage setData(String data, String dayOfTheWeekAndData) {
        driver.findElement(dataField).sendKeys(data);
        By dateLocator = By.xpath(String.format(datePickerDayTemplate, dayOfTheWeekAndData));
        driver.findElement(dateLocator).click();
        return this;
    }

    @Step("Нажимаем на кнопку Далее")
    public OrderPage clickNextButton() {
        driver.findElement(nextButton).click();
        return this;
    }

    @Step("Вводим номер телефона")
    public OrderPage setPhoneNumber(String number) {
        driver.findElement(phoneNumberField).sendKeys(number);
        return this;
    }

    @Step("выбираем станцию метро")
    public OrderPage setSubwayStation(String subwayStation) {
        driver.findElement(subwayStationField).sendKeys(subwayStation);
        driver.findElement(selectedSubwayStation).click();
        return this;
    }

    @Step("Вводим адрес")
    public OrderPage setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
        return this;
    }

    @Step("Вводим фамилию")
    public OrderPage setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
        return this;
    }

    @Step("Вводим имя")
    public OrderPage setName(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    @Step("Получаем текст сообщения об успешном заказе")
    public String getSuccessOrderText() {
        return driver.findElement(successfulOrder).getText();
    }
}
