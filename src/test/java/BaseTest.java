import Page.FaqPage;
import Page.MainPage;
import Page.OrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    WebDriver driver;
    MainPage mainPage;
    OrderPage orderPage;
    FaqPage faqPage;


    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
        faqPage = new FaqPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

