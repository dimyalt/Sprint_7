import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TestLoginCourierNegative {
    private final String courierLogin = "Samokatchik3";
    private final String courierPassword = "1234";
    private final String incorrectCourierPassword = "12345";
    private final String emptyCourierPassword = "";
    private final String courierFirstname = "saskeshket";
    private String id;

    @Before
    public void setUp(){
        //Создаем курьера
        CourierClient courier = new CourierClient(courierLogin, courierPassword, courierFirstname);
        courier.createCourier();
    }
    @Test
    @DisplayName("Логин курьера с неправильным паролем")
    public void loginCourierWithIncorrectPassword(){
        CourierClient courierClientWrongPass = new CourierClient(courierLogin, incorrectCourierPassword, courierFirstname);
        String result =  courierClientWrongPass.getCourierLoginResponseBody();
        String expectedResult = "404"; //Ищем в ответе код ошибки
        assertThat(result, containsString(expectedResult));
        CourierClient courierClient = new CourierClient(courierLogin, courierPassword, courierFirstname);
        id = courierClient.getLoginCourierId();
    }

    @Test
    @DisplayName("Логин курьера без обязательного поля")
    public void loginCourierWithoutRequiredField(){
        CourierClient courierClientWithoutRequiredField = new CourierClient(courierLogin, emptyCourierPassword, courierFirstname);
        String result =  courierClientWithoutRequiredField.getCourierLoginResponseBody();
        String expectedResult = "400"; //Ищем в ответе код ошибки
        assertThat(result, containsString(expectedResult));
        CourierClient courierClient = new CourierClient(courierLogin, courierPassword, courierFirstname);
        id = courierClient.getLoginCourierId();
    }
    @After
    public void tearsDown(){
        CourierClient courier = new CourierClient(courierLogin, courierPassword, courierFirstname);
        courier.deleteCourier(id);
    }
}

