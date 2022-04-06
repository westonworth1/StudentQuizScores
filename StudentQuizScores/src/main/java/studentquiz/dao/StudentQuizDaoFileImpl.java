/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentquiz.dao;

import studentquiz.dto.StudentQuizScores;
import studentquiz.dto.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author westo
 */
public class StudentQuizDaoFileImpl implements StudentQuizDao {
    private Map<String, Student> students = new HashMap<>();
    private Map<String, ArrayList<Integer>> quizScores = new HashMap<>();

    @Override
    public Student addStudent(String studentId, Student student) {
        Student prevStudent = students.put(studentId, student);
        return prevStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<Student>(students.values());
    }

    /*@Override
    public Student getStudent(String studentId) {
        return students.get(studentId);
    }*/

    @Override
    public Student removeStudent(String studentId) {
        Student removedStudent = students.remove(studentId);
        return removedStudent;
    }
    
    @Override
    public int getAvgQuizScores(String studentId) {
        StudentQuizScores curStudent = new StudentQuizScores();
        curStudent.setScores(quizScores.get(studentId));
        int average = curStudent.getAverageScore();
        return average;
    }
    @Override
    public Map<String, ArrayList<Integer>> enterQuizScore(StudentQuizScores newStudentQuiz) {
        quizScores.put(newStudentQuiz.getStudentID(), newStudentQuiz.getScores());
        return quizScores;
    }
    @Override
    public ArrayList<Integer> getStudentScores(String studentId)
    {
        ArrayList<Integer> scores = quizScores.get(studentId);
        return scores;
    }
}
