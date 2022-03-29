package cycling;

import java.util.ArrayList;
import java.util.List;
// We need to create an array of raceIds
// Each time a new race is created a unique race id will be generated and we need to add this to the array
// The array will start off as an arraylist so the size can be changed and then turned back into an array so it can be called from the portal
// ArrayList<String> cars = new ArrayList<String>();
public class Race {

    private String name;
    private String description;
    private int raceId;
    private int numberOfStages;
    private double totalLength;
    //private Stage[] stageArray = new Stage[1000];
    private List<Stage> raceStageList = new ArrayList<Stage>();
    private Stage[] raceStageArray = new Stage[1000];
    //raceStageArrayList is an array that contains stages for each individual race object
    //private final ArrayList<Stage> raceStageArrayList;
    private static int count = 0;
    
    Race(String name, String description) {
        // Needs testing
        // Need to add race to race array list
        this.name = name;
        this.description = description;
        count++;
        raceId = count; 
    }

    Race RaceEmpty() {
        count++;
        raceId = count;
        return null;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRaceId() {
        return raceId;
    }

    public int getNumberOfStagesInArray() {
        return numberOfStages;
    }
    
    public double getTotalLength() {
        return totalLength;
    }

    public Stage[] getRaceStageArray() {
    	return raceStageArray;
    }
    
    public List<Stage> getRaceStageList() {
    	return raceStageList;
    }
//    public ArrayList<Stage> getRaceStagesArrayList() {
//        return raceStagesArrayList;
//    }

    // Setters 

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }
    public void setNumberOfStages(int numberOfStages) {
        this.numberOfStages = numberOfStages;
    }
//    public void setRaceStagesArrayList(ArrayList<Stage> raceStagesArrayList) {
//        this.raceStagesArrayList = raceStagesArrayList;
//    }
    
    public void setRaceStagesArray(Stage[] raceStageArray) {
        this.raceStageArray = raceStageArray;
    } 
    
    public void setRaceStageList(List<Stage> raceStageList) {
    	this.raceStageList = raceStageList;
    }
    
    // Methods

//    public void addStage(Stage stage){
//        this.raceStagesArrayList.add(stage);
//    }

    // add stages to

}
