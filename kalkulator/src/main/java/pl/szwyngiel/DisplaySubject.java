package pl.szwyngiel;

import java.util.ArrayList;
import java.util.List;

public class DisplaySubject {
    private final List<DisplayObserver> observers = new ArrayList<>();
    private String text;

    public void addObserver(DisplayObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (DisplayObserver observer : observers) {
            observer.update(text);
        }
    }

    public void setText(String text) {
        this.text = text;
        notifyObservers();
    }
}