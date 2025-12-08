package entities;
import enums_records.OpenableSound;
import enums_records.OpenableState;
import enums_records.Position;
import exceptions.CannotOpenException;
import java.util.logging.Logger;
import interfaces.Lockable;

public abstract class Passage implements Lockable {
    protected boolean isLocked;
    protected OpenableState openState;
    protected final String name;
    protected OpenableSound soundModifier;
    protected final Position position;

    private static final Logger log = Logger.getLogger(Passage.class.getName());
    
    public Passage(Position position, OpenableSound soundModifier, String name) {
        this.position = position;
        this.soundModifier = soundModifier;
        this.name = name;
    }

    public Passage(Position position, String name) {
        this(position, OpenableSound.NONE, name);
    }

    public void makeSound() {
        log.info(this.name + " " + soundModifier.toString() + " " + this.openState.getSound());
    }   

    @Override
    public void open() throws CannotOpenException {
        this.openState = OpenableState.OPENED;
        this.makeSound();
    }
    
    @Override
    public void close() {
        this.openState = OpenableState.CLOSED;
        this.makeSound();
    }

    @Override
    public void setLocked(boolean locked) {
        this.isLocked = locked;
    }

    @Override
    public boolean getLocked() {
        return this.isLocked;
    }

    @Override
    public String toString() {
        return name + "[место=" + position + ", открыта=" + openState.getState() + "]";
    }
    
    public OpenableState getOpenState() {
        return openState;
    }

    public Position getPosition() {
        return position;
    }
}