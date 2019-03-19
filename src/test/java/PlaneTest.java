import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {
    Plane plane = new Plane("British Airways");

    @Test
    @DisplayName("Is the plane landed on default")
    void isLanded() {
        assertFalse(plane.isLanded());
    }

    @Test
    @DisplayName("Able to set plane if landed or not")
    void setLanded() {
        plane.setLanded(true);
        assertTrue(plane.isLanded());
    }
}