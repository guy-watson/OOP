package test;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import cycling.CyclingPortal;
import cycling.CyclingPortalInterface;
import cycling.DuplicatedResultException;
import cycling.IDNotRecognisedException;
import cycling.IllegalNameException;
import cycling.InvalidCheckpointsException;
import cycling.InvalidLengthException;
import cycling.InvalidLocationException;
import cycling.InvalidNameException;
import cycling.InvalidStageStateException;
import cycling.InvalidStageTypeException;
import cycling.MiniCyclingPortalInterface;
import cycling.NameNotRecognisedException;
import cycling.SegmentType;
import cycling.StageType;

/**
 * A short program to illustrate an app testing some minimal functionality of a
 * concrete implementation of the CyclingPortalInterface interface -- note you
 * will want to increase these checks, and run it on your CyclingPortal class
 * (not the BadCyclingPortal class).
 *
 * 
 * @author Diogo Pacheco
 * @version 1.0
 */
public class CyclingPortalInterfaceTestApp {

	/**
	 * Test method.
	 * 
	 * @param args not used
	 * @throws InvalidNameException
	 * @throws IllegalNameException
	 * @throws InvalidLengthException
	 * @throws IDNotRecognisedException
	 * @throws NameNotRecognisedException 
	 */
	/**
	 * @param args
	 * @throws IllegalNameException
	 * @throws InvalidNameException
	 * @throws IDNotRecognisedException
	 * @throws InvalidLengthException
	 * @throws NameNotRecognisedException
	 * @throws InvalidStageTypeException 
	 * @throws InvalidStageStateException 
	 * @throws InvalidLocationException 
	 * @throws InvalidCheckpointsException 
	 * @throws DuplicatedResultException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IllegalNameException, InvalidNameException, IDNotRecognisedException, InvalidLengthException, NameNotRecognisedException, InvalidLocationException, InvalidStageStateException, InvalidStageTypeException, DuplicatedResultException, InvalidCheckpointsException, IOException, ClassNotFoundException {
		System.out.println("The system compiled and started the execution...");

		//MiniCyclingPortalInterface portal = MiniCyclingPortalInterfaceal();
		CyclingPortalInterface portal = new CyclingPortal();

		
		
		//assert (portal.getRaceIds().length == 0)
		//		: "Initial SocialMediaPlatform not empty as required or not returning an empty array.";

		
		portal.createRace("pooa", "wheely bike race");
		portal.createRace("poob", "wheely bike race");
		portal.createRace("pooc", "wheely bike race");
		portal.createRace("pood", "wheely bike race");
		portal.createRace("pooe", "wheely bike race");
		portal.createRace("poof", "wheely bike race");
		portal.createRace("poog", "wheely bike race");
		portal.createRace("pooh", "wheely bike race");
		
		String testRaceIds = Arrays.toString(portal.getRaceIds());
		System.out.println(testRaceIds);
		
		
		System.out.println(portal.viewRaceDetails(1));
		
		LocalDateTime datetime1 = LocalDateTime.of(2017, 1, 14, 10, 34);  
		StageType flatStage = StageType.FLAT;
		StageType timeTrial = StageType.TT;
		portal.addStageToRace(1, "race1", "stage1", 15.3, datetime1, flatStage);
		portal.addStageToRace(1, "race2", "stage1", 15.3, datetime1, flatStage);
		portal.addStageToRace(1, "race3", "stage1", 15.3, datetime1, flatStage);
		
		System.out.println(portal.viewRaceDetails(1));
		portal.getRaceStages(1);
		System.out.println(portal.getNumberOfStages(1));
		System.out.println(portal.getStageLength(1));
		portal.createTeam("WHEELZ", "Amazing cycling team!");
		portal.createTeam("SQUAREZ", "Amazing cycling team2!");
		String wowza = Arrays.toString(portal.getTeams());
		System.out.println(wowza);
		System.out.println("HELLLLLLLLLLLLLLLLLLLLLLLO");
		portal.createRider(1, "moo", 2002);
		portal.createRider(1, "moo222", 2002);
	//	String wowza1 = Arrays.toString(portal.getTeamRiders(1));
		//System.out.println(wowza1);
		
		//portal.removeRider(1);
		//System.out.println("HELLLLLLLLLLLLLLLLLLLLLLLO");
		//String wowza2 = Arrays.toString(portal.getTeamRiders(1));
		//System.out.println(wowza2);
		//portal.removeRaceById(2);
		//String testRaceIds2 = Arrays.toString(portal.getRaceIds());
		//System.out.println(testRaceIds2);
		
		SegmentType c4 = SegmentType.C4;
		portal.addCategorizedClimbToStage(1, 43.4, c4, 34.3, 45.2);
		portal.addCategorizedClimbToStage(1, 43.4, c4, 34.3, 45.2);
		portal.addCategorizedClimbToStage(1, 43.4, c4, 34.3, 45.2);
		portal.addIntermediateSprintToStage(1, 10.2);

		String testss = Arrays.toString(portal.getStageSegments(1));
		System.out.println(testss + "stage segments b4");
		portal.removeSegment(3);
		String testsss = Arrays.toString(portal.getStageSegments(1));
		System.out.println(testsss + "stage segments after"); 
	
		
		LocalTime theMFTime = LocalTime.of(23, 23, 23);
		LocalTime theM1FTime = LocalTime.of(23, 1, 23);
		portal.registerRiderResultsInStage(2, 1, theMFTime);
		portal.registerRiderResultsInStage(3, 2, theM1FTime);
		portal.registerRiderResultsInStage(2, 3, theMFTime);
		portal.registerRiderResultsInStage(2, 4, theMFTime);
		portal.registerRiderResultsInStage(3, 5, theMFTime);
		portal.registerRiderResultsInStage(2, 1, theMFTime);

		String LALALALA = Arrays.toString(portal.getRiderResultsInStage(2, 1));
		System.out.println(LALALALA);

		String LALALALA1 = Arrays.toString(portal.getRiderResultsInStage(2, 3));

		System.out.println(LALALALA1);
		// IT WORKS LESSSSSSSS GOOOOOOOOOOO
		
		portal.saveCyclingPortal("savesave.ser");
		System.out.println(portal.getNumberOfStages(1));

		portal.loadCyclingPortal("savesave.ser");
		System.out.println(portal.getNumberOfStages(1));
		
		portal.getRaceIds();

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
	}

}
