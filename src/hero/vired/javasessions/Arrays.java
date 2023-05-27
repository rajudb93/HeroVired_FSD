package hero.vired.javasessions;

public class Arrays {
    public static void main(String[] args) {
        int arr1[]={2,4,6,8,10,12};        
        int arr2[]=new int[4];
        String arr3[]={"Hello","World","how","are","you"};
        arr2[0]=1;
        arr2[1]=2;
        arr2[2]=3;
        arr2[3]=4;

        System.out.println(arr2[3]);
        System.out.println("============================================");

        for (int i : arr1) {
            System.out.println(i);
            
        }

        System.out.println("============================================");

        for (String str : arr3) {
            System.out.println(str);
        }

        System.out.println("============================================");
        int i=0;

        while (i < arr3.length) {
            String element = arr3[i];
            System.out.println(element);
            i++;
        }

        String str="Raju";
        char[] c=str.toCharArray();
        for (char d : c) {
            System.out.println(d);
        }


    }
    
}
