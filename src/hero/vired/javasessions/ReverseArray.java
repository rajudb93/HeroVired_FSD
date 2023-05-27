package hero.vired.javasessions;


import java.util.Comparator;
import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        Integer[] array = {5, 2, 8, 1, 9};

        Arrays.sort(array,Comparator.reverseOrder());

        System.out.println(Arrays.toString(array));
    }
    
}
