
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The SeatMaker.java file is used to create the seats for each event and track them.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.util.*;

public class SeatMaker {
        /**
         * Creates seats based off of stats provided in the eventList.csv file
         * 
         * @param ticketsWithMaximumStock
         * @param ticketsAvailable
         */
        public static void createSeats(HashMap<Integer, List<Integer>> ticketsWithMaximumStock,
                        HashMap<Integer, List<Integer>> ticketsAvailable) {
                for (int i = 0; i < Event.getEventList().size(); i++) {
                        int unavailableSeats = (Venue.getVenueList().get(i).getPctSeatsUnavailable()
                                        * Venue.getVenueList().get(i).getVenueCapacity()) / 100;

                        int vipSeats = ((Venue.getVenueList().get(i).getVenueCapacity() - unavailableSeats)
                                        * (Venue.getVenueList().get(i).getVipPct()) / 100);
                        int goldSeats = ((Venue.getVenueList().get(i).getVenueCapacity() - unavailableSeats)
                                        * (Venue.getVenueList().get(i).getGoldPct()) / 100);
                        int silverSeats = ((Venue.getVenueList().get(i).getVenueCapacity() - unavailableSeats)
                                        * (Venue.getVenueList().get(i).getSilverPct()) / 100);
                        int bronzeSeats = ((Venue.getVenueList().get(i).getVenueCapacity() - unavailableSeats)
                                        * (Venue.getVenueList().get(i).getBronzePct()) / 100);
                        int generalSeats = ((Venue.getVenueList().get(i).getVenueCapacity() - unavailableSeats)
                                        * (Venue.getVenueList().get(i).getGeneralPct()) / 100);
                        int reservedSeats = ((Venue.getVenueList().get(i).getVenueCapacity() - unavailableSeats)
                                        * (Venue.getVenueList().get(i).getReservedExtraPct()) / 100);

                        ticketsWithMaximumStock.put(i + 1,
                                        Arrays.asList(vipSeats, goldSeats, silverSeats, bronzeSeats, generalSeats,
                                                        reservedSeats));

                        ticketsAvailable.put(i + 1,
                                        Arrays.asList(vipSeats, goldSeats, silverSeats, bronzeSeats, generalSeats,
                                                        reservedSeats));
                }

        }
}
