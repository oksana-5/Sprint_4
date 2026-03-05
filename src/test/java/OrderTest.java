import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String subwayStation;
    private final String phoneNumber;
    private final String data;
    private final String dayOfTheWeekAndData;
    private final String numberOfDays;
    private final String colour;

    public OrderTest(
            String name,
            String surname,
            String address,
            String subwayStation,
            String phoneNumber,
            String data,
            String dayOfTheWeekAndData,
            String numberOfDays,
            String colour
    ) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phoneNumber = phoneNumber;
        this.data = data;
        this.dayOfTheWeekAndData = dayOfTheWeekAndData;
        this.numberOfDays = numberOfDays;
        this.colour = colour;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {
                        "Гарри",
                        "Поттер",
                        "Тисовая улица, 4",
                        "Верхние котлы",
                        "+77777777777",
                        "31.07.2025",
                        "четверг, 31-е июля 2025 г.",
                        "семеро суток",
                        "grey"
                },
                {
                        "Джинни",
                        "Уизли",
                        "Нора, 7",
                        "Верхние котлы",
                        "+77777777777",
                        "11.08.2025",
                        "понедельник, 11-е августа 2025 г.",
                        "трое суток",
                        "black"
                },
        };
    }

    @Test
    @DisplayName("Тест проверяет оформление заказа при нажатии на первую кнопку оформления заказа")
    public void orderWithFirstOrderButtonTest() {
        mainPage.openPage()
                .clickConfirmCookieButton()
                .clickFirstOrderButton();
        orderPage.setName(name)
                .setSurname(surname)
                .setAddress(address)
                .setSubwayStation(subwayStation)
                .setPhoneNumber(phoneNumber)
                .clickNextButton()
                .setData(data, dayOfTheWeekAndData)
                .setNumberOfDays(numberOfDays)
                .setColour(colour)
                .clickOrderButton()
                .clickConfirmButton();
        assertTrue("Заказ не оформился", orderPage.getSuccessOrderText().contains("Хотите оформить заказ"));
    }

    @Test
    @DisplayName("Тест проверяет оформление заказа при нажатии на вторую кнопку оформления заказа")
    public void orderWithSecondOrderButtonTest() {
        mainPage.openPage()
                .clickConfirmCookieButton()
                .clickSecondOrderButton();
        orderPage.setName(name)
                .setSurname(surname)
                .setAddress(address)
                .setSubwayStation(subwayStation)
                .setPhoneNumber(phoneNumber)
                .clickNextButton()
                .setData(data, dayOfTheWeekAndData)
                .setNumberOfDays(numberOfDays)
                .setColour(colour)
                .clickOrderButton()
                .clickConfirmButton();
        assertTrue("Заказ не оформился", orderPage.getSuccessOrderText().contains("Хотите оформить заказ"));
    }
}

