/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.studentquizscores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jeonghoon
 */
public class StudentQuizController {

    // key: Student name, value: quiz scores
    Map<String, ArrayList<Integer>> students = new HashMap<>();

    UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection;

        while (keepGoing) {
            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    listQuizScoresByStudent();
                    break;
                case 5:
                    getAverageQuizScoreByStudent();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }

    private int getMenuSelection() {
        io.print("\nMain Menu");
        io.print("1. List Students");
        io.print("2. Create New Student");
        io.print("3. Remove a Student");
        io.print("4. View a list of quiz scores for a student");
        io.print("5. View the average quiz score for a student");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    private void listStudents() {
        io.print("\n=== Display All Students ===");

        if (students.isEmpty()) {
            io.print("No students in the list");
        } else {
            students.keySet().forEach(io::print);
        }
    }

    private void addStudent() {
        String studentName = io.readString("Please enter Student Name");
        int numberOfScores = io.readInt("How many quiz scores do you want to add?", 1, 100);

        ArrayList<Integer> scores = new ArrayList<>();
        int quizScore;
        for (int i = 1; i <= numberOfScores; i++) {
            quizScore = io.readInt("Quiz" + i, 0, 100);
            scores.add(quizScore);
        }
        students.put(studentName, scores);

        io.readString("Student successfully added. Please hit enter to continue");
    }

    private void removeStudent() {
        String studentName = io.readString("Please enter the student name to remove");

        if (students.remove(studentName) != null) {
            io.print("Student successfully removed.");
        } else {
            io.print("No such student.");
        }
    }

    private void listQuizScoresByStudent() {
        String studentName = io.readString("Please enter the student name");

        ArrayList scores = students.get(studentName);
        if (scores != null) {
            io.print("--List of quiz scores--");
            scores.forEach(score -> io.print(score.toString()));
        } else {
            io.print("No such student.");
        }
    }

    private void getAverageQuizScoreByStudent() {
        String studentName = io.readString("Please enter the student name");

        ArrayList<Integer> scores = students.get(studentName);
        if (scores != null && !scores.isEmpty()) {
            int totalScore = scores.stream().reduce(0, Integer::sum);
            float average = (float) totalScore / scores.size();
            io.print(String.format("Average quiz score: %.2f", average));
        } else {
            io.print("No such student.");
        }
    }

    private void exitMessage() {
        io.print("Good Bye!!!");
    }

    private void unknownCommand() {
        io.print("Unknown Command!!!");
    }
}
