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
        CreateNewCourier courier = new CreateNewCourier(courierLogin, courierPassword, courierFirstname);
        courier.creatingCourier();
    }
    @Test
    @DisplayName("Логин курьера")
    public void loginCourierOk(){
        LoginCourier loginCourier = new LoginCourier(courierLogin, courierPassword);
        String result =  loginCourier.testLoginCourier();
        String expectedResult = "id"; //Ищем в ответе id
        assertThat(result, containsString(expectedResult));

        id = loginCourier.loginCourier();
    }
    @After
    public void tearsDown(){
        DeleteCourier courier = new DeleteCourier(id);
        courier.deleteCourier();
    }
}
