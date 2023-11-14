
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The Concert.java file is used to create Concert objects that will be used to populate the Event arrayList.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.util.*;

public class Concert extends Event {

    private static HashMap<Integer, Concert> concertMap = new HashMap<Integer, Concert>();

    /**
     * Creates an empty instance of the Concert object
     * 
     * @param none
     */
    public Concert() {

    }

    /**
     * Creates a filled instance of the Concert object
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
    public Concert(int eventID, String eventType, String eventName, String eventDate, String eventTime, double vipPrice,
            double goldPrice, double silverPrice, double bronzePrice, double generalPrice) {
        super(eventID, eventType, eventName, eventDate, eventTime, vipPrice, goldPrice, silverPrice, bronzePrice,
                generalPrice);
    }

    /**
     * 
     * @return A hashmap of the Concerts, with the eventID as the key
     */
    public static HashMap<Integer, Concert> getConcertMap() {
        return concertMap;
    }

    /**
     * Sets the information in the hashmap of Concerts
     * 
     * @param concertMap
     */
    public static void setConcertMap(HashMap<Integer, Concert> concertMap) {
        Concert.concertMap = concertMap;
    }

}
