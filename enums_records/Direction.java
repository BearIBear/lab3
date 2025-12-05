package enums_records;
public enum Direction {
    LEFT("налево"),
    RIGHT("направо"),
    STRAIGHT("прямо"),
    BACKWARD("назад");

    private final String russian;

    Direction(String russian) {
        this.russian = russian;
    }

    public String toRussian() {
        return russian;
    }
}