package entities;
import enums_records.OpenableSound;
import enums_records.OpenableState;
import enums_records.Position;
import exceptions.CannotOpenException;
import java.util.logging.Logger;
import interfaces.Lockable;

public abstract class Passage implements Lockable {
    protected boolean isLocked;
    protected boolean isOpen;
    protected String name;
    protected OpenableSound soundModifier;
    protected final Position position;

    private static final Logger log = Logger.getLogger(Passage.class.getName());
    
    public Passage(Position position, OpenableSound soundModifier) {
        this.position = position;
        this.soundModifier = soundModifier;
    }

    public Passage(Position position) {
        this(position, OpenableSound.NONE);
    }

    public void makeSound() {
        String action = isOpen ? OpenableState.OPENED.toString() : OpenableState.CLOSED.toString();
        log.info(this.name + " " + soundModifier.toString() + action);
    }   

    @Override
    public void open() throws CannotOpenException {
        this.isOpen = true;
        this.makeSound();
    }
    
    @Override
    public void close() {
        this.isOpen = false;
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
    
    public boolean isOpen() {
        return isOpen;
    }

    public Position getPosition() {
        return position;
    }
}