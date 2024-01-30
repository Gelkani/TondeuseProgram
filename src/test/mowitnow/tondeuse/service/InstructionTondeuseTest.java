package test.mowitnow.tondeuse.service;

import main.mowitnow.tondeuse.entities.ParamsTondeuse;
import main.mowitnow.tondeuse.entities.Position;
import main.mowitnow.tondeuse.entities.PositionTondeuse;
import main.mowitnow.tondeuse.exception.ExceptionTondeuse;
import main.mowitnow.tondeuse.service.InstructionTondeuse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionTondeuseTest {

    @Test
    public void position_x_y_south_instruction_Turn_To_Right() throws ExceptionTondeuse {
        Position positionMax = new Position(5, 5);
        int x = 2;
        int y = 3;
        Position position = new Position(x, y);
        PositionTondeuse positionTondeuse = new PositionTondeuse(position, ParamsTondeuse.Orientation.SOUTH);
        InstructionTondeuse.executeInstruction(positionTondeuse, ParamsTondeuse.InstructionTondeuse.DROITE, positionMax);
        assertEquals(positionTondeuse.getPositionTondeuse(), new Position(x, y));
        assertEquals(positionTondeuse.getOrientationTondeuse(), ParamsTondeuse.Orientation.WEST);
    }


    @Test
    public void move_to_right() throws ExceptionTondeuse{

        ParamsTondeuse.Orientation nextOrientation = InstructionTondeuse.moveToRight(ParamsTondeuse.Orientation.EAST);
        assertEquals(nextOrientation , ParamsTondeuse.Orientation.SOUTH);

        nextOrientation = InstructionTondeuse.moveToRight(ParamsTondeuse.Orientation.WEST);
        assertEquals(nextOrientation , ParamsTondeuse.Orientation.NORTH);

        nextOrientation = InstructionTondeuse.moveToRight(ParamsTondeuse.Orientation.NORTH);
        assertEquals(nextOrientation, ParamsTondeuse.Orientation.EAST);

        nextOrientation = InstructionTondeuse.moveToRight(ParamsTondeuse.Orientation.SOUTH);
        assertEquals(nextOrientation ,ParamsTondeuse.Orientation.WEST);
    }

    @Test
    public void move_to_left() throws ExceptionTondeuse{
        ParamsTondeuse.Orientation nextOrientation = InstructionTondeuse.moveToLeft(ParamsTondeuse.Orientation.EAST);
        assertEquals(nextOrientation,ParamsTondeuse.Orientation.NORTH);

        nextOrientation = InstructionTondeuse.moveToLeft(ParamsTondeuse.Orientation.WEST);
        assertEquals(nextOrientation ,ParamsTondeuse.Orientation.SOUTH);

        nextOrientation = InstructionTondeuse.moveToLeft(ParamsTondeuse.Orientation.NORTH);
        assertEquals(nextOrientation , ParamsTondeuse.Orientation.WEST);

        nextOrientation = InstructionTondeuse.moveToLeft(ParamsTondeuse.Orientation.SOUTH);
        assertEquals(nextOrientation , ParamsTondeuse.Orientation.EAST);
    }
}
