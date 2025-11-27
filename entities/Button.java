package entities;
import java.util.Objects;
import java.util.logging.Logger;

import enums_records.Position;
import exceptions.CannotOpenException;
import interfaces.Pressable;


public class Button implements Pressable {
    private int timesPressed;
    private Passage controlledPassage;
    private final Position location;
    private static final Logger log = Logger.getLogger(Button.class.getName());


    public Button(Position location) {
        this.location = location;
    }
    
    public Button() {
        this(new Position("дом", "стена у двери"));
    }
    
    public Position getPosition() {
        return location;
    }

    public int getTimesPressed() {
        return timesPressed;
    }
    
    public void setControlledPassage(Passage passage) {
        this.controlledPassage = passage;
    }
    
    @Override
    public void press() throws CannotOpenException {
        this.timesPressed += 1;
        log.info("Кнопка нажата");
        if (controlledPassage != null) {
            controlledPassage.open();
        }
    }

    @Override
    public String toString() {
        return "Button[location=" + location + ", pressed=" + timesPressed + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Button button = (Button) o;
        return timesPressed == button.timesPressed && 
               Objects.equals(controlledPassage, button.controlledPassage) && 
               Objects.equals(location, button.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timesPressed, controlledPassage, location);
    }
}