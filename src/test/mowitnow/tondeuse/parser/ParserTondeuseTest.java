package test.mowitnow.tondeuse.parser;

import main.mowitnow.tondeuse.parserUtilities.ParserTondeuse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTondeuseTest {

    @Test
    public void parse_tondeuse(){
        ParserTondeuse parserTondeuse = new ParserTondeuse();
        parserTondeuse.setInstructions("DGDGA");
        parserTondeuse.setPelouse("50 5");
        parserTondeuse.setTondeuse("1 2 N");
        assertTrue(parserTondeuse.executeParse());
    }
    @Test

    public void parse_tondeuse_pelouse_wrong(){
        ParserTondeuse parserTondeuse = new ParserTondeuse();
        parserTondeuse.setInstructions("DGDGA");
        parserTondeuse.setPelouse("0 -1");
        parserTondeuse.setTondeuse("1 2 N");
        assertFalse(parserTondeuse.executeParse());
    }

    @Test
    public void parse_tondeuse_empty_data(){
        ParserTondeuse parserTondeuse = new ParserTondeuse();
        assertFalse(parserTondeuse.executeParse());
    }
}
