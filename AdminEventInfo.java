
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The AdminEventInfo.java file is used to receive information about the events.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.text.DecimalFormat;

public class AdminEventInfo {

    /**
     * Formats values into a monetary way
     */
    public static DecimalFormat df = new DecimalFormat("$0.00");

    /**
     * 
     * @param eventName
     * @return Returns true if the eventName provided exists within the list of
     *         events
     */
    public static boolean eventNameExists(String eventName) {
        for (int i = 0; i < Event.getEventList().size(); i++) {
            if (Event.getEventList().get(i).getEventName().toLowerCase().equals(eventName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prints the event's information based off the ID provided
     * @param eventID
     */
    public static void printInfoByID(int eventID) {
        eventID -= 1;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Event ID: " + Event.getEventList().get(eventID).getEventID() + "\n"
                + Event.getEventList().get(eventID).getEventName() + "\n"
                + Event.getEventList().get(eventID).getEventDate() + "\n"
                + Event.getEventList().get(eventID).getEventTime() + "\nEvent Type: "
                + Event.getEventList().get(eventID).getEventType() + "\nEvent Capacity: "
                + Venue.getVenueList().get(eventID).getVenueCapacity() + "\nTotal Seats sold: "
                + EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalSeatsSold() + "\nTotal VIP Seats sold: "
                + EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalVipSeatsSold()
                + "\nTotal Gold Seats sold: "
                + EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalGoldSeatsSold()
                + "\nTotal Silver Seats sold: "
                + EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalSilverSeatsSold()
                + "\nTotal Bronze Seats sold: "
                + EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalBronzeSeatsSold()
                + "\nTotal General Adm Seats sold: "
                + EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalGeneralSeatsSold()
                + "\nTotal revenue for VIP tickets: "
                + df.format(EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalVipTicketsRevenue())
                + "\nTotal revenue for Gold tickets: "
                + df.format(EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalGoldTicketsRevenue())
                + "\nTotal revenue for Silver tickets: "
                + df.format(EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalSilverTicketsRevenue())
                + "\nTotal revenue for Bronze tickets: "
                + df.format(EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalBronzeTicketsRevenue())
                + "\nTotal revenue for General Admission tickets: "
                + df.format(EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalGeneralTicketsRevenue())
                + "\nTotal revenue for all tickets: "
                + df.format(EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalRevenueAllTickets())
                + "\nExpected profit (Sell Out): "
                + df.format(EventAnalytics.getEventAnalyticsMap().get(eventID).getExpectedProfit())
                + "\nActual profit: "
                + df.format(EventAnalytics.getEventAnalyticsMap().get(eventID).getActualProfit()));

    }

    /**
     * Prints the event's information based off the Name provided
     * @param eventName
     */
    public static void printInfoByName(String eventName) {
        int eventID = -1;
        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int i = 0; i < Event.getEventList().size(); i++) {
            if (Event.getEventList().get(i).getEventName().toLowerCase().equals(eventName)) {
                eventID = Event.getEventList().get(i).getEventID() - 1;
            }
        }

        if (eventID != -1) {
            System.out.println("Event ID: " + Event.getEventList().get(eventID).getEventID() + "\n"
                    + Event.getEventList().get(eventID).getEventName() + "\n"
                    + Event.getEventList().get(eventID).getEventDate() + "\n"
                    + Event.getEventList().get(eventID).getEventTime() + "\nEvent Type: "
                    + Event.getEventList().get(eventID).getEventType() + "\nEvent Capacity: "
                    + Venue.getVenueList().get(eventID).getVenueCapacity() + "\nTotal Seats sold: "
                    + EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalSeatsSold()
                    + "\nTotal VIP Seats sold: "
                    + EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalVipSeatsSold()
                    + "\nTotal Gold Seats sold: "
                    + EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalGoldSeatsSold()
                    + "\nTotal Silver Seats sold: "
                    + EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalSilverSeatsSold()
                    + "\nTotal Bronze Seats sold: "
                    + EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalBronzeSeatsSold()
                    + "\nTotal General Adm Seats sold: "
                    + EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalGeneralSeatsSold()
                    + "\nTotal revenue for VIP tickets: "
                    + df.format(EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalVipTicketsRevenue())
                    + "\nTotal revenue for Gold tickets: "
                    + df.format(EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalGoldTicketsRevenue())
                    + "\nTotal revenue for Silver tickets: "
                    + df.format(EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalSilverTicketsRevenue())
                    + "\nTotal revenue for Bronze tickets: "
                    + df.format(EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalBronzeTicketsRevenue())
                    + "\nTotal revenue for General Admission tickets: "
                    + df.format(EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalGeneralTicketsRevenue())
                    + "\nTotal revenue for all tickets: "
                    + df.format(EventAnalytics.getEventAnalyticsMap().get(eventID).getTotalRevenueAllTickets())
                    + "\nExpected profit (Sell Out): "
                    + df.format(EventAnalytics.getEventAnalyticsMap().get(eventID).getExpectedProfit())
                    + "\nActual profit: "
                    + df.format(EventAnalytics.getEventAnalyticsMap().get(eventID).getActualProfit()));
        } else {
            System.out.println("That event does not exist.");
        }
    }
}
