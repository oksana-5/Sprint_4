package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FaqPage {
    private WebDriver driver;
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    // Кнопка согласия на использование cookie
    private final By CONFIRM_COOKIE_BUTTON = By.id("rcc-confirm-button");
    // Локаторы вопросов и ответов
    private final String QUESTION_LOCATOR = "accordion__heading-%d";
    private final String ANSWER_LOCATOR = "accordion__panel-%d";

    public FaqPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(URL);
    }

    public void clickConfirmCookieButton() {
        driver.findElement(CONFIRM_COOKIE_BUTTON).click();
    }

    public void clickQuestion(int questionIndex) {
        By questionLocator = By.id(String.format(QUESTION_LOCATOR, questionIndex));
        driver.findElement(questionLocator).click();
    }

    public String getQuestionText(int questionIndex) {
        By questionLocator = By.id(String.format(QUESTION_LOCATOR, questionIndex));
        return driver.findElement(questionLocator).getText();
    }

    public String getAnswerText(int answerIndex) {
        By answerLocator = By.id(String.format(ANSWER_LOCATOR, answerIndex));
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(answerLocator));
        return element.getText();
    }

}
