package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private final List<MoveDirection> moves;
    private final AbstractWorldMap map;
    private final List<Animal> animals;

    public SimulationEngine(MoveDirection[] moves, AbstractWorldMap map, Vector2d[] initialPositions) {
        this.map = map;
        this.moves = List.of(moves);
        this.animals = new ArrayList<>();
        for (Vector2d initialPosition: initialPositions) {
            Animal animal = new Animal(map, initialPosition);
            animals.add(animal);
            map.place(animal);
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
            }
        }
    }
}
