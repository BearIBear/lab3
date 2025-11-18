public enum Direction {
    LEFT, RIGHT, STRAIGHT, BACKWARD;
    
    public String toRussian() {
        return switch (this) {
            case LEFT -> "налево";
            case RIGHT -> "направо";
            case STRAIGHT -> "прямо";
            case BACKWARD -> "назад";
        };
    }
}