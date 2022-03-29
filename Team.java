package cycling;

import java.util.ArrayList;
import java.util.List;

public class Team {
// Attributes 

  private int teamId;
  private String name;
  private String description;
  static int count = 0;
  private List<Rider> teamRidersList = new ArrayList<Rider>();
  private Rider[] teamRiders = new Rider[1000];

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


  Team(String name, String description) throws InvalidNameException, IllegalNameException {
	  
    //if (teamArrayList.getAttribute(name).equals(name)) {
    //    throw IllegalNameException();
    //}
  this.name = name;
  this.description = description;
  count++;
  teamId = count;
  //teamArrayList.add(this);
  // ***** teamArrayList.add(new Team(name, description);
  }
    
    // Getters

    public int getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
        }
    
    public String getDescription() {
        return description;
    }  
	public Rider[] getTeamRiders() {
		return teamRiders;
	}
	public List<Rider> getTeamRidersList() {
		return teamRidersList;
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
    
	public void setTeamRiders(Rider[] teamRiders) {
		this.teamRiders = teamRiders;
	} 
	
	public void setTeamRidersList(List<Rider> teamRidersList) {
		this.teamRidersList = teamRidersList;
	}
}
