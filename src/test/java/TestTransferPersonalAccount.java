import SupportClasses.Browser;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.RegistrationPage;
import static org.junit.Assert.assertEquals;
public class TestTransferPersonalAccount {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    @Before
    public void setUp() {
        // Создаем WebDriver через класс SupportClasses.Browser
        driver = Browser.createWebDriver();
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site");
        registrationPage = new RegistrationPage(driver);
    }
    @Test
    @DisplayName("Тест 1: Проверь переход по клику на «Личный кабинет».")
    @Description("Проверка для неавторизированного пользователя")
    public void testTransferPersonalAccount(){
        registrationPage.clickButtonLoginAccount();
        assertEquals(registrationPage.enableButtonLogin(), true);
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
