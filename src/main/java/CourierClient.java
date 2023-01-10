import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CourierClient {
    private final String login;
    private final String password;
    private final String firstname;
    private final String LOGIN_URL = "http://qa-scooter.praktikum-services.ru/api/v1/courier/login";
    private final String DELETE_URL = "http://qa-scooter.praktikum-services.ru/api/v1/courier/";
    private final String COURIER_URL = "http://qa-scooter.praktikum-services.ru/api/v1/courier";

    public CourierClient(String login, String password, String firstname) {
        this.login = login;
        this.password = password;
        this.firstname = firstname;
    }

    public String createCourier(){
        CourierData courierJson = new CourierData(login, password, firstname);
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(courierJson)
                        .post(COURIER_URL);
        return response.body().asString();
    }

    public String getLoginCourierId(){
        CourierData courierJson = new CourierData(login, password);
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body(courierJson)
                        .when().post(LOGIN_URL);
        String responseBody = response.body().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        return jsonPath.getString("id");

    }
    public String getCourierLoginResponseBody(){
        CourierData courierJson = new CourierData(login, password);
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body(courierJson)
                        .when().post(LOGIN_URL);
        return response.body().asString();

    }
    public void deleteCourier(String courierId){
        given()
                .header("Content-type", "application, json")
                .when()
                .delete(DELETE_URL+courierId)
                .then().statusCode(200);
    }
}
