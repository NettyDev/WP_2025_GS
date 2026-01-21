package pl.szwyngiel;

import java.awt.*;


enum Directions {North, East, South, West};

public abstract class MapSite {
    private int x;
    private int y; // współrzędne elementu na mapie
    public static final int Length = 50;  // długość ścian pokoju

    public MapSite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract void draw(Image image);
}
