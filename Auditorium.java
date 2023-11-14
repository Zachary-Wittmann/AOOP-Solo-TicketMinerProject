
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The Auditorium.java file is used to create Auditorium objects that will be used to populate the Venue arrayList.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.util.HashMap;

public class Auditorium extends Venue {

    private static HashMap<Integer, Auditorium> auditoriumMap = new HashMap<Integer, Auditorium>();

    /**
     * Creates an empty instance of the Auditorium object
     * 
     * @param none
     */
    Auditorium() {

    }

    /**
     * Creates a filled instance of the Auditorium object
     * 
     * @param eventID
     * @param venueName
     * @param pctSeatsUnavailable
     * @param venueType
     * @param venueCapacity
     * @param venueCost
     * @param vipPct
     * @param goldPct
     * @param silverPct
     * @param bronzePct
     * @param generalPct
     * @param reservedExtraPct
     * @param fireworksPlanned
     * @param fireworksCost
     */
    public Auditorium(int eventID, String venueName, int pctSeatsUnavailable, String venueType, int venueCapacity,
            int venueCost,
            int vipPct,
            int goldPct, int silverPct, int bronzePct, int generalPct, int reservedExtraPct, String fireworksPlanned,
            int fireworksCost) {
        super(eventID, venueName, pctSeatsUnavailable, venueType, venueCapacity, venueCost, vipPct, goldPct, silverPct,
                bronzePct, generalPct, reservedExtraPct, fireworksPlanned, fireworksCost);
    }

    /**
     * 
     * @return A hashmap of the Auditoriums, with the eventID as the key
     */
    public static HashMap<Integer, Auditorium> getAuditoriumMap() {
        return auditoriumMap;
    }

    /**
     * Sets the information in the hashmap of Auditoriums
     * 
     * @param auditoriumMap
     */
    public static void setAuditoriumMap(HashMap<Integer, Auditorium> auditoriumMap) {
        Auditorium.auditoriumMap = auditoriumMap;
    }
}
