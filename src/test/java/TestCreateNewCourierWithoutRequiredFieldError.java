import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class TestCreateNewCourierWithoutRequiredFieldError {

    @Test
    @DisplayName("Создание курьера без обязательного поля")
    public void createNewCourier(){
        String newCourierLogin = "Samokatchik3";
        String newCourierPassword = "";
        String newCourierFirstname = "saskeshket";
        String expectedResult = ":400";

        CreateNewCourier newCourier = new CreateNewCourier(newCourierLogin, newCourierPassword, newCourierFirstname);
        String result = newCourier.creatingCourier();
        assertThat(result, containsString(expectedResult));

    }

}
