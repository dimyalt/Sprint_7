import static io.restassured.RestAssured.given;

public class DeleteCourier {
    private final String courierId;
    public DeleteCourier(String courierId) {
        this.courierId = courierId;
    }
    public void deleteCourier(){
        System.out.println("http://qa-scooter.praktikum-services.ru/api/v1/courier/"+courierId);
        given()
                .header("Content-type", "application, json")
                .when()
                .delete("http://qa-scooter.praktikum-services.ru/api/v1/courier/"+courierId)
        .then().statusCode(200);
    }
}
