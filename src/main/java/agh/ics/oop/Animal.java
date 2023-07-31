package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private int start_point = 2;
    private Vector2d position = new Vector2d(start_point, start_point);

    public String toString(){
        return "position: " + this.position + ", orientation: " + this.orientation;
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){
        int top_border = 4;
        int bottom_border = 0;
        switch (direction) {
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.orientation.toUnitVector());
                if (newPosition.precedes(new Vector2d(top_border,top_border)) && newPosition.follows(new Vector2d(bottom_border,bottom_border))) {
                    this.position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.subtract(this.orientation.toUnitVector());
                if (newPosition.precedes(new Vector2d(top_border,top_border)) && newPosition.follows(new Vector2d(bottom_border,bottom_border))) {
                    this.position = newPosition;
                }
            }
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
        }
    }
}


