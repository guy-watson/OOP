package cycling;

/**
 *<h1>Rider is a public class that holds the rider object information.</h1>
 * 
 * 
 *<p>
 * Rider contains each competitors id, their team id, year of birth.
 * The class contains the constructor that creates the rider object, 
 * as well as getters, setters and methods for the objects attributes. 
 *<p>
 * 
 * 
 *
 */

public class Rider {
    // Attributes

    private String name; // name of the rider
    private int yearOfBirth; // year the rider was born
    private int riderId; // the unique id of the rider generated within the constructor
    private int teamId; // the unique id of the team that the rider is assigned to
    private static int count = 0; // count allows each rider to have an incrementing id

    // Constructor 

    /**
     *<h1>Rider Constructor</h1>
     * Rider constructor creates a rider object. It also assigns the rider 
     * with an incremented riderId using the count attribute/variable.
     * The rider object is created with a teamId parameter that assigns the
     * rider to a team object. 
     * 
     * @param teamId The teamId that represents the team that the rider is assigned to
     * @param name The name of the rider being created
     * @param yearOfBirth The year of birth of the rider being created
     */
    public Rider(int teamId, String name, int yearOfBirth) {

        this.teamId = teamId;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        count++;
        this.riderId = count;
    }

    // Getters

    /**
     * Gets the riders name
     * @return name A string representing the name of the rider
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the year of birth
     * @return An integer representing the year that the rider
     * 		was born
     */
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    /**
     * Gets the riderId
     * @return An integer representing the unique riderId of the rider
     */
    public int getRiderId() {
        return riderId;
    }

    /**
     * Gets the teamId
     * @return An integer representing the unique teamId that the rider belongs to
     */
    public int getTeamId() {
        return teamId;
    }
    // Setters 

    /**
     * Sets the name of the rider
     * @param name A string that represents the name of the rider
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the year of birth of the rider
     * @param yearOfBirth An integer that represents the year the rider was born
     */
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    /**
     * Sets the riderId of the rider
     * @param riderId An integer representing the riderId of the rider
     */
    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }

}
