
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The Festival.java file is used to create Festival objects that will be used to populate the Event arrayList.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.util.*;

public class Festival extends Event {

    private static HashMap<Integer, Festival> festivalMap = new HashMap<Integer, Festival>();

    /**
     * Creates an empty instace of the Festival object
     * 
     * @param none
     */
    public Festival() {

    }

    public Festival(int eventID, String eventType, String eventName, String eventDate, String eventTime,
            double vipPrice,
            double goldPrice, double silverPrice, double bronzePrice, double generalPrice) {
        super(eventID, eventType, eventName, eventDate, eventTime, vipPrice, goldPrice, silverPrice, bronzePrice,
                generalPrice);
    }

    public static void sortbyKey() {
        TreeMap<Integer, Festival> sorted = new TreeMap<>(Festival.getFestivalMap());

        for (Map.Entry<Integer, Festival> entry : sorted.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    public static HashMap<Integer, Festival> getFestivalMap() {
        return festivalMap;
    }

    public static void setFestivalMap(HashMap<Integer, Festival> festivalMap) {
        Festival.festivalMap = festivalMap;
    }

}
