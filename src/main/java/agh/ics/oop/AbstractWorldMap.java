package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class AbstractWorldMap implements IWorldMap {
    protected Vector2d lowerLeft = new Vector2d(0, 0);
    protected Vector2d upperRight = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    //protected List<Animal> animals = new ArrayList<>();
    //protected List<Grass> grasses = new ArrayList<>();
    protected List<IMapElement> elements = new ArrayList<>();
    protected final MapVisualizer visualiser = new MapVisualizer(this);

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft)  && !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            elements.add(animal);
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
        for (IMapElement element: elements) {
            if (element.getPosition().equals(position)) {
                return element;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        Vector2d bottom = new Vector2d(upperRight.x, upperRight.y);
        Vector2d top = new Vector2d(lowerLeft.x, lowerLeft.y);
        for (IMapElement animal: elements) {
            bottom = bottom.lowerLeft(animal.getPosition());
            top = top.upperRight(animal.getPosition());
        }
        return visualiser.draw(bottom, top);
    }
}
