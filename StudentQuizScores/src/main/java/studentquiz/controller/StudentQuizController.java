/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentquiz.controller;

import java.util.ArrayList;
import java.util.List;
import studentquiz.dto.Student;
import studentquiz.dao.StudentQuizDao;
import studentquiz.dao.StudentQuizDaoFileImpl;
import studentquiz.dto.StudentQuizScores;
import studentquiz.ui.StudentQuizView;

/**
 *
 * @author westo
 */
public class StudentQuizController {

    private StudentQuizView view = new StudentQuizView();
    private StudentQuizDao dao = new StudentQuizDaoFileImpl();
    private ArrayList<Integer> scoreList = new ArrayList<>();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        while (keepGoing) {
            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    enterQuizScore();
                    break;
                case 5:
                    viewQuizScores(); // TBI
                    break;
                case 6:
                    viewAverageScore(); // TBI
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
                    ;
            }
            exitMessage();
        }
    }

    private void enterQuizScore() {
        view.displayAddScoreBanner();
        StudentQuizScores newStudentQuiz = view.getScoreInfo();
        dao.enterQuizScore(newStudentQuiz);
        view.displayQuizEntrySuccessBanner();
    }
    private void viewAverageScore() {
        view.displayAverageScoreBanner();
        String studentId = view.getStudentIdChoice();
        int average = dao.getAvgQuizScores(studentId);
        view.displayAverageScore(average);
    }

    private void viewQuizScores() {
        view.displayViewScoreBanner();
        String studentId = view.getStudentIdChoice();
        ArrayList<Integer> quizList = dao.getStudentScores(studentId);
        view.displayViewScoreBanner();
        view.displayQuizList(quizList);
    }

    private void createStudent() {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }

    private void removeStudent() {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student removedStudent = dao.removeStudent(studentId);
        view.displayRemoveResult(removedStudent);
    }

    private void listStudents() {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }

    private int getMenuSelection() {
        return view.getMenuSelection();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
}
