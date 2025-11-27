package interfaces;
import exceptions.CannotOpenException;

public interface Pressable {
    void press() throws CannotOpenException;
}