import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TestLoginCourierNegative {
    private final String courierLogin = "Samokatchik3";
    private String courierPassword = "1234";
    private final String incorrectCourierPassword = "12345";
    private final String emptyCourierPassword = "";
    private final String courierFirstname = "saskeshket";
    private String id;
    CourierClient courier = new CourierClient(courierLogin, courierPassword, courierFirstname);

    @Before
    public void setUp(){
        //Создаем курьера
        courier.createCourier();
    }
    @Test
    @DisplayName("Логин курьера с неправильным паролем")
    public void loginCourierWithIncorrectPassword(){
        id = courier.getLoginCourierId();
        //Меняем у объекта courier пароль на неправильный
        courier.setCourierPassword(incorrectCourierPassword);
        // Пытаемся залогиниться с неправильным паролем и получаем ответ сервера
        String result =  courier.getCourierLoginResponseBody();
        String expectedResult = "404"; //Ищем в ответе код ошибки
        assertThat(result, containsString(expectedResult));
    }

    @Test
    @DisplayName("Логин курьера без обязательного поля")
    public void loginCourierWithoutRequiredField(){
        id = courier.getLoginCourierId();
        //Меняем у объекта courier пароль на пустой
        courier.setCourierPassword(emptyCourierPassword);
        // Пытаемся залогиниться с пустым паролем и получаем ответ сервера
        String result =  courier.getCourierLoginResponseBody();
        String expectedResult = "400"; //Ищем в ответе код ошибки
        assertThat(result, containsString(expectedResult));
    }
    @After
    public void tearsDown(){
        courier.deleteCourier(id);
    }
}

