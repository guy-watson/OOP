package cycling;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * BadCyclingPortal is a minimally compiling, but non-functioning implementor
 * of the CyclingPortalInterface interface.
 * 
 * @author Diogo Pacheco
 * @version 1.0
 *
 */
public class CyclingPortal implements CyclingPortalInterface {
	
	//private static final int RaceID = 0;
	private final ArrayList<Race> raceArrayList;
	private final ArrayList<Team> teamArrayList;
	private final ArrayList<Rider> riderArrayList;
	private final ArrayList<Stage> stageArrayList;
	private final ArrayList<Stage> raceStageArrayList;
	
	
	//private final ArrayList<Stage> raceStagesArrayList;

	@Override
	public int[] getRaceIds() 
	{
		// WORKS
		
		int j = raceArrayList.size();
		int[] raceIdsArray = new int[j];

		for (int i=0;i<raceArrayList.size();i++) {
			raceIdsArray[i] = raceArrayList.get(i).getRaceId();
		}				
		return raceIdsArray;
	}

	@Override
	public int createRace(String name, String description) throws IllegalNameException, InvalidNameException {
		// WORKS
		if(name.length() >= 30 || name.isEmpty() || name.trim().isEmpty() || name == null || name.contains(" ")) {
			throw new InvalidNameException("That is an invalid name."); 	
		}
		for(int i = 0; i < raceArrayList.size(); i++) {
			if(name.equals(raceArrayList.get(i).getName())) {
				throw new IllegalNameException("A team with that name already exists");
			}
		}
		Race newRace = new Race(name, description);
		raceArrayList.add(newRace);
		return newRace.getRaceId();
	}
	

	@Override
	public String viewRaceDetails(int raceId) throws IDNotRecognisedException {
		// WORKS
		String output = null;
		int count = 0;
		int size = raceArrayList.size();
		for(Race race : raceArrayList) {
			if(race.getRaceId() == raceId){				
				int rID = race.getRaceId();
				String n = race.getName();
				String d = race.getDescription();
				int nos = race.getNumberOfStagesInArray();
				Object l = race.getTotalLength();
				output = String.format("RaceID: %d, Name: %s, Description: %s, Number of Stages: %s, Total Length: %f", rID, n, d, nos, l);
			} else {
				count++;
				if(count == size) {
					throw new IDNotRecognisedException("A race with that race ID does not exist.");
				}
			}
		}
		return output;
	}

		
	

	@Override
	public void removeRaceById(int raceId) throws IDNotRecognisedException { 
		// WORKS
		int i = -1;
		for(Race race : raceArrayList) {
			if(race.getRaceId() == raceId){	
				i = raceArrayList.indexOf(race);
			} else {
				if(i == -1) {
					throw new IDNotRecognisedException("A race with that raceID does not exist. ");
				}
			}
		}
		if(i > 0)
		raceArrayList.remove(i);
	}
			

	@Override
	public int getNumberOfStages(int raceId) throws IDNotRecognisedException {
		// --
		if(raceId > raceArrayList.size()){
			throw new IDNotRecognisedException("That Race ID does not exist.");
		}
		int numOfStages = 0;
		for(int i = 0; i < raceArrayList.size(); i++) {
			if(raceArrayList.get(i).getRaceId() == raceId){
				numOfStages = raceArrayList.get(i).getNumberOfStagesInArray();
				//if(i == raceArrayList.size()){
				//	throw new IDNotRecognisedException("That Race ID does not exist.");
				}
			}
		return numOfStages;
		}
		

	@Override
	public int addStageToRace(int raceId, String stageName, String description, double length, LocalDateTime startTime, StageType type) throws IDNotRecognisedException, IllegalNameException, InvalidNameException, InvalidLengthException {
		// --
		if (stageName.length() >= 30) {
			throw new InvalidNameException("The stage name is too long");
		} if (stageName.isEmpty()) {
			throw new InvalidNameException("The stage name is empty");
		} if (stageName.trim().isEmpty()) {
			throw new InvalidNameException("The stage name is empty");
		}  if (stageName.contains(" ")) {
			throw new InvalidNameException("The stage name contains a white space");
		}
		
		for(Stage stage : stageArrayList) {
			if(stageName.equals(stage.getStageName())) {
				throw new IllegalNameException("A stage with that name already exists");
				}
			}
			
		
	
		
		Stage newStage = new Stage(stageName, description, length, raceId, startTime, type);
		
		
		
		return newStage.getStageId();


		}



	@Override
	public int[] getRaceStages(int raceId) throws IDNotRecognisedException {
		// Needs testing
		
		// Need to find the race of the race ID
		// need to get the arraylist of stages from that race = "stageArrayList"
		// turn that array list into an array and return
		
//		if(raceId > raceArrayList.size()){
//			throw new IDNotRecognisedException("That Race ID does not exist.");
//		}
//		Stage[] raceStages = new Stage[1000];
//		for(int i = 0; i < raceArrayList.size(); i++) {
//			if(raceArrayList.get(i).getRaceId() == raceId){
//				raceStages = stageArray[i].getStageArray();
//			}					
//		}
//	return raceStagesIDList;
	return null;
	}
		


	@Override
	public double getStageLength(int stageId) throws IDNotRecognisedException {
		// Needs testing
		// THIS DOES NOT WORK 
		// Needs to throw exception
		
		
		
		
		
		
		
		
		
		//double stageLength = 0;

		
		//for(int i = 0; i <= stageArrayList.size(); i++) {
			//if(stageArrayList.get(i).getStageId() == stageId) { 
				//stageLength = stageArrayList.get(i).getLength();
			return 0.0;
//			return stageLength;
	}
		
		
	

	@Override
	public void removeStageById(int stageId) throws IDNotRecognisedException {
		// needs testing
		int i = -1;
		for(Stage stage : stageArrayList) {
			if(stage.getStageId() == stageId){	
				i = stageArrayList.indexOf(stage);
			} else {
				if(i == -1) {
					throw new IDNotRecognisedException("A stage with that stageID does not exist. ");
				}
			}
		}
		if(i > 0)
		stageArrayList.remove(i);
	}
			

	@Override
	public int addCategorizedClimbToStage(int stageId, Double location, SegmentType type, Double averageGradient, Double length) throws IDNotRecognisedException, InvalidLocationException, InvalidStageStateException,
			InvalidStageTypeException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addIntermediateSprintToStage(int stageId, double location) throws IDNotRecognisedException,
			InvalidLocationException, InvalidStageStateException, InvalidStageTypeException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeSegment(int segmentId) throws IDNotRecognisedException, InvalidStageStateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void concludeStagePreparation(int stageId) throws IDNotRecognisedException, InvalidStageStateException {
		// TODO Auto-generated method stub
	}

	@Override
	public int[] getStageSegments(int stageId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createTeam(String name, String description) throws IllegalNameException, InvalidNameException {
		// WORKS -- add illegal exception
		if (name.length() >= 30) {
			throw new InvalidNameException("The name is too long");
		} if (name.isEmpty()) {
			throw new InvalidNameException("The name is empty");
		} if (name.trim().isEmpty()) {
			throw new InvalidNameException("The name is empty");
		}  if (name.contains(" ")) {
			throw new InvalidNameException("The name contains a white space");
		} 
		//if (teamArrayList.contains()) {
		//	throw new IllegalNameException();
		//} 
		Team team = new Team(name, description);
		teamArrayList.add(team);
		return team.getTeamId();
	}

	@Override
	public void removeTeam(int teamId) throws IDNotRecognisedException {
		// WORKS
		for(int i = 0; i < teamArrayList.size(); i++) {
			if(teamArrayList.get(i).getTeamId() == teamId){
				teamArrayList.remove(i);
				if(i == teamArrayList.size()){
					throw new IDNotRecognisedException("That Team ID does not exist.");
				}
			}
		}
	}

	@Override
	public int[] getTeams() {
		// WORKS
		int j = teamArrayList.size();
		int[] teamIdsArray = new int[j];
		for (int i=0;i<teamArrayList.size();i++) {
			teamIdsArray[i] = teamArrayList.get(i).getTeamId();
		}
		return teamIdsArray;
	}
	
	@Override
	public int[] getTeamRiders(int teamId) throws IDNotRecognisedException {
		// Need to create an array list of riders in a team
		// does not work
		int i = 0;
		int teamSize = teamArrayList.size();
		int[] teamIdsArray = new int[teamSize];
		for (Rider rider : riderArrayList) {
			if(rider.getTeamId() == teamId) {
				teamIdsArray[i] = rider.getRiderId();
				i++;
			}
		}
		return teamIdsArray;
	}

	@Override
	public int createRider(int teamId, String name, int yearOfBirth) throws IDNotRecognisedException, IllegalArgumentException {
		// needs to throw exceptions
		// needs testing
		if(name == null){
			throw new IllegalArgumentException("The name is null.");
		}
		if(yearOfBirth < 1900){
			throw new IllegalArgumentException("That age is invalid.");
		}
		for(int i = 0; i < teamArrayList.size(); i++) {
			if(teamArrayList.get(i).getTeamId() == teamId) {
				break;
			}
			if(i == teamArrayList.size()) {
				throw new IDNotRecognisedException("That Team ID does not exist.");
			}
		}
		Rider rider = new Rider(teamId, name, yearOfBirth);
		riderArrayList.add(rider);
		for(int i = 0; i < teamArrayList.size();i++) {
			if(teamArrayList.get(i).getTeamId() == teamId){
				//riderInTeamArrayList.add(rider);
				// need to make the rider add to the array not sure how??
			}
		
		
		}
		return rider.getRiderId();

	}

	@Override
	public void removeRider(int riderId) throws IDNotRecognisedException {
		// Needs testing
		// Needs to remove results and update race results as well
		for(int i = 0; i <= riderArrayList.size(); i++) {
			if(riderArrayList.get(i).getRiderId() == riderId){
				riderArrayList.remove(i);
				if(i == riderArrayList.size()){
					throw new IDNotRecognisedException("That Rider ID does not exist.");
				}
			}
		}

	}

	@Override
	public void registerRiderResultsInStage(int stageId, int riderId, LocalTime... checkpoints)
			throws IDNotRecognisedException, DuplicatedResultException, InvalidCheckpointsException,
			InvalidStageStateException {
		// TODO Auto-generated method stub

	}

	@Override
	public LocalTime[] getRiderResultsInStage(int stageId, int riderId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalTime getRiderAdjustedElapsedTimeInStage(int stageId, int riderId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRiderResultsInStage(int stageId, int riderId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub

	}

	@Override
	public int[] getRidersRankInStage(int stageId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalTime[] getRankedAdjustedElapsedTimesInStage(int stageId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getRidersPointsInStage(int stageId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getRidersMountainPointsInStage(int stageId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eraseCyclingPortal() {
		teamArrayList.clear();
		raceArrayList.clear();
		riderArrayList.clear();
	}

	@Override
	public void saveCyclingPortal(String filename) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadCyclingPortal(String filename) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRaceByName(String name) throws NameNotRecognisedException {
		// Works
		// Exception DOES NOT WORK
		// Need to make sure removing segments, results and stages as well
		//for(int i = 0; i < raceArrayList.size(); i++) {
		//	if(raceArrayList.get(i).getName() == name){
		//		raceArrayList.remove(i);
		//	if(i == raceArrayList.size()){
			//	throw new NameNotRecognisedException("A race with that name does not exist.");
			//}
		//}
	//}
		for(int i = 0; i < raceArrayList.size(); i++) {
			if(raceArrayList.get(i).getName() == name){
				raceArrayList.remove(i);
			}else if(i == raceArrayList.size()){
				throw new NameNotRecognisedException("A race with that name does not exist.");
			}
		}
	}


	@Override
	public LocalTime[] getGeneralClassificationTimesInRace(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getRidersPointsInRace(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getRidersMountainPointsInRace(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getRidersGeneralClassificationRank(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getRidersPointClassificationRank(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getRidersMountainPointClassificationRank(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	public CyclingPortal() {
		raceArrayList = new ArrayList<>();
		teamArrayList = new ArrayList<>();
		riderArrayList = new ArrayList<>();
		stageArrayList = new ArrayList<>();
		raceStageArrayList = new ArrayList<>();
		//stageArrayList = new ArrayList<>();
	}

	public static void main(String[] args) {

	}

}
