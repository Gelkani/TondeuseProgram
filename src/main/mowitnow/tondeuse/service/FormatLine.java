package main.mowitnow.tondeuse.service;

import main.mowitnow.tondeuse.entities.ParamsTondeuse;
import main.mowitnow.tondeuse.entities.Pelouse;
import main.mowitnow.tondeuse.entities.Position;
import main.mowitnow.tondeuse.entities.PositionTondeuse;

import java.util.ArrayList;
import java.util.List;

public class FormatLine {

    private static final String WHITESPACE= " ";

    public FormatLine() {
    }

    public static PositionTondeuse formatLineTondeuse(String ligneTondeuse){
        String[] elements = ligneTondeuse.split(WHITESPACE);
        Position pTondeuse = new Position(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
        ParamsTondeuse.Orientation orientationTondeuse = getOrientation(elements[2].charAt(0));
        return new PositionTondeuse(pTondeuse, orientationTondeuse);
    }

    public static Pelouse formatLinePelouse(String linePelouse){
        String[] elements = linePelouse.split(WHITESPACE);
        return new Pelouse(new Position(Integer.parseInt(elements[0]), Integer.parseInt(elements[1])));
    }

    public static List<ParamsTondeuse.InstructionTondeuse> formatLineInstruction(String lineInstruction){
        List<ParamsTondeuse.InstructionTondeuse> listInstruction = new ArrayList<ParamsTondeuse.InstructionTondeuse>();
        for(char instruction :lineInstruction.toCharArray()){
            listInstruction.add(getInstruction(instruction));
        }
        return listInstruction;
    }


    public static ParamsTondeuse.Orientation getOrientation(char cOrientation){
        for(ParamsTondeuse.Orientation orientation : ParamsTondeuse.Orientation.values()) {
            if (orientation.getOrientationCode() == cOrientation){
                return orientation;
            }
        }
        return null;
    }
    public static ParamsTondeuse.InstructionTondeuse getInstruction(char cInstruction){
        for(ParamsTondeuse.InstructionTondeuse instruction : ParamsTondeuse.InstructionTondeuse.values()) {
            if (instruction.getInstructionCode() == cInstruction) {
                return instruction;
            }
        }
        return null;
    }
}
