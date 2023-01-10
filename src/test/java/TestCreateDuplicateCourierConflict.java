import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import java.util.Random;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TestCreateDuplicateCourierConflict {
    private static final Random random = new Random();
    private static final int randomNumber = random.nextInt(100);
    private static final String newCourierLogin = "Samokatchik"+randomNumber;
    private static final String newCourierPassword = "1234";
    private static final String newCourierFirstname = "saskeshket";
    private static String id;

    @BeforeClass
    public static void setUp(){
        //Создаем "старого" курьера
        CourierClient oldCourier = new CourierClient(newCourierLogin, newCourierPassword, newCourierFirstname);
        oldCourier.createCourier();
    }
    @Test
    @DisplayName("Создание дубликата учетной записи курьера")
    public void createDuplicateCourier(){
        CourierClient newCourier = new CourierClient(newCourierLogin, newCourierPassword, newCourierFirstname);
        String result = newCourier.createCourier();
        String expectedResult = ":409"; //Ищем в ответе код ошибки
        assertThat(result, containsString(expectedResult));
        CourierClient courierClientId = new CourierClient(newCourierLogin, newCourierPassword, newCourierFirstname);
        id = courierClientId.getLoginCourierId();
    }
    @AfterClass
    public static void tearsDown(){
        CourierClient courier = new CourierClient(newCourierLogin, newCourierPassword, newCourierFirstname);
        courier.deleteCourier(id);
    }

}
