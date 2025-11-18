public class CannotOpenException extends Exception {
    public CannotOpenException(String message) {
        super(message);
    }
    
    @Override
    public String getMessage() {
        return "ОШИБКА ОТКРЫТИЯ: " + super.getMessage();
    }
}