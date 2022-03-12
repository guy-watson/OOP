package cycling;

public class stageSegment {

    private int segmentId;
    private SegmentType type;
    private double averageGradient;
    private double length;

    public int getSegmentId() {
        return segmentId;
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
}
