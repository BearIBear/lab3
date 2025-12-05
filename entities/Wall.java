package entities;
import java.util.Objects;
import java.util.logging.Logger;
import enums_records.Position;

public class Wall {
    private Button mountedButton;

    private Door mountedDoor;
    private final Position location;
    private static final Logger log = Logger.getLogger(Wall.class.getName());
    
    public Wall(Position location) {
        this.location = location;
    }
    
    public void mountButton(Button button) {
        mountedButton = button;
        log.info("Кнопка установлена на стене " + location);
    }

    public void mountDoor(Door door) {
        mountedDoor = door;
        log.info("Дверь установлена в стене " + location);
    }

    @Override
    public String toString() {
        String output = "Wall[location=" + location;
        if (mountedButton != null) {
            output += ", button=" + mountedButton;
        }
        if (mountedDoor != null) {
            output += ", door=" + mountedDoor;
        }
        return output + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wall wall = (Wall) o;
        return mountedButton.equals(wall.mountedButton) &&
        location.equals(wall.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, mountedButton);
    }

    public Button getMountedButton() {
        return mountedButton;
    }
}