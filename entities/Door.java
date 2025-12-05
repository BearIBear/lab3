package entities;
import java.util.Objects;
import java.util.logging.Logger;
import enums_records.OpenableState;
import enums_records.Position;
import exceptions.CannotOpenException;

public class Door extends Passage {
    private  House house;
    private static final Logger log = Logger.getLogger(Door.class.getName());

    public Door(House house, String area, String name) {
        super(new Position(house.getName(), area));
        house.setDoor(this);
        this.house = house;
        this.name = name;
    }

    public Door(Position location, String name) {
        super(location);
        this.name = name;
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
    public void makeSound() {
        String action = isOpen ? OpenableState.OPENED.toString() : OpenableState.CLOSED.toString();
        log.info("Дверь " + soundModifier.toString() + action);
    }
    
    @Override
    public String toString() {
        return "Дверь[место=" + position + ", открыта=" + isOpen + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Door d)) return false;
        return isOpen == d.isOpen && Objects.equals(position, d.position);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(position, isOpen);
    }

    public House getHouse() {
        return house;
    }
}