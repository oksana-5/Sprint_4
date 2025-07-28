package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private WebDriver driver;
    // Кнопка согласия на использование cookie
    private By confirmButton = By.xpath(".//button[text()='Да']");
    // Кнопка "Заказать"
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // Поле "Срок аренды"
    private By numberOfDausField = By.className("Dropdown-placeholder");
    // Поле "Когда привезти самокат"
    private By dataField = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    // Кнопка "Далее"
    private By nextButton = By.xpath(".//button[text()='Далее']");
    // Поле "Телефон: на него позвонит курьер"
    private By phoneNumberField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    // Поле "Станция метро"
    private By subwayStationField = By.cssSelector("input[placeholder='* Станция метро']");
    // Выбранная станция метро
    private By selectedSubwayStation = By.xpath(".//div[@class='select-search__select']");
    // Поле "Адрес: куда привезти заказ"
    private By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    // Поле "Фамилия"
    private By surnameField = By.cssSelector("input[placeholder='* Фамилия']");
    // Поле "Имя"
    private By nameField = By.cssSelector("input[placeholder='* Имя']");
    // Окно успешного оформления заказа
    private By successfulOrder = By.xpath(".//div[contains(text(), 'Заказ оформлен')]");


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
        By colourField = By.xpath(".//input[@id='" + colour + "']");
        driver.findElement(colourField).click();
    }

    public void setNumberOfDays(String numberOfDays) {
        driver.findElement(numberOfDausField).click();
        By sevenDaysDropDown = By.xpath(".//div[text()='" + numberOfDays + "']");
        driver.findElement(sevenDaysDropDown).click();
    }

    public void setData(String data, String dayOfTheWeekAndData) {
        driver.findElement(dataField).sendKeys(data);
        By dataAndDayOfTheWeek = By.xpath(".//div[@aria-label='Choose " + dayOfTheWeekAndData + "']");
        driver.findElement(dataAndDayOfTheWeek).click();
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

    public WebElement getWebElement() {
        return driver.findElement(successfulOrder);
    }
}
