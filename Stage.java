package cycling;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Stage {
// Attributes
    private String stageName;
    private String description;
    private double length;
    private int raceId;
    private int stageId;
    private LocalDateTime startTime;
    private StageType type;
    private static int count = 0;
    private ArrayList<StageSegment> segmentStageList = new ArrayList<StageSegment>();
    private Double location;

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

    public String getStageName() {
        return stageName;
    }

    public String getDescription() {

        return description;
    }
    
    public double getLength() {
        return length;
    }

    public int getRaceId() {
        return raceId;
    }

     public int getStageId() {
        return stageId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public StageType getType() {
        return type;
    } 

    // Setters
    
    public void setStageName(String stageName) {
        this.stageName = stageName;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }
    
     public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setType(StageType type) {
        this.type = type;
    }

	
}
