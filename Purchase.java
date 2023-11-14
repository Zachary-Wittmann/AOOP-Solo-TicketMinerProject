import java.util.ArrayList;

public class Purchase {

    /**
     * Creates a queue of tickets that the customer is purchasing to later run
     * through the purchaseTicket method
     * 
     * @param customer
     * @param event
     * @param ticketType
     * @param numOfTickets
     */
    public static void queueTicketPurchase(Customer customer, Event event, Venue venue, String ticketType,
            int numOfTickets) {
        int ticketsOfTypeLeft = 0;
        double ticketTypeCost = 0.0;

        switch (ticketType) {
            case "General Admission":
                ticketTypeCost = event.getGeneralPrice();
                ticketsOfTypeLeft = TicketMaker.getTicketsAvailable().get(event.getEventID() + 1).get(4);
                break;
            case "Bronze":
                ticketTypeCost = event.getBronzePrice();
                ticketsOfTypeLeft = TicketMaker.getTicketsAvailable().get(event.getEventID() + 1).get(3);
                break;
            case "Silver":
                ticketTypeCost = event.getSilverPrice();
                ticketsOfTypeLeft = TicketMaker.getTicketsAvailable().get(event.getEventID() + 1).get(2);
                break;
            case "Gold":
                ticketTypeCost = event.getGoldPrice();
                ticketsOfTypeLeft = TicketMaker.getTicketsAvailable().get(event.getEventID() + 1).get(1);
                break;
            case "VIP":
                ticketTypeCost = event.getVipPrice();
                ticketsOfTypeLeft = TicketMaker.getTicketsAvailable().get(event.getEventID() + 1).get(0);
                break;
            default:
        }

        if ((customer.getCustomerMoneyAvailable() * numOfTickets >= ticketTypeCost * numOfTickets) && numOfTickets <= 6
                && ticketsOfTypeLeft >= numOfTickets) {

            customer.setCustomerMoneyAvailable(customer.getCustomerMoneyAvailable() - ticketTypeCost * numOfTickets);
            for (int i = 0; i < numOfTickets; i++) {
                Ticket ticketIn = new Ticket(TicketMaker.ticketNumGenerator(event, ticketType), event.getEventID(),
                        event.getEventName(), venue.getVenueName(),
                        ticketType, ticketTypeCost, event.getEventDate(), event.getEventTime());
                if (event.getEventType().toLowerCase().equals("concert")) {
                    customer.setCustomerConcertsPurchased(customer.getCustomerConcertsPurchased() + 1);
                }
                TicketMaker.getTicketsPending().add(ticketIn);
            }
            Invoice.customerInvoiceCreator(customer, ticketType, event, ticketTypeCost);
            purchaseTicket(customer, TicketMaker.getTicketsPending());

            // Edit this
            EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).setTotalSeatsSold(
                    EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).getTotalSeatsSold()
                            + numOfTickets);
            EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1)
                    .setActualProfit(ticketTypeCost * numOfTickets);
            EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1)
                    .setActualProfit(EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).getActualProfit()
                            - Venue.getVenueList().get(event.getEventID() - 1).getVenueCost()
                            - Venue.getVenueList().get(event.getEventID() - 1).getFireworksCost());

            EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).setTotalRevenueAllTickets(EventAnalytics
                    .getEventAnalyticsMap().get(event.getEventID() - 1).getTotalGeneralTicketsRevenue()
                    + EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).getTotalBronzeTicketsRevenue()
                    + EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).getTotalSilverTicketsRevenue()
                    + EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).getTotalGoldTicketsRevenue()
                    + EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).getTotalVipTicketsRevenue());

            switch (ticketType) {
                case "General Admission":
                    EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).setTotalGeneralSeatsSold(
                            EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).getTotalGeneralSeatsSold()
                                    + numOfTickets);
                    EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).setTotalGeneralTicketsRevenue(
                            EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).getTotalGeneralSeatsSold()
                                    * ticketTypeCost);
                    break;
                case "Bronze":
                    EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).setTotalBronzeSeatsSold(
                            EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).getTotalBronzeSeatsSold()
                                    + numOfTickets);
                    EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).setTotalBronzeTicketsRevenue(
                            EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).getTotalBronzeSeatsSold()
                                    * ticketTypeCost);
                    break;
                case "Silver":
                    EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).setTotalSilverSeatsSold(
                            EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).getTotalSilverSeatsSold()
                                    + numOfTickets);
                    EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).setTotalSilverTicketsRevenue(
                            EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).getTotalSilverSeatsSold()
                                    * ticketTypeCost);
                    break;
                case "Gold":
                    EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).setTotalGoldSeatsSold(
                            EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).getTotalGoldSeatsSold()
                                    + numOfTickets);
                    EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).setTotalGoldTicketsRevenue(
                            EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).getTotalGoldSeatsSold()
                                    * ticketTypeCost);
                    break;
                case "VIP":
                    EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).setTotalVipSeatsSold(
                            EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).getTotalVipSeatsSold()
                                    + numOfTickets);
                    EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).setTotalVipTicketsRevenue(
                            EventAnalytics.getEventAnalyticsMap().get(event.getEventID() - 1).getTotalVipSeatsSold()
                                    * ticketTypeCost);
                    break;
                default:
            }

            Customer.updateCustomerList(CSVHandler.getCustomerList(), customer.getCustomerID());

            Event.updateEventList(CSVHandler.getEventList(), event.getEventID());

        } else if (customer.getCustomerMoneyAvailable() < ticketTypeCost) {
            System.out.println("Insufficient funds for this transaction. Redirecting to menu.");
        }

    }

    /**
     * Used to purchase the tickets from the queueTicketPurchase method before
     * clearing the queue
     * 
     * @param customer
     * @param ticketsPending
     */
    public static void purchaseTicket(Customer customer, ArrayList<Ticket> ticketsPending) {
        for (int i = 0; i < ticketsPending.size(); i++) {
            customer.updateTicketsOwned(ticketsPending.get(i));
        }
        ticketsPending.clear();
    }
}
