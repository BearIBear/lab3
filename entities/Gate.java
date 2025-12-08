package entities;
import java.util.Objects;
import enums_records.Position;
import exceptions.CannotOpenException;

public class Gate extends Passage {
    private Street street;

    public Gate(Position location, String name) {
        super(location, name);
    }

    public Gate(Street street, String area, String name) {
        super(new Position(street.getName(), area), name);
        street.setGate(this);
        this.street = street;
    }

    @Override
    public void open() throws CannotOpenException {
        if (isLocked) {
            throw new CannotOpenException("Калитка заперта");
        }
        super.open();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Gate g) || obj == null) return false;
        return Objects.equals(name, g.name) && Objects.equals(position, g.position);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }

    public Street getStreet() {
        return street;
    }
}