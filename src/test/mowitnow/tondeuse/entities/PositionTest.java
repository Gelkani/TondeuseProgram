package test.mowitnow.tondeuse.entities;

import main.mowitnow.tondeuse.entities.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PositionTest {

    @Test
    public void verify_equal_Position(){
        Position p1= new Position(1,2);
        Position p2 = new Position( 1,2);
        assertEquals(p1, p2);
    }

    @Test
    public void verify_valid_position() {
        Position positionPelouse = new Position(4, 4);
        Position p1 = new Position(1, 0);
        Position p2 = new Position(-2, 2);
        assertTrue(positionPelouse.isPositionValid(p1));
        assertFalse(positionPelouse.isPositionValid(p2));
    }

}
