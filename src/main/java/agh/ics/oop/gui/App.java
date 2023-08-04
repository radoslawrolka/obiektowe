package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

//import static agh.ics.oop.OptionParser.parse;

public class App extends Application {
    private AbstractWorldMap map;
    private int xMin;
    private int yMin;
    private int xMax;
    private int yMax;
    private final int width = 50;
    private final int height = 50;
    private MoveDirection[] directions;
    private Vector2d[] positions;
    private static GridPane gridPane = new GridPane();

    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        try {
            directions = new OptionParser().parse(args);
            positions = new Vector2d[]{new Vector2d(2, 2), new Vector2d(3, 4)};
            map = new GrassField(10, positions);
            gridPane = new GridPane();
        }
        catch(IllegalArgumentException ex) {
            System.out.println(ex);
            System.exit(0);
        }
    }

    public void updateBounds(){
        xMin = map.getMapLowerLeft().getX();
        yMin = map.getMapLowerLeft().getY();
        xMax = map.getMapUpperRight().getX();
        yMax = map.getMapUpperRight().getY();
    }

    public void xyLabel(){
        GridPane.setHalignment(new Label("y/x"), HPos.CENTER);
        gridPane.getColumnConstraints().add(new ColumnConstraints(width));
        gridPane.getRowConstraints().add(new RowConstraints(height));
        gridPane.add(new Label("y/x"), 0, 0);
    }

    public void columnsFunction(){
        for (int i = xMin; i <= xMax; i++){
            Label label = new Label(Integer.toString(i));
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.getColumnConstraints().add(new ColumnConstraints(width));
            gridPane.add(label, i-xMin+1, 0);
        }
    }

    public void rowsFunction(){
        for (int i = yMax; i >= yMin; i--){
            Label label = new Label(Integer.toString(i));
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.getRowConstraints().add(new RowConstraints(height));
            gridPane.add(label, 0, yMax -i + 1);
        }
    }

    public void addElements() {
        for (int i = xMin; i <= xMax; i++) {
            for (int j = yMax; j >= yMin; j--) {
                Vector2d pos = new Vector2d(i,j);
                if(map.isOccupied(pos)){
                    GuiElementBox elementBox = new GuiElementBox(map.objectAt(pos));
                    gridPane.add(elementBox.getvBox(),i-xMin+1,yMax-j+1);
                    GridPane.setHalignment(elementBox.getvBox(),HPos.CENTER);
                }
                else {
                    gridPane.add(new Label(" "),i-xMin+1,yMax-j+1);
                }
            }
        }
    }

    public void prepareScene(){
        updateBounds();
        xyLabel();
        columnsFunction();
        rowsFunction();
        addElements();
        gridPane.setGridLinesVisible(true);
    }

    public void refreshMap() {
        Platform.runLater(() -> {
            gridPane.getChildren().clear();
            gridPane.setGridLinesVisible(false);
            gridPane.getColumnConstraints().clear();
            gridPane.getRowConstraints().clear();
            prepareScene();
        });
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GridPane Experiment");

        Button button = new Button("Start");
        TextField textField = new TextField();
        HBox hbox = new HBox(textField, button);

        button.setOnAction(event -> {
            String[] args = textField.getText().split(" ");
            directions = new OptionParser().parse(args);
            IEngine engine = new SimulationEngine(directions, map, positions,2000, this);
            Thread thread = new Thread((Runnable) engine);
            thread.start();
        });

        prepareScene();
        VBox mapAndButtons = new VBox(hbox, gridPane);

        Scene scene = new Scene(mapAndButtons,600,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
