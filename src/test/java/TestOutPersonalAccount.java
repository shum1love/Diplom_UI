import SupportClasses.ApiRegistration;
import SupportClasses.Browser;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.RegistrationPage;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class TestOutPersonalAccount {
    private WebDriver driver;
    ApiRegistration apiRegistration = new ApiRegistration();
    private String token;
    private RegistrationPage registrationPage;
    private String name = "Bogdan";
    String email = "bogdan.example99@yandex.ru";
    String password = "Bogdan123";
    @Before
    public void setUp() {
        // Создаем WebDriver через класс SupportClasses.Browser
        driver = Browser.createWebDriver();
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site");
        registrationPage = new RegistrationPage(driver);
    }
    @Test
    @DisplayName("Тест: Выход из аккаунта")
    @Description("Проверяет выход по кнопке «Выйти» в личном кабинете.")
    public void testOutPersonalAccount() {
        token = apiRegistration.apiRegistration(email, password, name);
        registrationPage.loginStep(email, password);
        registrationPage.clickPersonalAccount();
        registrationPage.clickButtonLogOut();
        assertEquals(registrationPage.enabledButtonPlaceOrder(), false);
    }
    @After
    public void tearDown() {
        // Удаление пользователя
        if (token != null) {
            given()
                    .header("Authorization", token)
                    .when()
                    .delete("https://stellarburgers.nomoreparties.site/api/auth/user");
        }
        // Закрытие драйвера
        if (driver != null) {
            driver.quit();
        }
    }
}
