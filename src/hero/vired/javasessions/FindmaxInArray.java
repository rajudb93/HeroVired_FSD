package hero.vired.javasessions;

public class FindmaxInArray {
    public static void main(String[] args) {
        int[] numbers = { 10, 5, 2, 20, 15, 3, 20, 10 };
        
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > highest) {
                secondHighest = highest;
                highest = numbers[i];
            } else if (numbers[i] > secondHighest && numbers[i] != highest) {
                secondHighest = numbers[i];
            }
        }
        
        System.out.println("First highest number: " + highest);
        System.out.println("Second highest number: " + secondHighest);
    }
    }
    

