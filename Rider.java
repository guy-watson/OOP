package Cycling;

import java.util.ArrayList;

public class Rider {
    // Attributes
    // add points attribute

    private String name;
    private int yearOfBirth;
    private int riderId;
    private int teamId;
    private static int count = 0;

    Rider(int teamId, String name, int yearOfBirth) {
        this.teamId = teamId;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        count++;
        this.riderId = count;

        
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
