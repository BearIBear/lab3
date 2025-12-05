package enums_records;

public enum OpenableSound {
    NONE(""),
    SILENT("бесшумно"),
    LOUD("громко");

    private final String russian;

    OpenableSound(String russian) {
        this.russian = russian;
    }

    public String toString() {
        return russian;
    }
}
