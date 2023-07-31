package agh.ics.oop;

import java.util.LinkedList;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        for(String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
        LinkedList<Direction> directions = convert(args);
        run(directions);
        System.out.println("system zakończył działanie");
    }

    public static void run(LinkedList<Direction> directions) {
        for (Direction direction : directions) {
            switch (direction) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case RIGHT -> System.out.println("Zwierzak idzie w prawo");
                case LEFT -> System.out.println("Zwierzak idzie w lewo");
            }
        }
    }

    public static LinkedList<Direction> convert(String[] args) {
        LinkedList<Direction> directions = new LinkedList<>();
        for (String arg : args) {
            switch (arg) {
                case "f" -> directions.add(Direction.FORWARD);
                case "b" -> directions.add(Direction.BACKWARD);
                case "r" -> directions.add(Direction.RIGHT);
                case "l" -> directions.add(Direction.LEFT);
            }
        }
        return directions;
    }
}
