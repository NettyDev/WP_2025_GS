package pl.szwyngiel;

import java.awt.Image;

public class Room extends MapSite {
    private int nr;
    private MapSite[] sites = new MapSite[4];


    public Room(int x, int y, int nr) {
        super(x, y);
        this.nr = nr;
    }

    @Override
    public void draw(Image image) {
        for(MapSite mapSite: sites) {
            if(mapSite != null)
                mapSite.draw(image);
        }
    }

    public void setSite(Directions dir, MapSite site) {
        if(site instanceof Wall) {
            switch (dir) {
                case North:
                    site.setX(getX());
                    site.setY(getY());
                    ((Wall)site).setDirection(Directions.North);
                    break;
                case West:
                    site.setX(getX());
                    site.setY(getY());
                    ((Wall)site).setDirection(Directions.West);
                    break;
                case South:
                    site.setX(getX());
                    site.setY(getY() + MapSite.Length);
                    ((Wall)site).setDirection(Directions.South);
                    break;
                default:
                    site.setX(getX() + MapSite.Length);
                    site.setY(getY());
                    ((Wall)site).setDirection(Directions.East);
                    break;
            }
        }
        sites[dir.ordinal()] = site;
    }
}