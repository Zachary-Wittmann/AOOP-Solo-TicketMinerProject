
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The CustomerCreator.java file is used to create Customers for the customer hashmap from the arrayList made by the CSVReader.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;

public class CustomerCreator {
    /**
     * Creates an instance of the CustomerCreator
     * 
     * @param none
     */
    CustomerCreator() {

    }

    /**
     * Creates the customers based off the arrayList made by the CSVReader
     * 
     * @param customerList
     * @throws InputMismatchException
     */
    public void createCustomers(ArrayList<String> customerList) throws InputMismatchException {
        for (int i = 1; i < customerList.size(); i++) {
            String[] splitList = customerList.get(i).split(",");

            try {
                Customer.getCustomerMap().put(Integer.parseInt(splitList[0]),
                        new Customer(Integer.parseInt(splitList[0]), splitList[1], splitList[2],
                                Double.parseDouble(splitList[3]), Integer.parseInt(splitList[4]),
                                Boolean.parseBoolean(splitList[5]), splitList[6], splitList[7]));
            } catch (InputMismatchException e) {
                System.out.println("Invalid type trying to be parsed.");
            }
        }
    }
}
