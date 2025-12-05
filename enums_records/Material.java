package enums_records;

public enum Material {
    WOOD("Деревянная"),
    STONE("Каменная");

    private final String russian;
    
    Material(String russian) {
        this.russian = russian;
    }

    public String toString() {
        return this.russian;
    }
}
