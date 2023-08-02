package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Vector2d lowerLeft = new Vector2d(0, 0);
    protected Vector2d upperRight = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected Map<Vector2d, IMapElement> elements = new HashMap<>();
    protected final MapVisualizer visualiser = new MapVisualizer(this);

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft)  && !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            elements.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {

        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return elements.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement element = elements.get(oldPosition);
        elements.remove(oldPosition);
        elements.put(newPosition, element);
    }

    @Override
    public String toString() {
        Vector2d bottom = new Vector2d(upperRight.x, upperRight.y);
        Vector2d top = new Vector2d(lowerLeft.x, lowerLeft.y);

        for (Vector2d position: elements.keySet()) {
            bottom = bottom.lowerLeft(position);
            top = top.upperRight(position);
        }
        return visualiser.draw(bottom, top);
    }
}
