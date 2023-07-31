package agh.ics.oop;

import org.junit.jupiter.api.Test;

public class Vector2dTest {
    @Test
    public void testEquals () {
        assert new Vector2d(1, 2).equals(new Vector2d(1, 2));
        assert !new Vector2d(1, 2).equals(new Vector2d(1, 3));
        assert !new Vector2d(1, 2).equals(new Vector2d(2, 2));
        assert !new Vector2d(1, 2).equals(new Vector2d(2, 3));
    }

    @Test
    public void testToString () {
        assert new Vector2d(1, 2).toString().equals("(1,2)");
    }

    @Test
    public void testPrecedes() {
        assert new Vector2d(1, 2).precedes(new Vector2d(1, 2));
        assert new Vector2d(1, 2).precedes(new Vector2d(1, 3));
        assert new Vector2d(1, 2).precedes(new Vector2d(2, 2));
        assert new Vector2d(1, 2).precedes(new Vector2d(2, 3));
        assert !new Vector2d(1, 2).precedes(new Vector2d(1, 1));
        assert !new Vector2d(1, 2).precedes(new Vector2d(0, 2));
        assert !new Vector2d(1, 2).precedes(new Vector2d(0, 1));
    }

    @Test
    public void testFollows() {
        assert new Vector2d(1, 2).follows(new Vector2d(1, 2));
        assert new Vector2d(1, 2).follows(new Vector2d(1, 1));
        assert new Vector2d(1, 2).follows(new Vector2d(0, 2));
        assert new Vector2d(1, 2).follows(new Vector2d(0, 1));
        assert !new Vector2d(1, 2).follows(new Vector2d(1, 3));
        assert !new Vector2d(1, 2).follows(new Vector2d(2, 2));
        assert !new Vector2d(1, 2).follows(new Vector2d(2, 3));
    }

    @Test
    public void testUpperRight() {
        assert new Vector2d(1, 2).upperRight(new Vector2d(1, 2)).equals(new Vector2d(1, 2));
        assert new Vector2d(1, 2).upperRight(new Vector2d(1, 3)).equals(new Vector2d(1, 3));
        assert new Vector2d(1, 2).upperRight(new Vector2d(2, 2)).equals(new Vector2d(2, 2));
        assert new Vector2d(1, 2).upperRight(new Vector2d(2, 3)).equals(new Vector2d(2, 3));
        assert new Vector2d(1, 2).upperRight(new Vector2d(0, 1)).equals(new Vector2d(1, 2));
        assert new Vector2d(1, 2).upperRight(new Vector2d(0, 3)).equals(new Vector2d(1, 3));
        assert new Vector2d(1, 2).upperRight(new Vector2d(2, 1)).equals(new Vector2d(2, 2));
        assert new Vector2d(1, 2).upperRight(new Vector2d(2, 0)).equals(new Vector2d(2, 2));
    }

    @Test
    public void testLowerLeft() {
        assert new Vector2d(1, 2).lowerLeft(new Vector2d(1, 2)).equals(new Vector2d(1, 2));
        assert new Vector2d(1, 2).lowerLeft(new Vector2d(1, 3)).equals(new Vector2d(1, 2));
        assert new Vector2d(1, 2).lowerLeft(new Vector2d(2, 2)).equals(new Vector2d(1, 2));
        assert new Vector2d(1, 2).lowerLeft(new Vector2d(2, 3)).equals(new Vector2d(1, 2));
        assert new Vector2d(1, 2).lowerLeft(new Vector2d(0, 1)).equals(new Vector2d(0, 1));
        assert new Vector2d(1, 2).lowerLeft(new Vector2d(0, 3)).equals(new Vector2d(0, 2));
        assert new Vector2d(1, 2).lowerLeft(new Vector2d(2, 1)).equals(new Vector2d(1, 1));
        assert new Vector2d(1, 2).lowerLeft(new Vector2d(2, 0)).equals(new Vector2d(1, 0));
    }

    @Test
    public void testAdd() {
        assert new Vector2d(1, 2).add(new Vector2d(1, 2)).equals(new Vector2d(2, 4));
        assert new Vector2d(1, 2).add(new Vector2d(1, 3)).equals(new Vector2d(2, 5));
        assert new Vector2d(1, 2).add(new Vector2d(2, 2)).equals(new Vector2d(3, 4));
        assert new Vector2d(1, 2).add(new Vector2d(2, 3)).equals(new Vector2d(3, 5));
        assert new Vector2d(1, 2).add(new Vector2d(0, 1)).equals(new Vector2d(1, 3));
        assert new Vector2d(1, 2).add(new Vector2d(0, 3)).equals(new Vector2d(1, 5));
        assert new Vector2d(1, 2).add(new Vector2d(2, 1)).equals(new Vector2d(3, 3));
        assert new Vector2d(1, 2).add(new Vector2d(2, 0)).equals(new Vector2d(3, 2));
    }

    @Test
    public void testSubtract() {
        assert new Vector2d(1, 2).subtract(new Vector2d(1, 2)).equals(new Vector2d(0, 0));
        assert new Vector2d(1, 2).subtract(new Vector2d(1, 3)).equals(new Vector2d(0, -1));
        assert new Vector2d(1, 2).subtract(new Vector2d(2, 2)).equals(new Vector2d(-1, 0));
        assert new Vector2d(1, 2).subtract(new Vector2d(2, 3)).equals(new Vector2d(-1, -1));
        assert new Vector2d(1, 2).subtract(new Vector2d(0, 1)).equals(new Vector2d(1, 1));
        assert new Vector2d(1, 2).subtract(new Vector2d(0, 3)).equals(new Vector2d(1, -1));
        assert new Vector2d(1, 2).subtract(new Vector2d(2, 1)).equals(new Vector2d(-1, 1));
        assert new Vector2d(1, 2).subtract(new Vector2d(2, 0)).equals(new Vector2d(-1, 2));
    }

    @Test
    public void testOpposite() {
        assert new Vector2d(1, 2).opposite().equals(new Vector2d(-1, -2));
        assert new Vector2d(1, -2).opposite().equals(new Vector2d(-1, 2));
        assert new Vector2d(-1, 2).opposite().equals(new Vector2d(1, -2));
        assert new Vector2d(-1, -2).opposite().equals(new Vector2d(1, 2));
    }
}
