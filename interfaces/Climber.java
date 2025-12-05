package interfaces;

public interface Climber extends Positionable {
    void climbUp(Climbable stairs, int steps);
    void climbDown(Climbable stairs, int steps);
}
