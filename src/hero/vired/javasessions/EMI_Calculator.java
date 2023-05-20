package hero.vired.javasessions;

import java.nio.file.AtomicMoveNotSupportedException;
import java.util.Scanner;

public class EMI_Calculator {

public static void main(String[] args) {
   // double interestRate=6.0;
    //double monthlyInterestRate = 0.005;
    //(interestRate / 100) / 12;
    Scanner sc = new Scanner(System.in);

        System.out.print("Enter loan amount: ");
        double loanAmount = sc.nextDouble();

        System.out.print("Enter interest rate (%): ");
        double interestRate = sc.nextDouble();
        double monthlyInterestRate = (interestRate / 100) / 12;

        System.out.print("Enter loan tenure (in months): ");
        int loanTenure = sc.nextInt();
        double f=Math.pow(1+monthlyInterestRate, loanTenure);   


        double EMI = (loanAmount * monthlyInterestRate * f) / (f - 1);

        System.out.println(EMI);
}

    
}
