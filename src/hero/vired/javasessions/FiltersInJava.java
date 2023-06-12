package hero.vired.javasessions;
import java.util.Arrays;

public class FiltersInJava {
    public static void main(String[] args) {
        int []num={1,2,3,4,5,6,7,8,9};
        int [] even=Arrays.stream(num).filter(i->i%2==0).toArray();
        System.out.println(Arrays.toString(even));
    }
    
}
