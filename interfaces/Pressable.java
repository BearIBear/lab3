package interfaces;
import exceptions.CannotOpenException;

public interface Pressable extends Positionable {
    void press() throws CannotOpenException;
}