package enums_records;

public enum OpenableState {
    OPENED("отворилась"),
    CLOSED("закрылась");

    private final String russian;

    OpenableState(String russian) {
        this.russian = russian;
    }

    public String toString() {
        return russian;
    }
}
