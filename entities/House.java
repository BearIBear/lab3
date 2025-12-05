package entities;

public class House {
    private final String name;
    private Stairs stairs;
    private Wall wall;
    private Room room;
    private Door door;

    public House(String name, Stairs stairs, Wall wall, Room room, Door door) {
        this.name = name;
        this.stairs = stairs;
        this.wall = wall;
        this.room = room;
        this.door = door;
    }
    
    public House(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public void setStairs(Stairs stairs) {
        this.stairs = stairs;
    }

    public void setWall(Wall wall) {
        this.wall = wall;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setDoor(Door door) {
        this.door = door;
    }
}
