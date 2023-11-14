
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The AdminMenuMethod.java file is used to traverse through the menu options for the administrator.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminMenuMethods {

    /**
     * These are the attributes for AdminMenuMethods
     */
    static Scanner scan = new Scanner(System.in);
    static boolean isUsing = true;

    /**
     * @param none This method is used to access the information the admin can see
     *             about the events
     */
    public static void accessEventInfo() {
        boolean choosingEventAccess = true;

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("A. Inquire event by ID\nB. Inquire event by name\nC. Exit");
        while (choosingEventAccess) {
            try {
                char logInMethod = scan.next(".").charAt(0);
                switch (Character.toUpperCase(logInMethod)) {
                    case 'A':
                        scan.nextLine();
                        choosingEventAccess = false;
                        accessByID();
                        break;
                    case 'B':
                        scan.nextLine();
                        choosingEventAccess = false;
                        accessByName();
                        break;
                    case 'C':
                        scan.nextLine();
                        choosingEventAccess = false;
                        isUsing = false;
                        break;
                    default:
                        System.out
                                .println("Invalid choice, please choose 'A' for event by ID or 'B' for event by name.");
                        scan.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice, please choose 'A' for event by ID or 'B' for event by name.");
                scan.nextLine();
            }
        }
    }

    /**
     * @param none This method allows for the admin to access the event information
     *             based off of the event's ID number
     */
    public static void accessByID() {
        boolean accessingByID = true;

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("What is the ID of the event?");
        while (accessingByID) {
            try {
                int eventIDChoice = scan.nextInt();
                scan.nextLine();
                if (eventIDChoice > 0 && eventIDChoice <= Event.getEventList().size()) {
                    accessingByID = false;
                    AdminEventInfo.printInfoByID(eventIDChoice);
                    scan.nextLine();
                } else {
                    System.out.println(
                            "\"Invalid choice, please enter a valid number between 1 and "
                                    + Event.getEventList().size() + ".");
                    scan.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice, please enter a valid number between 1 and "
                        + Event.getEventList().size() + ".");
                scan.nextLine();
            }
        }
    }

    /**
     * @param none This method allows for the admin to access the event information
     *             based off of the event's name
     */
    public static void accessByName() {
        boolean accessingByName = true;

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("What is the name of the event?");
        while (accessingByName) {
            try {
                String eventNameChoice = scan.nextLine().toLowerCase();
                if (AdminEventInfo.eventNameExists(eventNameChoice)) {
                    accessingByName = false;
                    AdminEventInfo.printInfoByName(eventNameChoice);
                    scan.nextLine();
                } else {
                    System.out.println("Invalid choice, please enter a valid event name.");
                    scan.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice, please enter a valid event name.");
                scan.nextLine();
            }
        }
    }

}
