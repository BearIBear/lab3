package interfaces;

import enums_records.Position;

public interface Climbable {
    int getSteps();
    String getMaterial();
    Position getLocation();
    Position getTop();
    Position getBottom();
}
