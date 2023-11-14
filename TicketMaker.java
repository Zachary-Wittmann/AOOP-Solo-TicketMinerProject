
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 *          CS 3331
 *          Dr. Mejia
 *          Programming Assignment 1
 *          Description: The TicketMaker.java file is used for helping to create
 *          the appropriate amount of tickets for the availability of each
 *          event.
 *          Honesty Statement: All code written in this file was done by Zachary
 *          Wittmann
 *          without any help from outside sources apart from the instructor and
 *          his assistants.
 */

import java.util.*;

public class TicketMaker {

    /**
     * These are the attributes of TicketMaker
     */
    private static HashMap<Integer, List<Integer>> ticketsWithMaximumStock = new HashMap<Integer, List<Integer>>();
    private static HashMap<Integer, List<Integer>> ticketsAvailable = new HashMap<Integer, List<Integer>>();

    private static int vipTicketNum;
    private static int goldTicketNum;
    private static int silverTicketNum;
    private static int bronzeTicketNum;
    private static int generalTicketNum;

    private static ArrayList<Ticket> ticketsPending = new ArrayList<>();

    /**
     * Used to generate the number for the tickets based off of event and type of
     * ticket
     * 
     * @param event
     * @param ticketType
     * @return The number for the ticket provided by the event and ticketType
     */
    public static int ticketNumGenerator(Event event, String ticketType) {

        switch (ticketType) {
            case "General Admission":
                generalTicketNum = ticketsWithMaximumStock.get(event.getEventID()).get(4)
                        - ticketsAvailable.get(event.getEventID()).get(4) + 1;
                ticketsAvailable.get(event.getEventID()).set(4,
                        TicketMaker.getTicketsAvailable().get(event.getEventID()).get(4) - 1);
                return getGeneralTicketNum();
            case "Bronze":
                bronzeTicketNum = ticketsWithMaximumStock.get(event.getEventID()).get(3)
                        - ticketsAvailable.get(event.getEventID()).get(3) + 1;
                ticketsAvailable.get(event.getEventID()).set(3,
                        TicketMaker.getTicketsAvailable().get(event.getEventID()).get(3) - 1);
                return getBronzeTicketNum();
            case "Silver":
                silverTicketNum = ticketsWithMaximumStock.get(event.getEventID()).get(2)
                        - ticketsAvailable.get(event.getEventID()).get(2) + 1;
                ticketsAvailable.get(event.getEventID()).set(2,
                        TicketMaker.getTicketsAvailable().get(event.getEventID()).get(2) - 1);
                return getSilverTicketNum();
            case "Gold":
                goldTicketNum = ticketsWithMaximumStock.get(event.getEventID()).get(1)
                        - ticketsAvailable.get(event.getEventID()).get(1) + 1;
                ticketsAvailable.get(event.getEventID()).set(1,
                        TicketMaker.getTicketsAvailable().get(event.getEventID()).get(1) - 1);
                return getGoldTicketNum();
            case "VIP":
                vipTicketNum = ticketsWithMaximumStock.get(event.getEventID()).get(0)
                        - ticketsAvailable.get(event.getEventID()).get(0) + 1;
                ticketsAvailable.get(event.getEventID()).set(0,
                        TicketMaker.getTicketsAvailable().get(event.getEventID()).get(0) - 1);
                return getVipTicketNum();
            default:
        }
        return 0;
    }

    // Getters and Setters
    /**
     * 
     * @return
     */
    public static int getGeneralTicketNum() {
        return generalTicketNum;
    }

    /**
     * 
     * @param generalTicketNum
     */
    public static void setGeneralTicketNum(int generalTicketNum) {
        TicketMaker.generalTicketNum = generalTicketNum;
    }

    /**
     * 
     * @return
     */
    public static int getBronzeTicketNum() {
        return bronzeTicketNum;
    }

    /**
     * 
     * @param bronzeTicketNum
     */
    public static void setBronzeTicketNum(int bronzeTicketNum) {
        TicketMaker.bronzeTicketNum = bronzeTicketNum;
    }

    /**
     * 
     * @return
     */
    public static int getSilverTicketNum() {
        return silverTicketNum;
    }

    /**
     * 
     * @param silverTicketNum
     */
    public static void setSilverTicketNum(int silverTicketNum) {
        TicketMaker.silverTicketNum = silverTicketNum;
    }

    /**
     * 
     * @return
     */
    public static int getGoldTicketNum() {
        return goldTicketNum;
    }

    /**
     * 
     * @param goldTicketNum
     */
    public static void setGoldTicketNum(int goldTicketNum) {
        TicketMaker.goldTicketNum = goldTicketNum;
    }

    /**
     * 
     * @return
     */
    public static int getVipTicketNum() {
        return vipTicketNum;
    }

    /**
     * 
     * @param vipTicketNum
     */
    public static void setVipTicketNum(int vipTicketNum) {
        TicketMaker.vipTicketNum = vipTicketNum;
    }

    /**
     * 
     * @return
     */
    public static ArrayList<Ticket> getTicketsPending() {
        return ticketsPending;
    }

    /**
     * 
     * @param ticketsPending
     */
    public static void setTicketsPending(ArrayList<Ticket> ticketsPending) {
        TicketMaker.ticketsPending = ticketsPending;
    }

    /**
     * 
     * @return
     */
    public static HashMap<Integer, List<Integer>> getTicketsWithMaximumStock() {
        return ticketsWithMaximumStock;
    }

    /**
     * 
     * @param ticketsWithMaximumStock
     */
    public static void setTicketsWithMaximumStock(HashMap<Integer, List<Integer>> ticketsWithMaximumStock) {
        TicketMaker.ticketsWithMaximumStock = ticketsWithMaximumStock;
    }

    /**
     * 
     * @return
     */
    public static HashMap<Integer, List<Integer>> getTicketsAvailable() {
        return ticketsAvailable;
    }

    /**
     * 
     * @param ticketsAvailable
     */
    public static void setTicketsAvailable(HashMap<Integer, List<Integer>> ticketsAvailable) {
        TicketMaker.ticketsAvailable = ticketsAvailable;
    }

}
