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
        // System.out.println("Проем '" + location + "' открыт");
    }
    
    @Override
    public void close() {
        this.isOpen = false;
        this.makeSound();
        // System.out.println("Проем '" + location + "' закрыт");
    }
    
    public boolean isOpen() {
        return isOpen;
    }
}