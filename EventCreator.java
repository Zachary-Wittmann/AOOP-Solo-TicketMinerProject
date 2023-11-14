
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The EventCreator.java file is used to create Events for the event hashmap from the arrayList made by the CSVReader.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;

public class EventCreator {
    /**
     * Creates an instance of the EventCreator
     * 
     * @param none
     */
    EventCreator() {

    }

    /**
     * Creates the events based off the arrayList made by the CSVReader
     * 
     * @param eventList
     * @throws InputMismatchException
     */
    public void createEvents(ArrayList<String> eventList) throws InputMismatchException {
        for (int i = 1; i < eventList.size(); i++) {
            String[] splitList = eventList.get(i).split(",");

            try {
                switch (splitList[1]) {
                    case "Concert":
                        Concert.getConcertMap().put(Integer.parseInt(splitList[0]),
                                new Concert(Integer.parseInt(splitList[0]), splitList[1], splitList[2], splitList[3],
                                        splitList[4], Double.parseDouble(splitList[5]),
                                        Double.parseDouble(splitList[6]),
                                        Double.parseDouble(splitList[7]), Double.parseDouble(splitList[8]),
                                        Double.parseDouble(splitList[9])));
                        Event.getEventList().add(Concert.getConcertMap().get(i));
                        break;

                    case "Festival":
                        Festival.getFestivalMap().put(Integer.parseInt(splitList[0]),
                                new Festival(Integer.parseInt(splitList[0]), splitList[1], splitList[2], splitList[3],
                                        splitList[4], Double.parseDouble(splitList[5]),
                                        Double.parseDouble(splitList[6]),
                                        Double.parseDouble(splitList[7]), Double.parseDouble(splitList[8]),
                                        Double.parseDouble(splitList[9])));
                        Event.getEventList().add(Festival.getFestivalMap().get(i));
                        break;

                    case "Sport":
                        Sport.getSportMap().put(Integer.parseInt(splitList[0]),
                                new Sport(Integer.parseInt(splitList[0]), splitList[1], splitList[2], splitList[3],
                                        splitList[4], Double.parseDouble(splitList[5]),
                                        Double.parseDouble(splitList[6]),
                                        Double.parseDouble(splitList[7]), Double.parseDouble(splitList[8]),
                                        Double.parseDouble(splitList[9])));
                        Event.getEventList().add(Sport.getSportMap().get(i));
                        break;

                    default:
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid type trying to be parsed.");
            }
        }
    }
}
