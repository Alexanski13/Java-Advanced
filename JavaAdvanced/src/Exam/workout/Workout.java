package Exam.workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        exercises = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public int getExerciseCount() {
        return exercises.size();
    }

    public void addExercise(Exercise exercise) {
        if (exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        boolean result = exercises.removeIf(n -> n.getName().equals(name) && n.getMuscle().equals(muscle));
        return result;
    }

    public Exercise getExercise(String name, String muscle) {
        return exercises.stream()
                .filter(exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle))
                .findFirst().orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        if (exercises.isEmpty()) {
            return null;
        } else {
            Exercise exercise = exercises.get(0);
            for (int i = 1; i < exercises.size(); i++) {
                if (exercises.get(i).getBurnedCalories() > exercises.get(i - 1).getBurnedCalories()) {
                    exercise = exercises.get(i);
                }
            }
            return exercise;
        }
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s%n", this.type));
        for (Exercise exercise : exercises) {
            sb.append(String.format("%s%n", exercise.toString()));
        }

        return sb.toString().trim();
    }
}
