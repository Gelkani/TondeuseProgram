package main.mowitnow.tondeuse.parserUtilities;

import main.mowitnow.tondeuse.entities.ParamsTondeuse;

public class ParserData {

    public ParserData() {
    }

    public static boolean parseTondeuse(String tondeuse){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(ParamsTondeuse.Orientation.NORTH.getOrientationCode())
                .append("|").append(ParamsTondeuse.Orientation.SOUTH.getOrientationCode())
                .append("|").append(ParamsTondeuse.Orientation.EAST.getOrientationCode())
                .append("|").append(ParamsTondeuse.Orientation.WEST.getOrientationCode());
        return tondeuse.matches("(\\d+) (\\d+) (" + stringBuilder.toString()+")");
    }

    public static boolean parseListInstruction(String instructions){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("(").append(ParamsTondeuse.InstructionTondeuse.AVANCER.getInstructionCode())
                .append("|").append(ParamsTondeuse.InstructionTondeuse.DROITE.getInstructionCode())
                .append("|").append(ParamsTondeuse.InstructionTondeuse.GAUCHE.getInstructionCode())
                .append(")+");

        return instructions.matches(stringBuilder.toString());
    }
    public static boolean parsePelouse(String pelouse){
        return pelouse.matches("(\\d+) (\\d+)");
    }
}
