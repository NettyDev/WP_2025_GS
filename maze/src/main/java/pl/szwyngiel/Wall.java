package pl.szwyngiel;

import java.awt.Graphics;
import java.awt.Image;

public class Wall extends MapSite {
    Directions direction;

    public Wall(Directions direction) {
        super(-1, -1);
        this.direction = direction;
    }

    @Override
    public void draw(Image image) {
        int x = getX();
        int y = getY();
        Graphics g = image.getGraphics();
        switch (direction) {
            case North:
                g.drawLine(x, y, x+MapSite.Length, y);
                break;
            case South:
                g.drawLine(x, y, x+MapSite.Length, y);
            default:
                g.drawLine(x, y, x, y + MapSite.Length);
                break;
        }
    }

    public void setDirection(Directions dir) {
        direction = dir;
    }
}
