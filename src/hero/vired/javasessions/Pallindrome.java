package hero.vired.javasessions;

import java.util.Scanner;

public class Pallindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it is a palindrome: ");
        String input = scanner.nextLine();

        String reversedInput = new StringBuilder(input).reverse().toString();

        if (input.equals(reversedInput)) {
            System.out.println(input + " is a palindrome");
        } else {
            System.out.println(input + " is not a palindrome");
        }
    
}
}
