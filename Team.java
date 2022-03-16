package cycling;

public class Team {
// Attributes 

  private int teamId;
  private String name;
  private String description;
  private static int count = 0;
    
  Team(String name, String description) {
  this.name = name;
  this.description = description;
  count++;
  teamId = count;
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
