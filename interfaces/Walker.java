package interfaces;

import enums_records.Direction;

public interface Walker extends Positionable {
    void walk(Direction direction);
}
