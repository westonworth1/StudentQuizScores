/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentquiz.dto;

import java.util.ArrayList;


/**
 *
 * @author westo
 */
public class StudentQuizScores {
    private String studentID;
    private ArrayList<Integer> scores;

    public String getStudentID() {
        return studentID;
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }
    public int getAverageScore(){
       int average = 0;
       int count = 0;
       for (int i : scores){
           average += i;
           count++;
       }
       
       return average/count;
    }
}
