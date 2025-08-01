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
    private final By confirmCookieButton = By.id("rcc-confirm-button");
    // Вопрос о стоимости
    private static final By questionAboutPayment = By.id("accordion__heading-0");
    // Вопрос о заказе нескольких самокатов
    private static final By questionAboutMultipleScooters = By.id("accordion__heading-1");
    // Вопрос о рассчете времени аренды
    private static final By questionAboutRentalTimeCalculation = By.id("accordion__heading-2");
    // Вопрос о заказе на сегодня
    private static final By questionAboutTodayOrder = By.id("accordion__heading-3");
    // Вопрос о продлении либо возврате раньше
    private static final By questionAboutExtendOrEarlyReturn = By.id("accordion__heading-4");
    // Вопрос о зарядке
    private static final By questionAboutCharger = By.id("accordion__heading-5");
    // Вопрос об отмене заказа
    private static final By questionAboutOrderCancellation = By.id("accordion__heading-6");
    // Вопрос о заказе за МКАД
    private static final By questionAboutDeliveryOutsideMkad = By.id("accordion__heading-7");
    // Ответ на вопрос о стоимости
    private static final By answerAboutPayment = By.id("accordion__panel-0");
    // Ответ на вопрос о заказе нескольких самокатов
    private static final By answerAboutMultipleScooters = By.id("accordion__panel-1");
    // Ответ на вопрос о рассчете времени аренды
    private static final By answerAboutRentalTimeCalculation = By.id("accordion__panel-2");
    // Ответ на вопрос о заказе на сегодня
    private static final By answerAboutTodayOrder = By.id("accordion__panel-3");
    // Ответ на вопрос о продлении либо возврате раньше
    private static final By answerAboutExtendOrEarlyReturn = By.id("accordion__panel-4");
    // Ответ на вопрос о зарядке
    private static final By answerAboutCharger = By.id("accordion__panel-5");
    // Ответ на вопрос об отмене заказа
    private static final By answerAboutOrderCancellation = By.id("accordion__panel-6");
    // Ответ на вопрос о заказе за МКАД
    private static final By answerAboutDeliveryOutsideMkad = By.id("accordion__panel-7");

    public FaqPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(URL);
    }

    public void clickConfirmCookieButton() {
        driver.findElement(confirmCookieButton).click();
    }

    // Геттеры для вопросов
    public static By getQuestionAboutPayment() {
        return questionAboutPayment;
    }

    public static By getQuestionAboutMultipleScooters() {
        return questionAboutMultipleScooters;
    }

    public static By getQuestionAboutRentalTimeCalculation() {
        return questionAboutRentalTimeCalculation;
    }

    public static By getQuestionAboutTodayOrder() {
        return questionAboutTodayOrder;
    }

    public static By getQuestionAboutExtendOrEarlyReturn() {
        return questionAboutExtendOrEarlyReturn;
    }

    public static By getQuestionAboutCharger() {
        return questionAboutCharger;
    }

    public static By getQuestionAboutOrderCancellation() {
        return questionAboutOrderCancellation;
    }

    public static By getQuestionAboutDeliveryOutsideMkad() {
        return questionAboutDeliveryOutsideMkad;
    }

    // Геттеры для ответов
    public static By getAnswerAboutPayment() {
        return answerAboutPayment;
    }

    public static By getAnswerAboutMultipleScooters() {
        return answerAboutMultipleScooters;
    }

    public static By getAnswerAboutRentalTimeCalculation() {
        return answerAboutRentalTimeCalculation;
    }

    public static By getAnswerAboutTodayOrder() {
        return answerAboutTodayOrder;
    }

    public static By getAnswerAboutExtendOrEarlyReturn() {
        return answerAboutExtendOrEarlyReturn;
    }

    public static By getAnswerAboutCharger() {
        return answerAboutCharger;
    }

    public static By getAnswerAboutOrderCancellation() {
        return answerAboutOrderCancellation;
    }

    public static By getAnswerAboutDeliveryOutsideMkad() {
        return answerAboutDeliveryOutsideMkad;
    }

    public void clickQuestion(By questionLocator) {
        driver.findElement(questionLocator).click();
    }

    public String getAnswerText(By answerLocator) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(answerLocator));
        String text = element.getText();
        return text;
    }

}
