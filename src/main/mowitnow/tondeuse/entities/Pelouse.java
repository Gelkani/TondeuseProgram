package main.mowitnow.tondeuse.entities;

public class Pelouse {
    private Position positionMax;

    public Pelouse() {
    }

    public Pelouse(Position positionMax) {
        this.positionMax = positionMax;
    }

    public Position getPositionMax() {
        return positionMax;
    }

    public void setPositionMax(Position positionMax) {
        this.positionMax = positionMax;
    }

}
