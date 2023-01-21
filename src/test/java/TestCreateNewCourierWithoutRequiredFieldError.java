import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class TestCreateNewCourierWithoutRequiredFieldError {
    private static String id;
    @Test
    @DisplayName("Создание курьера без обязательного поля")
    public void createNewCourierWithoutPassword(){
        String newCourierLogin = "Samokatchik3";
        String newCourierPassword = "";
        String newCourierFirstname = "saskeshket";
        String expectedResult = ":400";
        // Создаем курьера без обязательного поля (пароль)
        CourierClient newCourier = new CourierClient(newCourierLogin, newCourierPassword, newCourierFirstname);
        String result = newCourier.createCourier();
        // Пытаемся залогиниться созданным курьером
        id = newCourier.getLoginCourierId();
        // Если ожидаемый результат (ошибка при создании учетной записи без пароля) отличается от фактического
        if (!result.contains(expectedResult)) {
            // Удаляем нового курьера из системы
            newCourier.deleteCourier(id);
        }
        assertThat(result, containsString(expectedResult));
    }

}
