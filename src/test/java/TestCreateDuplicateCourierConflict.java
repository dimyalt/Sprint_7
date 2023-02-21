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
    private static final CourierClient testCourier = new CourierClient(newCourierLogin, newCourierPassword, newCourierFirstname);

    @BeforeClass

    public static void setUp(){
        //Создаем "старого" курьера
        testCourier.createCourier();
    }
    @Test
    @DisplayName("Создание дубликата учетной записи курьера")
    public void createDuplicateCourier(){
        //Создаем "нового" курьера
        String result = testCourier.createCourier();
        String expectedResult = ":409"; //Ищем в ответе код ошибки
        //Перед проверкой, получаем id курьера
        id = testCourier.getLoginCourierId();
        //Проверка
        assertThat(result, containsString(expectedResult));

    }
    @AfterClass
    public static void tearsDown(){
        testCourier.deleteCourier(id);
    }

}
