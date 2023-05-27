package hero.vired.javasessions;

public class CountMinMaxAverage {
    public static void main(String[] args) {
        int[] arrNum = {31, 42, 25, 21, 56, 61, 13, 45, 76, 55};

        int count = arrNum.length;
        int min = arrNum[0];
        int max = arrNum[0];
        int sum = arrNum[0];

        for (int i = 1; i < count; i++) {
            if (arrNum[i] < min) {
                min = arrNum[i];
            }
            if (arrNum[i] > max) {
                max = arrNum[i];
            }
            sum += arrNum[i];
        }

        double average = (double) sum / count;

        System.out.println("The element with the Minimum value: " + min);
        System.out.println("The element with the Maximum value: " + max);
        System.out.println("Average of all array elements: " + average);
        System.out.println("Total number of array elements: " + count);
    }
    
}
