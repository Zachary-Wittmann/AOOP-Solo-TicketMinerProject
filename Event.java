
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The Event.java file is used to create Event objects.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.util.*;

public abstract class Event {
    /**
     * These are the attributes
     */
    private int eventID;
    private String eventType;
    private String eventName;
    private String eventDate;
    private String eventTime;
    private double vipPrice;
    private double goldPrice;
    private double silverPrice;
    private double bronzePrice;
    private double generalPrice;

    private static ArrayList<Event> eventList = new ArrayList<>();
    private static HashMap<Integer, ArrayList<Ticket>> purchasedTicketsWithID = new HashMap<>();

    /**
     * This creates an empty instance of Event
     * 
     * @param none
     */
    public Event() {

    }

    /**
     * This creates a filled instance of Event
     * 
     * @param eventID
     * @param eventType
     * @param eventName
     * @param eventDate
     * @param eventTime
     * @param vipPrice
     * @param goldPrice
     * @param silverPrice
     * @param bronzePrice
     * @param generalPrice
     */
    public Event(int eventID, String eventType, String eventName, String eventDate, String eventTime, double vipPrice,
            double goldPrice, double silverPrice, double bronzePrice, double generalPrice) {
        this.eventID = eventID;
        this.eventType = eventType;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.vipPrice = vipPrice;
        this.goldPrice = goldPrice;
        this.silverPrice = silverPrice;
        this.bronzePrice = bronzePrice;
        this.generalPrice = generalPrice;
    }

    /**
     * This updates the event list by adding in a new event to the arrayList
     * 
     * @param eventList
     * @param index
     */
    public static void updateEventList(ArrayList<String> eventList, int index) {
        eventList.set(index + 1, csvFormatting(index));
    }

    /**
     * 
     * @param index
     * @return A string that is formatted to be used to write the eventList.csv file
     */
    public static String csvFormatting(int index) {
        return (eventList.get(index).getEventID() + "," + eventList.get(index).getEventType() + ","
                + eventList.get(index).getEventName() + "," + eventList.get(index).getEventDate() + ","
                + eventList.get(index).getEventTime() + "," + eventList.get(index).getVipPrice() + ","
                + eventList.get(index).getGoldPrice() + "," + eventList.get(index).getSilverPrice() + ","
                + eventList.get(index).getBronzePrice() + "," + eventList.get(index).getGeneralPrice() + ","
                + Venue.csvFormatting(index));
    }

    /**
     * Updates the list of tickets that were purchased for each event
     * 
     * @param ticketIn
     */
    public static void updatePurchasedTickets(Ticket ticketIn) {
        purchasedTicketsWithID.computeIfAbsent(ticketIn.getEventID(), k -> new ArrayList<Ticket>()).add(ticketIn);
    }

    /**
     * 
     * @return
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
     * @return
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * 
     * @param eventType
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * 
     * @return
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
     * @return
     */
    public String getEventDate() {
        return eventDate;
    }

    /**
     * 
     * @param eventDate
     */
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * 
     * @return
     */
    public String getEventTime() {
        return eventTime;
    }

    /**
     * 
     * @param eventTime
     */
    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    /**
     * 
     * @return
     */
    public double getVipPrice() {
        return vipPrice;
    }

    /**
     * 
     * @param vipPrice
     */
    public void setVipPrice(double vipPrice) {
        this.vipPrice = vipPrice;
    }

    /**
     * 
     * @return
     */
    public double getGoldPrice() {
        return goldPrice;
    }

    /**
     * 
     * @param goldPrice
     */
    public void setGoldPrice(double goldPrice) {
        this.goldPrice = goldPrice;
    }

    /**
     * 
     * @return
     */
    public double getSilverPrice() {
        return silverPrice;
    }

    /**
     * 
     * @param silverPrice
     */
    public void setSilverPrice(double silverPrice) {
        this.silverPrice = silverPrice;
    }

    /**
     * 
     * @return
     */
    public double getBronzePrice() {
        return bronzePrice;
    }

    /**
     * 
     * @param bronzePrice
     */
    public void setBronzePrice(double bronzePrice) {
        this.bronzePrice = bronzePrice;
    }

    /**
     * 
     * @return
     */
    public double getGeneralPrice() {
        return generalPrice;
    }

    /**
     * 
     * @param generalPrice
     */
    public void setGeneralPrice(double generalPrice) {
        this.generalPrice = generalPrice;
    }

    /**
     * 
     * @return
     */
    public static ArrayList<Event> getEventList() {
        return eventList;
    }

    /**
     * 
     * @param eventList
     */
    public static void setEventList(ArrayList<Event> eventList) {
        Event.eventList = eventList;
    }

    /**
     * 
     * @return
     */
    public static HashMap<Integer, ArrayList<Ticket>> getPurchasedTicketsWithID() {
        return purchasedTicketsWithID;
    }

    /**
     * 
     * @param purchasedTicketsWithID
     */
    public static void setPurchasedTicketsWithID(HashMap<Integer, ArrayList<Ticket>> purchasedTicketsWithID) {
        Event.purchasedTicketsWithID = purchasedTicketsWithID;
    }

}
