package pl.szwyngiel;

public class MazeBuilder implements IMazeBuilder {
    private Maze maze;

    @Override 
    public void buildMaze() {
        maze = new Maze();
    }

    @Override 
    public void buildRoom(int x, int y, int nr) {
        Room r = new Room(x, y, nr);
        r.setSite(Directions.East, new Wall(Directions.East));
        r.setSite(Directions.West, new Wall(Directions.West));
        r.setSite(Directions.South, new Wall(Directions.South));
        r.setSite(Directions.North, new Wall(Directions.North));
        maze.addRoom(r);
    }
    
    @Override
    public void buildDoor(int roomOne, int roomTwo) {
        Room room1 = maze.getRoom(roomOne);
        Room room2 = maze.getRoom(roomTwo);
        if (room1 != null && room2 != null) {
            new Door(room1, room2);
        }
    }

    @Override
    public Maze getMaze() {
        return maze;
    }
}