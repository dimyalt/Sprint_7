import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class CreateNewOrder {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final int metroStation;
    private final String phone;
    private final int rentTime;
    private final String deliveryDate;
    private final String comment;
    private final String color;

    public CreateNewOrder(String firstName, String lastName, String address, int metroStation, String phone,
                          int rentTime, String deliveryDate, String comment, String color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }
    public String createOrder(){
        String json = "{\"firstName\": \""+firstName+"\",\"lastName\": \""+lastName+"\",\"address\": \""+address+"\"," +
                "\"metroStation\": "+metroStation+",\"phone\": \""+phone+"\",\"rentTime\": "+rentTime+"," +
                "\"deliveryDate\": \""+deliveryDate+"\",\"comment\": \""+comment+"\",\"color\": [\""+color+"\"]}";
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(json)
                        .post("http://qa-scooter.praktikum-services.ru/api/v1/orders");
        System.out.println(response.body().asString());
        return response.body().asString();

    }

}
