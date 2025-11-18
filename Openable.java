public interface Openable {
    void open() throws CannotOpenException;
    void close();
}