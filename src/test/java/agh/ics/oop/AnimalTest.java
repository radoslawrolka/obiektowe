package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    public void testToString() {
    }

    @Test
    public void testIsAt() {
        AbstractWorldMap map = new GrassField(5,5);
        Vector2d pos = new Vector2d(2,2);
        Animal animal = new Animal(map, pos);
        assert animal.isAt(new Vector2d(2,2));
    }

    @Test
    public void test() {
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionParser().parse(args);

        assertEquals(MoveDirection.FORWARD, directions[0]);
        assertEquals(MoveDirection.BACKWARD, directions[1]);
        assertEquals(MoveDirection.RIGHT, directions[2]);
        assertEquals(MoveDirection.LEFT, directions[3]);
        assertEquals(MoveDirection.FORWARD, directions[4]);
        assertEquals(MoveDirection.FORWARD, directions[5]);
        assertEquals(MoveDirection.RIGHT, directions[6]);

        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        Animal animal1 = new Animal(map, positions[0]);
        Animal animal2 = new Animal(map, positions[1]);


        animal1.move(directions[0]);
        assertTrue(animal1.isAt(new Vector2d(2,3)));
        animal2.move(directions[1]);
        assertTrue(animal2.isAt(new Vector2d(3,3)));

        animal1.move(directions[2]);
        assertTrue(animal1.isAt(new Vector2d(2,3)));
        animal2.move(directions[3]);
        assertTrue(animal2.isAt(new Vector2d(3,3)));

        animal1.move(directions[4]);
        assertTrue(animal1.isAt(new Vector2d(3,3)));
        animal2.move(directions[5]);
        assertTrue(animal2.isAt(new Vector2d(2,3)));

        animal1.move(directions[6]);
        assertTrue(animal1.isAt(new Vector2d(3,3)));
        animal2.move(directions[7]);
        assertTrue(animal2.isAt(new Vector2d(2,3)));

        animal1.move(directions[8]);
        assertTrue(animal1.isAt(new Vector2d(3,2)));
        animal2.move(directions[9]);
        assertTrue(animal2.isAt(new Vector2d(2,4)));
    }

    @Test
    public void testEngine() {
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionParser().parse(args);

        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };

        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertTrue(map.isOccupied(new Vector2d(2,0)));
        assertTrue(map.isOccupied(new Vector2d(3,4)));
    }
}
