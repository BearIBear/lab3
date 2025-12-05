package interfaces;
import enums_records.Material;
import enums_records.Position;

public interface Climbable {
    int getSteps();
    Material getMaterial();
    Position getPosition();
    Position getTop();
    Position getBottom();
}
