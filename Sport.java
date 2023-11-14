
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The Sport.java file is used to create Sport objects that will be used to populate the Event arrayList.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.util.*;

public class Sport extends Event {

    private static HashMap<Integer, Sport> sportMap = new HashMap<Integer, Sport>();

    /**
     * Creates an empty instance of the Sport object
     * 
     * @param none
     */
    public Sport() {

    }

    /**
     * Creates a filled instance of the Sport object
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
    public Sport(int eventID, String eventType, String eventName, String eventDate, String eventTime, double vipPrice,
            double goldPrice, double silverPrice, double bronzePrice, double generalPrice) {
        super(eventID, eventType, eventName, eventDate, eventTime, vipPrice, goldPrice, silverPrice, bronzePrice,
                generalPrice);
    }

    /**
     * 
     * @return A hashmap of the Sports, with the eventID as the key
     */
    public static HashMap<Integer, Sport> getSportMap() {
        return sportMap;
    }

    /**
     * Sets the information in the hashmap of Sports
     * 
     * @param sportMap
     */
    public static void setSportMap(HashMap<Integer, Sport> sportMap) {
        Sport.sportMap = sportMap;
    }

}
