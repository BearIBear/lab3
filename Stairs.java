public class Stairs {
    // TODO: Добавить поддержку Position
    private final int steps;
    private final String material;
    
    public Stairs(int steps, String material) {
        this.steps = steps;
        this.material = material;
    }
    
    public void climb(Friend friend) {
        System.out.println(friend.getName() + " поднялся по " + material + " лестнице из " + steps + " ступеней");
    }
}