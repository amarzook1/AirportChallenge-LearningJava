import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    private Airport airport;

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
        airport.landPlane(plane1, new Weather("Clear"));
        assertEquals(1, airport.getPlanes().size());
    }

    @Test
    @DisplayName("Plane cannot land if weather is Stormy")
    void landPlaneStormy() {
        Plane plane1 = new Plane("British Airways");
        airport.landPlane(plane1, new Weather("Stormy"));
        assertEquals(0, airport.getPlanes().size());
    }

    @Test
    @DisplayName("Test if you can land already landed planes")
    void landLandedPlanes() {
        Plane plane1 = new Plane("British Airways");
        plane1.setLanded(true);
        airport.landPlane(plane1, new Weather("Clear"));
        assertEquals(0, airport.getPlanes().size());
    }

    @Test
    @DisplayName("When plane landed .isLanded() is set to true")
    void planeIsLanded(){
        Plane plane1 = new Plane("British Airways");
        airport.landPlane(plane1, new Weather("Clear"));
        assertTrue(airport.getPlanes().get(0).isLanded());
    }

    @Test
    @DisplayName("Plane can takeoff from airport")
    void takeOffPlane() {
        airport.landPlane(new Plane("Ahmed"), new Weather("Clear"));
        airport.takeOff("Ahmed", new Weather("Clear"));
        assertEquals(0,airport.getPlanes().size());
    }

    @Test
    @DisplayName("Plane cannot takeoff if weather is Stormy")
    void takeOffPlaneStormy() {
        airport.landPlane(new Plane("Ahmed"), new Weather("Clear"));
        airport.takeOff("Ahmed", new Weather("Stormy"));
        assertEquals(1,airport.getPlanes().size());
    }

    @Test
    @DisplayName("When Hanger is full planes cannot land")
    void hangerCapacityFull() {
        airport.landPlane(new Plane("Jimmy"), new Weather("Clear"));
        airport.landPlane(new Plane("Fallon"), new Weather("Clear"));
        airport.landPlane(new Plane("Carter"), new Weather("Clear"));
        assertFalse(airport.landPlane(new Plane("BOOO"), new Weather("Clear")));
    }

    @Test
    @DisplayName("Able to change current capcity of airport hanger")
    void hangerCapacityChange() {
        airport.landPlane(new Plane("Jimmy"), new Weather("Clear"));
        airport.landPlane(new Plane("Fallon"), new Weather("Clear"));
        airport.landPlane(new Plane("Carter"), new Weather("Clear"));
        airport.landPlane(new Plane("Jimmy"), new Weather("Clear"));
        airport.setCapacity(4);
        assertTrue(airport.landPlane(new Plane("BOOO"), new Weather("Clear")));
    }

}