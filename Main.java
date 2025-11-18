import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== Начало ===\n");
        Random random = new Random();
        
        // TODO: Переделать "Друзей" в "Коротышек"
        // Создаём друзей
        List<Friend> friends = new ArrayList<>();
        Friend bublik = new Friend("Бублик", new Position("улица", "калитка"));
        Friend donut = new Friend("Пончик", new Position("улица", "калитка"));
        Friend hardtack = new Friend("Сухарь", new Position("улица", "калитка"));
        friends.add(bublik);
        friends.add(donut);
        friends.add(hardtack);
        
        // Создаём предметы
        Gate gate = new Gate();
        Stairs stairs = new Stairs(random.nextInt(10) + 1, "каменной");
        Wall wall = new Wall("у двери");
        Button button = new Button();
        Door door = new Door();
        button.setControlledPassage(door);
        wall.mountButton(button);
        Room room = new Room();

        // Запрём калитку и дверь, если повезёт
        gate.setLocked(random.nextBoolean());
        door.setLocked(random.nextBoolean());
        
        System.out.println("\n--- Калитка открывается ---");
        for (Friend friend : friends) {
            try {
                friend.enter(gate);
            } catch (CannotOpenException error) {
                System.out.println(friend.getName() + " не смог войти: " + error.getMessage());
                System.out.println(friend.getName() + " использовал \"ПСЖ\" на калитку!");
                gate.setLocked(false);
                try {
                    friend.enter(gate);
                } catch (CannotOpenException error1) {
                    System.out.println("Калитку не отчислили: " + error1.getMessage());
                }
            }
        }
        
        System.out.println("\n--- Троица идёт к дому ---");
        for (Friend friend : friends) {
            friend.walk(Direction.LEFT);
        }
        
        System.out.println("\n--- Подъём по лестнице ---");
        for (Friend friend : friends) {
            friend.climb(stairs);
        }

        System.out.println("\n--- Поиск и нажатие кнопки ---");
        bublik.findButton(button);
        try {
            bublik.press(button);
        } catch (CannotOpenException e) {
            System.out.println("Кнопка нажалась, да дверь не открылась: " + e.getMessage());
            System.out.println(bublik.getName() + " использовал \"ПСЖ\" на дверь!");
            door.setLocked(false);
            try {
                bublik.press(button);
            } catch (CannotOpenException e1) {
                System.out.println("Боги ПСЖ покинули нас, надежды больше нет: " + e1.getMessage());
            }
        }
        
        System.out.println("\n--- Вход в комнату ---");
        for (Friend friend : friends) {
            try {
                friend.enter(door);
                friend.appear(room);
            } catch (CannotOpenException e) {
                System.out.println(friend.getName() + " не смог войти: " + e.getMessage());
                System.out.println(friend.getName() + " использовал \"ПСЖ\" на дверь!");
                door.setLocked(false);
                try {
                    friend.enter(door);
                    friend.appear(room);
                } catch (CannotOpenException e1) {
                    System.out.println("Боги ПСЖ покинули нас, надежды больше нет: " + e1.getMessage());
                }
            }
        }
        
        System.out.println("\n=== Конец ===");
        System.out.println("В комнате сейчас: " + room);
        for (Friend friend : friends) {
            System.out.println("  - " + friend.getStatus());
        }
    }
}