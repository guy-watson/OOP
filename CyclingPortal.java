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
	
	//private final ArrayList<Stage> raceStagesArrayList;

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
		// Works until you try and add stages
		Race selectedRace = null;
		String output = null;
		
		for(int i = 0; i < raceArrayList.size(); i++) {
			if(raceArrayList.get(i).getRaceId() == raceId){
				
				selectedRace = raceArrayList.get(i);
				int rID = selectedRace.getRaceId();
				String n = selectedRace.getName();
				String d = selectedRace.getDescription();
				int nos = selectedRace.getNumberOfStages();
				Object l = selectedRace.getTotalLength();
				output = String.format("RaceID: %d, Name: %s, Description: %s, Number of Stages: %s, Total Length: %d", rID, n, d, nos, l);
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
		// Needs testing
		int numOfStages = 0;
		for(int i = 0; i < raceArrayList.size(); i++) {
			if(raceArrayList.get(i).getRaceId() == raceId){
				numOfStages = ((MiniCyclingPortalInterface) raceArrayList).getNumberOfStages(i);
				if(i == raceArrayList.size()){
					throw new IDNotRecognisedException("That Race ID does not exist.");
				}
			}
		}
		return numOfStages;
	}

	@Override
	public int addStageToRace(int raceId, String stageName, String description, double length, LocalDateTime startTime, StageType type) throws IDNotRecognisedException, IllegalNameException, InvalidNameException, InvalidLengthException {
		// workywork
		// throw exceptions
		Stage newStage = new Stage(stageName, description, length, raceId, startTime, type);
		
		for(int i = 0; i < raceArrayList.size(); i++) {		
			if(raceArrayList.get(i).getRaceId() == raceId){
				Stage[] stageArrayA =  new Stage[100];
				stageArrayA = raceArrayList.get(i).getStageArray();
				stageArrayA[newStage.getStageId()] = newStage;
				raceArrayList.get(i).setStageArray(stageArrayA);
				int stageCount = raceArrayList.get(i).getNumberOfStages();
				stageCount++;
				raceArrayList.get(i).setNumberOfStages(stageCount);
			}
		}
		return newStage.getStageId();
	}

	@Override
	public int[] getRaceStages(int raceId) throws IDNotRecognisedException {
		// Needs testing
		
		// Need to find the race of the race ID
		// need to get the arraylist of stages from that race = "stageArrayList"
		// turn that array list into an array and return
		ArrayList<Stage> raceStagesList = null; 
		int[] raceStagesIDList = new int[1000];
		for(int i = 0; i < raceArrayList.size(); i++) {
			if(i == raceArrayList.size()){
					throw new IDNotRecognisedException("That Race ID does not exist.");
				}
			if(raceArrayList.get(i).getRaceId() == raceId){
				raceStagesList = raceArrayList.get(i).getRaceStagesArrayList();
					for(int k = 0; k < raceStagesList.size(); k++) {
						raceStagesIDList[k] = (raceStagesList.get(k).getStageId());
					}
			}
		}
		return raceStagesIDList;
		
	}

	@Override
	public double getStageLength(int stageId) throws IDNotRecognisedException {
		// Needs testing
		// THIS DOES NOT WORK 
		// Needs to throw exception
		//Stage stage1 = null;
		// SDADSHADSAKJDSAKJDHSAKJDHSAKJDHSAKJDSAKJD
		// SADJSADHKSADHSAJDKSADHSAJDSAKDJSADSA
		// DSAJKDHSAKJDHSAKJDHSAKJDHSAKJDHASKJDSAHKD
		// SDAHJDSAKJDHSAKJDHSAKJDASKJDHASJDSAKJDSA
		double length = 0;
		for(int i = 0; i < stageArrayList.size(); i++) {
			if(stageArrayList.get(i).getStageId() == stageId){
				length = stageArrayList.get(i).getLength();
				
			}
					
	
		}
		return length;
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
		stageArrayList = new ArrayList<>();
	}

	public static void main(String[] args) {

	}

}
