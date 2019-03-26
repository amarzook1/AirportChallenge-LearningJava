import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

class WeatherTest {

    @RepeatedTest(10)
    @DisplayName("Testing Random weather object")
    void getWeather() {
        Weather weather = new Weather();
        String actualValue = weather.getWeather();
        assertTrue("Stormy".equals(actualValue) || "Clear".equals(actualValue));
    }

}