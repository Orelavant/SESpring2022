package Assignment1;
import java.io.*;
import java.util.ArrayList;

public class AverageValue {

    public static void main(String[] args) throws IOException {
        // Validate parameters as int and csv file
        int colIndex = Integer.parseInt(args[0]);
        String fileName = args[1];

        // Read in a column
        ArrayList<Double> column = readinColumn(colIndex, fileName);
        
        // Display results
        System.out.println(column.toString());
        System.out.println(average(column));
    }

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
            column.add(Double.parseDouble(tempArr[colIndex]));
            //System.out.print(tempArr[colIndex] + " ");
        }
        fr.close();
        br.close();

        return column;
    }

    public static double average(ArrayList<Double> numArr) {
        double sum = 0;
        int count = 0;

        for(double num : numArr) {
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