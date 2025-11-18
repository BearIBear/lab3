import java.util.Objects;

public class Friend {
    private final String name;
    private Position position;
    private boolean canSeeButton = false;
    
    public Friend(String name, Position position) {
        if (name == null || name.isBlank()) {
            throw new InvalidStateException("Имя друга не может быть пустым");
        }
        this.name = name;
        this.position = position;
    }
    
    public String getName() {
        return name;
    }
    
    public void walk(Direction direction) {
        if (position == null) {
            throw new InvalidStateException("Друг не знает, где он находится!");
        }
        System.out.println(name + " повернул " + direction.toRussian() + " и пошел");
        this.position = new Position("дом", "около каменной лестницы");
    }
    
    public void enter(Passage passage) throws CannotOpenException {
        if (passage == null) {
            throw new InvalidStateException("Нет проема для входа");
        }
        if (!passage.isOpen) {
            passage.open();
        }
        System.out.println(name + " вошел");
    }
    
    public void climb(Stairs stairs) {
        stairs.climb(this);
        this.position = new Position("лестница", "вершина");
    }

    
    // TODO: Сделать так, чтобы этот метод чекал, где располагается кнопка

    // Сначала нам нужно найти кнопку, а потом уже нажать
    public void findButton(Button button) {
        if (this.position.toString().intern() == "Position[place=лестница, area=вершина]") {
            System.out.println(name + " отыскал кнопку на стене");
            this.canSeeButton = true;
    // System.out.println("Видящий кнопку друг находится " + this.position);
        }
    }
    
    public void press(Button button) throws CannotOpenException {
        if (!canSeeButton) {
            throw new InvalidStateException("Не видит кнопку");
        }
        button.press();
    }
    
    public void appear(Room room) {
        room.addVisitor(this);
        this.position = new Position("комната", "вход");
        System.out.println(name + " очутился в комнате");
    }
    
    public String getStatus() {
        return name + " находится: " + position;
    }
    
    @Override
    public String toString() {
        return "Friend[name=" + name + ", position=" + position + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Friend f)) return false;
        return Objects.equals(name, f.name) && Objects.equals(position, f.position);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}