package entities;
import java.util.Objects;
import java.util.logging.Logger;

import enums_records.Direction;
import enums_records.Position;
import exceptions.CannotOpenException;
import exceptions.InvalidStateException;
import interfaces.Climbable;
import interfaces.Climber;
import interfaces.Walker;

public class Halfling implements Climber, Walker {
    private final String name;
    private Position position;
    private int elevation;
    private static final Logger log = Logger.getLogger(Halfling.class.getName());
    private boolean canSeeButton = false;
    
    public Halfling(String name, Position position) {
        if (name == null || name.isBlank()) {
            throw new InvalidStateException("Имя друга не может быть пустым");
        }
        this.name = name;
        this.position = position;
    }
    
    public void walk(Direction direction) {
        if (position == null) {
            throw new InvalidStateException("Друг не знает, где он находится!");
        }
        log.info(name + " повернул " + direction.toRussian() + " и пошел");
        this.position = new Position("дом", "около каменной лестницы");
    }
    
    public void enter(Passage passage) throws CannotOpenException {
        if (passage == null) {
            throw new InvalidStateException("Нет проема для входа");
        }
        if (!passage.isOpen) {
            passage.open();
        }
        log.info(name + " вошел");
    }
    
    public void climbUp(Climbable stairs, int steps) {
        if (elevation == stairs.getSteps()) {
            log.warning(this.name + " уже на вершине лестницы!");
            return;
        }
        for (int i = 0; i < steps; i++) {
            if (elevation != stairs.getSteps()) {
                elevation += 1;
                this.setPosition(new Position(stairs.getLocation().place(), elevation + " ступень " + stairs.toString()));
            } else {
                this.setPosition(stairs.getTop());
                log.info(this.name + " поднялся по лестнице");
                return;
            }
        }
    }

    public void climbDown(Climbable stairs, int steps) {
        if (elevation == 0) {
            log.warning(this.name + " уже спустился по лестнице!");
            return;
        }
        for (int i = 0; i < steps; i++) {
            if (elevation != 0) {
                elevation -= 1;
                this.setPosition(new Position(stairs.getLocation().place(), elevation + " ступень " + stairs.toString()));
            } else {
                this.setPosition(stairs.getBottom());
                log.info(this.name + " спустился по лестнице");
                return;
            }
        }
    }

    public void findButton(Wall wall) { // TODO: сделать поиск кнопки на стене, а не поиск кнопки по кнопке
        if (this.position.place().equals(wall.getMountedButton().getPosition().place())) {
            log.info(name + " отыскал кнопку на стене");
            this.canSeeButton = true;
        } else {
            log.info(name + " не отыскал кнопку на стене");
        } 
    }
    
    public void press(Button button) throws CannotOpenException {
        if (!canSeeButton) {
            throw new InvalidStateException("Не видит кнопку");
        }
        button.press();
    }
    
    public void appear(Room room) {
        room.addVisitor(this);
        this.position = new Position("комната", "вход");
        log.info(name + " очутился в комнате");
    }
    
    public String getStatus() {
        return name + " находится: " + position;
    }
    
    @Override
    public String toString() {
        return "Friend[name=" + name + ", position=" + position + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Halfling f)) return false;
        return Objects.equals(name, f.name) && Objects.equals(position, f.position);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }
}