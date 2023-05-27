package hero.vired.javasessions;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> arr=new ArrayList<>();

        arr.add("Hello");
        arr.add("World");
        arr.add("how");
        arr.add("are");
        arr.add("you");

        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        //Modify

        arr.set(0, "Hi");
        System.out.println(arr);
    }
    
}
