package entities;

public class House {
    private final Stairs stairs;
    private final Wall wall;
    private final Room room;
    private final Door door; // Храним ссылку, даже если она есть в стене, для удобства доступа

    public House(Stairs stairs, Wall wall, Room room, Door door) {
        this.stairs = stairs;
        this.wall = wall;
        this.room = room;
        this.door = door;
    }

    public Stairs getStairs() {
        return stairs;
    }

    public Wall getWall() {
        return wall;
    }

    public Room getRoom() {
        return room;
    }

    public Door getDoor() {
        return door;
    }
}
