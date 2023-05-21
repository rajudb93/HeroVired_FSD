package hero.vired.javasessions;

import java.util.Scanner;

public class SwapTwoIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the value of numA: ");
        int numA = sc.nextInt();
        
        System.out.print("Enter the value of numB: ");
        int numB = sc.nextInt();
        
        System.out.println("Before swapping:");
        System.out.println("numA = " + numA);
        System.out.println("numB = " + numB);
        
        // Swapping the values
        int temp = numA;
        numA = numB;
        numB = temp;
        
        System.out.println("After swapping:");
        System.out.println("numA = " + numA);
        System.out.println("numB = " + numB);
        sc.close();
    }
}
