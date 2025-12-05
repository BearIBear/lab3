package entities;
import java.util.Objects;
import java.util.logging.Logger;

import enums_records.Position;
import exceptions.CannotOpenException;

public class Gate extends Passage {
    private static final Logger log = Logger.getLogger(Gate.class.getName());

    public Gate(Position location) {
        super(location);
    }
    
    public Gate() {
        this(new Position("двор", "вход"));
    }
    
    public void setLocked(boolean locked) {
        this.isLocked = locked;
    }
    
    @Override
    public void open() throws CannotOpenException {
        if (isLocked) {
            throw new CannotOpenException("Калитка заперта");
        }
        super.open();
    }
    
    @Override
    public void makeSound() {
        String action = isOpen ? "открылась" : "закрылась";
        log.info("Калитка бесшумно " + action);
    }
    
    @Override
    public String toString() {
        return "Калитка[место=" + location + ", открыта=" + isOpen + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Gate g)) return false;
        return isOpen == g.isOpen && Objects.equals(location, g.location);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(location, isOpen);
    }
}