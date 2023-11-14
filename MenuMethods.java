
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The MenuMethods.java file is used to traverse through the different menus created for the program.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuMethods {
    /**
     * These are the attributes for MenuMethods
     */
    static Scanner scan = new Scanner(System.in);
    static boolean isUsing = true;
    static Customer customerLoggedIn = null;
    static int menuChoice = -1;
    public static DecimalFormat df = new DecimalFormat("$0.00");

    /**
     * 
     * @return Whether the user is an admin or just a customer
     */
    public static boolean adminMode() {
        boolean choosingAdminMode = true;

        System.out.println("Are you a customer or admin?\n1. Customer\n2. Admin");
        while (choosingAdminMode) {
            try {
                int logInMethod = scan.nextInt();
                switch (logInMethod) {
                    case 1:
                        scan.nextLine();
                        choosingAdminMode = false;
                        return false;
                    case 2:
                        scan.nextLine();
                        choosingAdminMode = false;
                        return true;
                    default:
                        System.out.println("Invalid choice, please choose 1 for Customer or 2 for Admin.");
                        scan.next();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice, please choose 1 for Customer or 2 for Admin.");
                scan.next();
            }
        }
        return false;
    }

    /**
     * 
     * @return How the user chose to log in (True for username/False for first and
     *         last name)
     */
    public static boolean chooseLogIn() {
        boolean choosingLogIn = true;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("How would you like to log in to TicketMiner?\n1. Username\n2. First and Last name");
        while (choosingLogIn) {
            try {
                int logInMethod = scan.nextInt();
                switch (logInMethod) {
                    case 1:
                        scan.nextLine();
                        choosingLogIn = false;
                        return true;
                    case 2:
                        scan.nextLine();
                        choosingLogIn = false;
                        return false;
                    default:
                        System.out
                                .println("Invalid choice, please choose 1 for Username or 2 for First and Last name.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice, please choose 1 for Username or 2 for First and Last name.");
                scan.next();
            }
        }
        return false;
    }

    /**
     * 
     * @param hasAccount
     */
    public static void logIn(boolean hasAccount) {
        boolean loggingIn = true;

        System.out.print("\033[H\033[2J");
        System.out.flush();
        if (hasAccount) {
            System.out.println("Please enter your login information(case-sensitivity is on)\n");
            while (loggingIn) {
                System.out.print("Username: ");
                String userName = scan.nextLine();
                System.out.print("Password: ");
                String password = scan.nextLine();

                customerLoggedIn = Customer.loggedInPassword(userName, password);

                if (customerLoggedIn != null) {
                    loggingIn = false;
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Login information not recognized, please try again (case-sensitivity is on)");
                }
            }
        } else {
            System.out.println("Please enter your first and last name");
            while (loggingIn) {
                System.out.print("First Name: ");
                String firstName = scan.nextLine().toLowerCase();
                System.out.print("Last Name: ");
                String lastName = scan.nextLine().toLowerCase();

                customerLoggedIn = Customer.loggedInName(firstName, lastName);

                if (customerLoggedIn != null) {
                    loggingIn = false;
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Name not recognized, please try again");
                }
            }
        }
    }

    /**
     * This method allows for the user to interact with the main menu and choose
     * which event they want to look at for ticket purchasing
     * 
     * @param none
     */
    public static void mainMenu() {
        boolean inMainMenu = true;

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(
                "Hello " + customerLoggedIn.getCustomerFirstName() + "!\n"
                        + "Welcome to Ticket Miner! Please select an option by typing it exactly as it appears:\nSports\nConcerts\nFestivals\nMyTickets\nEXIT");
        String mainChoice = scan.nextLine().toLowerCase();

        while (inMainMenu) {
            switch (mainChoice) {
                case "sports":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("You have selected Sports");
                    inMainMenu = false;
                    viewEventMenu("sports");
                    break;

                case "concerts":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("You have selected Concerts");
                    inMainMenu = false;
                    viewEventMenu("concerts");
                    break;

                case "festivals":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("You have selected Festivals");
                    inMainMenu = false;
                    viewEventMenu("festivals");
                    break;

                case "mytickets":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("You have selected MyTickets");
                    inMainMenu = false;
                    customerLoggedIn.printTicketsOwned();
                    System.out.println("\nPlease press enter and then enter your next choice");
                    scan.nextLine();
                    break;

                case "exit":
                    System.out.println("You have selected to exit the program");
                    inMainMenu = false;
                    isUsing = false;
                    break;

                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Invalid input, please type your choice exactly as it appears.\n");
                    System.out.println(
                            "Please select an option by typing it exactly as it appears:\nSports\nConcerts\nFestivals\nMyTickets\nEXIT");
                    mainChoice = scan.nextLine().toLowerCase();
                    break;
            }
        }
        eventPurchasingMenu(menuChoice - 1);
    }

    /**
     * This method allows for you to view the list of events based off of your
     * choice at the main menu
     * 
     * @param mainChoice
     */
    public static void viewEventMenu(String mainChoice) {
        boolean viewingEventTickets = true;

        // Remove the 's' from the end so that it can be used easier
        mainChoice = mainChoice.substring(0, mainChoice.length() - 1);

        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < Event.getEventList().size(); i++) {
            if (Event.getEventList().get(i).getEventType().toLowerCase().equals(mainChoice)) {
                System.out.println(Event.getEventList().get(i).getEventID() + ". " +
                        Event.getEventList().get(i).getEventName() + "\nTickets Available: " +
                        (Venue.getVenueList().get(i).getVenueCapacity()
                                - ((Venue.getVenueList().get(i).getPctSeatsUnavailable()
                                        * Venue.getVenueList().get(i).getVenueCapacity()) / 100)
                                - TicketMaker.getTicketsWithMaximumStock().get(i + 1).get(5)));

                System.out.println();
            }
        }

        // Ensures only choices of event ids within range shown can be picked (i.e.
        // choice < 45 for sport)
        while (viewingEventTickets) {
            System.out.print("Please enter the event number you are interested in: ");
            try {
                int eventTicketChoice = scan.nextInt();
                scan.nextLine();
                switch (mainChoice) {
                    case "sport":
                        if (Sport.getSportMap().keySet().contains(eventTicketChoice)) {
                            menuChoice = eventTicketChoice;
                            viewingEventTickets = false;
                            break;
                        } else {
                            System.out.println("Please choose a valid choice.");
                            break;
                        }

                    case "concert":
                        if (Concert.getConcertMap().keySet().contains(eventTicketChoice)) {
                            menuChoice = eventTicketChoice;
                            viewingEventTickets = false;
                            break;
                        } else {
                            System.out.println("Please choose a valid choice.");
                            break;
                        }

                    case "festival":
                        if (Festival.getFestivalMap().keySet().contains(eventTicketChoice)) {
                            menuChoice = eventTicketChoice;
                            viewingEventTickets = false;
                            break;
                        } else {
                            System.out.println("Please choose a valid choice.");
                            break;
                        }
                    default:
                }
            } catch (InputMismatchException e) {
                System.out.println("Please choose a valid choice.");
                scan.next();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please choose a valid choice.");
                scan.next();
            }
        }
    }

    /**
     * Based off the choice made for which event you wanted to view, takes you to
     * this menu to purchase tickets and choose the type of ticket alongside the
     * quantity
     * 
     * @param eventIDChosen
     */
    public static void eventPurchasingMenu(int eventIDChosen) {
        boolean inPurchasingMenu = true;
        boolean selectingTicketType = true;
        boolean purchasingTickets = true;
        String ticketTypeString = "";
        int ticketsOfTypeLeft = 0;
        double ticketTypeCost = 0.0;

        System.out.print("\033[H\033[2J");
        System.out.flush();

        try {
            FileWriter logger = new FileWriter("Log.txt", true);
            PrintWriter loggerPrint = new PrintWriter(logger);
            if (eventIDChosen >= 0) {
                while (inPurchasingMenu) {

                    System.out.println(Event.getEventList().get(eventIDChosen).getEventName());
                    System.out.println("\n1. General Admission Ticket: "
                            + df.format(Event.getEventList().get(eventIDChosen).getGeneralPrice())
                            + "\nSeats Available: " + TicketMaker.getTicketsAvailable().get(eventIDChosen + 1).get(4));
                    System.out
                            .println("\n2. Bronze Ticket: "
                                    + df.format(Event.getEventList().get(eventIDChosen).getBronzePrice())
                                    + "\nSeats Available: "
                                    + TicketMaker.getTicketsAvailable().get(eventIDChosen + 1).get(3));
                    System.out
                            .println("\n3. Silver Ticket: "
                                    + df.format(Event.getEventList().get(eventIDChosen).getSilverPrice())
                                    + "\nSeats Available: "
                                    + TicketMaker.getTicketsAvailable().get(eventIDChosen + 1).get(2));
                    System.out
                            .println("\n4. Gold Ticket: "
                                    + df.format(Event.getEventList().get(eventIDChosen).getGoldPrice())
                                    + "\nSeats Available: "
                                    + TicketMaker.getTicketsAvailable().get(eventIDChosen + 1).get(1));
                    System.out.println(
                            "\n5. VIP Ticket: " + df.format(Event.getEventList().get(eventIDChosen).getVipPrice())
                                    + "\nSeats Available: "
                                    + TicketMaker.getTicketsAvailable().get(eventIDChosen + 1).get(0));
                    System.out.println("\nYour Money: " + df.format(customerLoggedIn.getCustomerMoneyAvailable()));
                    System.out.print("Please enter your choice: ");

                    try {
                        while (selectingTicketType) {
                            int ticketTypeInt = scan.nextInt();
                            scan.nextLine();

                            switch (ticketTypeInt) {
                                case 1:
                                    ticketTypeString = "General Admission";
                                    selectingTicketType = false;
                                    ticketsOfTypeLeft = TicketMaker.getTicketsAvailable().get(eventIDChosen + 1).get(4);
                                    ticketTypeCost = Event.getEventList().get(eventIDChosen).getGeneralPrice();
                                    break;
                                case 2:
                                    ticketTypeString = "Bronze";
                                    selectingTicketType = false;
                                    ticketsOfTypeLeft = TicketMaker.getTicketsAvailable().get(eventIDChosen + 1).get(3);
                                    ticketTypeCost = Event.getEventList().get(eventIDChosen).getBronzePrice();
                                    break;
                                case 3:
                                    ticketTypeString = "Silver";
                                    selectingTicketType = false;
                                    ticketsOfTypeLeft = TicketMaker.getTicketsAvailable().get(eventIDChosen + 1).get(2);
                                    ticketTypeCost = Event.getEventList().get(eventIDChosen).getSilverPrice();
                                    break;
                                case 4:
                                    ticketTypeString = "Gold";
                                    selectingTicketType = false;
                                    ticketsOfTypeLeft = TicketMaker.getTicketsAvailable().get(eventIDChosen + 1).get(1);
                                    ticketTypeCost = Event.getEventList().get(eventIDChosen).getGoldPrice();
                                    break;
                                case 5:
                                    ticketTypeString = "VIP";
                                    selectingTicketType = false;
                                    ticketsOfTypeLeft = TicketMaker.getTicketsAvailable().get(eventIDChosen + 1).get(0);
                                    ticketTypeCost = Event.getEventList().get(eventIDChosen).getVipPrice();
                                    break;
                                default:
                                    System.out.println("Please select a valid option.");
                                    break;
                            }
                        }

                        while (purchasingTickets) {
                            try {
                                System.out.println("How many tickets would you like? (Maximum of 6 tickets)");
                                int numOfTickets = scan.nextInt();
                                scan.nextLine();
                                if (numOfTickets <= 6 && customerLoggedIn.getCustomerMoneyAvailable() >= ticketTypeCost
                                        * numOfTickets && ticketsOfTypeLeft >= numOfTickets) {
                                    Purchase.queueTicketPurchase(customerLoggedIn,
                                            Event.getEventList().get(eventIDChosen),
                                            Venue.getVenueList().get(eventIDChosen),
                                            ticketTypeString, numOfTickets);
                                    purchasingTickets = false;
                                    inPurchasingMenu = false;
                                    loggerPrint.write(customerLoggedIn.getCustomerFirstName() + " "
                                            + customerLoggedIn.getCustomerLastName()
                                            + " purchased " + numOfTickets + " " + ticketTypeString + " tickets.\n");
                                    System.out.println(
                                            "Thank you for your purchase! Check the invoices folder for your invoice.");
                                    scan.nextLine();
                                    break;
                                } else if (numOfTickets > 6 || ticketsOfTypeLeft >= numOfTickets) {
                                    System.out.println("You are attempting to buy too many tickets.");
                                    scan.nextLine();
                                } else if (ticketTypeCost * numOfTickets > customerLoggedIn
                                        .getCustomerMoneyAvailable()) {
                                    System.out.println(
                                            "You do not have enough money for these tickets.\nRedirecting to the menu.");
                                    scan.nextLine();
                                    purchasingTickets = false;
                                    inPurchasingMenu = false;
                                }

                            } catch (InputMismatchException e) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Please choose a valid number of tickets.");
                                scan.next();

                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Please choose a valid number of tickets.");
                                scan.next();
                            }
                        }

                    } catch (InputMismatchException e) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Please choose a valid choice.");
                        scan.next();

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Please choose a valid choice.");
                        scan.next();
                    }
                }
                menuChoice = -1;
            }
            loggerPrint.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, unable to find the file.");
        } catch (IOException e) {
            System.out.println("Sorry, and IOException has occurred.");
        }
    }

}