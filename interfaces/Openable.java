package interfaces;
import exceptions.CannotOpenException;

public interface Openable {
    void open() throws CannotOpenException;
    void close();
}