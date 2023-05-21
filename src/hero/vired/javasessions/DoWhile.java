package hero.vired.javasessions;

public class DoWhile {
    public static void main(String[] args) {
        int n=5;
        int fact=1;

       do{
             fact=fact*n;
            n--;
        }while(n>=1);
       System.out.println("Factorial="+fact);
    }
    
}
