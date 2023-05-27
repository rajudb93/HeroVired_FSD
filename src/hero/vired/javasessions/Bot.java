package hero.vired.javasessions;

import java.util.Scanner;

public class Bot {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

    

        System.out.println("Enter your age=");
        int age=sc.nextInt();
        if(age>=18){
            System.out.println("You are eligible to vote");
        }
        else{
            System.out.println("You acan't vote");
        }

        // System.out.println("Enter your hobby=");
        // String hobby=sc.nextLine();

        // System.out.println("Enter your mobile number=");
        // long  contactNumber=sc.nextLong();

        sc.close();
        
    }
    
}
