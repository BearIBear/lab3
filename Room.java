import java.util.ArrayList;
import java.util.List;

public class Room {
    // TODO: Добавить поддержку Position
    private final List<Friend> visitors = new ArrayList<>();
    
    public void addVisitor(Friend friend) {
        visitors.add(friend);
    }
    
    public boolean hasVisitor(Friend friend) {
        return visitors.contains(friend);
    }
    
    @Override
    public String toString() {
        return "Комната[посетители=" + visitors.size() + " чел.]";
    }
}