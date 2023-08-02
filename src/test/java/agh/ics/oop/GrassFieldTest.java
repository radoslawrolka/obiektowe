package agh.ics.oop;

import org.junit.jupiter.api.Test;

public class GrassFieldTest {
    @Test
    public void test() {
        GrassField map = new GrassField(10, new Vector2d[] {new Vector2d(2,2), new Vector2d(3,4)});
        assert (map.elements.size() == 10);
    }
}
