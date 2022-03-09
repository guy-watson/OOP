package cycling;

public class Race {

    private String stringName;
    private String stringDescription;
    private int raceId;
    private int numberOfStages;
    
    public Race(String stringDescription, int numberOfStages) {
        this.stringName = "Race";
        this.stringDescription = stringDescription;
        this.raceId = 2;
        this.numberOfStages = numberOfStages;
    }

    /** public static void main(String[] args) {
        Race raceyboy = new Race("A cool race", 10);
    }**/

}