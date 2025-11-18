public class Button implements Pressable {
    // TODO: Добавить поддержку Position

    private int timesPressed;
    private Passage controlledPassage;
    
    public Button() {}
    
    public int timesPressed() {
        return timesPressed;
    }
    
    public void setControlledPassage(Passage passage) {
        this.controlledPassage = passage;
    }
    
    @Override
    public void press() throws CannotOpenException {
        // if (isPressed) {
        //     throw new ButtonStateException("Кнопка уже нажата");
        // }
        
        this.timesPressed += 1;
        System.out.println("Кнопка нажата");
        
        if (controlledPassage != null) {
            controlledPassage.open();
        }
    }
}