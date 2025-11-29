import SupportClasses.Browser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.RegistrationPage;
import static org.junit.Assert.assertTrue;

public class TestTransitionsConstructor {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    String expectedClass = "tab_tab_type_current__2BEPc";
    @Before
    public void setUp() {
        // Создаем WebDriver через класс SupportClasses.Browser
        driver = Browser.createWebDriver();
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site");
        registrationPage = new RegistrationPage(driver);
    }
    @Test
    @DisplayName("Тест 1: Проверка перехода к разделу булки")
    public void testTransitionsBuns(){
        registrationPage.clickButtonConstructorSauce();
        registrationPage.clickButtonConstructorBuns();
        By bunsTabLocator = registrationPage.buttonConstructorBuns;
        // Получение класса элемента вкладки
        String actualClass = driver.findElement(bunsTabLocator).getAttribute("class");
        // Проверка изменения класса
        assertTrue("Класс выбранной вкладки изменился на ожидаемый",
                actualClass.contains(expectedClass));
    }
    @Test
    @DisplayName("Тест 2: Проверка перехода к разделу соусы")
    public void testTransitionsSauce(){
        registrationPage.clickButtonConstructorSauce();
        By bunsTabLocator = registrationPage.buttonConstructorSauce;
        // Получение класса элемента вкладки
        String actualClass = driver.findElement(bunsTabLocator).getAttribute("class");
        // Проверка изменения класса
        assertTrue("Класс выбранной вкладки изменился на ожидаемый",
                actualClass.contains(expectedClass));
    }
    @Test
    @DisplayName("Тест 3: Проверка перехода к разделу начинки")
    public void testTransitionsFillings(){
        registrationPage.clickButtonConstructorFillings();
        By bunsTabLocator = registrationPage.buttonConstructorFillings;
        // Получение класса элемента вкладки
        String actualClass = driver.findElement(bunsTabLocator).getAttribute("class");
        // Проверка изменения класса
        assertTrue("Класс выбранной вкладки изменился на ожидаемый",
                actualClass.contains(expectedClass));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
