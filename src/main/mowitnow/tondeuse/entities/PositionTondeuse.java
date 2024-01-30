package main.mowitnow.tondeuse.entities;

public class PositionTondeuse {

    private Position positionTondeuse;
    private ParamsTondeuse.Orientation orientationTondeuse;

    public PositionTondeuse(Position positionTondeuse, ParamsTondeuse.Orientation orientationTondeuse) {
        this.positionTondeuse = positionTondeuse;
        this.orientationTondeuse = orientationTondeuse;
    }

    public Position getPositionTondeuse() {
        return positionTondeuse;
    }

    public void setPositionTondeuse(Position positionTondeuse) {
        this.positionTondeuse = positionTondeuse;
    }

    public ParamsTondeuse.Orientation getOrientationTondeuse() {
        return orientationTondeuse;
    }

    public void setOrientationTondeuse(ParamsTondeuse.Orientation orientationTondeuse) {
        this.orientationTondeuse = orientationTondeuse;
    }
}
