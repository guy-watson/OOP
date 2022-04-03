package cycling;

/**
 * <h1>StageSegment is a public class that holds segment object information</h1>
 * 
 * 
 * <p>
 * StageSegment contains the segmentId, the type of segment, the average gradient and the 
 * length of the segment. StageSegment objects are contained in the stage object. The class contains a constructor that 
 * creates the segment object, as well as getters, setters and methods for the object attributes.
 * <p>
 * 
 * 
 */

public class StageSegment {
    // Attributes

    private int stageId; //
    private int segmentId; // the unique id of the segment
    private SegmentType type; // defines the type of segment, SPRINT, C1-C4 or HC
    private double averageGradient; // the average gradient of the stage
    private double length; // total length of the segment in kilometres
    private double location;
    private static int count = 0;

    public StageSegment(int stageId, Double location, SegmentType type, Double averageGradient, Double length) {
        this.stageId = stageId;
        this.location = location;
        this.type = type;
        this.averageGradient = averageGradient;
        this.length = length;
        count++;
        this.segmentId = count;
    }

    public StageSegment(int stageId, Double location, SegmentType type) {
        this.stageId = stageId;
        this.location = location;
        this.type = type;
    }

    // Getters

    /**
     * Gets the stageId of the stage that contains the segment
     * @return an integer representing the stageId
     */
    public int getStageId() {
        return stageId;
    }
    /**
     * Gets the segmentId
     * @return An integer representing the segment id
     */
    public int getSegmentId() {
        return segmentId;
    }

    /**
     * Gets the type of segment
     * @return enum is used to represent the segment types within stages 
     */
    public SegmentType getType() {
        return type;
    }

    /**
     * Gets the average gradient 
     * @return A double that represents the gradient of the segment
     */
    public double getAverageGradient() {
        return averageGradient;
    }

    /**
     * Gets the length of the segment 
     * @return A double that represents the length of the segment
     */
    public double getLength() {
        return length;
    }

    public double getLocation() {
        return location;
    }

    // Setters 

    /**
     * Sets the segmentId
     * @param segmentId An integer that represents the id of the segment
     */
    public void setSegmentId(int segmentId) {
        this.segmentId = segmentId;
    }

    /**
     * Sets the segment type
     * @param type enum is used to represent the segment types within stages 
     */
    public void setType(SegmentType type) {
        this.type = type;
    }

    /**
     * Sets the average gradient
     * @param averageGradient A double that represents the average gradient of a segment
     */
    public void setAverageGradient(double averageGradient) {
        this.averageGradient = averageGradient;
    }

    /**
     * Sets the length of the segment 
     * @param length A double that represents the total length of a segment
     */
    public void setLength(double length) {
        this.length = length;
    }

    public void setLocation(double location) {
        this.location = location;
    }

}
