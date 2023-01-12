import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TestOrderList {

    @Test
    @DisplayName("Получение списка заказов")
    public void orderList(){
        OrderClient order = new OrderClient();
        assertThat(order.getOrderList(), containsString("orders"));
    }
}
