/* 
   * Desc:
   *    The main driver program for Assignment 1.
   *    This program reads the integer and file specified by the command line
   *    arguments, averages a column of numbers if possible, and returns the result.
   * @author Jacob Valero
*/

package Assignment1;
import java.io.*;
import java.util.ArrayList;

// Class with methods used to average a column of values based off of a provided index and CSV.
public class AverageValue {

    public static void main(String[] args) throws IOException {
        // Check for errors
        if (!inputCheck(args)) {
            System.out.println("Invalid data");
            return;
        }

        // Set vars
        int colIndex = Integer.parseInt(args[0]);
        String fileName = args[1];

        try {
            // Read file and return a column
            ArrayList<Double> column = readinColumn(colIndex, fileName);
        
            // Display results
            System.out.println(column.toString());
            System.out.println(average(column));
        } catch (IOException e) {
            System.out.println("Invalid data");
        } 
    }

    // Checks commandline input for errors, returns false if any errors exist. 
    public static boolean inputCheck(String[] args) {
        // Check for at least 2 arguemnts (more than 2 will be ignored)
        if (args.length < 2) { return false; }

        // Validate arg[0] as int.
        int colIndex = -1;
        try {
            colIndex = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            return false;
        }

        // Make sure colIndex isn't negative
        if (colIndex < 0) { return false; }

        return true;
    }

    // Read in the file and return the column specified by the first command line argument as an arr
    public static ArrayList<Double> readinColumn(int colIndex, String fileName) throws IOException {
        // Read in CSV. Code modified: https://www.tutorialspoint.com/how-to-read-the-data-from-a-c
        // sv-file-in-java#:~:text=We%20can%20read%20a%20CSV,by%20using%20an%20appropriate%20index.
        ArrayList<Double> column = new ArrayList<Double>();
        String delimiter = ",";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String[] tempArr;
        while((line = br.readLine()) != null) {
            tempArr = line.split(delimiter);
            try {
                column.add(Double.parseDouble(tempArr[colIndex]));
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) { 
                // if missing num or out of bounds, or number can't be parsed, add 0.
                column.add(0.0);
            }
        }
        fr.close();
        br.close();

        return column;
    }

    // Average an array of doubles.
    public static double average(ArrayList<Double> numArr) {
        double sum = 0;
        int count = 0;

        // Sum
        for(double num : numArr) {
            sum = sum + num;
            count ++;
        }

        // Return average
        if (count != 0) {
            return sum / count;
        } else {
            return 0;
        }
    }
}