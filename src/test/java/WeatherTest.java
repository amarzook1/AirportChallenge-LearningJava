import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class WeatherTest {

    @Test
    @DisplayName("Testing Random weather object")
    @RepeatedTest(6)
    void getWeather() {
        Weather weather = new Weather();
        String actualValue = weather.getWeather();
        assertTrue("Stormy".equals(actualValue) || "Clear".equals(actualValue));
    }

    @ParameterizedTest
    @CsvSource(value = {"Stormy , Stormy","Clear , Clear"})
    @DisplayName("Testing user entered weather")
    void getSelectedWeather(String actualValue, String expectedValue) {
        Weather weather = new Weather(actualValue);
        assertEquals(expectedValue, weather.getWeather());


    }
}