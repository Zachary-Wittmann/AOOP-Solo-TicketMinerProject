
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The CSVWriter.java file is used to write a csv file that will be labeled as 'Updated' with the original filename following.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.io.*;
import java.util.ArrayList;

public class CSVWriter {
    /**
     * Creates an instance of the CSVWriter
     * 
     * @param none
     */
    public CSVWriter() {
    }

    /**
     * 
     * Writes the new csv file
     * 
     * @param fileName
     * @param listIn
     */
    public void writeCSV(String fileName, ArrayList<String> listIn) {
        String outputName = "Updated" + fileName;

        try {
            FileWriter csvWriter = new FileWriter(outputName);

            for (int i = 0; i < listIn.size(); i++) {
                csvWriter.write(listIn.get(i) + "\n");
            }
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
