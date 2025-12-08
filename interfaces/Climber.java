package interfaces;

import enums_records.Position;

public interface Climber extends Positionable {
    void setPosition(Position position);
    String getName();
    void climbUp(Climbable stairs, int steps);
    void climbDown(Climbable stairs, int steps);
}
