package finalprojectclasses;

/*
 * Program name: WorkoutApp.java
 * Author: Aldo Cortez-Lucero
 * Date last updated: 5/10/2026
 * Purpose: JavaFX GUI for adding, searching, and viewing strength workouts.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WorkoutApp extends Application {
    private WorkoutManager manager = new WorkoutManager();

    private TextField tfDate = new TextField();
    private TextField tfExerciseName = new TextField();
    private TextField tfDuration = new TextField();
    private TextField tfNotes = new TextField();
    private TextField tfMuscleGroup = new TextField();
    private TextField tfSets = new TextField();
    private TextField tfReps = new TextField();
    private TextField tfWeight = new TextField();
    private TextField tfDifficulty = new TextField();
    private TextField tfSearch = new TextField();

    private TextArea outputArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        VBox mainPane = new VBox(12);
        mainPane.setPadding(new Insets(15));

        Label title = new Label("Workout Tracker");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        GridPane inputGrid = new GridPane();
        inputGrid.setHgap(10);
        inputGrid.setVgap(8);

        inputGrid.add(new Label("Date:"), 0, 0);
        inputGrid.add(tfDate, 1, 0);

        inputGrid.add(new Label("Exercise:"), 0, 1);
        inputGrid.add(tfExerciseName, 1, 1);

        inputGrid.add(new Label("Duration Minutes:"), 0, 2);
        inputGrid.add(tfDuration, 1, 2);

        inputGrid.add(new Label("Notes:"), 0, 3);
        inputGrid.add(tfNotes, 1, 3);

        inputGrid.add(new Label("Muscle Group:"), 0, 4);
        inputGrid.add(tfMuscleGroup, 1, 4);

        inputGrid.add(new Label("Sets:"), 0, 5);
        inputGrid.add(tfSets, 1, 5);

        inputGrid.add(new Label("Reps:"), 0, 6);
        inputGrid.add(tfReps, 1, 6);

        inputGrid.add(new Label("Weight:"), 0, 7);
        inputGrid.add(tfWeight, 1, 7);

        inputGrid.add(new Label("Difficulty 1-10:"), 0, 8);
        inputGrid.add(tfDifficulty, 1, 8);

        Button addButton = new Button("Add Workout");
        Button summaryButton = new Button("Show Summary");
        Button clearButton = new Button("Clear Form");

        GridPane buttonGrid = new GridPane();
        buttonGrid.setHgap(10);
        buttonGrid.add(addButton, 0, 0);
        buttonGrid.add(summaryButton, 1, 0);
        buttonGrid.add(clearButton, 2, 0);

        GridPane searchGrid = new GridPane();
        searchGrid.setHgap(10);
        searchGrid.setVgap(8);

        Button searchButton = new Button("Search Exercise");

        searchGrid.add(new Label("Search by Exercise:"), 0, 0);
        searchGrid.add(tfSearch, 1, 0);
        searchGrid.add(searchButton, 2, 0);

        outputArea.setPrefHeight(220);
        outputArea.setEditable(false);

        // Event 1: Add a workout from the input fields
        addButton.setOnAction(e -> addWorkout());

        // Event 2: Show total workouts, total minutes, and total volume
        summaryButton.setOnAction(e -> showSummary());

        // Event 3: Search workouts by exercise name
        searchButton.setOnAction(e -> searchWorkout());

        // Event 4: Clear all input fields
        clearButton.setOnAction(e -> clearForm());

        mainPane.getChildren().addAll(
                title,
                inputGrid,
                buttonGrid,
                searchGrid,
                new Label("Results / Output:"),
                outputArea
        );

        Scene scene = new Scene(mainPane, 620, 650);
        primaryStage.setTitle("Workout Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addWorkout() {
        try {
            String date = tfDate.getText();
            String exerciseName = tfExerciseName.getText();
            int duration = Integer.parseInt(tfDuration.getText());
            String notes = tfNotes.getText();
            String muscleGroup = tfMuscleGroup.getText();
            int sets = Integer.parseInt(tfSets.getText());
            int reps = Integer.parseInt(tfReps.getText());
            double weight = Double.parseDouble(tfWeight.getText());
            int difficulty = Integer.parseInt(tfDifficulty.getText());

            StrengthWorkout workout = new StrengthWorkout(
                    date,
                    exerciseName,
                    duration,
                    notes,
                    muscleGroup,
                    sets,
                    reps,
                    weight,
                    difficulty
            );

            boolean added = manager.addWorkout(workout);

            if (added) {
                outputArea.setText("Workout added successfully.\n\n" + workout);
            } else {
                outputArea.setText("Workout was not added. Please check that the required fields are valid.");
            }
        } catch (NumberFormatException ex) {
            outputArea.setText("Input error: duration, sets, reps, weight, and difficulty must be numbers.");
        }
    }

    private void showSummary() {
        String result = "Workout Summary\n";
        result += "--------------------\n";
        result += "Workout Count: " + manager.getWorkoutCount() + "\n";
        result += "Total Minutes: " + manager.getTotalWorkoutMinutes() + "\n";
        result += "Total Volume: " + manager.getTotalVolume() + "\n";

        outputArea.setText(result);
    }

    private void searchWorkout() {
        String exerciseName = tfSearch.getText();

        if (exerciseName == null || exerciseName.isBlank()) {
            outputArea.setText("Enter an exercise name to search.");
            return;
        }

        String result = "Search Results for: " + exerciseName + "\n";
        result += "--------------------\n";

        boolean found = false;

        for (StrengthWorkout workout : manager.searchByExerciseName(exerciseName)) {
            result += workout + "\n--------------------\n";
            found = true;
        }

        if (!found) {
            result += "No workouts found.";
        }

        outputArea.setText(result);
    }

    private void clearForm() {
        tfDate.clear();
        tfExerciseName.clear();
        tfDuration.clear();
        tfNotes.clear();
        tfMuscleGroup.clear();
        tfSets.clear();
        tfReps.clear();
        tfWeight.clear();
        tfDifficulty.clear();
        tfSearch.clear();

        outputArea.setText("Form cleared.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}