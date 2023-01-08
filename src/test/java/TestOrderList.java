import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class TestOrderList {

    @Test
    @DisplayName("Получение списка заказов")
    public void orderList(){
            given()
                .get("http://qa-scooter.praktikum-services.ru/api/v1/orders")
                .then().assertThat().body("$", hasKey("orders"));
    }
}
