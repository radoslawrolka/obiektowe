package agh.ics.oop;

import agh.ics.oop.gui.App;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable {
    private final List<MoveDirection> moves;
    private final AbstractWorldMap map;
    private final List<Animal> animals;
    private int MoveDelay;
    private App app;

    public SimulationEngine(MoveDirection[] moves, AbstractWorldMap map, Vector2d[] initialPositions, int moveDelay, App app) {
        this.map = map;
        this.MoveDelay = moveDelay;
        this.moves = List.of(moves);
        this.app = app;
        this.animals = new ArrayList<>();
        for (Vector2d initialPosition: initialPositions) {
            Animal animal = new Animal(map, initialPosition);
            animals.add(animal);
            if (!map.place(animal)) {
                throw new IllegalArgumentException("Cannot place another animal at " + animal.getPosition());
            }
        }
    }

    @Override
    public void run() {
        System.out.println(map);
        int flag = 0;
        for (int i=0; i<moves.size(); i++) {
            animals.get(i%animals.size()).move(moves.get(i));
            flag++;
            if (flag%animals.size() == 0) {
                System.out.println(map);
                app.refreshMap();
                System.out.println(map);
                try{
                    Thread.sleep(MoveDelay);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
