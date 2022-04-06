package cycling;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Race is a public class that holds the race object information. </h1>
 * 
 *
 *<p>
 *Race contains the name, description, raceId, number of stages, total length of the stages in the race and also every 
 *stage object within the race. The class contains a constructor to create race objects as well as getters, setters and 
 *methods for the objects attribute. 	
 *<p>
 * 
 *
 */

public class Race {
    // Attributes

    private String name; // name of the race
    private String description; // description of the race
    private int raceId; // unique id of the race
    private int numberOfStages; // number of stages in the race
    private double totalLength; // total length of all stages in the race
    private List < Stage > raceStageList = new ArrayList < > (); //List containing all of the stages in the race object
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
    public Race(String name, String description) {
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
     * @return A string representing the name of the race
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the race
     * @return A string representing the description of the race
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the raceId 
     * @return An integer representing the raceId of the race
     */
    public int getRaceId() {
        return raceId;
    }

    /**
     * Gets the number of stages in the race
     * @return An integer representing the number of stages within the race
     */
    public int getNumberOfStagesInRace() {
        return numberOfStages;
    }

    /**
     * Gets the total length of all stages in a race
     * @return A double that is the sum of all the stage lengths in the race
     */
    public double getTotalLength() {
        return totalLength;
    }

    /**
     * Gets the list of race stages
     * @return A list that contains all of the stages within the race
     */
    public List < Stage > getRaceStageList() {
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
    public void setRaceStageList(List < Stage > raceStageList) {
        this.raceStageList = raceStageList;
    }

	/**
     * Sets the total length
     * @param totalLength A double that is the sum of all the stage lengths in the race
     */
	public void setTotalLength(double totalLength) {
        this.totalLength = totalLength;
    }
}
