package hero.vired.javasessions;

public class StringExample {
    public static void main(String[] args) {
        String s1="Hello";
        String s2="Hello";
        String s3=new String("hello");
        String s4=new String("Hello");

        if(s1==s2){
            System.out.println("same");
        }
        else{
            System.out.println("different");
        }

        if(s3==s4){
            System.out.println("same");
        }
        else{
            System.out.println("different");
        }
    }
    
}
