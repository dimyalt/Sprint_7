import data.OrderData;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;

public class OrderClient {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final int metroStation;
    private final String phone;
    private final int rentTime;
    private final String deliveryDate;
    private final String comment;
    private final String color;
    private final String ORDER_URL = "http://qa-scooter.praktikum-services.ru/api/v1/orders";

    public OrderClient(String firstName, String lastName, String address, int metroStation, String phone,
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
        List<OrderData> orderData = new ArrayList<>();
        orderData.add(new OrderData(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color));
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(orderData)
                        .post(ORDER_URL);
        return response.body().asString();

    }

}
