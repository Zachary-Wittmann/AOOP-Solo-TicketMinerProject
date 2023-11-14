
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The Customer.java file is used to create Customer objects.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.util.*;

public class Customer {
    /**
     * These are the attributes
     */
    private int customerID;
    private String customerFirstName;
    private String customerLastName;
    private double customerMoneyAvailable;
    private int customerConcertsPurchased;
    private boolean customerMembership;
    private String customerUsername;
    private String customerPassword;

    private int invoices = 0;
    private static HashMap<Integer, Customer> customerMap = new HashMap<Integer, Customer>();
    private HashMap<String, ArrayList<Ticket>> ticketsOwned = new HashMap<>();

    /**
     * This creates an empty instance of Customer
     * 
     * @param none
     */
    public Customer() {

    }

    /**
     * This creates a filled instance of Customer
     * 
     * @param customerID
     * @param customerFirstName
     * @param customerLastName
     * @param customerMoneyAvailable
     * @param customerConcertsPurchased
     * @param customerMembership
     * @param customerUsername
     * @param customerPassword
     */
    public Customer(int customerID, String customerFirstName, String customerLastName, double customerMoneyAvailable,
            int customerConcertsPurchased, boolean customerMembership, String customerUsername,
            String customerPassword) {
        this.customerID = customerID;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerMoneyAvailable = customerMoneyAvailable;
        this.customerConcertsPurchased = customerConcertsPurchased;
        this.customerMembership = customerMembership;
        this.customerUsername = customerUsername;
        this.customerPassword = customerPassword;
    }

    /**
     * 
     * @param userName
     * @param password
     * @return The customer that logged in using password
     */
    public static Customer loggedInPassword(String userName, String password) {
        for (int i = 1; i < customerMap.size(); i++) {
            if ((customerMap.get(i).getCustomerUsername().equals(userName))
                    && customerMap.get(i).getCustomerPassword().equals(password)) {
                return customerMap.get(i);
            }
        }
        return null;
    }

    /**
     * 
     * @param firstName
     * @param lastName
     * @return The customer that logged in using their name
     */
    public static Customer loggedInName(String firstName, String lastName) {
        for (int i = 1; i < customerMap.size(); i++) {
            if ((customerMap.get(i).getCustomerFirstName().toLowerCase().equals(firstName))
                    && customerMap.get(i).getCustomerLastName().toLowerCase().equals(lastName)) {
                return customerMap.get(i);
            }
        }
        return null;
    }

    /**
     * This updates the number of tickets that are owned by the customer
     * 
     * @param ticketIn
     */
    public void updateTicketsOwned(Ticket ticketIn) {
        ticketsOwned.computeIfAbsent(ticketIn.getEventName(), k -> new ArrayList<Ticket>()).add(ticketIn);
    }

    /**
     * @param none Prints out the tickets the Customer owns
     */
    public void printTicketsOwned() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Tickets owned:\n");
        for (String key : ticketsOwned.keySet()) {
            System.out.println("********************\n" + key + ": \n");
            for (int i = 0; i < ticketsOwned.get(key).size(); i++) {
                ticketsOwned.get(key).get(i).printTicketInfo();
                System.out.println();
            }
            System.out.println("********************");
        }
    }

    /**
     * This is used to update the list of customers
     * 
     * @param customerList
     * @param index
     */
    public static void updateCustomerList(ArrayList<String> customerList, int index) {
        customerList.set(index, csvFormatting(index));
    }

    /**
     * 
     * @param index
     * @return A string that is formatted to be used to write the customerList.csv
     *         file
     */
    public static String csvFormatting(int index) {
        return (customerMap.get(index).getCustomerID() + "," + customerMap.get(index).getCustomerFirstName() + ","
                + customerMap.get(index).getCustomerLastName() + ","
                + customerMap.get(index).getCustomerMoneyAvailable() + ","
                + customerMap.get(index).getCustomerConcertsPurchased() + ","
                + customerMap.get(index).isCustomerMembership() + ","
                + customerMap.get(index).getCustomerUsername() + "," + customerMap.get(index).getCustomerPassword());
    }

    /**
     * 
     * @return
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * 
     * @param customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * 
     * @return
     */
    public String getCustomerFirstName() {
        return customerFirstName;
    }

    /**
     * 
     * @param customerFirstName
     */
    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    /**
     * 
     * @return
     */
    public String getCustomerLastName() {
        return customerLastName;
    }

    /**
     * 
     * @param customerLastName
     */
    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    /**
     * 
     * @return
     */
    public double getCustomerMoneyAvailable() {
        return customerMoneyAvailable;
    }

    /**
     * 
     * @param customerMoneyAvailable
     */
    public void setCustomerMoneyAvailable(double customerMoneyAvailable) {
        this.customerMoneyAvailable = customerMoneyAvailable;
    }

    /**
     * 
     * @return
     */
    public int getCustomerConcertsPurchased() {
        return customerConcertsPurchased;
    }

    /**
     * 
     * @param customerConcertsPurchased
     */
    public void setCustomerConcertsPurchased(int customerConcertsPurchased) {
        this.customerConcertsPurchased = customerConcertsPurchased;
    }

    /**
     * 
     * @return
     */
    public boolean isCustomerMembership() {
        return customerMembership;
    }

    /**
     * 
     * @param customerMembership
     */
    public void setCustomerMembership(boolean customerMembership) {
        this.customerMembership = customerMembership;
    }

    /**
     * 
     * @return
     */
    public String getCustomerUsername() {
        return customerUsername;
    }

    /**
     * 
     * @param customerUsername
     */
    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    /**
     * 
     * @return
     */
    public String getCustomerPassword() {
        return customerPassword;
    }

    /**
     * 
     * @param customerPassword
     */
    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    /**
     * 
     * @return
     */
    public static HashMap<Integer, Customer> getCustomerMap() {
        return customerMap;
    }

    /**
     * 
     * @param customerMap
     */
    public static void setCustomerMap(HashMap<Integer, Customer> customerMap) {
        Customer.customerMap = customerMap;
    }

    /**
     * 
     * @return
     */
    public HashMap<String, ArrayList<Ticket>> getTicketsOwned() {
        return ticketsOwned;
    }

    /**
     * 
     * @param ticketsOwned
     */
    public void setTicketsOwned(HashMap<String, ArrayList<Ticket>> ticketsOwned) {
        this.ticketsOwned = ticketsOwned;
    }

    /**
     * 
     * @return
     */
    public int getInvoices() {
        return invoices;
    }

    /**
     * 
     * @param invoices
     */
    public void setInvoices(int invoices) {
        this.invoices = invoices;
    }

}
