package agh.ics.oop.gui;

import agh.ics.oop.*;
import agh.ics.oop.IMapElement;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class GuiElementBox {
    protected Image image;
    protected ImageView imageView;
    protected VBox vBox = new VBox();

    public GuiElementBox(IMapElement element) {
        System.out.println(element.getImagePath());
        this.image = new Image("/" + element.getImagePath() +".png");
        this.imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);

        Label label = new Label(element.getPosition().toString());
        vBox.getChildren().addAll(imageView, label);
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
    }

    public VBox getvBox() {
        return vBox;
    }
}
