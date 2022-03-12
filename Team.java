package cycling;

public class Team {

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

    public int getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
        }
    
    public int getDescription() {
        return teamId;
    }    
    
}
