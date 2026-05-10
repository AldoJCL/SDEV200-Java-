package Exercise15_07;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise15_07 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Circle circle = new Circle(100, 100, 50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        // When mouse button is pressed, make the circle black
        circle.setOnMousePressed(e -> {
            circle.setFill(Color.BLACK);
        });

        // When mouse button is released, make the circle white
        circle.setOnMouseReleased(e -> {
            circle.setFill(Color.WHITE);
        });

        pane.getChildren().add(circle);

        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Exercise15_07");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}