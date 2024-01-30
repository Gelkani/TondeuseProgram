package main.mowitnow.tondeuse.service;

import main.mowitnow.tondeuse.entities.ParamsTondeuse;
import main.mowitnow.tondeuse.entities.Position;
import main.mowitnow.tondeuse.entities.PositionTondeuse;
import main.mowitnow.tondeuse.exception.ExceptionTondeuse;


public class InstructionTondeuse {

    public InstructionTondeuse() {
    }
    public static Position moveForwardTondeuse(PositionTondeuse positionTondeuse, Position positionMax) throws ExceptionTondeuse {
        Position nextPosition = null;
        int x, y;
        switch (positionTondeuse.getOrientationTondeuse()) {
            case NORTH:
                x = positionTondeuse.getPositionTondeuse().getX();
                y = positionTondeuse.getPositionTondeuse().getY() + 1;
                break;
            case EAST:
                x = positionTondeuse.getPositionTondeuse().getX() + 1;
                y = positionTondeuse.getPositionTondeuse().getY();
                break;
            case SOUTH:
                x = positionTondeuse.getPositionTondeuse().getX();
                y = positionTondeuse.getPositionTondeuse().getY() - 1;
                break;
            case WEST:
                x = positionTondeuse.getPositionTondeuse().getX() - 1;
                y = positionTondeuse.getPositionTondeuse().getY();
                break;
            default:
                throw new ExceptionTondeuse(ParamsTondeuse.WRONG_POSITION);
        }
        nextPosition = new Position(x, y);
        if (nextPosition != null
                && positionMax.isPositionValid(nextPosition)) {
            return nextPosition;
        } else {
            return positionTondeuse.getPositionTondeuse();
        }
    }

    public static ParamsTondeuse.Orientation moveToRight(ParamsTondeuse.Orientation orientation) throws ExceptionTondeuse{
        ParamsTondeuse.Orientation orientationSuivante = null ;
        switch (orientation){
            case NORTH :
                orientationSuivante =  ParamsTondeuse.Orientation.EAST;
                break;
            case EAST :
                orientationSuivante =  ParamsTondeuse.Orientation.SOUTH;
                break;
            case SOUTH :
                orientationSuivante =  ParamsTondeuse.Orientation.WEST;
                break;
            case WEST :
                orientationSuivante =  ParamsTondeuse.Orientation.NORTH;
                break;
            default :
                throw new ExceptionTondeuse(ParamsTondeuse.WRONG_ORIENTATION);
        }
        return orientationSuivante;
    }

    public static ParamsTondeuse.Orientation moveToLeft(ParamsTondeuse.Orientation orientation) throws ExceptionTondeuse{
        ParamsTondeuse.Orientation orientationSuivante = null ;
        switch (orientation){
            case NORTH :
                orientationSuivante =  ParamsTondeuse.Orientation.WEST;
                break;
            case EAST :
                orientationSuivante =  ParamsTondeuse.Orientation.NORTH;
                break;
            case SOUTH :
                orientationSuivante =  ParamsTondeuse.Orientation.EAST;
                break;
            case WEST :
                orientationSuivante =  ParamsTondeuse.Orientation.SOUTH;
                break;
            default :
                throw new ExceptionTondeuse(ParamsTondeuse.WRONG_ORIENTATION);
        }
        return orientationSuivante;
    }

    public static void executeInstruction(PositionTondeuse positionTondeuse, ParamsTondeuse.InstructionTondeuse instruction,Position positionMax) throws ExceptionTondeuse{

        switch (instruction){
            case AVANCER :
                positionTondeuse.setPositionTondeuse(InstructionTondeuse.moveForwardTondeuse(positionTondeuse, positionMax));
                break;
            case DROITE :
                positionTondeuse.setOrientationTondeuse(InstructionTondeuse.moveToRight(positionTondeuse.getOrientationTondeuse()));
                break;
            case GAUCHE :
                positionTondeuse.setOrientationTondeuse(InstructionTondeuse.moveToLeft(positionTondeuse.getOrientationTondeuse()));
                break;
            default: throw new ExceptionTondeuse(ParamsTondeuse.WRONG_INSTRUCTION);
        }
    }
}
