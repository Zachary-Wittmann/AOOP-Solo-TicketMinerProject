
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The Stadium.java file is used to create Stadium objects that will be used to populate the Venue arrayList.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.util.HashMap;

public class Stadium extends Venue {

    private static HashMap<Integer, Stadium> stadiumMap = new HashMap<Integer, Stadium>();

    /**
     * Creates an empty instance of the Stadium object
     * 
     * @param none
     */
    Stadium() {

    }

    /**
     * Creates a filled instance of the Stadium object
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
    public Stadium(int eventID, String venueName, int pctSeatsUnavailable, String venueType, int venueCapacity,
            int venueCost,
            int vipPct,
            int goldPct, int silverPct, int bronzePct, int generalPct, int reservedExtraPct, String fireworksPlanned,
            int fireworksCost) {
        super(eventID, venueName, pctSeatsUnavailable, venueType, venueCapacity, venueCost, vipPct, goldPct, silverPct,
                bronzePct, generalPct, reservedExtraPct, fireworksPlanned, fireworksCost);
    }

    /**
     * 
     * @return A hashmap of the Stadiums, with the eventID as the key
     */
    public static HashMap<Integer, Stadium> getStadiumMap() {
        return stadiumMap;
    }

    /**
     * Sets the information in the hashmap of Stadiums
     * 
     * @param stadiumMap
     */
    public static void setStadiumMap(HashMap<Integer, Stadium> stadiumMap) {
        Stadium.stadiumMap = stadiumMap;
    }
}
