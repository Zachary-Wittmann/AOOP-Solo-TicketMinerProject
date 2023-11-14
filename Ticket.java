
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The Ticket.java file is used to create Ticket objects.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.text.DecimalFormat;

public class Ticket {
    /**
     * Formats values into a monetary way
     */
    public static DecimalFormat df = new DecimalFormat("$0.00");

    /**
     * These are the attributes for Ticket
     */
    private int ticketNum;
    private int eventID;
    private String eventName;
    private String venueName;
    private String ticketType;
    private double ticketCost;
    private String date;
    private String time;

    // Constructor
    /**
     * @param none
     */
    public Ticket() {

    }

    /**
     * 
     * @param ticketNum
     * @param eventID
     * @param eventName
     * @param venueName
     * @param ticketType
     * @param ticketCost
     * @param date
     * @param time
     */
    public Ticket(int ticketNum, int eventID, String eventName, String venueName, String ticketType, double ticketCost,
            String date,
            String time) {
        this.ticketNum = ticketNum;
        this.eventID = eventID;
        this.eventName = eventName;
        this.venueName = venueName;
        this.ticketType = ticketType;
        this.ticketCost = ticketCost;
        this.date = date;
        this.time = time;
    }

    // Methods
    /**
     * @param none
     *             Prints out info for the ticket
     */
    public void printTicketInfo() {
        System.out.println(
                getTicketType() + " Ticket Number " + getTicketNum() + ":\n" + getEventName() + " at the "
                        + getVenueName() + "\nDate: " + getDate() + " " + getTime() + "\nTicket Cost: ("
                        + df.format(getTicketCost()) + ")");
    }

    // Getters and Setters
    /**
     * 
     * @return The ticket's number
     */
    public int getTicketNum() {
        return ticketNum;
    }

    /**
     * 
     * @param ticketNum
     */
    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    /**
     * 
     * @return The event on the ticket's ID
     */
    public int getEventID() {
        return eventID;
    }

    /**
     * 
     * @param eventID
     */
    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    /**
     * 
     * @return The event on the ticket's name
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * 
     * @param eventName
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * 
     * @return The venue on the ticket's name
     */
    public String getVenueName() {
        return venueName;
    }

    /**
     * 
     * @param venueName
     */
    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    /**
     * 
     * @return The ticket's type for seating
     */
    public String getTicketType() {
        return ticketType;
    }

    /**
     * 
     * @param ticketType
     */
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    /**
     * 
     * @return The cost of the ticket
     */
    public double getTicketCost() {
        return ticketCost;
    }

    /**
     * 
     * @param ticketCost
     */
    public void setTicketCost(double ticketCost) {
        this.ticketCost = ticketCost;
    }

    /**
     * 
     * @return The date of the event on the ticket
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return The time of the event on the ticket
     */
    public String getTime() {
        return time;
    }

    /**
     * 
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }
}
