
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The CSVHandler.java file is used to handle the information that was read by the CSVReader.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.util.ArrayList;

public class CSVHandler {
    /**
     * These are the attributes
     */
    private static ArrayList<String> customerList;
    private static ArrayList<String> eventList;

    /**
     * This is used to read the csv file using CSVReader.java
     * 
     * @param none
     */
    public static void readCSV() {
        CSVReader reader = new CSVReader();

        customerList = reader.readCSV("CustomerListPA2.csv");
        eventList = reader.readCSV("EventListPA2.csv");
        CustomerCreator customerCreator = new CustomerCreator();
        EventCreator eventCreator = new EventCreator();
        VenueCreator venueCreator = new VenueCreator();
        customerCreator.createCustomers(customerList);
        eventCreator.createEvents(eventList);
        venueCreator.createVenues(eventList);
    }

    /**
     * This is used to write the csv file using CSVWriter.java
     * 
     * @param none
     */
    public static void writeCSV() {
        CSVWriter writer = new CSVWriter();

        writer.writeCSV("EventListPA2.csv", CSVHandler.getEventList());
        writer.writeCSV("CustomerListPA2.csv", CSVHandler.getCustomerList());
    }

    /**
     * 
     * @return An arrayList of the customers
     */
    public static ArrayList<String> getCustomerList() {
        return customerList;
    }

    /**
     * Sets the arrayList of the customers
     * 
     * @param customerList
     */
    public static void setCustomerList(ArrayList<String> customerList) {
        CSVHandler.customerList = customerList;
    }

    /**
     * 
     * @return An arrayList of the events
     */
    public static ArrayList<String> getEventList() {
        return eventList;
    }

    /**
     * Sets the arrayList of the events
     * 
     * @param eventList
     */
    public static void setEventList(ArrayList<String> eventList) {
        CSVHandler.eventList = eventList;
    }
}
