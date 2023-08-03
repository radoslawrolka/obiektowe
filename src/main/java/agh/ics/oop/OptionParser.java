package agh.ics.oop;

public class OptionParser {
    public MoveDirection[] parse(String[] args) {
        int len = 0;
        for (String arg : args) {
            if (arg.equals("f") || arg.equals("b") ||
                arg.equals("r") || arg.equals("l")) {
                len += 1;
            }
        }
        MoveDirection[] commands = new MoveDirection[len];
        int i = 0;
        for (String arg : args) {
            switch (arg) {
                case "f" -> {commands[i] = MoveDirection.FORWARD; i++;}
                case "b" -> {commands[i] = MoveDirection.BACKWARD; i++;}
                case "r" -> {commands[i] = MoveDirection.RIGHT; i++;}
                case "l" -> {commands[i] = MoveDirection.LEFT; i++;}
                default -> throw new IllegalArgumentException("'" + arg + "'" + " is not legal move specification");
            }
        }
        return commands;
    }
}