package cycling;

public class Race {

    private String name;
    private String description;
    private int raceId;
    private int numberOfStages;
    private static int count = 0;
    
    Race(String name, String description, int numberOfStages) {
        
        this.name = name;
        if (name.length() >= 30 || name.length() == 0); {
            throw InvalidNameException;
		}
		 
        
        this.description = description;
        this.numberOfStages = numberOfStages;
        count++;
        raceId = count;
    }

}


