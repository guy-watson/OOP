package cycling;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Race.java</h1>
 * 
 * Race is an object class that contains the constructor, attributes, methods, getters and setters for the race object. 
 *<p>
 *	
 *	
 *<p>
 * 
 *
 */
 
public class Race {
	// Attributes

    private String name; // name of the race
    private String description; // description of the race
    private int raceId;	// unique id of the race
    private int numberOfStages; // number of stages in the race
    private double totalLength; // total length of all stages in the race
    //private Stage[] stageArray = new Stage[1000];
    private List<Stage> raceStageList = new ArrayList<>(); //List containing all of the stages in the race object
    //raceStageArrayList is an array that contains stages for each individual race object
    //private final ArrayList<Stage> raceStageArrayList;
    private static int count = 0; // count allows each rider to have an incrementing id
    
    // Constructor 
    
    /**
     * <h1>Race constructor</h1>
     * Race constructor creates a race object. It assigns the race with an 
     * incremented raceId using the count attribute/variable. The race object contains stage objects,
     * these in turn contain segments.
     * 
     * @param name The name of the race
     * @param description The description of the race
     */
    Race(String name, String description) {
        // Needs testing
        // Need to add race to race array list
        this.name = name;
        this.description = description;
        count++;
        raceId = count; 
    }

    // Getters
    
    /**
     * Gets the race name
     * @return name A string representing the name of the race
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the description of the race
     * @return description A string representing the description of the race
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Gets the raceId 
     * @return raceId An integer representing the raceId of the race
     */
    public int getRaceId() {
        return raceId;
    }
    
    /**
     * Gets the number of stages in the race
     * @return numberOfStages An integer representing the number of stages within the race
     */
    public int getNumberOfStagesInRace() {
        return numberOfStages;
    }
    
    /**
     * Gets the total length of all stages in a race
     * @return totalLength An integer that is the sum of all the stage lengths in the race
     */
    public double getTotalLength() {
        return totalLength;
    }
    
    /**
     * Gets the list of race stages
     * @return raceStageList A list that contains all of the stages within the race
     */
    public List<Stage> getRaceStageList() {
    	return raceStageList;
    }

    // Setters 
    
    /**
     * Sets name of the race  
     * @param name A string representing the name of the race
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Sets the description of the race
     * @param description A string representing the description of the race
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Sets the raceId of the race
     * @param raceId An integer representing the raceId of the race
     */
    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }
    
    /**
     * Sets the number of stages of the race
     * @param numberOfStages An integer representing the number of stages within the race
     */
    public void setNumberOfStages(int numberOfStages) {
        this.numberOfStages = numberOfStages;
    }
    
    /**
     * Sets the race stage list
     * @param raceStageList A list that contains all of the stages within the race
     */
    public void setRaceStageList(List<Stage> raceStageList) {
    	this.raceStageList = raceStageList;
    }

}
