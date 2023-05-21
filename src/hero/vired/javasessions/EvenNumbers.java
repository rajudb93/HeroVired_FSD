package hero.vired.javasessions;

public class EvenNumbers {
    public static void main(String[] args) {
        int evenNumberCounter=0;
        int startingEvenNumber=2;

        while(evenNumberCounter<10){
            if (startingEvenNumber%2==0){
                System.out.println(startingEvenNumber);
                evenNumberCounter++;
            }
            startingEvenNumber=startingEvenNumber+2;

        }
    }
    
}
