
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The CSVReader.java file is used to read a csv file that will be provided.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.io.*;
import java.util.*;

public class CSVReader {
    /**
     * Creates an instance of the CSVReader
     * 
     * @param none
     */
    public CSVReader() {
    }

    /**
     * 
     * @param fileName
     * @return An arrayList of the csv file once it has been read
     */
    public ArrayList<String> readCSV(String fileName) {
        ArrayList<String> data = new ArrayList<>();

        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            while (reader.hasNext()) {
                String temp = reader.nextLine();
                data.add(temp);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return data;
    }
}
