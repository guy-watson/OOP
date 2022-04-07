package cycling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.HashMap;

/*
 * @authors Guy Watson and Alex Gulliver
 * @version 1.0
 *
 */
public class CyclingPortal implements CyclingPortalInterface {

    // ?
    private static final long serialVersionUID = 345344545;

    private final ArrayList < Race > raceArrayList;
    private final ArrayList < Team > teamArrayList;
    private final ArrayList < Rider > riderArrayList;
    private final ArrayList < Stage > stageArrayList;
    private final ArrayList < StageSegment > segmentArrayList;

    /**
     * Gets the id for each race.
     *
     * @return the race id's as an array of integers
     */
    @Override
    public int[] getRaceIds() {
        int j = raceArrayList.size();
        int[] raceIdsArray = new int[j];

        for (int i = 0; i < raceArrayList.size(); i++) {
            raceIdsArray[i] = raceArrayList.get(i).getRaceId();
        }
        assert raceIdsArray.length != 0: "No races have been created.";
        return raceIdsArray;
    }

    /**
     * Creates the race.
     *
     * @param name the name
     * @param description the description
     * @return the int
     * @throws IllegalNameException the illegal name exception
     * @throws InvalidNameException the invalid name exception
     */
    @Override
    public int createRace(String name, String description) throws IllegalNameException, InvalidNameException {
        if (name.length() >= 30 || name.isEmpty() || name.trim().isEmpty() || name.contains(" ")) {
            throw new InvalidNameException("That is an invalid name.");
        }
        for (int i = 0; i < raceArrayList.size(); i++) {
            if (name.equals(raceArrayList.get(i).getName())) {
                throw new IllegalNameException("A team with that name already exists");
            }
        }
        Race newRace = new Race(name, description);
       assert newRace.getName() != null : "That race name is null";
       assert newRace.getDescription() != null : "That race description is null";
        raceArrayList.add(newRace);
        return newRace.getRaceId();
    }

    /**
     * View race details.
     *
     * @param raceId the race id
     * @return the string
     * @throws IDNotRecognisedException the ID not recognised exception
     */
    @Override
    public String viewRaceDetails(int raceId) throws IDNotRecognisedException {
        String output = null;
        int count = 0;
        int size = raceArrayList.size();
        for (Race race: raceArrayList) {
            if (race.getRaceId() == raceId) {
                int rID = race.getRaceId();
                String n = race.getName();
                String d = race.getDescription();
                int nos = getNumberOfStages(raceId);
                Object l = race.getTotalLength();
                output = String.format("RaceID: %d, Name: %s, Description: %s, Number of Stages: %s, Total Length: %f", rID, n, d, nos, l);
            } else {
                count++;
                if (count == size) {
                    throw new IDNotRecognisedException("A race with that race ID does not exist.");
                }
            }
        }
        return output;
    }

    /**
     * Removes the race by id.
     *
     * @param raceId the race id
     * @throws IDNotRecognisedException the ID not recognised exception
     */
    @Override
    public void removeRaceById(int raceId) throws IDNotRecognisedException {
        int count = 0;
        int size = raceArrayList.size();
        for (Race race: raceArrayList) {
            if (race.getRaceId() == raceId) {;
            } else {
                count++;
                if (count == size) {
                    throw new IDNotRecognisedException("A race with that race ID does not exist.");
                }
            }
        }
        removeRaceFromGlobalArray(raceId);
    }


    /**
     * Gets the number of stages.
     *
     * @param raceId the race id
     * @return the number of stages
     * @throws IDNotRecognisedException the ID not recognised exception
     */
    @Override
    public int getNumberOfStages(int raceId) throws IDNotRecognisedException {
        int count = 0;
        int size = raceArrayList.size();
        int length = 0;
        for (Race race: raceArrayList) {
            if (race.getRaceId() == raceId) {
                List < Stage > temp = race.getRaceStageList();
                length = temp.size();
            } else {
                count++;
                if (count == size) {
                    throw new IDNotRecognisedException("A race with that race ID does not exist.");
                }
            }
        }
        return length;
    }

    /**
     * Adds the stage to race.
     *
     * @param raceId the race id
     * @param stageName the stage name
     * @param description the description
     * @param length the length
     * @param startTime the start time
     * @param type the type
     * @return the int
     * @throws IDNotRecognisedException the ID not recognised exception
     * @throws IllegalNameException the illegal name exception
     * @throws InvalidNameException the invalid name exception
     * @throws InvalidLengthException the invalid length exception
     */
    @Override
    public int addStageToRace(int raceId, String stageName, String description, double length, LocalDateTime startTime, StageType type) throws IDNotRecognisedException, IllegalNameException, InvalidNameException, InvalidLengthException {
        int count = 0;
        int size = raceArrayList.size();
        if (stageName.length() >= 30 || stageName.isEmpty() || stageName.trim().isEmpty() || stageName.contains(" ")) {
            throw new InvalidNameException("That is an invalid name.");
        }
        // don't know what a null double is *********
        if (length < 5) {
            throw new InvalidLengthException("The length is is null or less than 5km");

        }
        for (Stage stage: stageArrayList) {
            if (stageName.equals(stage.getStageName())) {
                throw new IllegalNameException("A stage with that name already exists");
            }
        }

        Stage newStage = new Stage(stageName, description, length, raceId, startTime, type);
        //puts stage in global array list with all stages
        stageArrayList.add(newStage);
        // puts stage in the race object attribute
        for (Race race: raceArrayList) {
            if (raceId == race.getRaceId()) {
                List < Stage > tempList = race.getRaceStageList();
                tempList.add(newStage);
                race.setRaceStageList(tempList);
                double tempLength = race.getTotalLength();
                tempLength = tempLength + length;
                race.setTotalLength(tempLength);
            } else {
                count++;
                if (count == size) {
                    throw new IDNotRecognisedException("A race with that race ID does not exist.");
                }
            }
        }

        return newStage.getStageId();
    }

    /**
     * Gets the race stages.
     *
     * @param raceId the race id
     * @return the race stages
     * @throws IDNotRecognisedException the ID not recognised exception
     */
    @Override
    public int[] getRaceStages(int raceId) throws IDNotRecognisedException {
        int count = 0;
        int size = raceArrayList.size();
        // Temporary array list used to store stage IDs
        List < Integer > tempStageArrayList = new ArrayList < > ();
        // Iterates through global race array list to find race with corresponding race id and adds the stage id's of the stages in that race
        for (Race race: raceArrayList) {
            if (race.getRaceId() == raceId) {
                // sorting needs to happen around here
                List < Stage > unsortedList = race.getRaceStageList();
                unsortedList.sort(Comparator.comparing(Stage::getStartTime));
                for (Stage stage: unsortedList) {
                    tempStageArrayList.add(stage.getStageId());
                }
            } else {
                count++;
                if (count == size) {
                    throw new IDNotRecognisedException("A race with that race ID does not exist");
                }
            }
        }
        Object[] stageArrayObject = new Object[tempStageArrayList.size()];
        stageArrayObject = tempStageArrayList.toArray();
        int[] stageArrayInteger = new int[stageArrayObject.length];
        for (int i = 0; i < stageArrayObject.length; i++) {
            stageArrayInteger[i] = (int) stageArrayObject[i];
        }

        return stageArrayInteger;
    }


    /**
     * Gets the stage length.
     *
     * @param stageId the stage id
     * @return the stage length
     * @throws IDNotRecognisedException the ID not recognised exception
     */
    @Override
    public double getStageLength(int stageId) throws IDNotRecognisedException {
        int count = 0;
        int size = stageArrayList.size();
        double length = 0;
        for (Stage stage: stageArrayList) {
            if (stage.getStageId() == stageId) {
                length = stage.getLength();
            } else {
                count++;
                if (count == size) {
                    throw new IDNotRecognisedException("A stage with that stage ID does not exist.");
                }
            }
        }
        return length;
    }

    /**
     * Removes the stage by id.
     *
     * @param stageId the stage id
     * @throws IDNotRecognisedException the ID not recognised exception
     */
    @Override
    public void removeStageById(int stageId) throws IDNotRecognisedException {
        int foundRaceId = 0;
        for (Stage stage: stageArrayList) {
            if (stage.getStageId() == stageId) {
                foundRaceId = stage.getRaceId();
                for (Race race: raceArrayList) {
                    if (race.getRaceId() == foundRaceId) {
                        race.getRaceStageList().remove(stage);
                    }
                }
            }
        }
        removeStageFromGlobalArray(stageId);
    }

    /**
     * Adds the categorized climb to stage.
     *
     * @param stageId the stage id
     * @param location the location
     * @param type the type
     * @param averageGradient the average gradient
     * @param length the length
     * @return the int
     * @throws IDNotRecognisedException the ID not recognised exception
     * @throws InvalidLocationException the invalid location exception
     * @throws InvalidStageStateException the invalid stage state exception
     * @throws InvalidStageTypeException the invalid stage type exception
     */
    @Override
    public int addCategorizedClimbToStage(int stageId, Double location, SegmentType type, Double averageGradient, Double length) throws IDNotRecognisedException, InvalidLocationException, InvalidStageStateException, InvalidStageTypeException {
        for (Stage stage: stageArrayList) {
            if (stage.getStageId() == stageId) {
                if (Boolean.FALSE.equals(stage.getStageState())) {
                    throw new InvalidStageStateException();
                }
            }
        }

        if (location <= 0 || location > length) {
            throw new InvalidLocationException("That is an invalid location.");
        }

        StageSegment newStageSegment = new StageSegment(stageId, location, type, averageGradient, length);

        int count = 0;
        int size = stageArrayList.size();
        for (Stage stage: stageArrayList) {
            if (stage.getStageId() == stageId) {
                if (stage.getType() != StageType.TT) {
                    ArrayList < StageSegment > tempArray = stage.getSegmentStageList();
                    tempArray.add(newStageSegment);
                    stage.setSegmentStageList(tempArray);
                } else {
                    throw new InvalidStageTypeException("That stage type is not allowed");
                }
            } else {
                count++;
                if (count == size) {
                    throw new IDNotRecognisedException("A stage with that stage ID does not exist.");
                }
            }

        }
        return newStageSegment.getSegmentId();
    }

    @Override
    public int addIntermediateSprintToStage(int stageId, double location) throws IDNotRecognisedException,
        InvalidLocationException, InvalidStageStateException, InvalidStageTypeException {
            // Needs testing

            int count = 0;
            int size = stageArrayList.size();

            for (Stage stage: stageArrayList) {
                if (stage.getStageId() == stageId) {;
                } else {
                    if (count == size) {
                        throw new IDNotRecognisedException("A stage with that stage ID does not exist");
                    }
                }
            }

            for (Stage stage: stageArrayList) {
                if (stage.getStageId() == stageId) {
                    if (Boolean.FALSE.equals(stage.getStageState())) {
                        throw new InvalidStageStateException();
                    }
                }
            }

            for (Stage stage: stageArrayList) {
                if (stage.getStageId() == stageId) {
                    if (location <= 0 || location > stage.getLength()) {
                        throw new InvalidLocationException("That is an invalid location.");
                    }


                }
            }

            StageSegment newStageSegment = new StageSegment(stageId, location, SegmentType.SPRINT);

            for (Stage stage: stageArrayList) {
                if (stage.getStageId() == stageId) {
                    ArrayList < StageSegment > tempArray = stage.getSegmentStageList();
                    tempArray.add(newStageSegment);
                    stage.setSegmentStageList(tempArray);
                }
            }
            return newStageSegment.getSegmentId();
        }


    /**
     * Removes the segment.
     *
     * @param segmentId the segment id
     * @throws IDNotRecognisedException the ID not recognised exception
     * @throws InvalidStageStateException the invalid stage state exception
     */
    @Override
    public void removeSegment(int segmentId) throws IDNotRecognisedException, InvalidStageStateException {
        // does not work
        int foundStageId = 0;
        for (StageSegment stageSegment: segmentArrayList) {
            if (stageSegment.getSegmentId() == segmentId) {
                foundStageId = stageSegment.getStageId();
                for (Stage stage: stageArrayList) {
                    if (stage.getStageId() == foundStageId) {
                        stage.getSegmentStageList().remove(stageSegment);
                    }
                }
            }
        }
        removeSegmentFromGlobalArray(segmentId);
    }

    /**
     * Conclude stage preparation.
     *
     * @param stageId the stage id
     * @throws IDNotRecognisedException the ID not recognised exception
     * @throws InvalidStageStateException the invalid stage state exception
     */
    @Override
    public void concludeStagePreparation(int stageId) throws IDNotRecognisedException, InvalidStageStateException {
        // Needs testing
        for (Stage stage: stageArrayList) {
            if (stage.getStageId() == stageId) {
                stage.setStageState(true);
            }
        }
    }

    /**
     * Gets the stage segments.
     *
     * @param stageId the stage id
     * @return the stage segments
     * @throws IDNotRecognisedException the ID not recognised exception
     */
    @Override
    public int[] getStageSegments(int stageId) throws IDNotRecognisedException {
        int count = 0;
        int size = stageArrayList.size();
        List < Integer > tempSegmentArrayList = new ArrayList < > ();
        for (Stage stage: stageArrayList) {
            if (stage.getStageId() == stageId) {
                for (StageSegment segment: stage.getSegmentStageList()) {
                    tempSegmentArrayList.add(segment.getSegmentId());
                }
            } else {
                count++;
                if (count == size) {
                    throw new IDNotRecognisedException("A team with that team ID does not exist.");
                }
            }
        }
        Object[] segmentArrayObject = new Object[tempSegmentArrayList.size()];
        segmentArrayObject = tempSegmentArrayList.toArray();
        int[] segmentArrayInteger = new int[segmentArrayObject.length];
        for (int i = 0; i < segmentArrayObject.length; i++) {
            segmentArrayInteger[i] = (int) segmentArrayObject[i];
        }
        return segmentArrayInteger;
    }

    /**
     * Creates the team.
     *
     * @param name the name
     * @param description the description
     * @return the int
     * @throws IllegalNameException the illegal name exception
     * @throws InvalidNameException the invalid name exception
     */
    @Override
    public int createTeam(String name, String description) throws IllegalNameException, InvalidNameException {
        if (name.length() >= 30) {
            throw new InvalidNameException("The name is too long");
        }
        if (name.isEmpty()) {
            throw new InvalidNameException("The name is empty");
        }
        if (name.trim().isEmpty()) {
            throw new InvalidNameException("The name is empty");
        }
        if (name.contains(" ")) {
            throw new InvalidNameException("The name contains a white space");
        }
        for (Team team: teamArrayList) {
            if (name.equals(team.getName())) {
                throw new IllegalNameException("A team with that name already exists");
            }
        }

        Team team = new Team(name, description);
        assert team.getName() != null : "That team name is null";
        assert team.getDescription() != null : "That team description is null";
        teamArrayList.add(team);
        return team.getTeamId();
    }

    /**
     * Removes the team.
     *
     * @param teamId the team id
     * @throws IDNotRecognisedException the ID not recognised exception
     */
    @Override
    public void removeTeam(int teamId) throws IDNotRecognisedException {
        for (int i = 0; i < teamArrayList.size(); i++) {
            if (teamArrayList.get(i).getTeamId() == teamId) {
                teamArrayList.remove(i);
                if (i == teamArrayList.size()) {
                    throw new IDNotRecognisedException("That Team ID does not exist.");
                }
            }
        }
    }

    /**
     * Gets the teams.
     *
     * @return the teams
     */
    @Override
    public int[] getTeams() {
        int j = teamArrayList.size();
        int[] teamIdsArray = new int[j];
        for (int i = 0; i < teamArrayList.size(); i++) {
            teamIdsArray[i] = teamArrayList.get(i).getTeamId();
        }
        return teamIdsArray;
    }

    /**
     * Gets the team riders.
     *
     * @param teamId the team id
     * @return the team riders
     * @throws IDNotRecognisedException the ID not recognised exception
     */
    @Override
    public int[] getTeamRiders(int teamId) throws IDNotRecognisedException {
        int count = 0;
        int size = teamArrayList.size();
        assert size != 0: "There are no teams to select riders from.";
        List < Integer > tempRiderArrayList = new ArrayList < > ();
        for (Team team: teamArrayList) {
            if (team.getTeamId() == teamId) {
                for (Rider rider: team.getTeamRidersList()) {
                    tempRiderArrayList.add(rider.getRiderId());
                }
            } else {
                count++;
                if (count == size) {
                    throw new IDNotRecognisedException("A team with that team ID does not exist.");
                }
            }
        }
        Object[] riderArrayObject = new Object[tempRiderArrayList.size()];
        riderArrayObject = tempRiderArrayList.toArray();
        int[] riderArrayInteger = new int[riderArrayObject.length];
        for (int i = 0; i < riderArrayObject.length; i++) {
            riderArrayInteger[i] = (int) riderArrayObject[i];
        }
        return riderArrayInteger;
    }

    /**
     * Creates the rider.
     *
     * @param teamId the team id
     * @param name the name
     * @param yearOfBirth the year of birth
     * @return the int
     * @throws IDNotRecognisedException the ID not recognised exception
     * @throws IllegalArgumentException the illegal argument exception
     */
    @Override
    public int createRider(int teamId, String name, int yearOfBirth) throws IDNotRecognisedException, IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException("The name is null.");
        }
        if (yearOfBirth < 1900) {
            throw new IllegalArgumentException("That age is invalid.");
        }

        Rider newRider = new Rider(teamId, name, yearOfBirth);
        riderArrayList.add(newRider);
        int count = 0;
        int size = teamArrayList.size();
        for (Team team: teamArrayList) {
            if (team.getTeamId() == teamId) {
                List < Rider > riderList = team.getTeamRidersList();
                riderList.add(newRider);
                team.setTeamRidersList(riderList);
            } else {
                count++;
                if (count == size) {
                    throw new IDNotRecognisedException("A team with that team ID does not exist.");
                }
            }

        }

        return newRider.getRiderId();
    }

    /**
     * Removes the rider.
     *
     * @param riderId the rider id
     * @throws IDNotRecognisedException the ID not recognised exception
     */
    @Override
    public void removeRider(int riderId) throws IDNotRecognisedException {
        int count = 0;
        int foundTeamId = 0;
        int size = riderArrayList.size();
        for (Rider rider: riderArrayList) {
            if (rider.getRiderId() == riderId) {
                foundTeamId = rider.getTeamId();
                for (Team team: teamArrayList) {
                    if (team.getTeamId() == foundTeamId) {
                        team.getTeamRidersList().remove(rider);
                    }
                }
            } else {
                count++;
                if (count == size) {
                    throw new IDNotRecognisedException("A rider with that rider ID does not exist.");
                }
            }
        }
        removeRiderFromGlobalArray(riderId);
    }

    /**
     * Register rider results in stage.
     *
     * @param stageId the stage id
     * @param riderId the rider id
     * @param checkpoints the checkpoints
     * @throws IDNotRecognisedException the ID not recognised exception
     * @throws DuplicatedResultException the duplicated result exception
     * @throws InvalidCheckpointsException the invalid checkpoints exception
     * @throws InvalidStageStateException the invalid stage state exception
     */
    @Override
    public void registerRiderResultsInStage(int stageId, int riderId, LocalTime...checkpoints)
    throws IDNotRecognisedException, DuplicatedResultException, InvalidCheckpointsException,
    InvalidStageStateException {

        int count = 0;
        Integer riderInteger = Integer.valueOf(riderId);
        int size = stageArrayList.size();
        for (Stage stage: stageArrayList) {
            if (stage.getStageId() == stageId) {
				for(int i : stage.getStageResultsHashMap().keySet())  {
                    if(i == riderInteger) {
                		//make new checkpoints
                		LocalTime[] currentList = stage.getStageResultsHashMap().get(riderInteger);
                		int len1 = currentList.length;
                		int len2 = checkpoints.length;
                		LocalTime[] newCheckpoints = new LocalTime[len1 + len2];
                		System.arraycopy(currentList, 0, newCheckpoints, 0, len1);
                		System.arraycopy(checkpoints, 0, newCheckpoints, len1, len2);
                		stage.getStageResultsHashMap().put(riderInteger, newCheckpoints);
                		} else {
                		stage.getStageResultsHashMap().put(riderInteger, checkpoints);
                	}
                }

				

                /*LocalTime[] resultsArray = stage.getStageResultsHashMap().get(riderId);
                int newSize = resultsArray.length + 1;
                LocalTime[] newResultsArray =  Arrays.copyOf(resultsArray, newSize);
                stage.setStageResultsHashMap(newSize, newResultsArray); */


            } else {
                count++;
                if (count > size) {
                    throw new IDNotRecognisedException();
                }
            }
        }
    }
    

    /**
     * Gets the rider results in stage.
     *
     * @param stageId the stage id
     * @param riderId the rider id
     * @return the rider results in stage
     * @throws IDNotRecognisedException the ID not recognised exception
     */
    @Override
    public LocalTime[] getRiderResultsInStage(int stageId, int riderId) throws IDNotRecognisedException {
        // The array of times at which the rider reached each of the segments of the stage and the total elapsed time. 
        // The elapsed time is the difference between the finish time and the start time.
        //  Return an empty array if there is no result registered for the rider in the stage.

        // at the moment the array of results is only returning the last result (adding results is overriding array?)
   	 	LocalTime[] resultsArray = null;

        for (Stage stage: stageArrayList) {
            if (stage.getStageId() == stageId) {
				System.out.println(stage.getStageResultsHashMap().get(riderId));
                resultsArray = stage.getStageResultsHashMap().get(riderId);
                //System.out.println(stage.getStageResultsHashMap().get(riderId).toString());
                //System.out.println(resultsArray + " Hello");
            }
           
        }
       return resultsArray;
    }

    /*  List < LocalTime > tempLocalTimeArrayList = new ArrayList < > ();
        
        for (Stage stage: stageArrayList) {
            if (stage.getStageId() == stageId) {
                Integer riderIdInteger = Integer.valueOf(riderId);
                tempLocalTimeArrayList = stage.getStageResultsHashMap().get(riderIdInteger);
                Object[] resultsArrayObject = new Object[tempLocalTimeArrayList.size()];
                resultsArrayObject = tempLocalTimeArrayList.toArray();
                LocalTime[] resultsArrayLocalTime = new LocalTime[resultsArrayObject.length];
                for (int i = 0; i < resultsArrayObject.length; i++) {
            		resultsArrayLocalTime[i] = (LocalTime) resultsArrayObject[i];
                }
        	}
    	}
    	return resultsArrayLocalTime;
    }
    */

    @Override
    public LocalTime getRiderAdjustedElapsedTimeInStage(int stageId, int riderId) throws IDNotRecognisedException {
        return null;
    }

    @Override
    public void deleteRiderResultsInStage(int stageId, int riderId) throws IDNotRecognisedException {

        int count = 0;
        int size = stageArrayList.size();
        for (Stage stage: stageArrayList) {
            if (stage.getStageId() == stageId) {
                stage.getStageResultsHashMap().remove(riderId);
            }
        }


    }

    @Override
    public int[] getRidersRankInStage(int stageId) throws IDNotRecognisedException {
        return null;
    }

    @Override
    public LocalTime[] getRankedAdjustedElapsedTimesInStage(int stageId) throws IDNotRecognisedException {
        return null;
    }

    @Override
    public int[] getRidersPointsInStage(int stageId) throws IDNotRecognisedException {
        return null;
    }

    @Override
    public int[] getRidersMountainPointsInStage(int stageId) throws IDNotRecognisedException {
        return null;
    }

    /**
     * Erase cycling portal.
     */
    @Override
    public void eraseCyclingPortal() {
        teamArrayList.clear();
        raceArrayList.clear();
        riderArrayList.clear();
        stageArrayList.clear();
        segmentArrayList.clear();
    }

    @Override
    public void saveCyclingPortal(String filename) throws IOException {

        CyclingPortal Object = new CyclingPortal();

        try {


            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(Object);

            out.close();
            file.close();

        } catch (IOException ex) {
            throw new IOException("IO Error");
        }


    }

    @Override
    public void loadCyclingPortal(String filename) throws IOException, ClassNotFoundException {

        CyclingPortal object1 = null;

        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            object1 = (CyclingPortal) in .readObject();

            in .close();
            file.close();

        } catch (IOException ex) {
            throw new IOException("IO Error");
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("ClassNotFoundException is caught");
        }

    }

    /**
     * Removes the race by name.
     *
     * @param name the name
     * @throws NameNotRecognisedException the name not recognised exception
     */
    @Override
    public void removeRaceByName(String name) throws NameNotRecognisedException {
        // WORKS
	
		assert race != null : "That name is null.";
        for (int i = 0; i < raceArrayList.size(); i++) {
            if (raceArrayList.get(i).getName() == name) {
                raceArrayList.remove(i);
            } else if (i == raceArrayList.size()) {
                throw new NameNotRecognisedException("A race with that name does not exist.");
            }
        }
    }

    @Override
    public LocalTime[] getGeneralClassificationTimesInRace(int raceId) throws IDNotRecognisedException {
        return null;
    }

    @Override
    public int[] getRidersPointsInRace(int raceId) throws IDNotRecognisedException {
        return null;
    }

    @Override
    public int[] getRidersMountainPointsInRace(int raceId) throws IDNotRecognisedException {
        return null;
    }

    @Override
    public int[] getRidersGeneralClassificationRank(int raceId) throws IDNotRecognisedException {
        return null;
    }

    @Override
    public int[] getRidersPointClassificationRank(int raceId) throws IDNotRecognisedException {
        return null;
    }

    @Override
    public int[] getRidersMountainPointClassificationRank(int raceId) throws IDNotRecognisedException {
        return null;
    }

    /**
     * Instantiates a new cycling portal.
     */
    public CyclingPortal() {
        raceArrayList = new ArrayList < > ();
        teamArrayList = new ArrayList < > ();
        riderArrayList = new ArrayList < > ();
        stageArrayList = new ArrayList < > ();
        segmentArrayList = new ArrayList < > ();
    }


    /**
     * Removes the rider from global array.
     *
     * @param riderId the rider id
     */
    public void removeRiderFromGlobalArray(int riderId) {

        for (Rider rider: riderArrayList) {
            if (rider.getRiderId() == riderId) {
                riderArrayList.remove(rider);
                break;
            }
        }
    }

    /**
     * Removes the race from global array.
     *
     * @param raceId the race id
     */
    public void removeRaceFromGlobalArray(int raceId) {

        for (Race race: raceArrayList) {
            if (race.getRaceId() == raceId) {
                raceArrayList.remove(race);
                break;
            }
        }
    }

    /**
     * Removes the stage from global array.
     *
     * @param stageId the stage id
     */
    public void removeStageFromGlobalArray(int stageId) {

        for (Stage stage: stageArrayList) {
            if (stage.getStageId() == stageId) {
                stageArrayList.remove(stage);
                break;
            }
        }
    }

    /**
     * Removes the segment from global array.
     *
     * @param segmentId the segment id
     */
    public void removeSegmentFromGlobalArray(int segmentId) {

        for (StageSegment stageSegment: segmentArrayList) {
            if (stageSegment.getSegmentId() == segmentId) {
                segmentArrayList.remove(stageSegment);
                break;
            }

        }
    }
    
  


	public static void main(String[] args) {

    }

}
