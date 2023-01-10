import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCreateNewCourierOk {
    private String id;
    private final String newCourierLogin = "Samokatchik3";
    private final String newCourierPassword = "1234";
    private final String newCourierFirstname = "saskeshket";
    private final String expectedResult = "{\"ok\":true}";
    @Test
    @DisplayName("Создание курьера")
    public void createNewCourier(){
        CourierClient newCourier = new CourierClient(newCourierLogin, newCourierPassword, newCourierFirstname);
        String result = newCourier.createCourier();
        assertEquals(expectedResult, result);

        CourierClient courierClientId = new CourierClient(newCourierLogin, newCourierPassword, newCourierFirstname);
        id = courierClientId.getLoginCourierId();
    }
    @After
    public void tearsDown(){
        CourierClient courier = new CourierClient(newCourierLogin, newCourierPassword, newCourierFirstname);
        courier.deleteCourier(id);
    }
}
