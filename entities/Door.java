package entities;
import java.util.Objects;
import enums_records.Position;
import exceptions.CannotOpenException;

public class Door extends Passage {
    private House house;

    public Door(House house, String area, String name) {
        super(new Position(house.getName(), area), name);
        house.setDoor(this);
        this.house = house;
    }

    public Door(Position location, String name) {
        super(location, name);
    }

    public void setLocked(boolean state) {
        this.isLocked = state;
    }

    @Override
    public void open() throws CannotOpenException {
        if (isLocked) {
            throw new CannotOpenException("Дверь заперта");
        }
        super.open();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Door d)) return false;
        return openState == d.openState && Objects.equals(position, d.position);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(position, openState);
    }

    public House getHouse() {
        return house;
    }
}