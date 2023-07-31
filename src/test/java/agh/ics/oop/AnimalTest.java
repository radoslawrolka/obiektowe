package agh.ics.oop;

import org.junit.jupiter.api.Test;

public class AnimalTest {
    @Test
    public void testToString() {
        Animal animal = new Animal();
        assert animal.toString().equals("position: (2,2), orientation: Północ");
    }

    @Test
    public void testIsAt() {
        Animal animal = new Animal();
        assert animal.isAt(new Vector2d(2,2));
    }

    @Test
    public void testMove() {
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        assert animal.toString().equals("position: (2,3), orientation: Północ");
        animal.move(MoveDirection.FORWARD);
        assert animal.toString().equals("position: (2,4), orientation: Północ");
        animal.move(MoveDirection.FORWARD);
        assert animal.toString().equals("position: (2,4), orientation: Północ");
        animal.move(MoveDirection.BACKWARD);
        assert animal.toString().equals("position: (2,3), orientation: Północ");
        animal.move(MoveDirection.BACKWARD);
        assert animal.toString().equals("position: (2,2), orientation: Północ");
        animal.move(MoveDirection.BACKWARD);
        assert animal.toString().equals("position: (2,1), orientation: Północ");
        animal.move(MoveDirection.RIGHT);
        assert animal.toString().equals("position: (2,1), orientation: Wschód");
        animal.move(MoveDirection.RIGHT);
        assert animal.toString().equals("position: (2,1), orientation: Południe");
        animal.move(MoveDirection.RIGHT);
        assert animal.toString().equals("position: (2,1), orientation: Zachód");
        animal.move(MoveDirection.RIGHT);
        assert animal.toString().equals("position: (2,1), orientation: Północ");
        animal.move(MoveDirection.LEFT);
        assert animal.toString().equals("position: (2,1), orientation: Zachód");
        animal.move(MoveDirection.LEFT);
        assert animal.toString().equals("position: (2,1), orientation: Południe");
        animal.move(MoveDirection.LEFT);
        assert animal.toString().equals("position: (2,1), orientation: Wschód");
        animal.move(MoveDirection.LEFT);
        assert animal.toString().equals("position: (2,1), orientation: Północ");
    }

}
