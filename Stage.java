package cycling;

public class Stage {
// Attributes
    private String stageName;
    private String description;
    private int length;
    private int raceId;
    private int startTime;
    private StageType type;
    // private Double location;
    
    // Getters

    public String getStageName() {
        return stageName;
    }

    public String getDescription() {
        return description;
    }

    public int getLength() {
        return length;
    }

    public int getRaceId() {
        return raceId;
    }

    public int getStartTime() {
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

    public void setLength(int length) {
        this.length = length;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setType(StageType type) {
        this.type = type;
    }
}
