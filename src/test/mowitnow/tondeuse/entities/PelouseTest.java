package test.mowitnow.tondeuse.entities;

import main.mowitnow.tondeuse.entities.Pelouse;
import main.mowitnow.tondeuse.entities.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PelouseTest {

    @Test
    public void verify_equal_Pelouse(){
        Pelouse p1 = new Pelouse(new Position(1, 2));
        Pelouse p2 = new Pelouse(new Position(1, 2));
        assertTrue(p1.getPositionMax().equals(p2.getPositionMax()));
        p2 = new Pelouse(new Position(1, 3));
        assertFalse(p1.equals(p2));
    }
}
