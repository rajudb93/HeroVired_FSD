package hero.vired.javasessions;

public class FindLargestPrimeInArray {
    public static void main(String[] args) {
        int[] arrNum = {2, 29, 51, 8, 4};

        int largestPrime = Integer.MIN_VALUE;

        for (int num : arrNum) {
            if (isPrime(num) && num > largestPrime) {
                largestPrime = num;
            }
        }

        if (largestPrime != Integer.MIN_VALUE) {
            System.out.println("The Largest Prime number in the given array: " + largestPrime);
        } else {
            System.out.println("No prime number found in the array.");
        }
    }

    // Helper method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
    
}
