import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class TestLoginCourierWithoutRequiredFieldError {
    private final String courierLogin = "Samokatchik3";
    private final String courierPassword = "1234";
    private final String incorrectCourierPassword = "";
    private final String courierFirstname = "saskeshket";
    private String id;

    @Before
    public void setUp(){
        //Создаем курьера
        CreateNewCourier courier = new CreateNewCourier(courierLogin, courierPassword, courierFirstname);
        courier.creatingCourier();
    }
    @Test
    @DisplayName("Логин курьера без обязательного поля")
    public void loginCourierWithoutRequiredField(){
        LoginCourier loginCourierWithoutRequiredField = new LoginCourier(courierLogin, incorrectCourierPassword);
        String result =  loginCourierWithoutRequiredField.testLoginCourier();
        System.out.println(loginCourierWithoutRequiredField.testLoginCourier());
        String expectedResult = "400"; //Ищем в ответе код ошибки
        assertThat(result, containsString(expectedResult));

        LoginCourier loginCourier = new LoginCourier(courierLogin, courierPassword);
        id = loginCourier.loginCourier();
    }
    @After
    public void tearsDown(){
        DeleteCourier courier = new DeleteCourier(id);
        courier.deleteCourier();
    }
}
