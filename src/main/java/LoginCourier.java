import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginCourier {
    private final String login;
    private final String password;

    public LoginCourier(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public String loginCourier(){
        String json = "{\"login\": \"" + login + "\",\"password\": \"" + password + "\"}";
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body(json)
                        .when().post("http://qa-scooter.praktikum-services.ru/api/v1/courier/login");
        String responseBody = response.body().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        return jsonPath.getString("id");

    }
    public String testLoginCourier(){
        String json = "{\"login\": \"" + login + "\",\"password\": \"" + password + "\"}";
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body(json)
                        .when().post("http://qa-scooter.praktikum-services.ru/api/v1/courier/login");
        return response.body().asString();

    }
}
