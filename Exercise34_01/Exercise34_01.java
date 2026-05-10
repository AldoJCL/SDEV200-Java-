package Exercise34_01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise34_01 extends Application {
    // text fields for the Staff table
    private TextField tfId = new TextField();
    private TextField tfLastName = new TextField();
    private TextField tfFirstName = new TextField();
    private TextField tfMi = new TextField();
    private TextField tfAddress = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfState = new TextField();
    private TextField tfTelephone = new TextField();
    private TextField tfEmail = new TextField();

    // status message
    private Label lblStatus = new Label("Enter staff information.");

    @Override
    public void start(Stage primaryStage) {
        // create the form layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(8);
        gridPane.setVgap(8);

        // add labels and text fields
        gridPane.add(new Label("ID:"), 0, 0);
        gridPane.add(tfId, 1, 0);

        gridPane.add(new Label("Last Name:"), 0, 1);
        gridPane.add(tfLastName, 1, 1);

        gridPane.add(new Label("First Name:"), 0, 2);
        gridPane.add(tfFirstName, 1, 2);

        gridPane.add(new Label("MI:"), 0, 3);
        gridPane.add(tfMi, 1, 3);

        gridPane.add(new Label("Address:"), 0, 4);
        gridPane.add(tfAddress, 1, 4);

        gridPane.add(new Label("City:"), 0, 5);
        gridPane.add(tfCity, 1, 5);

        gridPane.add(new Label("State:"), 0, 6);
        gridPane.add(tfState, 1, 6);

        gridPane.add(new Label("Telephone:"), 0, 7);
        gridPane.add(tfTelephone, 1, 7);

        gridPane.add(new Label("Email:"), 0, 8);
        gridPane.add(tfEmail, 1, 8);

        // create buttons
        Button btView = new Button("View");
        Button btInsert = new Button("Insert");
        Button btUpdate = new Button("Update");
        Button btClear = new Button("Clear");

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(btView, btInsert, btUpdate, btClear);

        // button actions
        btView.setOnAction(e -> viewStaff());
        btInsert.setOnAction(e -> insertStaff());
        btUpdate.setOnAction(e -> updateStaff());
        btClear.setOnAction(e -> clearFields());

        VBox mainBox = new VBox(10);
        mainBox.setPadding(new Insets(10));
        mainBox.getChildren().addAll(gridPane, buttonBox, lblStatus);

        Scene scene = new Scene(mainBox, 420, 430);
        primaryStage.setTitle("Exercise 34.1 - Staff Database");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // views a staff record from the database
    private void viewStaff() {
        lblStatus.setText("View staff record.");
    }

    // inserts a new staff record into the database
    private void insertStaff() {
        lblStatus.setText("Insert staff record.");
    }

    // updates an existing staff record in the database
    private void updateStaff() {
        lblStatus.setText("Update staff record.");
    }

    // clears all text fields
    private void clearFields() {
        tfId.clear();
        tfLastName.clear();
        tfFirstName.clear();
        tfMi.clear();
        tfAddress.clear();
        tfCity.clear();
        tfState.clear();
        tfTelephone.clear();
        tfEmail.clear();

        lblStatus.setText("Fields cleared.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}