package entities;

public class Street {
    private final String name;
    private Gate gate;

    public Street(String name, Gate gate) {
        this.name = name;
        this.gate = gate;
    }

    public Street(String name) {
        this.name = name;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public String getName() {
        return this.name;
    }

    public Gate getGate() {
        return this.gate;
    }
}
