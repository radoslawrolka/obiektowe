package agh.ics.oop;

import java.util.LinkedList;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");

        for(String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
        LinkedList<MoveDirection> directions = new OptionParser().parse(args);

        Animal animal = new Animal();
        System.out.println(animal);
        run(directions, animal);
        System.out.println(animal);

        System.out.println("system zakończył działanie");
    }

    public static void run(LinkedList<MoveDirection> directions, Animal animal) {
        for (MoveDirection direction : directions) {
            switch (direction) {
                case FORWARD -> animal.move(MoveDirection.FORWARD);
                case BACKWARD -> animal.move(MoveDirection.BACKWARD);
                case RIGHT -> animal.move(MoveDirection.RIGHT);
                case LEFT -> animal.move(MoveDirection.LEFT);
            }
        }
    }
}
