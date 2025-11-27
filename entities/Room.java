package entities;
import java.util.HashSet;
import java.util.Objects;

import enums_records.Position;

public class Room {
    private final Position location;
    private final HashSet<Halfling> visitors = new HashSet<>();

    public Room(Position location) {
        this.location = location;
    }
    
    public void addVisitor(Halfling friend) {
        visitors.add(friend);
    }
    
    public boolean hasVisitor(Halfling friend) {
        return visitors.contains(friend);
    }
    
    @Override
    public String toString() {
        return "Room[visitors=" + visitors.size() + ", location=" + location + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return location.equals(room.location) &&
        visitors.equals(room.visitors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, visitors);
    }
}