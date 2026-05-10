package finalprojectclasses;

/*
 * Program name: WorkoutEntry.java
 * Author: Aldo Cortez-Lucero
 * Date last updated: 5/10/2026
 * Purpose: Abstract parent class for workout records.
 */

public abstract class WorkoutEntry {
    private String date;
    private String exerciseName;
    private int durationMinutes;
    private String notes;

    public WorkoutEntry(String date, String exerciseName, int durationMinutes, String notes) {
        setDate(date);
        setExerciseName(exerciseName);
        setDurationMinutes(durationMinutes);
        setNotes(notes);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (date == null || date.isBlank()) {
            this.date = "No date";
        } else {
            this.date = date;
        }
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        if (exerciseName == null || exerciseName.isBlank()) {
            this.exerciseName = "Unnamed Exercise";
        } else {
            this.exerciseName = exerciseName;
        }
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes < 0) {
            this.durationMinutes = 0;
        } else {
            this.durationMinutes = durationMinutes;
        }
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        if (notes == null) {
            this.notes = "";
        } else {
            this.notes = notes;
        }
    }

    // checks if the workout has the basic required info
    public boolean isValid() {
        return !date.equals("No date") &&
               !exerciseName.equals("Unnamed Exercise") &&
               durationMinutes > 0;
    }

    @Override
    public String toString() {
        return "Date: " + date +
               "\nExercise: " + exerciseName +
               "\nDuration: " + durationMinutes + " minutes" +
               "\nNotes: " + notes;
    }
}