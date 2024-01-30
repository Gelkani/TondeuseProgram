package test.mowitnow.tondeuse.entities;

import main.mowitnow.tondeuse.entities.ParamsTondeuse;
import main.mowitnow.tondeuse.entities.Position;
import main.mowitnow.tondeuse.entities.PositionTondeuse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTondeuseTest {

    @Test
    public void verify_Position_Tondeuse_valid(){
        PositionTondeuse posT= new PositionTondeuse(new Position(4,4), ParamsTondeuse.Orientation.NORTH);
        PositionTondeuse posValid= new PositionTondeuse(new Position(4,4), ParamsTondeuse.Orientation.NORTH);
        PositionTondeuse posNotValid= new PositionTondeuse(new Position(4,4), ParamsTondeuse.Orientation.SOUTH);
        assertAll("position Tondeuse",
                () -> assertTrue(posT.getPositionTondeuse().equals(posValid.getPositionTondeuse())),
                () -> assertTrue(posT.getOrientationTondeuse().equals(posValid.getOrientationTondeuse())));
        assertFalse(posT.equals(posNotValid));
    }
}
