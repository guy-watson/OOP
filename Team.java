package cycling;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Team is a public class that holds the team object information.<h1>
 * 
 * 
 * <p>
 * Team contains each teamId, name, description and a list of the riders with the team.
 * The team object contains the rider objects. The class contains a constructor that creates
 * team objects as well as getters, setters and methods for the object attributes
 * <p>
 *
 */

public class Team {
    // Attributes 

    private int teamId; // the unique id of the team
    private String name; // name of the team
    private String description; // description of the team
    static int count = 0;
    private List < Rider > teamRidersList = new ArrayList < > (); // array list of all riders within the team

    // Constructor 

    /**
     * <h1>Team Constructor</h1>
     * Team constructor creates a team object. It assigns the team with an Id using the count attribute/variable.
     * @param name The name of the team
     * @param description The description of the team
     * @throws InvalidNameException Thrown when attempting to assign a race name null, empty or having more than
     * the system limit of characters. A name must be a single word
     * @throws IllegalNameException Thrown when attempting to assign a race name already in use in the system
     */
    public Team(String name, String description) {

        this.name = name;
        this.description = description;
        count++;
        teamId = count;

    }

    // Getters

    /**
     * Gets the teamId
     * @return An integer representing the unique id of the team
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * Gets the name of the team
     * @return string representing the name of the team
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the team
     * @return string representing the description of the team
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets an array list that contains the riders in the team
     * @return An array list containing the riders in the team 
     */
    public List < Rider > getTeamRidersList() {
        return teamRidersList;
    }

    // Setters 

    /**
     * Sets the teamId
     * @param An integer that represents the id of the team
     */
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    /**
     * Sets the name of the team
     * @param A string representing the name of the team
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the description of the team
     * @param A string representing the description of the team
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets team riders list 
     * @param A list that contains all of the riders within the team
     */
    public void setTeamRidersList(List < Rider > teamRidersList) {
        this.teamRidersList = teamRidersList;
    }
}
