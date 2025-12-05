package interfaces;
import exceptions.CannotOpenException;

public interface Openable extends Positionable {
    void open() throws CannotOpenException;
    void close();
}