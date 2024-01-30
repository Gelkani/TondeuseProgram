package main.mowitnow.tondeuse.entities;

public class ParamsTondeuse {
    public static enum Orientation {
        NORTH('N', "Nord"),
        EAST('E', "Est"),
        WEST('W', "Ouest"),
        SOUTH('S', "Sud");

        private char orientationCode;
        private String orientationLabel;

        private Orientation(char orientationCode, String orientationLabel){
            this.orientationCode = orientationCode;
            this.orientationLabel = orientationLabel;
        }
        public char getOrientationCode() {
            return orientationCode;
        }
        public String getOrientationLabel() {
            return orientationLabel;
        }
    }


    public static enum InstructionTondeuse{
        DROITE('D', "Pivoter à droite"),
        GAUCHE('G', "Pivoter à gauche"),
        AVANCER('A', "Avancer");

        private String instructionLabel;
        private char instructionCode;

        private InstructionTondeuse(char instructionCode, String instructionLabel) {
            this.instructionLabel = instructionLabel;
            this.instructionCode = instructionCode;
        }

        public String getInstructionLabel() {
            return instructionLabel;
        }
        public char getInstructionCode() {
            return instructionCode;
        }

    }


    public static final String ERROR_WRONG_DATA= "données incorrectes";
    public static final String ERROR_FILE_NOT_EXISTENT= "fichier inexistant";
    public static final String WRONG_ORIENTATION = "orientation incorrecte";
    public static final String WRONG_INSTRUCTION = "instruction incorrecte";
    public static final String WRONG_POSITION = "position incorrecte";
}
