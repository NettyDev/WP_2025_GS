package pl.szwyngiel;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Maze {
    private List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoom(int nr) {
        for (Room room : rooms) {
            if (room.getNr() == nr) {
                return room;
            }
        }
        return null;
    }

    public void draw(Image image) {
        for (Room room : rooms) {
            room.draw(image);
        }
    }
}
