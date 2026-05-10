package finalproject;

/*
 * Program name: StrengthWorkout.java
 * Author: Aldo Cortez-Lucero
 * Date last updated: 5/10/2026
 * Purpose: Represents a strength training workout entry.
 */

public class StrengthWorkout extends WorkoutEntry {
    private String muscleGroup;
    private int sets;
    private int reps;
    private double weight;
    private int difficultyRating;

    public StrengthWorkout(String date, String exerciseName, int durationMinutes, String notes,
                           String muscleGroup, int sets, int reps, double weight, int difficultyRating) {
        super(date, exerciseName, durationMinutes, notes);
        setMuscleGroup(muscleGroup);
        setSets(sets);
        setReps(reps);
        setWeight(weight);
        setDifficultyRating(difficultyRating);
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        if (muscleGroup == null || muscleGroup.isBlank()) {
            this.muscleGroup = "Unknown";
        } else {
            this.muscleGroup = muscleGroup;
        }
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        if (sets < 0) {
            this.sets = 0;
        } else {
            this.sets = sets;
        }
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        if (reps < 0) {
            this.reps = 0;
        } else {
            this.reps = reps;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 0) {
            this.weight = 0;
        } else {
            this.weight = weight;
        }
    }

    public int getDifficultyRating() {
        return difficultyRating;
    }

    public void setDifficultyRating(int difficultyRating) {
        if (difficultyRating < 1) {
            this.difficultyRating = 1;
        } else if (difficultyRating > 10) {
            this.difficultyRating = 10;
        } else {
            this.difficultyRating = difficultyRating;
        }
    }

    // volume is sets x reps x weight
    public double calculateVolume() {
        return sets * reps * weight;
    }

    @Override
    public boolean isValid() {
        return super.isValid() &&
               !muscleGroup.equals("Unknown") &&
               sets > 0 &&
               reps > 0 &&
               weight >= 0;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nMuscle Group: " + muscleGroup +
               "\nSets: " + sets +
               "\nReps: " + reps +
               "\nWeight: " + weight +
               "\nDifficulty Rating: " + difficultyRating +
               "\nVolume: " + calculateVolume();
    }
}