
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The OpenAir.java file is used to create OpenAir objects that will be used to populate the Venue arrayList.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.util.HashMap;

public class OpenAir extends Venue {

    private static HashMap<Integer, OpenAir> openAirMap = new HashMap<Integer, OpenAir>();

    /**
     * Creates an empty instance of the OpenAir object
     * 
     * @param none
     */
    OpenAir() {

    }

    /**
     * Creates a filled instance of the OpenAir object
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
    public OpenAir(int eventID, String venueName, int pctSeatsUnavailable, String venueType, int venueCapacity,
            int venueCost,
            int vipPct,
            int goldPct, int silverPct, int bronzePct, int generalPct, int reservedExtraPct, String fireworksPlanned,
            int fireworksCost) {
        super(eventID, venueName, pctSeatsUnavailable, venueType, venueCapacity, venueCost, vipPct, goldPct, silverPct,
                bronzePct, generalPct, reservedExtraPct, fireworksPlanned, fireworksCost);
    }

    /**
     * 
     * @return A hashmap of the OpenAir objects, with the eventID as the key
     */
    public static HashMap<Integer, OpenAir> getOpenAirMap() {
        return openAirMap;
    }

    /**
     * Sets the information in the hashmap of OpenAir objects
     * 
     * @param openAirMap
     */
    public static void setOpenAirMap(HashMap<Integer, OpenAir> openAirMap) {
        OpenAir.openAirMap = openAirMap;
    }
}
