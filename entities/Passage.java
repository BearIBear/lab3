package entities;
import enums_records.OpenableSound;
import enums_records.Position;
import exceptions.CannotOpenException;
import interfaces.Lockable;

public abstract class Passage implements Lockable {
    protected boolean isLocked;
    protected boolean isOpen;
    protected OpenableSound soundModifier;
    protected final Position location;
    
    public Passage(Position location, OpenableSound soundModifier) {
        this.location = location;
        this.soundModifier = soundModifier;
    }

    public Passage(Position location) {
        this(location, OpenableSound.NONE);
    }

    public abstract void makeSound();
    
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
}