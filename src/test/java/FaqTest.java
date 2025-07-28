import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import static Page.FaqPage.*;
import static org.junit.Assert.assertEquals;

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
                {QUESTION_1, ANSWER_1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {QUESTION_2, ANSWER_2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {QUESTION_3, ANSWER_3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {QUESTION_4, ANSWER_4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {QUESTION_5, ANSWER_5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {QUESTION_6, ANSWER_6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {QUESTION_7, ANSWER_7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {QUESTION_8, ANSWER_8, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void FaqTest() {
        faqPage.openPage();
        faqPage.clickConfirmCookieButton();
        faqPage.clickQuestion(question);
        String answerText = faqPage.getAnswerText(answer);
        assertEquals("Текст ответа неверный", expectedAnswer, answerText);
    }
}

