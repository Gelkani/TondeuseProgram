package test.mowitnow.tondeuse.service;

import main.mowitnow.tondeuse.entities.ParamsTondeuse;
import main.mowitnow.tondeuse.entities.Pelouse;
import main.mowitnow.tondeuse.entities.Position;
import main.mowitnow.tondeuse.service.FormatLine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FormatLineTest {
    @Test
    public void format_line_tondeuse() {
        assertEquals(FormatLine.formatLineTondeuse("10 15 N").getPositionTondeuse(),new Position(10, 15));
        assertEquals(FormatLine.formatLineTondeuse("10 15 N").getOrientationTondeuse(),ParamsTondeuse.Orientation.NORTH);
    }

    @Test
    public void format_line_pelouse() {
        assertEquals(FormatLine.formatLinePelouse("10 15").getPositionMax(),new Pelouse(new Position(10, 15)).getPositionMax());
    }

    @Test
    public void format_line_instruction() {
        assertEquals(FormatLine.formatLineInstruction("DGA").get(0), ParamsTondeuse.InstructionTondeuse.DROITE);
        assertEquals(FormatLine.formatLineInstruction("DGA").get(1), ParamsTondeuse.InstructionTondeuse.GAUCHE);
        assertEquals(FormatLine.formatLineInstruction("DGA").get(2), ParamsTondeuse.InstructionTondeuse.AVANCER);

    }

    @Test
    public void retrieve_orientation() {
        assertEquals(FormatLine.getOrientation('E'),ParamsTondeuse.Orientation.EAST);
        assertEquals(FormatLine.getOrientation('N') , ParamsTondeuse.Orientation.NORTH);
        assertEquals(FormatLine.getOrientation('S') ,ParamsTondeuse.Orientation.SOUTH);
        assertEquals(FormatLine.getOrientation('W') , ParamsTondeuse.Orientation.WEST);
        assertNull(FormatLine.getOrientation('a'));
    }

    @Test
    public void testGetInstruction() {
        assertEquals(FormatLine.getInstruction('A'), ParamsTondeuse.InstructionTondeuse.AVANCER);
        assertEquals(FormatLine.getInstruction('D'), ParamsTondeuse.InstructionTondeuse.DROITE);
        assertEquals(FormatLine.getInstruction('G'), ParamsTondeuse.InstructionTondeuse.GAUCHE);
        assertNull(FormatLine.getInstruction(' '));
    }

}
