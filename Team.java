package cycling;

public class Team {
// Attributes 

  private int teamId;
  private String name;
  private String description;
  static int count = 0;
    
    /**
		* Creates a team with name and description.
		* <p>
		* The state of this MiniCyclingPortalInterface must be unchanged if any
		* exceptions are thrown.
		*
		* @param name The identifier name of the team.
		* @param description A description of the team.
		* @return The ID of the created team.
		* @throws IllegalNameException If the name already exists in the platform.
		* @throws InvalidNameException If the new name is null, empty, has more than
		* 30 characters.
		*/
    //if(teamArray.contains(name) {
    // throw exception
    //}


  Team(String name, String description) {
    if (name.length() >= 30); {
        throw InvalidNameException("The name is too long");
    } if (name.isEmpty()) {
        throw InvalidNameException("The name is empty");
    } if (name.trim().isEmpty()) {
        throw InvalidNameException("The name is empty");
    } if (name == null) {
        throw InvalidNameException("The name is null");
    } if (name.contains(" ")) {
        throw InvalidNameException("The name contains a white space");
    } if (teamArrayList.contains(name)) {
        throw IllegalNameException();
    } 
    //if (teamArrayList.getAttribute(name).equals(name)) {
    //    throw IllegalNameException();
    //}

    

  this.name = name;
  this.description = description;
  count++;
  teamId = count;
  teamArrayList.add(this);
  }
    
    // Getters

    public int getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
        }
    
    public int getDescription() {
        return description;
    }  
    
    // Setters 
    
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    } 
}
