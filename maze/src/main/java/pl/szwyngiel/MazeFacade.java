package pl.szwyngiel;

import java.awt.Image;

public class MazeFacade {
    private Maze maze;
    private final MazeBuilder mazeBuilder;

    public MazeFacade() {
        this.mazeBuilder = new MazeBuilder();
    }

    public Maze createMaze(int x, int y) {
        mazeBuilder.buildMaze();

        int nr = 1;
        int length = MapSite.Length;

        mazeBuilder.buildRoom(x, y, nr++);
        mazeBuilder.buildRoom(x, y + length, nr++);
        mazeBuilder.buildRoom(x, y + length * 2, nr++);
        mazeBuilder.buildRoom(x + length, y + length, nr++);
        mazeBuilder.buildRoom(x + length, y + length * 2, nr++);

        mazeBuilder.buildRoom(x + length * 2, y, nr++);
        mazeBuilder.buildRoom(x + length * 2, y + length, nr++);
        mazeBuilder.buildRoom(x + length * 2, y + length * 2, nr++);

        mazeBuilder.buildDoor(1, 2);
        mazeBuilder.buildDoor(2, 3);
        mazeBuilder.buildDoor(2, 4);
        mazeBuilder.buildDoor(4, 5);
        mazeBuilder.buildDoor(5, 8);
        mazeBuilder.buildDoor(4, 7);
        mazeBuilder.buildDoor(7, 6);

        return mazeBuilder.getMaze();
    }
    
    public void draw(Image image) {
        if(maze != null) {
            maze.draw(image);
        }
    }
}
