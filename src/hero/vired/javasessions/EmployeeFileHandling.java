package hero.vired.javasessions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeFileHandling {
    private static String  filename="EmployeeFile.csv";

    private  static  void writedatatocsv(){
      
      try(BufferedWriter wr=new BufferedWriter(new FileWriter(filename))){
     
        wr.write("name,empID,designation,salary");
        wr.newLine();
        wr.write("Raju,101,engineer,100");
        wr.newLine();
        wr.write("Shyam,102,doctor,150");
        wr.newLine();
        wr.write("Ram,103,lawyer,110");
        wr.newLine();
        wr.write("Ashok,104,engineer,90");
        wr.newLine();
        wr.write("Hari,105,doctor,150");
        wr.newLine();
      }  
      catch(Exception e){
        e.printStackTrace();
      }
    }

    private static void readdatafromcsv(){
        try(BufferedReader br=new BufferedReader(new FileReader(filename))){
            String line;
            line=br.readLine();
            while((line=br.readLine())!=null){
                String [] data=line.split(",");
                String name=data[0];
                int empID=Integer.parseInt(data[1]);
               
                System.out.println("Name of the employee="+name+" Employee ID="+empID);

            }
        }
        catch(Exception e){
            System.err.println();
        }
    }

    private static void printConditionalSalary(){
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            line=br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
               
                    String name = data[0];
                    int empID = Integer.parseInt(data[1]);
                    int salary = Integer.parseInt(data[3]);

                    if (salary > 100) {
                        System.out.println("Name: " + name);
                        System.out.println("Employee ID: " + empID);
                        System.out.println("Salary: " + salary);
                        System.out.println();
                    }

                    if (empID==105  ) {
                        System.out.println("Please find the Employee 102 details below");
                        System.out.println("Name: " + name);
                        System.out.println("Employee ID: " + empID);
                        System.out.println("Salary: " + salary);
                        System.out.println();
                    }
               
        }
     } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        //writedatatocsv();
        //readdatafromcsv();
        printConditionalSalary();
    }
    
}
