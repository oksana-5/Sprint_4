package Page;

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

    public void openPage() {
        driver.get(URL);
    }

    public void clickConfirmCookieButton() {
        driver.findElement(confirmCookieButton).click();
    }

    public void clickFirstOrderButton() {
        driver.findElement(firstOrderButton).click();
    }

    public void clickSecondOrderButton() {
        driver.findElement(secondOrderButton).click();
    }
}

