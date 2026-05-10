package Exercise14_01;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise14_01 extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();

ImageView flag1 = new ImageView(new Image(getClass().getResource("flag1.gif").toExternalForm()));
ImageView flag2 = new ImageView(new Image(getClass().getResource("flag2.gif").toExternalForm()));
ImageView flag6 = new ImageView(new Image(getClass().getResource("flag6.gif").toExternalForm()));
ImageView flag7 = new ImageView(new Image(getClass().getResource("flag7.gif").toExternalForm()));

        flag1.setFitWidth(200);
        flag1.setFitHeight(120);
        flag2.setFitWidth(200);
        flag2.setFitHeight(120);
        flag6.setFitWidth(200);
        flag6.setFitHeight(120);
        flag7.setFitWidth(200);
        flag7.setFitHeight(120);

        pane.add(flag1, 0, 0);
        pane.add(flag2, 1, 0);
        pane.add(flag6, 0, 1);
        pane.add(flag7, 1, 1);

        Scene scene = new Scene(pane, 400, 240);

        primaryStage.setTitle("Exercise14_01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}