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
    CourierClient courier = new CourierClient(courierLogin, courierPassword, courierFirstname);

    @Before
    public void setUp(){
        //Создаем курьера
        courier.createCourier();
    }
    @Test
    @DisplayName("Логин курьера")
    public void loginCourierOk(){
        String result =  courier.getCourierLoginResponseBody();
        id = courier.getLoginCourierId();
        String expectedResult = "id"; //Ищем в ответе id
        assertThat(result, containsString(expectedResult));
    }
    @After
    public void tearsDown(){
        courier.deleteCourier(id);
    }
}
