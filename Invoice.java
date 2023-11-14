
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 *          CS 3331
 *          Dr. Mejia
 *          Programming Assignment 1
 *          Description: The Invoice.java file is used to create invoices for
 *          the customer following their purchase(s).
 *          Honesty Statement: All code written in this file was done by Zachary
 *          Wittmann
 *          without any help from outside sources apart from the instructor and
 *          his assistants.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;

public class Invoice {
    /**
     * Formats values into a monetary way
     */
    public static DecimalFormat df = new DecimalFormat("$0.00");

    /**
     * These are the attributes for Invoice
     */
    private String customerName;
    private String confirmationNum;
    private int ticketsPurchased;
    private double totalPrice;

    // Constructor
    /**
     * @param none
     */
    public Invoice() {

    }

    /**
     * Used to create an invoice for the customer and then send it to an Invoices
     * folder with subfolders for each customer
     * 
     * @param customer
     * @param ticketType
     * @param event
     * @param eventCost
     */
    public static void customerInvoiceCreator(Customer customer, String ticketType, Event event, double eventCost) {
        File invoices = new File("Invoices");
        invoices.mkdir();
        File customerFile = new File(
                "Invoices/" + customer.getCustomerLastName() + "_" + customer.getCustomerFirstName());
        customerFile.mkdir();
        try {
            customer.setInvoices(customer.getInvoices() + 1);
            PrintWriter invoice = new PrintWriter(
                    "Invoices/" + customer.getCustomerLastName() + "_" + customer.getCustomerFirstName()
                            + "/Invoice " + customer.getInvoices() + ".txt",
                    "UTF-8");

            invoice.println("Invoice " + customer.getInvoices() + ": ");
            invoice.println(TicketMaker.getTicketsPending().size() + " tickets purchased");
            invoice.println("Cost: " + df.format(eventCost * TicketMaker.getTicketsPending().size()));
            invoice.println("Confirmation Number: " + event.getEventID() + ticketType.substring(0, 2).toUpperCase()
                    + customer.getCustomerFirstName().substring(0, 2).toUpperCase()
                    + customer.getCustomerLastName().substring(0, 2).toUpperCase()
                    + (customer.isCustomerMembership() ? "IM" : "NM")
                    + TicketMaker.getTicketsPending().size());
            invoice.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, unable to find the file.");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Sorry, there is an error with the encoding.");
        }
    }

    // Getters and Setters
    /**
     * 
     * @return The customer's name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 
     * @return The confirmation number for the invoice
     */
    public String getConfirmationNum() {
        return confirmationNum;
    }

    /**
     * 
     * @param confirmationNum
     */
    public void setConfirmationNum(String confirmationNum) {
        this.confirmationNum = confirmationNum;
    }

    /**
     * 
     * @return The tickets purchased
     */
    public int getTicketsPurchased() {
        return ticketsPurchased;
    }

    /**
     * 
     * @param ticketsPurchased
     */
    public void setTicketsPurchased(int ticketsPurchased) {
        this.ticketsPurchased = ticketsPurchased;
    }

    /**
     * 
     * @return The total price for the invoice
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * 
     * @param totalPrice
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
