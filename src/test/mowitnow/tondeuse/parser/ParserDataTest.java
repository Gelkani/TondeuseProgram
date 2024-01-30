package test.mowitnow.tondeuse.parser;

import main.mowitnow.tondeuse.parserUtilities.ParserData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserDataTest {

    @Test
    public void parse_tondeuse(){
        assertFalse(ParserData.parseTondeuse(""));
        assertFalse(ParserData.parseTondeuse("1 45"));
        assertFalse(ParserData.parseTondeuse("123S"));
        assertTrue(ParserData.parseTondeuse("1 2 N"));
        assertTrue(ParserData.parseTondeuse("1 2 S"));
    }

    @Test
    public void parse_list_instruction(){
        assertFalse(ParserData.parseListInstruction(""));
        assertFalse(ParserData.parseListInstruction(" "));
        assertFalse(ParserData.parseListInstruction("G D"));
        assertFalse(ParserData.parseListInstruction("GGAAGADGAS"));
        assertFalse(ParserData.parseListInstruction("GDAAGA ADGAS"));
        assertTrue(ParserData.parseListInstruction("GDA"));
        assertTrue(ParserData.parseListInstruction("GGAAAGADDA"));
    }

    @Test
    public void parse_pelouse(){
        assertFalse(ParserData.parsePelouse(""));
        assertFalse(ParserData.parsePelouse("1 2 3"));
        assertFalse(ParserData.parsePelouse("123"));
        assertFalse(ParserData.parsePelouse("1 2 "));
        assertTrue(ParserData.parsePelouse("1 2"));
        assertFalse(ParserData.parsePelouse("1 N"));
    }
}
