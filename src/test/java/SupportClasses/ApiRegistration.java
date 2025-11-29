package SupportClasses;

import static io.restassured.RestAssured.*;

import SupportClasses.User;
import io.restassured.response.Response;

public class ApiRegistration {
    private String refreshToken; // Поле для сохранения refreshToken

    public String apiRegistration(String email, String password, String name) {
        User user = new User(email, password, name);

        // Выполняем POST запрос и извлекаем ответ
        Response response = given()
                .header("Content-Type", "application/json")
                .body(user)
                .post("https://stellarburgers.nomoreparties.site/api/auth/register");

        // Проверяем, что статус-код равен 200
        response.then().statusCode(200);

        // Извлекаем refreshToken из ответа
        refreshToken = response.jsonPath().getString("accessToken"); // Сохраняем refreshToken
        return refreshToken; // Возвращаем refreshToken
    }

    public String getRefreshToken() {
        return refreshToken; // Геттер для доступа к refreshToken
    }
}
