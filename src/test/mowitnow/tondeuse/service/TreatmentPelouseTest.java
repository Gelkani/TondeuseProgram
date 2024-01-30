package test.mowitnow.tondeuse.service;

import main.mowitnow.tondeuse.entities.ParamsTondeuse;
import main.mowitnow.tondeuse.entities.Pelouse;
import main.mowitnow.tondeuse.entities.Position;
import main.mowitnow.tondeuse.entities.PositionTondeuse;
import main.mowitnow.tondeuse.exception.ExceptionTondeuse;
import main.mowitnow.tondeuse.service.TreatmentPelouse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreatmentPelouseTest {
    Position positionMax = new Position(5, 5);

    @Test
    public void executer_instruction_aucune_instruction() throws ExceptionTondeuse {
        int x = 0;
        int y = 0;
        Position position = new Position(x, y);
        PositionTondeuse positionTondeuse = new PositionTondeuse(position, ParamsTondeuse.Orientation.NORTH);

        TreatmentPelouse traitementP = new TreatmentPelouse();
        traitementP.setPelouse(new Pelouse(positionMax));
        traitementP.setPositionTondeuse(positionTondeuse);
        traitementP.setListInstruction(new ArrayList<>());
        traitementP.executeInstructions();
        assertEquals(traitementP.toString(),("0 0 N"));
    }

    @Test
    public void execute_instruction_unitaire() throws ExceptionTondeuse{
        List<ParamsTondeuse.InstructionTondeuse> listInstruction = new ArrayList<>();
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.AVANCER);
        int x = 1;
        int y = 1;
        Position position = new Position(x, y);
        PositionTondeuse positionTondeuse = new PositionTondeuse(position, ParamsTondeuse.Orientation.NORTH);
        TreatmentPelouse traitementP = new TreatmentPelouse();
        traitementP.setPelouse(new Pelouse(positionMax));
        traitementP.setPositionTondeuse(positionTondeuse);
        traitementP.setListInstruction(listInstruction);
        traitementP.executeInstructions();
        assertEquals(traitementP.toString(), ("1 2 N"));
    }

    @Test
    public void executer_instruction_plusieurs() throws ExceptionTondeuse{
        List<ParamsTondeuse.InstructionTondeuse> listInstruction = new ArrayList<>();
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.GAUCHE);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.AVANCER);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.GAUCHE);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.AVANCER);
        int x = 3;
        int y = 2;
        Position position = new Position(x, y);
        PositionTondeuse positionTondeuse = new PositionTondeuse(position, ParamsTondeuse.Orientation.NORTH);
        TreatmentPelouse traitementP = new TreatmentPelouse();
        traitementP.setPelouse(new Pelouse(positionMax));
        traitementP.setPositionTondeuse(positionTondeuse);
        traitementP.setListInstruction(listInstruction);
        traitementP.executeInstructions();
        assertEquals(traitementP.toString(), ("2 1 S"));
    }

    @Test
    public void execute_instruction_case_example_line_1() throws ExceptionTondeuse{
        List<ParamsTondeuse.InstructionTondeuse> listInstruction = new ArrayList<>();
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.GAUCHE);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.AVANCER);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.GAUCHE);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.AVANCER);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.GAUCHE);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.AVANCER);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.GAUCHE);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.AVANCER);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.AVANCER);
        int x = 1;
        int y = 2;
        Position coordonnees = new Position(x, y);
        PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, ParamsTondeuse.Orientation.NORTH);
        TreatmentPelouse traitementP = new TreatmentPelouse();
        traitementP.setPelouse(new Pelouse(positionMax));
        traitementP.setPositionTondeuse(positionTondeuse);
        traitementP.setListInstruction(listInstruction);
        traitementP.executeInstructions();
        assertEquals(traitementP.toString(), ("1 3 N"));
    }
    @Test
    public void execute_instruction_example_line_2() throws ExceptionTondeuse{
        List<ParamsTondeuse.InstructionTondeuse> listInstruction = new ArrayList<>();
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.AVANCER);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.AVANCER);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.DROITE);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.AVANCER);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.AVANCER);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.DROITE);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.AVANCER);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.DROITE);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.DROITE);
        listInstruction.add(ParamsTondeuse.InstructionTondeuse.AVANCER);
        int x = 3;
        int y = 3;
        Position position = new Position(x, y);
        PositionTondeuse positionTondeuse = new PositionTondeuse(position, ParamsTondeuse.Orientation.EAST);
        TreatmentPelouse traitementP = new TreatmentPelouse();
        traitementP.setPelouse(new Pelouse(positionMax));
        traitementP.setPositionTondeuse(positionTondeuse);
        traitementP.setListInstruction(listInstruction);
        traitementP.executeInstructions();
        assertEquals(traitementP.toString(),("5 1 E"));
    }



}
