package enums_records;

public enum OpenableState {
    OPENED("отворилась", true),
    CLOSED("закрылась", false);

    private final String sound;
    private final Boolean state;

    OpenableState(String sound, Boolean state) {
        this.sound = sound;
        this.state = state;
    }

    public String getSound() {
        return sound;
    }

    public Boolean getState() {
        return state;
    }
}
