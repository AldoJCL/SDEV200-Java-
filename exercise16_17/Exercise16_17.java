package Exercise16_17;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Exercise16_17 extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox mainPane = new VBox(15);
        mainPane.setStyle("-fx-padding: 20;");

        Label text = new Label("Color Preview");
        text.setStyle("-fx-font-size: 30px; -fx-font-family: Arial; -fx-font-weight: bold;");

        ScrollBar redBar = new ScrollBar();
        ScrollBar greenBar = new ScrollBar();
        ScrollBar blueBar = new ScrollBar();
        ScrollBar opacityBar = new ScrollBar();

        redBar.setMax(255);
        greenBar.setMax(255);
        blueBar.setMax(255);
        opacityBar.setMax(100);

        // Starting values so the text is not just black at first
        redBar.setValue(80);
        greenBar.setValue(120);
        blueBar.setValue(200);
        opacityBar.setValue(100);

        redBar.setPrefWidth(280);
        greenBar.setPrefWidth(280);
        blueBar.setPrefWidth(280);
        opacityBar.setPrefWidth(280);

        GridPane controls = new GridPane();
        controls.setHgap(12);
        controls.setVgap(12);

        controls.add(new Label("Red"), 0, 0);
        controls.add(redBar, 1, 0);

        controls.add(new Label("Green"), 0, 1);
        controls.add(greenBar, 1, 1);

        controls.add(new Label("Blue"), 0, 2);
        controls.add(blueBar, 1, 2);

        controls.add(new Label("Opacity"), 0, 3);
        controls.add(opacityBar, 1, 3);

        redBar.valueProperty().addListener(e -> updateColor(text, redBar, greenBar, blueBar, opacityBar));
        greenBar.valueProperty().addListener(e -> updateColor(text, redBar, greenBar, blueBar, opacityBar));
        blueBar.valueProperty().addListener(e -> updateColor(text, redBar, greenBar, blueBar, opacityBar));
        opacityBar.valueProperty().addListener(e -> updateColor(text, redBar, greenBar, blueBar, opacityBar));

        updateColor(text, redBar, greenBar, blueBar, opacityBar);

        mainPane.getChildren().addAll(text, controls);

        Scene scene = new Scene(mainPane, 430, 240);
        primaryStage.setTitle("Exercise16_17 - Color Selector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateColor(Label text, ScrollBar redBar, ScrollBar greenBar, ScrollBar blueBar, ScrollBar opacityBar) {
        double red = redBar.getValue() / 255.0;
        double green = greenBar.getValue() / 255.0;
        double blue = blueBar.getValue() / 255.0;
        double opacity = opacityBar.getValue() / 100.0;

        text.setTextFill(new Color(red, green, blue, opacity));
    }

    public static void main(String[] args) {
        launch(args);
    }
}