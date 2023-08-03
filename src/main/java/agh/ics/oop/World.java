package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        for(String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
        Application.launch(App.class, args);
        System.out.println("system zakończył działanie");
    }
}
