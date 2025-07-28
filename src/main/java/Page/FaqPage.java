package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FaqPage {
    private WebDriver driver;
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    // Кнопка согласия на использование cookie
    private By confirmCookieButton = By.id("rcc-confirm-button");
    // Первый вопрос (Сколько это стоит? И как оплатить?)
    public static final By QUESTION_1 = By.id("accordion__heading-0");
    // Второй вопрос (Хочу сразу несколько самокатов! Так можно?)
    public static final By QUESTION_2 = By.id("accordion__heading-1");
    // Третий вопрос (Как рассчитывается время аренды?)
    public static final By QUESTION_3 = By.id("accordion__heading-2");
    // Четвёртый вопрос (Можно ли заказать самокат прямо на сегодня?)
    public static final By QUESTION_4 = By.id("accordion__heading-3");
    // Пятый вопрос (Можно ли продлить заказ или вернуть самокат раньше?)
    public static final By QUESTION_5 = By.id("accordion__heading-4");
    // Шестой вопрос (Вы привозите зарядку вместе с самокатом?)
    public static final By QUESTION_6 = By.id("accordion__heading-5");
    // Седьмой вопрос (Можно ли отменить заказ?)
    public static final By QUESTION_7 = By.id("accordion__heading-6");
    // Восьмой вопрос (Я жизу за МКАДом, привезёте?)
    public static final By QUESTION_8 = By.id("accordion__heading-7");
    // Ответ на первый вопрос
    public static final By ANSWER_1 = By.id("accordion__panel-0");
    // Ответ на второй вопрос
    public static final By ANSWER_2 = By.id("accordion__panel-1");
    // Ответ на третий вопрос
    public static final By ANSWER_3 = By.id("accordion__panel-2");
    // Ответ на четвёртый вопрос
    public static final By ANSWER_4 = By.id("accordion__panel-3");
    // Ответ на пятый вопрос
    public static final By ANSWER_5 = By.id("accordion__panel-4");
    // Ответ на шестой вопрос
    public static final By ANSWER_6 = By.id("accordion__panel-5");
    // Ответ на седьмой вопрос
    public static final By ANSWER_7 = By.id("accordion__panel-6");
    // Ответ на восьмой вопрос
    public static final By ANSWER_8 = By.id("accordion__panel-7");

    public FaqPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(URL);
    }

    public void clickConfirmCookieButton() {
        driver.findElement(confirmCookieButton).click();
    }

    public void clickQuestion(By questionLocator) {
        driver.findElement(questionLocator).click();
    }

    public String getAnswerText(By answerLocator) {
        WebElement element = driver.findElement(answerLocator);
        String text = element.getText();
        return text;
    }

}
