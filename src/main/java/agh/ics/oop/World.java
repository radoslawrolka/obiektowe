package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");

        for(String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();

        MoveDirection[] directions = new OptionParser().parse(args);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        AbstractWorldMap map = new GrassField(10, positions);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        System.out.println("system zakończył działanie");
    }
}
