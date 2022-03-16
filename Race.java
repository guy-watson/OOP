package cycling;

import java.util.ArrayList;
// We need to create an array of raceIds
// Each time a new race is created a unique race id will be generated and we need to add this to the array
// The array will start off as an arraylist so the size can be changed and then turned back into an array so it can be called from the portal
// ArrayList<String> cars = new ArrayList<String>();
public class Race {

    private String name;
    private String description;
    private int raceId;
    private int numberOfStages;
    private static int count = 0;
    
    Race(String name, String description, int numberOfStages) {
        this.name = name;
        if (name.length() >= 30 || name.isEmpty() || name.trim().isEmpty() || name == null || name.contains(" ")); {
            throw InvalidNameException;
		}
        this.description = description;
        this.numberOfStages = numberOfStages;
        count++;
        raceId = count; 
        raceArrayList.add(this);
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

    public int getNumberOfStages() {
        return numberOfStages;
    }

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

    // Methods

}
