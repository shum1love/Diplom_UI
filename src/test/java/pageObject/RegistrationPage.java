package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.By.*;

public class RegistrationPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Кнопка Конструктор в шапке сайта
    private final By buttonConstructor = xpath(".//p[contains(text(), 'Конструктор')]");
    // Логотип Stellar Burger в шапке сайта
    private final By logoStellarBurger = xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    // Кнопка Войти в аккаунт на главной странице
    private final By buttonLoginAccount = xpath(".//button[contains(text(), 'Войти в аккаунт')]");
    // Кнопка Оформить заказ на главной страницы. Видно только авторизированному пользователю
    private final By buttonPlaceOrder = xpath(".//button[contains(text(), 'Оформить заказ')]");

    // Кнопка личный кабинет
    private final By buttonPersonalAccount = xpath(".//p[contains(text(), 'Личный Кабинет')]");

    // Окно Авторизции
    // Поле ввода email в окне авторизации
    private final By fieldEmailLogin = xpath(".//label[contains(text(), 'Email')]/following-sibling::input");
    // Поле ввода password в окне авторизации
    private final By fieldPasswordLogin = xpath(".//label[contains(text(), 'Пароль')]/following-sibling::input");
    // Кнопка регистрации в окне авторизации
    private final By buttonRegistration = className("Auth_link__1fOlj");
    // Кнопка зарегистрироваться в окне авторизации
    private final By buttonLoginLogin = xpath(".//button[contains(text(), 'Войти')]");
    // Кнопка Восстановить пароль в окне авторизации
    private final By buttonRecoverPassword = xpath(".//a[text()='Восстановить пароль']");


    // Окно Восстановление пароля
    // Кнопка Войти в окне Восстановление пароля
    private final By buttonLoginRecoveryPassword = xpath(".//a[text()='Войти']");


    // Окно Регистрации
    // Поле ввода имени в окне Регистрации
    private final By fieldNameReg = xpath(".//label[contains(text(), 'Имя')]/following-sibling::input");
    // Поле ввода емейла в окне Регистрации
    private final By fieldEmailReg = xpath(".//label[contains(text(), 'Email')]/following-sibling::input");
    // Поле ввода пароля в окне Регистрации
    private final By fieldPasswordReg = xpath(".//label[contains(text(), 'Пароль')]/following-sibling::input");
    // Кнопка регистрации в в окне Регистрации
    private final By buttonRegistrationReg = xpath(".//button[contains(text(), 'Зарегистрироваться')]");
    // Кнопка Войти в в окне Регистрации
    private final By buttonLoginReg = xpath(".//a[text()='Войти']");
    // Текст некорректный пароль в в окне Регистрации
    private final By textWrongPassword = xpath(".//p[contains(text(), 'Некорректный пароль')]");

    //ЛК
    // Кнопка Выйти в ЛК
    private final By buttonLogOut = xpath(".//button[contains(text(), 'Выйти']");

    //Конструктор Бургера разделы
    // Вкладка Булки
    public By buttonConstructorBuns = xpath(".//span[contains(text(), 'Булки')]/..");
    // Вкладка Соусы
    public By buttonConstructorSauce = xpath(".//span[contains(text(), 'Соусы')]/..");
    // Вкладка Начинки
    public By buttonConstructorFillings = xpath(".//span[contains(text(), 'Начинки')]/..");


    @Step("Клик по кнопке войти в аккаунт на главной странице сайта")
    public void clickButtonLoginAccount() {
        driver.findElement(buttonLoginAccount).click();
    }
    @Step("Проверка видимости кнопки Войти в аккаунт")
    public boolean checkButtonLoginAccount() {
        return driver.findElement(buttonLoginAccount).isDisplayed();
    }
    @Step("Ожидание, что кнопка оформить заказ станет видимой")
    public void waitButtonPlaceOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonPlaceOrder));
    }

    @Step("Видимость кнопки Оформить заказ на главной странице сайта")
    public boolean enabledButtonPlaceOrder() {
        return driver.findElement(buttonPlaceOrder).isDisplayed();
    }

    @Step("Клик по полю Email в окне авторизации")
    public void clickFieldEmailLogin() {
        driver.findElement(fieldEmailLogin).click();
    }

    @Step("Ввод текста в поле Email в окне авторизации")
    public void setFieldEmailLogin(String email) {
        driver.findElement(fieldEmailLogin).sendKeys(email);
    }

    @Step("Клик по полю Пароль в окне Авторизации")
    public void clickFieldPasswordLogin() {
        driver.findElement(fieldPasswordLogin).click();
    }

    @Step("Ввод текста в поле пароль в окне Авторизации")
    public void setFieldPasswordLogin(String password) {
        driver.findElement(fieldPasswordLogin).sendKeys(password);
    }

    @Step("Клик по кнопке личный кабинет в шапке сайта")
    public void clickPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }

    @Step("Клик по кнопке Войти в окне авторизации")
    public void clickButtonLoginLogin() {
        driver.findElement(buttonLoginLogin).click();
    }

    @Step("Клик по кнопке зарегистрироваться в окне авторизации")
    public void clickButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }

    @Step("Клик по кнопке восстановление пароля в окне авторизации")
    public void clickButtonRecoveryPassword() {
        driver.findElement(buttonRecoverPassword).click();
    }
    @Step("Видимость кнопки Войти ")
    public boolean enableButtonLogin(){
        return driver.findElement(buttonLoginLogin).isDisplayed();
    }


    // Окно Восстановлеине пароля
    @Step("Клик по кнопке Войти в окне Восстановление пароля")
    public void clickButtonLoginRecoveryPassword() {
        driver.findElement(buttonLoginRecoveryPassword).click();
    }


    // Окно регистрации
    @Step("Клик по полю Имя в окне регистрации")
    public void clickFieldNameReg() {
        driver.findElement(fieldNameReg).click();
    }

    @Step("Ввод текста в поле Имя в окне регистрации")
    public void setFieldNameReg(String name) {
        driver.findElement(fieldNameReg).sendKeys(name);
    }

    @Step("Клик по полю Email")
    public void clickEmailField() {
        driver.findElement(fieldEmailReg).click();
    }

    @Step("Ввод email: {email}")
    public void setEmail(String email) {
        driver.findElement(fieldEmailReg).sendKeys(email);
    }

    @Step("Клик по полю Password")
    public void clickPasswordField() {
        driver.findElement(fieldPasswordReg).click();
    }

    @Step("Ввод password: {password}")
    public void setPassword(String password) {
        driver.findElement(fieldPasswordReg).sendKeys(password);
    }

    @Step("Клик по кнопке Зарегистрироваться в окне регистрации")
    public void clickButtonRegistrationReg() {
        driver.findElement(buttonRegistrationReg).click();
    }

    @Step("Проверка на отображение текста ошибки при неверно набранном пароле")
    public boolean visibleTextWrongPassword() {
        return driver.findElement(textWrongPassword).isDisplayed();
    }

    @Step
    public void clickButtonLoginReg() {
        driver.findElement(buttonLoginReg).click();
    }

    // Шапка сайта
    // Logo
    @Step("Клик по логотипу Stellar Burger в шапке сайта")
    public void clickLogoStellarBurger(){
        driver.findElement(logoStellarBurger).click();
    }
    // Конструткор в шапке сайта
    @Step("Клик по кнопке конструктор в шапке сайта")
    public void clickButtonConstructor(){
        driver.findElement(buttonConstructor).click();
    }

    // ЛК
    @Step("Клик по кновке Выход в личном кабинете")
    public void clickButtonLogOut(){
        driver.findElement(buttonLogOut).click();
    }

    //Конструктор Бургера разделы
    @Step("Клик по вкладке Булки")
    public void clickButtonConstructorBuns(){
        WebElement element = driver.findElement(buttonConstructorBuns);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    @Step("Клик по вкладке Соусы")
    public void clickButtonConstructorSauce(){
        WebElement element = driver.findElement(buttonConstructorSauce);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }
    @Step("Клик по вкладке Начинка")
    public void clickButtonConstructorFillings(){
        WebElement element = driver.findElement(buttonConstructorFillings);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }


    // ШАГ: логин
    @Step("Шаг логин")
    public void loginStep(String email, String password){
        clickButtonLoginAccount();
        clickFieldEmailLogin();
        setFieldEmailLogin(email);
        clickFieldPasswordLogin();
        setFieldPasswordLogin(password);
        clickButtonLoginLogin();
    }
    // ШАГ: логин без ЛК
    @Step("Короткая версия Шага Логин")
    public void loginStepShort(String email, String password){
        clickFieldEmailLogin();
        setFieldEmailLogin(email);
        clickFieldPasswordLogin();
        setFieldPasswordLogin(password);
        clickButtonLoginLogin();
        waitButtonPlaceOrder();
    }
    //ШАГ: Регистрация
    @Step("Короткая версия Шага Логин")
    public void registrationStep(String email, String password, String name){
        clickPersonalAccount();
        clickButtonRegistration();
        clickFieldNameReg();
        setFieldNameReg(name);
        clickEmailField();
        setEmail(email);
        clickPasswordField();
        setPassword(password);
        clickButtonRegistrationReg();
    }
}
