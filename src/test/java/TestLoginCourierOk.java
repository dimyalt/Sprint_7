import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TestLoginCourierOk {
    private final String courierLogin = "Samokatchik3";
    private final String courierPassword = "1234";
    private final String courierFirstname = "saskeshket";
    private String id;

    @Before
    public void setUp(){
        //Создаем курьера
        CourierClient courier = new CourierClient(courierLogin, courierPassword, courierFirstname);
        courier.createCourier();
    }
    @Test
    @DisplayName("Логин курьера")
    public void loginCourierOk(){
        CourierClient courierClient = new CourierClient(courierLogin, courierPassword, courierFirstname);
        String result =  courierClient.getCourierLoginResponseBody();
        String expectedResult = "id"; //Ищем в ответе id
        assertThat(result, containsString(expectedResult));

        id = courierClient.getLoginCourierId();
    }
    @After
    public void tearsDown(){
        CourierClient courier = new CourierClient(courierLogin, courierPassword, courierFirstname);
        courier.deleteCourier(id);
    }
}
