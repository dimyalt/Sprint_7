import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TestLoginCourierWithIncorrectPassword {
    private final String courierLogin = "Samokatchik3";
    private final String courierPassword = "1234";
    private final String incorrectCourierPassword = "12345";
    private final String courierFirstname = "saskeshket";
    private String id;

    @Before
    public void setUp(){
        //Создаем курьера
        CreateNewCourier courier = new CreateNewCourier(courierLogin, courierPassword, courierFirstname);
        courier.creatingCourier();
    }
    @Test
    @DisplayName("Логин курьера с неправильным паролем")
    public void loginCourierWithIncorrectPassword(){
        LoginCourier loginCourierWrongPass = new LoginCourier(courierLogin, incorrectCourierPassword);
        String result =  loginCourierWrongPass.testLoginCourier();
        System.out.println(loginCourierWrongPass.testLoginCourier());
        String expectedResult = "404"; //Ищем в ответе код ошибки
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
