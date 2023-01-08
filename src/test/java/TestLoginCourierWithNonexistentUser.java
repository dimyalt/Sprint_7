import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TestLoginCourierWithNonexistentUser {
    private final String courierLogin = "Samokatchik3";
    private final String courierPassword = "1234";

    @Test
    @DisplayName("Логин несуществующего курьера")
    public void loginCourierWithNonexistentUser() {
        LoginCourier loginCourierNonexistentUser = new LoginCourier(courierLogin, courierPassword);
        String result = loginCourierNonexistentUser.testLoginCourier();
        System.out.println(loginCourierNonexistentUser.testLoginCourier());
        String expectedResult = "404"; //Ищем в ответе код ошибки
        assertThat(result, containsString(expectedResult));
    }
}
