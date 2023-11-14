
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The VenueCreator.java file is used to create Venues for the venue hashmap from the arrayList made by the CSVReader.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;

public class VenueCreator {
    /**
     * Creates an instance of VenueCreator
     * 
     * @param none
     */
    VenueCreator() {

    }

    /**
     * Creates the venues based off the arrayList made by the CSVReader
     * 
     * @param eventList
     * @throws InputMismatchException
     */
    public void createVenues(ArrayList<String> eventList) throws InputMismatchException {
        for (int i = 1; i < eventList.size(); i++) {
            String[] splitList = eventList.get(i).split(",");
            String fireworksPlanned = "No";
            int fireworksCost = 0;

            try {
                if (splitList.length == 22) {
                    fireworksPlanned = splitList[21];
                } else if (splitList.length == 23) {
                    fireworksPlanned = splitList[21];
                    fireworksCost = Integer.parseInt(splitList[22]);
                }

                switch (splitList[12]) {
                    case "Arena":
                        Arena.getArenaMap().put(Integer.parseInt(splitList[0]),
                                new Arena(Integer.parseInt(splitList[0]), splitList[10],
                                        Integer.parseInt(splitList[11]),
                                        splitList[12], Integer.parseInt(splitList[13]), Integer.parseInt(splitList[14]),
                                        Integer.parseInt(splitList[15]), Integer.parseInt(splitList[16]),
                                        Integer.parseInt(splitList[17]), Integer.parseInt(splitList[18]),
                                        Integer.parseInt(splitList[19]), Integer.parseInt(splitList[20]),
                                        fireworksPlanned, fireworksCost));
                        Venue.getVenueList().add(Arena.getArenaMap().get(i));
                        break;

                    case "Auditorium":
                        Auditorium.getAuditoriumMap().put(Integer.parseInt(splitList[0]),
                                new Auditorium(Integer.parseInt(splitList[0]), splitList[10],
                                        Integer.parseInt(splitList[11]), splitList[12],
                                        Integer.parseInt(splitList[13]), Integer.parseInt(splitList[14]),
                                        Integer.parseInt(splitList[15]), Integer.parseInt(splitList[16]),
                                        Integer.parseInt(splitList[17]), Integer.parseInt(splitList[18]),
                                        Integer.parseInt(splitList[19]), Integer.parseInt(splitList[20]),
                                        fireworksPlanned, fireworksCost));
                        Venue.getVenueList().add(Auditorium.getAuditoriumMap().get(i));
                        break;

                    case "Open Air":
                        OpenAir.getOpenAirMap().put(Integer.parseInt(splitList[0]),
                                new OpenAir(Integer.parseInt(splitList[0]), splitList[10],
                                        Integer.parseInt(splitList[11]),
                                        splitList[12], Integer.parseInt(splitList[13]), Integer.parseInt(splitList[14]),
                                        Integer.parseInt(splitList[15]), Integer.parseInt(splitList[16]),
                                        Integer.parseInt(splitList[17]), Integer.parseInt(splitList[18]),
                                        Integer.parseInt(splitList[19]), Integer.parseInt(splitList[20]),
                                        fireworksPlanned, fireworksCost));
                        Venue.getVenueList().add(OpenAir.getOpenAirMap().get(i));
                        break;

                    case "Stadium":
                        Stadium.getStadiumMap().put(Integer.parseInt(splitList[0]),
                                new Stadium(Integer.parseInt(splitList[0]), splitList[10],
                                        Integer.parseInt(splitList[11]),
                                        splitList[12], Integer.parseInt(splitList[13]), Integer.parseInt(splitList[14]),
                                        Integer.parseInt(splitList[15]), Integer.parseInt(splitList[16]),
                                        Integer.parseInt(splitList[17]), Integer.parseInt(splitList[18]),
                                        Integer.parseInt(splitList[19]), Integer.parseInt(splitList[20]),
                                        fireworksPlanned, fireworksCost));
                        Venue.getVenueList().add(Stadium.getStadiumMap().get(i));
                        break;

                    default:
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid type trying to be parsed.");
            }
        }
    }
}
