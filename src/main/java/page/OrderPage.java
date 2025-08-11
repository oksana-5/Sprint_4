package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;
    // Кнопка согласия на использование cookie
    private final By confirmButton = By.xpath(".//button[text()='Да']");
    // Кнопка "Заказать"
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // Поле "Срок аренды"
    private final By numberOfDaysField = By.className("Dropdown-placeholder");
    // Поле "Когда привезти самокат"
    private final By dataField = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    // Кнопка "Далее"
    private final By nextButton = By.xpath(".//button[text()='Далее']");
    // Поле "Телефон: на него позвонит курьер"
    private final By phoneNumberField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    // Поле "Станция метро"
    private final By subwayStationField = By.cssSelector("input[placeholder='* Станция метро']");
    // Выбранная станция метро
    private final By selectedSubwayStation = By.xpath(".//div[@class='select-search__select']");
    // Поле "Адрес: куда привезти заказ"
    private final By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    // Поле "Фамилия"
    private final By surnameField = By.cssSelector("input[placeholder='* Фамилия']");
    // Поле "Имя"
    private final By nameField = By.cssSelector("input[placeholder='* Имя']");
    // Окно успешного оформления заказа
    private final By successfulOrder = By.xpath(".//div[contains(text(), 'Заказ оформлен')]");
    // Поле "Цвет самоката"
    private final String colourCheckboxTemplate = ".//input[@id='%s']";
    // Выбор количества дней
    private final String numberOfDaysOptionTemplate = ".//div[text()='%s']";
    // Выбор даты
    private final String datePickerDayTemplate = ".//div[@aria-label='Choose %s']";



    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void setColour(String colour) {
        By colourLocator = By.xpath(String.format(colourCheckboxTemplate, colour));
        driver.findElement(colourLocator).click();
    }

    public void setNumberOfDays(String numberOfDays) {
        driver.findElement(numberOfDaysField).click();
        By daysLocator = By.xpath(String.format(numberOfDaysOptionTemplate, numberOfDays));
        driver.findElement(daysLocator).click();
    }

    public void setData(String data, String dayOfTheWeekAndData) {
        driver.findElement(dataField).sendKeys(data);
        By dateLocator = By.xpath(String.format(datePickerDayTemplate, dayOfTheWeekAndData));
        driver.findElement(dateLocator).click();
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void setPhoneNumber(String number) {
        driver.findElement(phoneNumberField).sendKeys(number);
    }

    public void setSubwayStation(String subwayStation) {
        driver.findElement(subwayStationField).sendKeys(subwayStation);
        driver.findElement(selectedSubwayStation).click();
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    // имя надо передавать параметром
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public String getSuccessOrderText() {
        return driver.findElement(successfulOrder).getText();
    }
}
