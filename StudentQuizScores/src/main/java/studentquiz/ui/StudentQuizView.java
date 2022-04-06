/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentquiz.ui;

import studentquiz.dto.StudentQuizScores;
import studentquiz.dto.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author westo
 */
public class StudentQuizView {

    private UserIO io = new UserIOConsoleImpl();

    public int getMenuSelection() {
        io.print("Main Menu");
        io.print("1. List Students");
        io.print("2. Create New Student");
        io.print("3. Remove a Student");
        io.print("4. Enter a quiz score");
        io.print("5. View a student's quiz scores");
        io.print("6. View a student's average quiz score");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public void displayStudentList(List<Student> studentList) {
        for (Student currentStudent : studentList) {
            String studentInfo = String.format("#%s : %s %s",
                    currentStudent.getStudentId(),
                    currentStudent.getFirstName(),
                    currentStudent.getLastName());
            io.print(studentInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    public void displayQuizList(ArrayList<Integer> quizList) {
        int count = 1;
        for (int i : quizList) {
            System.out.println("Quiz # " + count + ": " + i);
            count++;
        }
        io.readString("Please hit enter to continue.");
    }

    public Student getNewStudentInfo() {
        String studentId = io.readString("Please enter Student ID");
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String cohort = io.readString("Please enter Cohort");
        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);
        return currentStudent;
    }

    public StudentQuizScores getScoreInfo() {
        String studentId = io.readString("Please enter Student ID");
        int numScores = io.readInt("Please enter the number of scores", 1, 100);
        ArrayList<Integer> scores = new ArrayList<>();
        int quizCount = 1;
        while (numScores > 0) {
            int quizScore = io.readInt("Quiz #" + quizCount + " :", 0, 100 );
            scores.add(quizScore);
            numScores--;
            quizCount++;
        }
        StudentQuizScores studentQuizScores = new StudentQuizScores();
        studentQuizScores.setScores(scores);
        studentQuizScores.setStudentID(studentId);
        return studentQuizScores;
    }

    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID.");
    }

    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }
    public void displayAverageScore(int average) {
        io.print("The average score is: " + average);
    }
    public void displayAverageScoreBanner() {
        io.print("=== Average Score ===");
    }
    public void displayAddScoreBanner() {
        io.print("=== Add Score ===");
    }
    public void displayViewScoreBanner() {
        io.print("=== View Score(s) ===");
    }
    public void displayCreateSuccessBanner() {
        io.readString(
                "Student successfully created.  Please hit enter to continue");
    }
    public void displayQuizEntrySuccessBanner() {
        io.readString(
                "Student quiz(zes) successfully entered. Please hit enter to continue");
    }

    public void displayRemoveStudentBanner() {
        io.print("=== Remove Student ===");
    }

    public void displayRemoveResult(Student studentRecord) {
        if (studentRecord != null) {
            io.print("Student successfully removed.");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
}
