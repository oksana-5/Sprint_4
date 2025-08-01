import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static page.FaqPage.*;

@RunWith(Parameterized.class)
public class FaqTest extends BaseTest {
    private final By question;
    private final By answer;
    private final String expectedAnswer;

    public FaqTest(By question, By answer, String expectedAnswer) {
        this.question = question;
        this.answer = answer;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {getQuestionAboutPayment(), getAnswerAboutPayment(), "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {getQuestionAboutMultipleScooters(), getAnswerAboutMultipleScooters(), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {getQuestionAboutRentalTimeCalculation(), getAnswerAboutRentalTimeCalculation(), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {getQuestionAboutTodayOrder(), getAnswerAboutTodayOrder(), "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {getQuestionAboutExtendOrEarlyReturn(), getAnswerAboutExtendOrEarlyReturn(), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {getQuestionAboutCharger(), getAnswerAboutCharger(), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {getQuestionAboutOrderCancellation(), getAnswerAboutOrderCancellation(), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {getQuestionAboutDeliveryOutsideMkad(), getAnswerAboutDeliveryOutsideMkad(), "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void faqTest() {
        faqPage.openPage();
        faqPage.clickConfirmCookieButton();
        faqPage.clickQuestion(question);
        String answerText = faqPage.getAnswerText(answer);
        assertEquals("Текст ответа неверный", expectedAnswer, answerText);
    }
}

