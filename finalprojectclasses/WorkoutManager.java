package finalprojectclasses;

import java.util.ArrayList;

/*
 * Program name: WorkoutManager.java
 * Author: Aldo Cortez-Lucero
 * Date last updated: 5/10/2026
 * Purpose: Stores and manages strength workout records.
 */

public class WorkoutManager {
    private ArrayList<StrengthWorkout> workouts;

    public WorkoutManager() {
        workouts = new ArrayList<>();
    }

    public boolean addWorkout(StrengthWorkout workout) {
        if (workout == null || !workout.isValid()) {
            return false;
        }

        workouts.add(workout);
        return true;
    }

    public boolean removeWorkout(int index) {
        if (index < 0 || index >= workouts.size()) {
            return false;
        }

        workouts.remove(index);
        return true;
    }

    public StrengthWorkout getWorkout(int index) {
        if (index < 0 || index >= workouts.size()) {
            return null;
        }

        return workouts.get(index);
    }

    public ArrayList<StrengthWorkout> getAllWorkouts() {
        return workouts;
    }

    public int getWorkoutCount() {
        return workouts.size();
    }

    public ArrayList<StrengthWorkout> searchByExerciseName(String exerciseName) {
        ArrayList<StrengthWorkout> results = new ArrayList<>();

        if (exerciseName == null) {
            return results;
        }

        for (StrengthWorkout workout : workouts) {
            if (workout.getExerciseName().equalsIgnoreCase(exerciseName)) {
                results.add(workout);
            }
        }

        return results;
    }

    public int getTotalWorkoutMinutes() {
        int total = 0;

        for (StrengthWorkout workout : workouts) {
            total += workout.getDurationMinutes();
        }

        return total;
    }

    public double getTotalVolume() {
        double total = 0;

        for (StrengthWorkout workout : workouts) {
            total += workout.calculateVolume();
        }

        return total;
    }

    public void clearWorkouts() {
        workouts.clear();
    }
}