import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import entities.Button;
import entities.Door;
import entities.Gate;
import entities.Halfling;
import entities.House;
import entities.Room;
import entities.Stairs;
import entities.Street;
import entities.Wall;
import enums_records.Direction;
import enums_records.Position;
import exceptions.CannotOpenException;

public class Main {
    private static final Logger log = Logger.getLogger(Halfling.class.getName());
    public static void main(String[] args) {
        System.out.println("=== Начало ===\n");
        Random random = new Random();
        
        // Создаём друзей
        List<Halfling> friends = new ArrayList<>();
        Halfling bublik = new Halfling("Бублик", new Position("улица", "калитка"));
        Halfling donut = new Halfling("Пончик", new Position("улица", "калитка"));
        Halfling hardtack = new Halfling("Сухарь", new Position("улица", "калитка"));
        friends.add(bublik);
        friends.add(donut);
        friends.add(hardtack);
        
        // Создаём предметы
        Gate gate = new Gate(new Position("двор", "вход"));
        Stairs stairs = new Stairs(new Position("дом", "южная часть"), new Position("дом", "верх лестницы"), new Position("дом", "низ лестницы"), random.nextInt(10) + 1, "каменной");
        Wall wall = new Wall(new Position("дом", "вершина каменной лестницы"));
        Button button = new Button(new Position("дом", "стена у двери"));
        Door door = new Door();
        button.setControlledPassage(door);
        wall.mountButton(button);
        wall.mountDoor(door);
        Room room = new Room(new Position("дом", "внутри"));

        // Запрём калитку и дверь, если повезёт
        gate.setLocked(random.nextBoolean());
        door.setLocked(random.nextBoolean());
        
        House home = new House(stairs, wall, room, door);
        Street street = new Street(gate);

        System.out.println("\n--- Калитка открывается ---");
        for (Halfling friend : friends) {
            friend.enter(street.getGate());
        }
        
        System.out.println("\n--- Троица идёт к дому ---");
        for (Halfling friend : friends) {
            friend.walk(Direction.LEFT);
        }
        
        System.out.println("\n--- Подъём по лестнице ---");
        for (Halfling friend : friends) {
            friend.climbUp(home.getStairs(), 999);
        }

        System.out.println("\n--- Поиск и нажатие кнопки ---");
        bublik.findButton(home.getWall());
        try {
            bublik.press(button);
        } catch (CannotOpenException e) {
            log.warning("Кнопка нажалась, да дверь не открылась: " + e.getMessage());
            log.warning(bublik.getName() + " использовал \"ПСЖ\" на дверь!");
            door.setLocked(false);
            try {
                bublik.press(button);
            } catch (CannotOpenException e1) {
                log.severe("Боги ПСЖ покинули нас, надежды больше нет: " + e1.getMessage());
            }
        }
        
        System.out.println("\n--- Вход в комнату ---");
        for (Halfling friend : friends) {
            friend.enter(home.getDoor());
            friend.appear(home.getRoom());
        }
        
        System.out.println("\n=== Конец ===");
        System.out.println("В комнате сейчас: " + home.getRoom());
        for (Halfling friend : friends) {
            System.out.println("  - " + friend.getStatus());
        }
    }
}