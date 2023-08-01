package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private final List<MoveDirection> moves;
    private final IWorldMap map;
    private final List<Animal> animals;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] initialPositions) {
        this.map = map;
        this.moves = List.of(moves);
        this.animals = new ArrayList<>();
        for (Vector2d initialPosition: initialPositions) {
            Animal animal = new Animal(map, initialPosition);
            animals.add(animal);
            map.place(animal);
        }
    }

    public Animal getAnimal(int i){
        return animals.get(i);
    }

    @Override
    public void run() {
        for (int i=0; i<moves.size(); i++) {
            animals.get(i%animals.size()).move(moves.get(i));
        }
    }
}
