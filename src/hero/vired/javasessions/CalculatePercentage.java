package hero.vired.javasessions;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatePercentage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the total marks: ");
        double totalMarks = sc.nextDouble();

        System.out.print("Enter the marks obtained: ");
        double marksObtained = sc.nextDouble();

        double percentage = (marksObtained / totalMarks) * 100;

        String grade;
        double gpa;

        if (percentage >= 90) {
            grade = "A";
            gpa = 4.0;
        } else if (percentage >= 80) {
            grade = "B";
            gpa = 3.0;
        } else if (percentage >= 70) {
            grade = "C";
            gpa = 2.0;
        } else if (percentage >= 60) {
            grade = "D";
            gpa = 1.0;
        } else {
            grade = "F";
            gpa = 0.0;
        }
        String formattedValue = String.format("%.2f", percentage);

        System.out.println("Percentage: "+ formattedValue + "%");
        System.out.println("Grade " + grade + ", GPA = " + gpa);

        sc.close();
    }
    
}
