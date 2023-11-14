
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 *        CS 3331
 *        Dr. Mejia
 *        Programming Assignment 2
 *        Description: The EventAnalyticsMaker.java file is used to create the
 *        different event analytics for the administrator to view.
 *        Honesty Statement: All code written in this file was done by Zachary
 *        Wittmann
 *        without any help from outside sources apart from the instructor and
 *        his assistants.
 */

public class EventAnalyticsMaker {
        /**
         * Creates analytics for each of the events based off of the seats available and
         * the profits
         * 
         * @param none
         */
        public static void createAnalytics() {
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

                        double expectedProfit = ((vipSeats * Event.getEventList().get(i).getVipPrice())
                                        + (goldSeats * Event.getEventList().get(i).getGoldPrice())
                                        + (silverSeats * Event.getEventList().get(i).getSilverPrice())
                                        + (bronzeSeats * Event.getEventList().get(i).getBronzePrice())
                                        + (generalSeats * Event.getEventList().get(i).getGeneralPrice())
                                        - Venue.getVenueList().get(i).getVenueCost()
                                        - Venue.getVenueList().get(i).getFireworksCost());

                        EventAnalytics.getEventAnalyticsMap().put(i,
                                        new EventAnalytics(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, expectedProfit, 0
                                                        - Venue.getVenueList().get(i).getVenueCost()
                                                        - Venue.getVenueList().get(i).getFireworksCost()));
                }
        }
}
