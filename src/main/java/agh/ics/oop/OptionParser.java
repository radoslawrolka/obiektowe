package agh.ics.oop;

import java.util.LinkedList;

public class OptionParser {
    public LinkedList<MoveDirection> parse(String[] args) {
        LinkedList<MoveDirection> commands = new LinkedList<>();
        for (String arg : args) {
            switch (arg) {
                case "f" -> commands.add(MoveDirection.FORWARD);
                case "b" -> commands.add(MoveDirection.BACKWARD);
                case "r" -> commands.add(MoveDirection.RIGHT);
                case "l" -> commands.add(MoveDirection.LEFT);
            }
        }
        return commands;
    }
}