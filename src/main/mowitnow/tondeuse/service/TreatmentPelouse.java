package main.mowitnow.tondeuse.service;

import main.mowitnow.tondeuse.entities.ParamsTondeuse;
import main.mowitnow.tondeuse.entities.Pelouse;
import main.mowitnow.tondeuse.entities.PositionTondeuse;
import main.mowitnow.tondeuse.exception.ExceptionTondeuse;

import java.util.List;

public class TreatmentPelouse {

    private Pelouse pelouse;
    private PositionTondeuse positionTondeuse;
    private List<ParamsTondeuse.InstructionTondeuse> listInstruction;

    public void setPelouse(Pelouse pelouse) {
        this.pelouse = pelouse;
    }

    public void setPositionTondeuse(PositionTondeuse positionTondeuse) {
        this.positionTondeuse = positionTondeuse;
    }

    public void setListInstruction(List<ParamsTondeuse.InstructionTondeuse> listInstruction) {
        this.listInstruction = listInstruction;
    }

    public void executeInstructions() throws ExceptionTondeuse {
        for(ParamsTondeuse.InstructionTondeuse instruction : listInstruction){
            InstructionTondeuse.executeInstruction(positionTondeuse,
                    instruction, this.pelouse.getPositionMax());
        }
    }

    public String toString(){
        return 	positionTondeuse.getPositionTondeuse().getX()
                + " "
                + positionTondeuse.getPositionTondeuse().getY()
                + " "
                + positionTondeuse.getOrientationTondeuse().getOrientationCode() ;
    }
}
