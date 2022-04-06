/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentQuizzes;

import studentquiz.controller.StudentQuizController;

/**
 *
 * @author westo
 */
public class App {

    public static void main(String[] args) {
        StudentQuizController controller = new StudentQuizController();

        controller.run();
    }  
}