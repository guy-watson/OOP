package cycling;

public class StageSegment {
// Attributes

    private int segmentId;
    private int stageId;
    private SegmentType type;
    private double averageGradient;
    private double length;
    
    // Getters
    
    public int getSegmentId() {
        return segmentId;
    }
    
    public int getStageId() {
    	return stageId;
    }

    public SegmentType getType() {
        return type;
    }

    public double getAverageGradient() {
        return averageGradient;
    }

    public double getLength() {
        return length;
    }
    
    // Setters 
    
    public void setSegmentId(int segmentId) {
        this.segmentId = segmentId;
    } 
    public void setStageId(int stageId) {
    	this.stageId = stageId;
    }
    public void setType(SegmentType type) {
        this.type = type;
    }
    public void setAverageGradient(double averageGradient) {
        this.averageGradient = averageGradient;
    }
    public void setLength(double length) {
        this.length = length;
    }
    
}
