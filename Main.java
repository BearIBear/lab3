import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== Начало ===\n");
        Random random = new Random();
        
        List<Friend> friends = new ArrayList<>();
        friends.add(new Friend("Бублик", new Position("улица", "калитка")));
        friends.add(new Friend("Ловетт", new Position("улица", "калитка")));
        friends.add(new Friend("TODD", new Position("улица", "калитка")));
        
        Gate gate = new Gate();
        Stairs stairs = new Stairs(random.nextInt(10) + 1, "каменной");
        Wall wall = new Wall("у двери");
        Button button = new Button();
        Door door = new Door();
        button.setControlledPassage(door);
        wall.mountButton(button);
        Room room = new Room();


        
        // Запрём калитку и дверь, если повезёт
        // gate.setLocked(random.nextBoolean());
        // door.setLocked(random.nextBoolean());
        
        // System.out.println("\n--- Калитка открывается ---");
        // for (Friend friend : friends) {
        //     try {
        //         friend.enter(gate);
        //     } catch (CannotOpenException error) {
        //         System.out.println(friend.getName() + " не смог войти: " + error.getMessage());
        //         System.out.println(friend.getName() + " использовал \"ПСЖ\" на калитку!");
        //         gate.setLocked(false);
        //         try {
        //             friend.enter(gate);
        //         } catch (CannotOpenException error1) {
        //             System.out.println("Калитку не отчислили: " + error1.getMessage());
        //         }
        //     }
        // }
        
        // System.out.println("\n--- Друзья идут к дому ---");
        // for (Friend friend : friends) {
        //     friend.walk(Direction.LEFT);
        // }
        
        // System.out.println("\n--- Подъем по лестнице ---");
        // for (Friend friend : friends) {
        //     friend.climb(stairs);
        // }
        
        // System.out.println("\n--- Поиск и нажатие кнопки ---");

        // TODO: Если мы не видим кнопку, то стоит ли останавливать программу?
        Friend bubik = friends.get(0);
        try {
            bubik.press(button);
        } catch (CannotOpenException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        // bubik.findButton(button);
        // try {
        //     bubik.press(button);
        // } catch (CannotOpenException e) {
        //     System.out.println("Кнопка нажалась, да дверь не открылась: " + e.getMessage());
        //     System.out.println(bubik.getName() + " использовал \"ПСЖ\" на дверь!");
        //     door.setLocked(false);
        //     try {
        //         bubik.press(button);
        //     } catch (CannotOpenException e1) {
        //         System.out.println("Боги ПСЖ покинули нас, надежды больше нет: " + e1.getMessage());
        //     }
        // }
        
        // System.out.println("\n--- Вход в комнату ---");
        // for (Friend friend : friends) {
        //     try {
        //         friend.enter(door);
        //         friend.appear(room);
        //     } catch (CannotOpenException e) {
        //         System.out.println(friend.getName() + " не смог войти: " + e.getMessage());
        //         System.out.println(friend.getName() + " использовал \"ПСЖ\" на дверь!");
        //         door.setLocked(false);
        //         try {
        //             friend.enter(door);
        //             friend.appear(room);
        //         } catch (CannotOpenException e1) {
        //             System.out.println("Боги ПСЖ покинули нас, надежды больше нет: " + e1.getMessage());
        //         }
        //     }
        // }
        
        // System.out.println("\n=== Конец сценария ===");
        // System.out.println("В комнате сейчас: " + room);
        // for (Friend friend : friends) {
        //     System.out.println("  - " + friend.getStatus());
        // }
    }
}