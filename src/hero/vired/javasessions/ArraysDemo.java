package hero.vired.javasessions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysDemo {
    public static void main(String[] args) {

       String[] arr={"Hello","World","How","Are","You"};
       List<String> al=new ArrayList<>(Arrays.asList(arr));
       System.out.println(al);

       al.remove(1);
       System.out.println(al);

       String[] array = al.toArray(new String[al.size()]);
       System.out.println(Arrays.toString(array));
       for (String ar : array) {
        System.out.println(ar);
       }
       Arrays.sort(array);
       System.out.println(Arrays.toString(array));

      System.out.println( Arrays.binarySearch(array,"You"));
    }
    
}
