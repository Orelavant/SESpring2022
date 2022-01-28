package Assignment1;
import java.io.*;  
import java.util.Scanner; 

public class AverageValue {

    public static void main(String[] args) throws FileNotFoundException {
        // Validate parameters as int and csv file
        System.out.println(args[0]);

        // Read in CSV. Code modified: https://www.javatpoint.com/how-to-read-csv-file-in-java
        Scanner sc = new Scanner(new File(args[1]));  
        sc.useDelimiter(","); 
        while (sc.hasNext()) {  
            System.out.print(sc.next());
            //System.out.print(' ');
            System.out.print(sc.hasNextLine());
        }   
        sc.close();
    }

    public static double average(double[] numsArr) {
        double sum = 0;
        int count = 0;

        for(double num : numsArr) {
            sum = sum + num;
            count ++;
        }

        if (count != 0) {
            return sum / count;
        } else {
            return 0;
        }
    }
}