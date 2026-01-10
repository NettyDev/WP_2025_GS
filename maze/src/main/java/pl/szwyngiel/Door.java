package pl.szwyngiel;

import java.awt.*;

public class Door extends MapSite {

    private Room room_1;
    private Room room_2;
    private Directions direction;

    public Door(Room room_1, Room room_2) {
        super(-1, -1);
        this.room_1 = room_1;
        this.room_2 = room_2;
        int x1 = room_1.getX(); // wsp. x pokoju 1
        int y1 = room_1.getY(); // wsp. y pokoju 1
        int x2 = room_2.getX(); // wsp. x pokoju 2
        int y2 = room_2.getY(); // wsp. y pokoju 2

        if(x2 > x1) { // pokuj leży jeden obok drugiego - w poziomie
            setX(x2); // pokój 2 jest po prawej - dzwi mają współrzędne x2, y2
            setY(y2);
            room_1.setSite(Directions.East, this);
            room_2.setSite(Directions.West, this);
            direction = Directions.East;
        } else if(x1 > x2) { // pokój leżą jeden obok drugiego - w poziomie
            setX(x1); // pokój 1 jest po prawej - drzwi mają współrzędne x1, y1
            setY(y1);
            room_2.setSite(Directions.East, this);
            room_1.setSite(Directions.West, this);
            direction = Directions.East;
        } else { // pokoje leżą jeden pod drugim - w pionie
            direction = Directions.North;
            if(y2 > y1) { // pokój 2 leży niżej
                setX(x2);
                setY(y2);
                room_1.setSite(Directions.South, this);
                room_2.setSite(Directions.North, this);
            } else if (y1 > y2) {
                setX(x1);
                setY(y1);
                room_2.setSite(Directions.South, this);
                room_1.setSite(Directions.North, this);
            }
        }
    }

    @Override
    public void draw(Image image) {
        int x = getX();
        int y = getY(); // wsp. drzwi
        Graphics graphics = image.getGraphics();
        if (direction == Directions.East) { // drzwi w pionie
            graphics.drawLine(x, y, x, y + MapSite.Length / 3);
            graphics.drawLine(x, y + 2 * MapSite.Length / 3, x, y + MapSite.Length);
        } else { // drzwi w poziomie
            graphics.drawLine(x, y, x + MapSite.Length / 3, y);
            graphics.drawLine(x + 2 * MapSite.Length / 3, y, x + MapSite.Length, y);
        }
    }

}
