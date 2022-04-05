/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.studentquizscores;

/**
 *
 * @author Jeonghoon
 */
public class StudentQuizController {

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 1;

        while (keepGoing) {
            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    System.out.println("View a list of students in the system");
                    break;
                case 2:
                    System.out.println("Add a student to the system");
                    break;
                case 3:
                    System.out.println("Remove a student from the system");
                    break;
                case 4:
                    System.out.println("View a list of quiz scores for a given student");
                    break;
                case 5:
                    System.out.println("View the average quiz score for a given student");
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    ;
            }
        }
    }

    private int getMenuSelection() {
        return 1;
    }
}
