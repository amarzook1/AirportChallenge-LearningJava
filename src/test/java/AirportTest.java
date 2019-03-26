import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;


class AirportTest {

    private Airport airport;
    //Introducing Mokito by mocking the weather class so it does not give a random output
    private Weather weather = mock(Weather.class);

    @BeforeEach
    void beforeEach(){
        System.out.println("Initializing Test");
        airport = new Airport("Gatwick", 3);
    }

    @Test
    @DisplayName("Gets airport Name")
    void getAirportName() {
        assertEquals("Gatwick", airport.getName());
    }

    @Test
    @DisplayName("Instruct Plane to land")
    void landPlanes() {
        Plane plane1 = new Plane("British Airways");
        //When .getWeather is used it will always return Clear
        when(weather.getWeather()).thenReturn("Clear");
        airport.landPlane(plane1, weather);
        assertEquals(1, airport.getPlanes().size());
    }

    @Test
    @DisplayName("Plane cannot land if weather is Stormy")
    void landPlaneStormy() {
        Plane plane1 = new Plane("British Airways");
        when(weather.getWeather()).thenReturn("Stormy");
        airport.landPlane(plane1, weather);
        assertEquals(0, airport.getPlanes().size());
    }

    @Test
    @DisplayName("Test if you can land already landed planes")
    void landLandedPlanes() {
        Plane plane1 = new Plane("British Airways");
        plane1.setLanded(true);
        when(weather.getWeather()).thenReturn("Clear");
        airport.landPlane(plane1, weather);
        assertEquals(0, airport.getPlanes().size());
    }

    @Test
    @DisplayName("When plane landed .isLanded() is set to true")
    void planeIsLanded(){
        Plane plane1 = new Plane("British Airways");
        when(weather.getWeather()).thenReturn("Clear");
        airport.landPlane(plane1, weather);
        assertTrue(airport.getPlanes().get(0).isLanded());
    }

    @Test
    @DisplayName("Plane can takeoff from airport")
    void takeOffPlane() {
        when(weather.getWeather()).thenReturn("Clear");
        airport.landPlane(new Plane("Ahmed"), weather);
        airport.takeOff("Ahmed", weather);
        assertEquals(0,airport.getPlanes().size());
    }

    @Test
    @DisplayName("Plane cannot takeoff if weather is Stormy")
    void takeOffPlaneStormy() {
        when(weather.getWeather()).thenReturn("Clear");
        airport.landPlane(new Plane("Ahmed"), weather);
        when(weather.getWeather()).thenReturn("Stormy");
        airport.takeOff("Ahmed", weather);
        assertEquals(1,airport.getPlanes().size());
    }

    @Test
    @DisplayName("When Hanger is full planes cannot land")
    void hangerCapacityFull() {
        when(weather.getWeather()).thenReturn("Clear");
        airport.landPlane(new Plane("Jimmy"), weather);
        airport.landPlane(new Plane("Fallon"), weather);
        airport.landPlane(new Plane("Carter"), weather);
        assertFalse(airport.landPlane(new Plane("BOOO"), weather));
    }

    @Test
    @DisplayName("Able to change current capacity of airport hanger")
    void hangerCapacityChange() {
        when(weather.getWeather()).thenReturn("Clear");
        airport.landPlane(new Plane("Jimmy"), weather);
        airport.landPlane(new Plane("Fallon"), weather);
        airport.landPlane(new Plane("Carter"), weather);
        airport.landPlane(new Plane("Jimmy"), weather);
        airport.setCapacity(4);
        assertTrue(airport.landPlane(new Plane("BOOO"), weather));
    }

}