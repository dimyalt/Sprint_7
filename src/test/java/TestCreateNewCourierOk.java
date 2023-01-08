import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCreateNewCourierOk {
    private String id;

    @Test
    @DisplayName("Создание курьера")
    public void createNewCourier(){
        String newCourierLogin = "Samokatchik3";
        String newCourierPassword = "1234";
        String newCourierFirstname = "saskeshket";
        String expectedResult = "{\"ok\":true}";

        CreateNewCourier newCourier = new CreateNewCourier(newCourierLogin, newCourierPassword, newCourierFirstname);
        String result = newCourier.creatingCourier();
        assertEquals(expectedResult, result);

        LoginCourier loginCourierId = new LoginCourier(newCourierLogin, newCourierPassword);
        id = loginCourierId.loginCourier();
    }
    @After
    public void tearsDown(){
        DeleteCourier courier = new DeleteCourier(id);
        courier.deleteCourier();
    }
}
