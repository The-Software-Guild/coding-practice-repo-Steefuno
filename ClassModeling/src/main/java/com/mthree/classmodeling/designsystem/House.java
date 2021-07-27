/*
 * @author Steven Nguyen
 * @email: steven.686295@gmail.com
 * @date: 
 */
package com.mthree.classmodeling.designsystem;

/**
 *
 * @author Steven
 */
public abstract class House {
    final private double plotWidth, plotLength;
    // I'll keep it simple and not make classes for some things that should have classes now
    private int walls;
    private int floors;
    private int ceilings;
    private int doors;
    
    /**
     * Constructs a new House given the width and length of the land plot 
     * @param plotWidth
     * @param plotLength 
     */
    public House(double plotWidth, double plotLength) {
        this.plotWidth = plotWidth;
        this.plotLength = plotLength;
    }
    
    /**
     * Adds a wall to the house
     */
    public abstract void addWall();
    
    /**
     * Removes a wall to the house
     */
    public abstract void removeWall();
    
    /**
     * Adds a floor to the house
     */
    public abstract void addFloor();
    
    /**
     * Removes a floor to the house
     */
    public abstract void removeFloor();
    
    /**
     * Adds a ceiling to the house
     */
    public abstract void addCeiling();
    
    /**
     * Removes a ceiling to the house
     */
    public abstract void removeCeiling();
    
    /**
     * Adds a door to the house
     */
    public abstract void addDoor();
    
    /**
     * Removes a door to the house
     */
    public abstract void removeDoor();
    
    /**
     * Gets the width of this house's plot
     * @return the width of this house's plot
     */
    public abstract double getPlotWidth();
    
    /**
     * Gets the length of this house's plot
     * @return the length of this house's plot
     */
    public abstract double getPlotLength();
    
    /**
     * Gets the number of walls in this house
     * @return the width of this house's plot
     */
    public abstract int getNumWalls();
    
    /**
     * Gets the number of floors in this house
     * @return the width of this house's plot
     */
    public abstract int getNumFloors();
    
    /**
     * Gets the number of ceilings in this house
     * @return the width of this house's plot
     */
    public abstract int getNumDoors();
}
