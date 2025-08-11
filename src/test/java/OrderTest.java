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
    public void orderWithFirstOrderButtonTest() {
        mainPage.openPage();
        mainPage.clickConfirmCookieButton();
        mainPage.clickFirstOrderButton();
        orderPage.setName(name);
        orderPage.setSurname(surname);
        orderPage.setAddress(address);
        orderPage.setSubwayStation(subwayStation);
        orderPage.setPhoneNumber(phoneNumber);
        orderPage.clickNextButton();
        orderPage.setData(data, dayOfTheWeekAndData);
        orderPage.setNumberOfDays(numberOfDays);
        orderPage.setColour(colour);
        orderPage.clickOrderButton();
        orderPage.clickConfirmButton();
        assertTrue("Заказ не оформился", orderPage.getSuccessOrderText().contains("Заказ оформлен"));
    }

    @Test
    public void orderWithSecondOrderButtonTest() {
        mainPage.openPage();
        mainPage.clickConfirmCookieButton();
        mainPage.clickSecondOrderButton();
        orderPage.setName(name);
        orderPage.setSurname(surname);
        orderPage.setAddress(address);
        orderPage.setSubwayStation(subwayStation);
        orderPage.setPhoneNumber(phoneNumber);
        orderPage.clickNextButton();
        orderPage.setData(data, dayOfTheWeekAndData);
        orderPage.setNumberOfDays(numberOfDays);
        orderPage.setColour(colour);
        orderPage.clickOrderButton();
        orderPage.clickConfirmButton();
        assertTrue("Заказ не оформился", orderPage.getSuccessOrderText().contains("Заказ оформлен"));
    }

}

