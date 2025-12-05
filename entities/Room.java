package entities;
import java.util.HashSet;
import java.util.Objects;
import enums_records.Position;
import interfaces.Positionable;

public class Room implements Positionable {
    private final Position position;


    private final HashSet<Halfling> visitors = new HashSet<>();

    public Room(Position position) {
        this.position = position;
    }
    
    public void addVisitor(Halfling friend) {
        visitors.add(friend);
    }
    
    public boolean hasVisitor(Halfling friend) {
        return visitors.contains(friend);
    }
    
    @Override
    public String toString() {
        return "Room[visitors=" + visitors.size() + ", position=" + position + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return position.equals(room.position) &&
        visitors.equals(room.visitors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, visitors);
    }

    public Position getPosition() {
        return position;
    }
}