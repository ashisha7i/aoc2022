package se.hernebring.day8;

public enum Direction {
    NORTH(0,-1), EAST(1,0), SOUTH(0,1), WEST(-1,0);

    private final int east, south;

    Direction(int east, int south) {
        this.east = east;
        this.south = south;
    }

    public int getEast() {
        return east;
    }

    public int getSouth() {
        return south;
    }
}
