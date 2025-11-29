package SupportClasses;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;

public class ApiLogin {
    private String refreshToken; // Поле для сохранения refreshToken
    private int statusCode;      // Поле для сохранения кода статуса

    public String apiLogin(String email, String password) {
        User user = new User(email, password);

        // Выполняем POST запрос и извлекаем ответ
        Response response = given()
                .header("Content-Type", "application/json")
                .body(user)
                .post("https://stellarburgers.nomoreparties.site/api/auth/login");

        // Сохраняем код статуса ответа
        statusCode = response.getStatusCode();

        // Извлекаем refreshToken из ответа
        refreshToken = response.jsonPath().getString("accessToken");
        return refreshToken; // Возвращаем refreshToken
    }

    public int getStatus() {
        return statusCode; // Возвращаем сохраненный код статуса
    }

    public String getRefreshToken() {
        return refreshToken; // Геттер для доступа к refreshToken
    }
}
