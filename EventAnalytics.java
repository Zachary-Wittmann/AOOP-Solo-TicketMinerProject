
/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The EventAnalytics.java file is used to create information on the events for the administrator to see.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */

import java.util.*;

public class EventAnalytics extends Event {
    /**
     * These are the attributes
     */
    private int totalSeatsSold;
    private int totalVipSeatsSold;
    private int totalGoldSeatsSold;
    private int totalSilverSeatsSold;
    private int totalBronzeSeatsSold;
    private int totalGeneralSeatsSold;
    private double totalVipTicketsRevenue;
    private double totalGoldTicketsRevenue;
    private double totalSilverTicketsRevenue;
    private double totalBronzeTicketsRevenue;
    private double totalGeneralTicketsRevenue;
    private double totalRevenueAllTickets;
    private double expectedProfit;
    private double actualProfit;

    private static HashMap<Integer, EventAnalytics> eventAnalyticsMap = new HashMap<Integer, EventAnalytics>();

    /**
     * Creates an empty instance of EventAnalytics
     * 
     * @param none
     */
    EventAnalytics() {

    }

    /**
     * Creates a filled instance of EventAnalytics
     * 
     * @param totalSeatsSold
     * @param totalVipSeatsSold
     * @param totalGoldSeatsSold
     * @param totalSilverSeatsSold
     * @param totalBronzeSeatsSold
     * @param totalGeneralSeatsSold
     * @param totalVipTicketsRevenue
     * @param totalGoldTicketsRevenue
     * @param totalSilverTicketsRevenue
     * @param totalBronzeTicketsRevenue
     * @param totalGeneralTicketsRevenue
     * @param totalRevenueAllTickets
     * @param expectedProfit
     * @param actualProfit
     */
    public EventAnalytics(int totalSeatsSold, int totalVipSeatsSold, int totalGoldSeatsSold, int totalSilverSeatsSold,
            int totalBronzeSeatsSold, int totalGeneralSeatsSold, double totalVipTicketsRevenue,
            double totalGoldTicketsRevenue, double totalSilverTicketsRevenue, double totalBronzeTicketsRevenue,
            double totalGeneralTicketsRevenue, double totalRevenueAllTickets, double expectedProfit,
            double actualProfit) {
        this.totalSeatsSold = totalSeatsSold;
        this.totalVipSeatsSold = totalVipSeatsSold;
        this.totalGoldSeatsSold = totalGoldSeatsSold;
        this.totalSilverSeatsSold = totalSilverSeatsSold;
        this.totalBronzeSeatsSold = totalBronzeSeatsSold;
        this.totalGeneralSeatsSold = totalGeneralSeatsSold;
        this.totalVipTicketsRevenue = totalVipTicketsRevenue;
        this.totalGoldTicketsRevenue = totalGoldTicketsRevenue;
        this.totalSilverTicketsRevenue = totalSilverTicketsRevenue;
        this.totalBronzeTicketsRevenue = totalBronzeTicketsRevenue;
        this.totalGeneralTicketsRevenue = totalGeneralTicketsRevenue;
        this.totalRevenueAllTickets = totalRevenueAllTickets;
        this.expectedProfit = expectedProfit;
        this.actualProfit = actualProfit;
    }

    /**
     * 
     * @return
     */
    public int getTotalSeatsSold() {
        return totalSeatsSold;
    }

    /**
     * 
     * @param totalSeatsSold
     */
    public void setTotalSeatsSold(int totalSeatsSold) {
        this.totalSeatsSold = totalSeatsSold;
    }

    /**
     * 
     * @return
     */
    public int getTotalVipSeatsSold() {
        return totalVipSeatsSold;
    }

    /**
     * 
     * @param totalVipSeatsSold
     */
    public void setTotalVipSeatsSold(int totalVipSeatsSold) {
        this.totalVipSeatsSold = totalVipSeatsSold;
    }

    /**
     * 
     * @return
     */
    public int getTotalGoldSeatsSold() {
        return totalGoldSeatsSold;
    }

    /**
     * 
     * @param totalGoldSeatsSold
     */
    public void setTotalGoldSeatsSold(int totalGoldSeatsSold) {
        this.totalGoldSeatsSold = totalGoldSeatsSold;
    }

    /**
     * 
     * @return
     */
    public int getTotalSilverSeatsSold() {
        return totalSilverSeatsSold;
    }

    /**
     * 
     * @param totalSilverSeatsSold
     */
    public void setTotalSilverSeatsSold(int totalSilverSeatsSold) {
        this.totalSilverSeatsSold = totalSilverSeatsSold;
    }

    /**
     * 
     * @return
     */
    public int getTotalBronzeSeatsSold() {
        return totalBronzeSeatsSold;
    }

    /**
     * 
     * @param totalBronzeSeatsSold
     */
    public void setTotalBronzeSeatsSold(int totalBronzeSeatsSold) {
        this.totalBronzeSeatsSold = totalBronzeSeatsSold;
    }

    /**
     * 
     * @return
     */
    public int getTotalGeneralSeatsSold() {
        return totalGeneralSeatsSold;
    }

    /**
     * 
     * @param totalGeneralSeatsSold
     */
    public void setTotalGeneralSeatsSold(int totalGeneralSeatsSold) {
        this.totalGeneralSeatsSold = totalGeneralSeatsSold;
    }

    /**
     * 
     * @return
     */
    public double getTotalVipTicketsRevenue() {
        return totalVipTicketsRevenue;
    }

    /**
     * 
     * @param totalVipTicketsRevenue
     */
    public void setTotalVipTicketsRevenue(double totalVipTicketsRevenue) {
        this.totalVipTicketsRevenue = totalVipTicketsRevenue;
    }

    /**
     * 
     * @return
     */
    public double getTotalGoldTicketsRevenue() {
        return totalGoldTicketsRevenue;
    }

    /**
     * 
     * @param totalGoldTicketsRevenue
     */
    public void setTotalGoldTicketsRevenue(double totalGoldTicketsRevenue) {
        this.totalGoldTicketsRevenue = totalGoldTicketsRevenue;
    }

    /**
     * 
     * @return
     */
    public double getTotalSilverTicketsRevenue() {
        return totalSilverTicketsRevenue;
    }

    /**
     * 
     * @param totalSilverTicketsRevenue
     */
    public void setTotalSilverTicketsRevenue(double totalSilverTicketsRevenue) {
        this.totalSilverTicketsRevenue = totalSilverTicketsRevenue;
    }

    /**
     * 
     * @return
     */
    public double getTotalBronzeTicketsRevenue() {
        return totalBronzeTicketsRevenue;
    }

    /**
     * 
     * @param totalBronzeTicketsRevenue
     */
    public void setTotalBronzeTicketsRevenue(double totalBronzeTicketsRevenue) {
        this.totalBronzeTicketsRevenue = totalBronzeTicketsRevenue;
    }

    /**
     * 
     * @return
     */
    public double getTotalGeneralTicketsRevenue() {
        return totalGeneralTicketsRevenue;
    }

    /**
     * 
     * @param totalGeneralTicketsRevenue
     */
    public void setTotalGeneralTicketsRevenue(double totalGeneralTicketsRevenue) {
        this.totalGeneralTicketsRevenue = totalGeneralTicketsRevenue;
    }

    /**
     * 
     * @return
     */
    public double getTotalRevenueAllTickets() {
        return totalRevenueAllTickets;
    }

    /**
     * 
     * @param totalRevenueAllTickets
     */
    public void setTotalRevenueAllTickets(double totalRevenueAllTickets) {
        this.totalRevenueAllTickets = totalRevenueAllTickets;
    }

    /**
     * 
     * @return
     */
    public double getExpectedProfit() {
        return expectedProfit;
    }

    /**
     * 
     * @param expectedProfit
     */
    public void setExpectedProfit(double expectedProfit) {
        this.expectedProfit = expectedProfit;
    }

    /**
     * 
     * @return
     */
    public double getActualProfit() {
        return actualProfit;
    }

    /**
     * 
     * @param actualProfit
     */
    public void setActualProfit(double actualProfit) {
        this.actualProfit = actualProfit;
    }

    /**
     * 
     * @return
     */
    public static HashMap<Integer, EventAnalytics> getEventAnalyticsMap() {
        return eventAnalyticsMap;
    }

    /**
     * 
     * @param eventAnalyticsMap
     */
    public static void setEventAnalyticsMap(HashMap<Integer, EventAnalytics> eventAnalyticsMap) {
        EventAnalytics.eventAnalyticsMap = eventAnalyticsMap;
    }

}
