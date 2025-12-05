package entities;
import java.util.Objects;
import java.util.logging.Logger;
import enums_records.Position;
import interfaces.Positionable;

public class Wall implements Positionable {
    private House house;
    private Button mountedButton;
    private Door mountedDoor;
    private final Position position;
    private static final Logger log = Logger.getLogger(Wall.class.getName());

    public Wall(House house, String area) {
        house.setWall(this);
        this.house = house;
        this.position = new Position(house.getName(), area);
    }

    public Wall(Position position) {
        this.position = position;
    }

    public void mountButton(Button button) {
        mountedButton = button;
        log.info("Кнопка установлена на стене " + position);
    }

    public void mountDoor(Door door) {
        mountedDoor = door;
        log.info("Дверь установлена в стене " + position);
    }

    @Override
    public String toString() {
        String output = "Wall[position=" + position;
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
        position.equals(wall.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, mountedButton);
    }

    public Button getMountedButton() {
        return mountedButton;
    }

    public Position getPosition() {
        return position;
    }

    public House getHouse() {
        return house;
    }
}