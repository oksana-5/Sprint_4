import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.FaqPage;
import page.MainPage;
import page.OrderPage;

public class BaseTest {
    WebDriver driver;
    MainPage mainPage;
    OrderPage orderPage;
    static FaqPage faqPage;


    @Before
    public void startUp() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
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

