package cycling;

public class Rider {
// Attributes

    private String name;
    private int yearOfBirth;
    private int riderId;
    private int teamId;
    private static int count = 0;

    Rider(String name, int yearOfBirth, int teamId) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.teamId = teamId;
        count++;
        riderId = count;
    }
    
    // Getters 

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getRiderId() {
        return riderId;
    }

    public int getTeamId() {
        return teamId;
    }
    // Setters 

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }

}
