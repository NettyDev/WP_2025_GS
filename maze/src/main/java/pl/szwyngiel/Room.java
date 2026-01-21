package pl.szwyngiel;

import java.awt.*;

public class Room extends MapSite{
    private int nr; // numer pokoju
    private MapSite [] sietes = new MapSite[4]; // tablica, która może przechowywać zarówno drzwi, jak i ściany

    public Room(int x, int y, int nr) {
        super(x, y);
        this.nr = nr;
    }

    @Override
    public void draw(Image image) {
        for (MapSite mapSite: sietes) {
            if (mapSite != null)
                mapSite.draw(image);
        }
    }

    /**
     * Wstawia element pokoju we wskazanym kierunku
     * @param d - kierunek
     * @param mapSite - element, który wstawiamy
     */
    public void setSite(Directions d, MapSite mapSite) {
        if (mapSite instanceof Wall) {  // jeżeli ścian
            switch (d) {
                case North -> {
                    mapSite.setX( getX() ); // ustawiamy na wsp. x pokoju
                    mapSite.setY( getY() ); // ustawiamy na wsp. y pokoju
                    ((Wall) mapSite).setDirection(Directions.North);
                }
                case West -> {
                    mapSite.setX( getX() ); // ustawiamy na wsp. x pokoju
                    mapSite.setY( getY() ); // ustawiamy na wsp. y pokoju
                    ((Wall) mapSite).setDirection(Directions.West);
                }
                case South -> {
                    mapSite.setX( getX() );
                    mapSite.setY( getY() + MapSite.Length);
                }
                default -> { // East
                    mapSite.setX( getX() + Length );
                    mapSite.setY( getY() );
                }
            }
        }
        sietes[d.ordinal()] = mapSite;

    }

}
