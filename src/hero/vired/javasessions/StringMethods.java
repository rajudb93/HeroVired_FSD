package hero.vired.javasessions;

public class StringMethods {
    public static void main(String[] args) {
        String s1=new String("hello");
        String s2=new String("Hello");

        System.out.println(s1.length());
        System.out.println(s1+" "+s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
        System.out.println(s1.compareTo(s2));

        String s3="Hello";
        System.out.println(s3.contains("Heo"));
        System.out.println(s3.indexOf("l"));
        System.out.println(s3.lastIndexOf("l"));
        System.out.println(s3.substring(1, 3));
        System.out.println(s3.replace('H','M'));
        System.out.println(s3.replaceAll("l", "m"));
        System.out.println(s3.toUpperCase());
        System.out.println(s3.toLowerCase());

        s3=" Hell o ";
        System.out.println(s3);
        System.out.println(s3.trim());

        int i=10;
        Integer I=i;
        System.out.println(I.toString());
       

        String str="10";
        System.out.println(Integer.parseInt(str));
        System.out.println(str.getClass().getSimpleName());
        

        String s4="Shakul,Mallik,her,Vired";
        String[] strArray=s4.split(",");
        for (String str1 : strArray) {
            System.out.print(str1+" ");
            
        }





        
    }
    
}
