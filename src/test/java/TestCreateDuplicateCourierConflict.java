import io.qameta.allure.junit4.DisplayName;
import org.junit.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TestCreateDuplicateCourierConflict {
    private static String id;
    private static final String newCourierLogin = "Samokatchik3";
    private static final String newCourierPassword = "1234";
    private static final String newCourierFirstname = "saskeshket";

    @BeforeClass
    public static void setUp(){
        //Создаем "старого" курьера
        CreateNewCourier oldCourier = new CreateNewCourier(newCourierLogin, newCourierPassword, newCourierFirstname);
        oldCourier.creatingCourier();
    }
    @Test
    @DisplayName("Создание дубликата учетной записи курьера")
    public void createDuplicateCourier(){
        CreateNewCourier newCourier = new CreateNewCourier(newCourierLogin, newCourierPassword, newCourierFirstname);
        String result = newCourier.creatingCourier();
        String expectedResult = ":409"; //Ищем в ответе код ошибки
        assertThat(result, containsString(expectedResult));
        LoginCourier loginCourierId = new LoginCourier(newCourierLogin, newCourierPassword);
        id = loginCourierId.loginCourier();
    }
    @AfterClass
    public static void tearsDown(){
        DeleteCourier courier = new DeleteCourier(id);
        courier.deleteCourier();
    }

}
