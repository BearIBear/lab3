package entities;
import java.util.Objects;
import java.util.logging.Logger;

import enums_records.OpenableState;
import enums_records.Position;
import exceptions.CannotOpenException;

public class Door extends Passage {
    private static final Logger log = Logger.getLogger(Door.class.getName());

    public Door(Position location) {
        super(location);
    }
    
    public Door() {
        this(new Position("дом","вход"));
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
        return "Дверь[место=" + location + ", открыта=" + isOpen + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Door d)) return false;
        return isOpen == d.isOpen && Objects.equals(location, d.location);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(location, isOpen);
    }
}