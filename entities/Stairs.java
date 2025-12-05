package entities;
import java.util.Objects;
import java.util.logging.Logger;
import enums_records.Material;
import enums_records.Position;
import interfaces.Climbable;

public class Stairs implements Climbable {
    private House house;
    private final Position position;
    private final Position top;
    private final Position bottom;
    private final int steps;
    private final Material material;
    private static final Logger log = Logger.getLogger(Stairs.class.getName());


    public Stairs(House house, String area, Position top, Position bottom, int steps, Material material) {
        house.setStairs(this);
        this.house = house;
        this.position = new Position(house.getName(), area);
        this.top = top;
        this.bottom = bottom;
        this.steps = steps;
        this.material = material;
    }

    public Stairs(Position position, Position top, Position bottom, int steps, Material material) {
        this.position = position;
        this.top = top;
        this.bottom = bottom;
        this.steps = steps;
        this.material = material;
    }
    
    public void climbUp(Halfling friend) {
        log.info(friend.getName() + " поднялся по " + material + " лестнице из " + steps + " ступеней");
        friend.setPosition(top);
    }
    
    public void climbDown(Halfling friend) {
        log.info(friend.getName() + " спустился по " + material + " лестнице из " + steps + " ступеней");
        friend.setPosition(bottom);
    }

    @Override
    public String toString() {
        return "Stairs[position=" + position + ", steps=" + steps + ", material=" + material + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stairs stairs = (Stairs) o;
        return steps == stairs.steps &&
            material.equals(stairs.material) &&
            position.equals(stairs.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, steps, material);
    }

    public House getHouse() {
        return house;
    }

    public Position getPosition() {
        return position;
    }

    public Material getMaterial() {
        return material;
    }

    public int getSteps() {
        return steps;
    }

    public Position getTop() {
        return top;
    }

    public Position getBottom() {
        return bottom;
    }
}