import data.OrderData;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;

public class OrderClient {
    private String firstName;
    private String lastName;
    private String address;
    private int metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private String color;
    private final String ORDER_URL = "http://qa-scooter.praktikum-services.ru/api/v1/orders";
    public OrderClient() {

    }
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
    public String getOrderList(){
        Response response =
                given()
                        .get(ORDER_URL);
                        //.then().assertThat().body("$", hasKey("orders"));
        return response.body().asString();
    }

}
