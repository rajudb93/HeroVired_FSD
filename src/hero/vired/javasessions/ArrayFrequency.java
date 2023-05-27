package hero.vired.javasessions;

public class ArrayFrequency {
    public static void main(String[] args) {
        int[] arrSuperSet = {3, 1, 3, 4, 1, 2, 1, 8, 3, 2, 1, 1, 3, 2, 3, 3, 4};
        int[] arrSubSet = {1, 2, 3, 5, 9};

        int[] frequencies = new int[arrSubSet.length];

        // Initialize frequencies array with zeros
        for (int i = 0; i < frequencies.length; i++) {
            frequencies[i] = 0;
        }

        // Count frequencies of subset elements in the superset
        for (int i = 0; i < arrSuperSet.length; i++) {
            for (int j = 0; j < arrSubSet.length; j++) {
                if (arrSuperSet[i] == arrSubSet[j]) {
                    frequencies[j]++;
                    break;
                }
            }
        }

        // Print frequencies
        for (int i = 0; i < arrSubSet.length; i++) {
            System.out.println("Frequency of " + arrSubSet[i] + ": " + frequencies[i]);
        }
    }
    
}
