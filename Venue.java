
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The Venue.java file is used to create Venue objects.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.util.ArrayList;

public abstract class Venue {
    /**
     * These are the attributes
     */
    private int eventID;
    private String venueName;
    private int pctSeatsUnavailable;
    private String venueType;
    private int venueCapacity;
    private int venueCost;
    private int vipPct;
    private int goldPct;
    private int silverPct;
    private int bronzePct;
    private int generalPct;
    private int reservedExtraPct;
    private String fireworksPlanned;
    private int fireworksCost;

    private static ArrayList<Venue> venueList = new ArrayList<>();

    /**
     * This creates an empty instance of Venue
     * 
     * @param none
     */
    public Venue() {

    }

    /**
     * This creates a filled instance of Venue
     * 
     * @param eventID
     * @param venueName
     * @param pctSeatsUnavailable
     * @param venueType
     * @param venueCapacity
     * @param venueCost
     * @param vipPct
     * @param goldPct
     * @param silverPct
     * @param bronzePct
     * @param generalPct
     * @param reservedExtraPct
     * @param fireworksPlanned
     * @param fireworksCost
     */
    public Venue(int eventID, String venueName, int pctSeatsUnavailable, String venueType, int venueCapacity,
            int venueCost, int vipPct,
            int goldPct, int silverPct, int bronzePct, int generalPct, int reservedExtraPct, String fireworksPlanned,
            int fireworksCost) {
        this.eventID = eventID;
        this.venueName = venueName;
        this.pctSeatsUnavailable = pctSeatsUnavailable;
        this.venueType = venueType;
        this.venueCapacity = venueCapacity;
        this.venueCost = venueCost;
        this.vipPct = vipPct;
        this.goldPct = goldPct;
        this.silverPct = silverPct;
        this.bronzePct = bronzePct;
        this.generalPct = generalPct;
        this.reservedExtraPct = reservedExtraPct;
        this.fireworksPlanned = fireworksPlanned;
        this.fireworksCost = fireworksCost;
    }

    /**
     * 
     * @param index
     * @return A string that is formatted to be used to write the eventList.csv file
     */
    public static String csvFormatting(int index) {
        return (venueList.get(index).getVenueName() + "," + venueList.get(index).getPctSeatsUnavailable() + ","
                + venueList.get(index).getVenueType() + "," + venueList.get(index).getVenueCapacity() + ","
                + venueList.get(index).getVenueCost() + "," + venueList.get(index).getVipPct() + ","
                + venueList.get(index).getGoldPct() + "," + venueList.get(index).getSilverPct() + ","
                + venueList.get(index).getBronzePct() + "," + venueList.get(index).getGeneralPct() + ","
                + venueList.get(index).getReservedExtraPct() + "," + venueList.get(index).getFireworksPlanned() + ","
                + venueList.get(index).getFireworksCost());
    }

    /**
     * 
     * @return
     */
    public int getEventID() {
        return eventID;
    }

    /**
     * 
     * @return
     */
    public String getVenueName() {
        return venueName;
    }

    /**
     * 
     * @param venueName
     */
    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    /**
     * 
     * @return
     */
    public int getPctSeatsUnavailable() {
        return pctSeatsUnavailable;
    }

    /**
     * 
     * @param pctSeatsUnavailable
     */
    public void setPctSeatsUnavailable(int pctSeatsUnavailable) {
        this.pctSeatsUnavailable = pctSeatsUnavailable;
    }

    /**
     * 
     * @return
     */
    public String getVenueType() {
        return venueType;
    }

    /**
     * 
     * @param venueType
     */
    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }

    /**
     * 
     * @return
     */
    public int getVenueCapacity() {
        return venueCapacity;
    }

    /**
     * 
     * @param venueCapacity
     */
    public void setVenueCapacity(int venueCapacity) {
        this.venueCapacity = venueCapacity;
    }

    /**
     * 
     * @return
     */
    public int getVenueCost() {
        return venueCost;
    }

    /**
     * 
     * @param venueCost
     */
    public void setVenueCost(int venueCost) {
        this.venueCost = venueCost;
    }

    /**
     * 
     * @return
     */
    public int getVipPct() {
        return vipPct;
    }

    /**
     * 
     * @param vipPct
     */
    public void setVipPct(int vipPct) {
        this.vipPct = vipPct;
    }

    /**
     * 
     * @return
     */
    public int getGoldPct() {
        return goldPct;
    }

    /**
     * 
     * @param goldPct
     */
    public void setGoldPct(int goldPct) {
        this.goldPct = goldPct;
    }

    /**
     * 
     * @return
     */
    public int getSilverPct() {
        return silverPct;
    }

    /**
     * 
     * @param silverPct
     */
    public void setSilverPct(int silverPct) {
        this.silverPct = silverPct;
    }

    /**
     * 
     * @return
     */
    public int getBronzePct() {
        return bronzePct;
    }

    /**
     * 
     * @param bronzePct
     */
    public void setBronzePct(int bronzePct) {
        this.bronzePct = bronzePct;
    }

    /**
     * 
     * @return
     */
    public int getGeneralPct() {
        return generalPct;
    }

    /**
     * 
     * @param generalPct
     */
    public void setGeneralPct(int generalPct) {
        this.generalPct = generalPct;
    }

    /**
     * 
     * @return
     */
    public int getReservedExtraPct() {
        return reservedExtraPct;
    }

    /**
     * 
     * @param reservedExtraPct
     */
    public void setReservedExtraPct(int reservedExtraPct) {
        this.reservedExtraPct = reservedExtraPct;
    }

    /**
     * 
     * @return
     */
    public String getFireworksPlanned() {
        return fireworksPlanned;
    }

    /**
     * 
     * @param fireworksPlanned
     */
    public void setFireworksPlanned(String fireworksPlanned) {
        this.fireworksPlanned = fireworksPlanned;
    }

    /**
     * 
     * @return
     */
    public int getFireworksCost() {
        return fireworksCost;
    }

    /**
     * 
     * @param fireworksCost
     */
    public void setFireworksCost(int fireworksCost) {
        this.fireworksCost = fireworksCost;
    }

    /**
     * 
     * @return
     */
    public static ArrayList<Venue> getVenueList() {
        return venueList;
    }

    /**
     * 
     * @param venueList
     */
    public static void setVenueList(ArrayList<Venue> venueList) {
        Venue.venueList = venueList;
    }
}
