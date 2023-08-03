package agh.ics.oop;

import java.util.Comparator;
import java.util.TreeSet;

public class MapBonduary implements IPositionChangeObserver {
    private TreeSet<Vector2d> X = new TreeSet<>(Comparator.comparing(Vector2d::getX));
    private TreeSet<Vector2d> Y = new TreeSet<>(Comparator.comparing(Vector2d::getY));

    public void update(Vector2d newPosition) {
        X.add(newPosition);
        Y.add(newPosition);
    }

    public void remove(Vector2d oldPosition) {
        X.remove(oldPosition);
        Y.remove(oldPosition);
    }

    public Vector2d getLowerLeft() {
        return new Vector2d(X.first().getX(), Y.first().getY());
    }

    public Vector2d getUpperRight() {
        return new Vector2d(X.last().getX(), Y.last().getY());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        remove(oldPosition);
        update(newPosition);
    }
}
