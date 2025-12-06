package entities;
import java.util.Objects;
import enums_records.Position;
import exceptions.CannotOpenException;

public class Gate extends Passage {
    private Street street;

    public Gate(Position location, String name) {
        super(location);
        this.name = name;
    }

    public Gate(Street street, String area, String name) {
        super(new Position(street.getName(), area));
        street.setGate(this);
        this.street = street;
        this.name = name;
    }

    @Override
    public void open() throws CannotOpenException {
        if (isLocked) {
            throw new CannotOpenException("Калитка заперта");
        }
        super.open();
    }
    
    // @Override
    // public void makeSound() {
    //     String action = isOpen ? OpenableState.OPENED.toString() : OpenableState.CLOSED.toString();
    //     log.info("Калитка " + soundModifier.toString() + action);
    // }
    
    // @Override
    // public String toString() {
    //     return "Калитка[место=" + position + ", открыта=" + openState.toString() + "]";
    // }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Gate g)) return false;
        return openState == g.openState && Objects.equals(position, g.position);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(position, openState);
    }

    public Street getStreet() {
        return street;
    }
}