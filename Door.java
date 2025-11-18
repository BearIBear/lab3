import java.util.Objects;

public class Door extends Passage {
    @SuppressWarnings("unused")
    private Button button;

    public Door(Position location, Button button) {
        super(location);
        this.button = button;
    }
    
    public Door() {
        this(new Position("дом","вход"), null);
    }
    
    public void setButton(Button button) {
        this.button = button;
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
        String action = isOpen ? "отворилась" : "закрылась";
        System.out.println("Дверь бесшумно " + action);
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