package pl.szwyngiel;

public interface IMazeBuilder {
    void buildMaze();
    void buildRoom(int x, int y, int nr);
    void buildDoor(int roomOne, int roomTwo);
    Maze getMaze();
}
