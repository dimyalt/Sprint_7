import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TestLoginCourierWithNonexistentUser {
    private final String courierLogin = "Samokatchik3";
    private final String courierPassword = "1234";
    private final String courierFirstname = "saskeshket";

    @Test
    @DisplayName("Логин несуществующего курьера")
    public void loginCourierWithNonexistentUser() {
        CourierClient courierClientNonexistentUser = new CourierClient(courierLogin, courierPassword, courierFirstname);
        String result = courierClientNonexistentUser.getCourierLoginResponseBody();
        String expectedResult = "404"; //Ищем в ответе код ошибки
        assertThat(result, containsString(expectedResult));
    }
}
