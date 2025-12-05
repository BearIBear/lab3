package interfaces;

public interface Lockable extends Openable {
    void setLocked(boolean locked);
    boolean getLocked();
}