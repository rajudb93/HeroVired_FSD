package hero.vired.javasessions;

import java.util.Scanner;

public class PatternPrint {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Select a pattern to print:");
        System.out.println("1: Pyramid");
        System.out.println("2: Diamond");
        System.out.println("3: Number Pattern");
        System.out.println("4: Floyd's Traingle");

        System.out.println("Enter your choice (1-4): ");
        int choice=sc.nextInt();

        switch(choice){
            case 1:{
                System.out.println("Pyramid Pattern");
                printPyramid();
                break;                

            }
            case 2:{
                System.out.println("Diamond Pattern");
                printDiamond();
                break;
            }
            case 3:{
                System.out.println("Number Pattern");
               printNumberPattern();
                break;
            }
            case 4:{
                System.out.println("Floyd's Traingle Pattern");
                printFloydTriangle();
                break;
            }
            default:
            System.out.println("Invalid Choice");
        }

    
}

    private static void printFloydTriangle() {

        int rows = 5;
        
        int number = 1;
        
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }
            
            System.out.println();
        }
    }

    private static void printDiamond() {

        int rows = 5;
        
        int spaces = rows / 2;
        int stars = 1;
        
        // Upper half of the diamond
        for (int i = 1; i <= rows; i += 2) {
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            
            for (int k = 1; k <= stars; k++) {
                System.out.print("*");
            }
            
            System.out.println();
            spaces--;
            stars += 2;
        }
        
        // Lower half of the diamond
        spaces = 1;
        stars = rows - 2;
        
        for (int i = 1; i <= rows - 2; i += 2) {
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            
            for (int k = 1; k <= stars; k++) {
                System.out.print("*");
            }
            
            System.out.println();
            spaces++;
            stars -= 2;
        }
    }

    private static void printNumberPattern() {
        int rows = 5;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void printPyramid() {
        int rows=5;
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=(rows-i);j++){
                System.out.print(" ");
            }
            for(int k=1;k<=2*i-1;k++){
                System.out.print("*");
        }
        System.out.println();
    }
}

}