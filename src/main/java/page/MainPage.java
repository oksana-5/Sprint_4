package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private WebDriver driver;
    // Кнопка согласия на использование cookie
    private By confirmCookieButton = By.id("rcc-confirm-button");
    // Первая кнопка "Заказать"
    private By firstOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    // Вторая кнопка "Заказать"
    private By secondOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открываем страницу")
    public MainPage openPage() {
        driver.get(URL);
        return this;
    }

    @Step("Нажимаем на кнопку согласия с использованием cookies")
    public MainPage clickConfirmCookieButton() {
        driver.findElement(confirmCookieButton).click();
        return this;
    }

    @Step("Нажимаем на первую кнопку оформления заказа")
    public MainPage clickFirstOrderButton() {
        driver.findElement(firstOrderButton).click();
        return this;
    }

    @Step("Нажимаем на вторую кнопку оформления заказа")
    public MainPage clickSecondOrderButton() {
        driver.findElement(secondOrderButton).click();
        return this;
    }
}

