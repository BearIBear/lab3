public class Wall {
    private final String location;
    
    public Wall(String location) {
        this.location = location;
    }
    
    public void mountButton(Button button) {
        System.out.println("Кнопка установлена на стене " + location);
    }
}