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
    private final CourierClient newCourier = new CourierClient(newCourierLogin, newCourierPassword, newCourierFirstname);

    @Test
    @DisplayName("Создание курьера")
    public void createNewCourier(){
        String result = newCourier.createCourier();
        id = newCourier.getLoginCourierId();
        assertEquals(expectedResult, result);

    }
    @After
    public void tearsDown(){
        newCourier.deleteCourier(id);
    }
}
