public enum Directions {
    UP, DOWN, LEFT, RIGHT;

    public Directions getOppositeDirection(Directions currDir) {
        switch (currDir) {
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case RIGHT:
                return LEFT;
            case LEFT:
                return RIGHT;
            default:
                throw new IllegalArgumentException("Invalid direction: " + currDir);
        }
    }
}
