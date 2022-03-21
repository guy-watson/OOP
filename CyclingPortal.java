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

	@Override
	public int[] getRaceIds() 
	{
		// HAS BEEN TESTED WORKYWORK
		int j = raceArrayList.size();
		int[] raceIdsArray = new int[j];

		for (int i=0;i<raceArrayList.size();i++) {
			raceIdsArray[i] = raceArrayList.get(i).getRaceId();
		}				
		return raceIdsArray;
	}

	@Override
	public int createRace(String name, String description) throws IllegalNameException, InvalidNameException {
		// WORKYWORK
		// Need to do exceptions
		Race newRace = new Race(name, description);
		raceArrayList.add(newRace);
		return newRace.getRaceId();

		//if(name.length() >= 30 || name.isEmpty() || name.trim().isEmpty() || name == null || name.contains///(" ")); {
        //    throw new InvalidNameException("That is an invalid name.");
		//}
	
	}

	@Override
	public String viewRaceDetails(int raceId) throws IDNotRecognisedException {
		
		// ** Needs testing
		Race selectedRace = null;
		String output = null;
		
		for(int i = 0; i <= raceArrayList.size(); i++) {
			if(raceArrayList.get(i).getRaceId() == raceId){
				
				selectedRace = raceArrayList.get(i);
				int rID = selectedRace.getRaceId();
				String n = selectedRace.getName();
				String d = selectedRace.getDescription();
				int nos = selectedRace.getNumberOfStages();
				Object l = selectedRace.getTotalLength();
				output = String.format("RaceID: %d, Name: %s, Description: %d, Number of Stages: %s, Total Length: %d", rID, n, d, nos, l);
				//if(i == raceArrayList.size() && selectedRace == null){
				//	throw new IDNotRecognisedException("That Race ID does not exist.");
				//}
			}
		}
		return output;
	}

	@Override
	public void removeRaceById(int raceId) throws IDNotRecognisedException {
		// Needs testing
		for(int i = 0; i < raceArrayList.size(); i++) {
			if(raceArrayList.get(i).getRaceId() == raceId){
				raceArrayList.remove(i);
				if(i == raceArrayList.size()){
					throw new IDNotRecognisedException("That Race ID does not exist.");
				}
			}
		}
	}

	@Override
	public int getNumberOfStages(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addStageToRace(int raceId, String stageName, String description, double length, LocalDateTime startTime, StageType type) throws IDNotRecognisedException, IllegalNameException, InvalidNameException, InvalidLengthException {
		// Needs testing

		// each race will have an arraylist of stages as an attribute?
		// WIll need to increase stages

		//find the race object via its raceid
		//add the stage
		// throw exceptions
		// increase number of stages in race object
		
		// Race findRace(int raceId) {
		//     for(Race race : ArrayListRace) {
		//         if(race.raceId().equals(raceId)) {
		//             return race;

		Race raceToAddStageTo = null;
		
		for(int i = 0; i < raceArrayList.size(); i++) {
			if(raceArrayList.get(i).getRaceId() == raceId){
				raceToAddStageTo = raceArrayList.get(i);
				if(i == raceArrayList.size()){
					throw new IDNotRecognisedException("That Race ID does not exist.");
				}
			
			}
			
				//return raceToAddStageTo;
		}
		
		Stage stageToAdd = new Stage(stageName, description, length, raceId, startTime, type);

		ArrayList<Stage> currentStageArrayList = raceToAddStageTo.getRaceStagesArrayList();
		currentStageArrayList.add(stageToAdd);
		raceToAddStageTo.setRaceStagesArrayList(currentStageArrayList);
		
		int currentNumOfStages = raceToAddStageTo.getNumberOfStages();
		currentNumOfStages++;
		raceToAddStageTo.setNumberOfStages(currentNumOfStages); 

		return 0; 
	}

	@Override
	public int[] getRaceStages(int raceId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getStageLength(int stageId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeStageById(int stageId) throws IDNotRecognisedException {
		// TODO Auto-generated method stub

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
		// Needs testing
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
		//Needs testing
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
		// Needs testing
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
		int j = teamArrayList.size();
		int[] teamIdsArray = new int[j];
		for (int i=0;i<teamArrayList.size();i++) {
			teamIdsArray[i] = teamArrayList.get(i).getTeamId();
		}				
		return teamIdsArray;
	}

	@Override
	public int createRider(int teamID, String name, int yearOfBirth) throws IDNotRecognisedException, IllegalArgumentException {
		// needs to throw exceptions
		// needs testing
		if(name == null){
			throw new IllegalArgumentException("The name is null.");
		}
		if(yearOfBirth < 1900){
			throw new IllegalArgumentException("That age is invalid.");
		}
		for(int i = 0; i <= teamArrayList.size(); i++) {
			if(teamArrayList.get(i).getTeamId() == teamID) {
				break;
			}
			if(i == teamArrayList.size()) {
				throw new IDNotRecognisedException("That Team ID does not exist.");
			}
		}
		Rider rider = new Rider(teamID, name, yearOfBirth);
		riderArrayList.add(rider);
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
		// Needs testing
		// Need to make sure removing segments, results and stages as well
		for(int i = 0; i <= raceArrayList.size(); i++) {
			if(raceArrayList.get(i).getName() == name){
				raceArrayList.remove(i);
				if(i == raceArrayList.size()){
					throw new NameNotRecognisedException("A race with that name does not exist.");
				}
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
	}

	public static void main(String[] args) {

	}

}
