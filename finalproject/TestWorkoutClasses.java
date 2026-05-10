package finalproject;

/*
 * Program name: TestWorkoutClasses.java
 * Author: Aldo Cortez-Lucero
 * Date last updated: 5/10/2026
 * Purpose: Tests the workout classes for the final project.
 */

public class TestWorkoutClasses {

    public static void main(String[] args) {
        WorkoutManager manager = new WorkoutManager();

        StrengthWorkout workout1 = new StrengthWorkout(
                "2026-05-10",
                "Bench Press",
                45,
                "Felt strong today.",
                "Chest",
                4,
                8,
                185.0,
                8
        );

        StrengthWorkout workout2 = new StrengthWorkout(
                "2026-05-11",
                "Squat",
                60,
                "Leg day.",
                "Legs",
                5,
                5,
                225.0,
                9
        );

        StrengthWorkout badWorkout = new StrengthWorkout(
                "",
                "",
                -20,
                null,
                "",
                -1,
                -5,
                -100,
                15
        );

        System.out.println("Adding workout 1: " + manager.addWorkout(workout1));
        System.out.println("Adding workout 2: " + manager.addWorkout(workout2));
        System.out.println("Adding bad workout: " + manager.addWorkout(badWorkout));

        System.out.println("\nWorkout count: " + manager.getWorkoutCount());

        System.out.println("\nAll Workouts:");
        for (StrengthWorkout workout : manager.getAllWorkouts()) {
            System.out.println("--------------------");
            System.out.println(workout);
        }

        System.out.println("\nTotal workout minutes: " + manager.getTotalWorkoutMinutes());
        System.out.println("Total training volume: " + manager.getTotalVolume());

        System.out.println("\nSearching for Bench Press:");
        for (StrengthWorkout workout : manager.searchByExerciseName("Bench Press")) {
            System.out.println(workout.getExerciseName() + " found on " + workout.getDate());
        }

        System.out.println("\nRemoving workout at index 0: " + manager.removeWorkout(0));
        System.out.println("Workout count after removal: " + manager.getWorkoutCount());

        manager.clearWorkouts();
        System.out.println("Workout count after clear: " + manager.getWorkoutCount());
    }
}