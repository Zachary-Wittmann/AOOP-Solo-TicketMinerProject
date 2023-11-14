
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 *        CS 3331
 *        Dr. Mejia
 *        Programming Assignment 2
 *        Description: The RunTicket.java file is used to run and execute the
 *        rest of the code provided.
 *        Honesty Statement: All code written in this file was done by Zachary
 *        Wittmann
 *        without any help from outside sources apart from the instructor and
 *        his assistants.
 */

public class RunTicket {
    /**
     * This is the main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        CSVHandler.readCSV();
        SeatMaker.createSeats(TicketMaker.getTicketsWithMaximumStock(), TicketMaker.getTicketsAvailable());
        EventAnalyticsMaker.createAnalytics();

        boolean inAdminMode = MenuMethods.adminMode();

        if (!inAdminMode) {

            MenuMethods.logIn(MenuMethods.chooseLogIn());

            while (MenuMethods.isUsing) {
                MenuMethods.mainMenu();

                // Ending use of program
                if (!MenuMethods.isUsing) {
                    System.out.println("Please come again!");
                }
            }

            CSVHandler.writeCSV();

        } else {

            while (AdminMenuMethods.isUsing) {

                AdminMenuMethods.accessEventInfo();

                // Ending use of program
                if (!AdminMenuMethods.isUsing) {
                    System.out.println("Thank for using!");
                }
            }
        }
    }
}
