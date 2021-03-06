package cycling;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *<h1>Stage is a public class that holds the stage object information</h1>
 * 
 *
 *<p>
 * Stage contains the name of the stage, the description, length of the stage, the raceId that the
 * stage belongs to, the unique stageId, the start time of the stage and array list that contains all of
 * the segments within the stage. 
 * 
 * The stage object is contained within the race object.
 *<p>
 * 
 * 
 *
 */

public class Stage {
    // Attributes

    // ** location ?

    private String stageName; // name of the stage
    private String description; // description of the stage
    private double length; // length in kilometres of the stage
    private int raceId; // the raceId that contains this stage
    private int stageId; // unique stageId that is generated within the class
    private LocalDateTime startTime; // Start time of the stage in the format year-month-day-hour-minute-second
    private StageType type; // defines the stage type, FLAT, MEDIUM_MOUNTAIN, HIGH_MOUNTAIN, or TT
    private static int count = 0; // increment for generating the Id of the stage
    private ArrayList < StageSegment > segmentStageList = new ArrayList < > (); // ArrayList containing the segments contained by the stage
    private Boolean stageState;
    private HashMap < Integer, LocalTime[] > stageResultsHashMap = new HashMap < > (); // HashMap containing ids of riders and also a list of their times
    // Constructor

    /**
     * <h1>Stage Constructor</h1>
     * Rider constructor generates a stage that is contained in the race object. It assigns the stage with an incremented stageId
     * using the count attribute/variable. The stage is created with a raceId parameter that assigns the stage to a race object.
     * The stage contains the segment objects. 
     * 
     * @param stageName The name of the stage
     * @param description The description of the stage
     * @param length Length of the stage in kilometres 
     * @param raceId Id of the Race that the stage is assigned to
     * @param startTime Defines the start time of the stage
     * @param type Defines the type of stage
     */
    public Stage(String stageName, String description, double length, int raceId, LocalDateTime startTime, StageType type) {
        // Needs testing
        // Need to add race to race array list
        this.stageName = stageName;
        this.description = description;
        this.length = length;
        this.raceId = raceId;
        this.startTime = startTime;
        this.type = type;
        count++;
        stageId = count;
    }


    // Getters

    /**
     * Gets the stage results hash map.
     *
     * @return hashmap containing the riders and their times
     */
    public HashMap < Integer, LocalTime[] > getStageResultsHashMap() {
        return stageResultsHashMap;
    }
    /**
     * Gets all of the segments contained in the stage
     * @return An array list containing all of the segments
     */
    public ArrayList < StageSegment > getSegmentStageList() {
        return segmentStageList;
    }

    /**
     * Gets the name of the stage 
     * @return A string representing the stage name
     */
    public String getStageName() {
        return stageName;
    }

    /**
     * Gets the description of the stage
     * @return A string representing the description of the stage
     */
    public String getDescription() {

        return description;
    }

    /**
     * Gets the length of the stage
     * @return A double that represents the length of the stage in kilometres
     */
    public double getLength() {
        return length;
    }

    /**
     * Gets the raceId of the race that contains the stage
     * @return An integer that represents the raceId
     */
    public int getRaceId() {
        return raceId;
    }

    /**
     * Gets the stageId 
     * @return An integer that represents the unique stage
     */
    public int getStageId() {
        return stageId;
    }

    /**
     * Gets the start time 
     * @return date time object that represents the start time of the race      
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     * Gets the type of stage
     * @return enum used to represent the stage types on road races
     */
    public StageType getType() {
        return type;
    }
    /**
     * Gets the stage state 
     * @return A boolean that says if the stage is concluded or not
     */
    public Boolean getStageState() {
        return stageState;
    }

    // Setters

    /**
     * Sets the stage results hash map.
     *
     * @param stageResultsHashMap the stage results hash map containing riderIds and their results
     */
    public void setStageResultsHashMap(HashMap < Integer, LocalTime[] > stageResultsHashMap) {
        this.stageResultsHashMap = stageResultsHashMap;
    }

    /**
     * Sets the stage state
     * @param stageState A boolean that says if the stage is concluded or not
     */
    public void setStageState(Boolean stageState) {
        this.stageState = stageState;
    }

    /**
     * sets the stage name
     * @param stageName String representing the name of the stage
     */
    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    /**
     * Sets the description
     * @param description String representing the description of the stage
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the length
     * @param length Double that represents the length of the stage in kilometres
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Sets the raceId
     * @param raceId integer that represents the raceId of the race that contains the stage
     */
    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    /**
     * Sets the stageId
     * @param stageId An integer that represents the stageId 
     */
    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    /**
     * Sets the start time
     * @param startTime date time object that represents the start time of the race      
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /** 
     * Sets the type of stage
     * @param type enum used to represent the stage types on road races
     */
    public void setType(StageType type) {
        this.type = type;
    }

    public void setSegmentStageList(ArrayList < StageSegment > segmentStageList) {
        this.segmentStageList = segmentStageList;
    }


}
