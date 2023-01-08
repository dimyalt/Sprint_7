import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class CreateNewCourier {

    private final String newCourierLogin;
    private final String newCourierPassword;
    private final String newCourierFirstname;

    public CreateNewCourier(String newCourierLogin, String newCourierPassword, String newCourierFirstname) {
        this.newCourierLogin = newCourierLogin;
        this.newCourierPassword = newCourierPassword;
        this.newCourierFirstname = newCourierFirstname;
    }
    public String creatingCourier(){
        String json = "{\"login\": \""+newCourierLogin+"\",\"password\": \""+newCourierPassword+"\",\"firstName\": \""+newCourierFirstname+"\"}";
        Response response =
                    given()
                .header("Content-type", "application/json")
                .and()
                .body(json)
                .post("http://qa-scooter.praktikum-services.ru/api/v1/courier");

        System.out.println(response.body().asString());
        return response.body().asString();
    }
}
