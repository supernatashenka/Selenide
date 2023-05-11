import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class OrderCardTest {
    @Test
    void ShouldPlaceTheOrderWithValidData() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");


    }
}
