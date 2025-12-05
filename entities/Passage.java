package entities;
// import java.util.logging.Logger;

import enums_records.Position;
import exceptions.CannotOpenException;
import interfaces.Openable;

public abstract class Passage implements Openable {
    protected boolean isLocked;
    protected boolean isOpen;
    protected final Position location;

    
    public Passage(Position location) {
        this.location = location;
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
    
    public boolean isOpen() {
        return isOpen;
    }
}