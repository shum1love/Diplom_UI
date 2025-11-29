import SupportClasses.ApiLogin;
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
public class TestRegistration {
    private WebDriver driver;
    ApiLogin apiLogin = new ApiLogin();
    private String token;
    private RegistrationPage registrationPage;
    private String name = "Bogdan";
    String email = "bogdan.example103@yandex.ru";
    String password = "Bogdan123";
    String wrongPassword = "12345";
    @Before
    public void setUp() {
        // Создаем WebDriver через класс SupportClasses.Browser
        driver = Browser.createWebDriver();
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/register");
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    @DisplayName("Тест 1: Успешная регистрация пользователя")
    @Description("Проверка успешной регистрации нового пользователя с корректными данными")
    public void testSuccessfulRegistration() {
        registrationPage.registrationStep(email, password, name);
        token = apiLogin.apiLogin(email, password);
        assertEquals(apiLogin.getStatus(), 200);

    }
    @Test
    @DisplayName("Тест 2: Проверка регистрации с паролем меньше допустимого")
    @Description("Пароль: 12345")
    public void testWrongPasswordRegistration() {
        registrationPage.registrationStep(email, wrongPassword, name);
        token = apiLogin.apiLogin(email, wrongPassword);
        assertEquals(registrationPage.visibleTextWrongPassword(), true);
        assertEquals(token, null);
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
