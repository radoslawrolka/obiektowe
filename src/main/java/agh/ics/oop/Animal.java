package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position;
    private final AbstractWorldMap map;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(AbstractWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.addObserver(map);
    }

    @Override
    public String toString() {
        return switch (orientation) {
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }

    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for( IPositionChangeObserver observer: this.observers ){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public void move(MoveDirection direction){
        switch (direction) {
            case FORWARD, BACKWARD -> {
                Vector2d unitVector = this.orientation.toUnitVector();
                if (direction == MoveDirection.BACKWARD) {
                    unitVector = unitVector.opposite();
                }
                Vector2d newPosition = this.position.add(unitVector);
                if (this.map.canMoveTo(newPosition)) {
                    if (map.objectAt(newPosition) instanceof Grass) {
                        ((GrassField) map).RespawnGrass(newPosition);
                    }
                    this.positionChanged(this.position, newPosition);
                    this.position = newPosition;
                }
            }
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
        }
    }
}


