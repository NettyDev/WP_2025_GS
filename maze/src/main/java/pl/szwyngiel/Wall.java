package pl.szwyngiel;

import java.awt.*;

/**
 * Reprezentuje ścianę
 */
public class Wall extends MapSite {
    Directions direction;

    public Wall(Directions direction) {
        super(-1, -1);
        this.direction = direction;
    }

    public void setDirection(Directions d)
    {
        direction = d;
    }

    @Override
    public void draw(Image image) {
        int x = getX();
        int y = getY();   //  pobieramy współrzędne lini
        Graphics g = image.getGraphics();
        switch (direction) {
            case North, South:
                g.drawLine(x, y, x + MapSite.Length, y);  // ściana pomioma
                break;
            default:
                g.drawLine(x, y, x, y + MapSite.Length);  // ściana pionowa
        }
    }
}
