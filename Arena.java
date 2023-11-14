
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The Arena.java file is used to create Arena objects that will be used to populate the Venue arrayList.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.util.HashMap;

public class Arena extends Venue {

    private static HashMap<Integer, Arena> arenaMap = new HashMap<Integer, Arena>();

    /**
     * Creates an empty instance of the Arena object
     * 
     * @param none
     */
    public Arena() {

    }

    /**
     * Creates a filled instance of the Arena object
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
    public Arena(int eventID, String venueName, int pctSeatsUnavailable, String venueType, int venueCapacity,
            int venueCost,
            int vipPct,
            int goldPct, int silverPct, int bronzePct, int generalPct, int reservedExtraPct, String fireworksPlanned,
            int fireworksCost) {
        super(eventID, venueName, pctSeatsUnavailable, venueType, venueCapacity, venueCost, vipPct, goldPct, silverPct,
                bronzePct, generalPct, reservedExtraPct, fireworksPlanned, fireworksCost);
    }

    /**
     * 
     * @return A hashmap of the Arenas, with the eventID as the key
     */
    public static HashMap<Integer, Arena> getArenaMap() {
        return arenaMap;
    }

    /**
     * Sets the information in the hashmap of Arenas
     * 
     * @param arenaMap
     */
    public static void setArenaMap(HashMap<Integer, Arena> arenaMap) {
        Arena.arenaMap = arenaMap;
    }

}
