import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

import cycling.CyclingPortal;
import cycling.CyclingPortalInterface;
import cycling.IDNotRecognisedException;
import cycling.IllegalNameException;
import cycling.InvalidLengthException;
import cycling.InvalidNameException;
import cycling.MiniCyclingPortalInterface;
import cycling.NameNotRecognisedException;
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
	 */
	public static void main(String[] args) throws IllegalNameException, InvalidNameException, IDNotRecognisedException, InvalidLengthException, NameNotRecognisedException {
		System.out.println("The system compiled and started the execution...");

		//MiniCyclingPortalInterface portal = MiniCyclingPortalInterfaceal();
		CyclingPortalInterface portal = new CyclingPortal();

		assert (portal.getRaceIds().length == 0)
				: "Innitial SocialMediaPlatform not empty as required or not returning an empty array.";

		//for (Integer i = 0;i <= 100; i++) {
			//portal.createRace("poo", "wheely bike race");
			//portal.createRace("poo", "wheely bike race");
		//}
		
		portal.createRace("pooa", "wheely bike race");
		portal.createRace("poob", "wheely bike race");
		portal.createRace("pooc", "wheely bike race");
		portal.createRace("pood", "wheely bike race");
		portal.createRace("pooe", "wheely bike race");
		portal.createRace("poof", "wheely bike race");
		portal.createRace("poog", "wheely bike race");
		portal.createRace("pooh", "wheely bike race");
		System.out.println("OO");
		System.out.println(portal.viewRaceDetails(1));
		portal.removeRaceByName("skrttttt");
		System.out.println("PP");
		System.out.println("------------------------------------------------------------");
		String testRaceIds = Arrays.toString(portal.getRaceIds());
		System.out.println(testRaceIds);
		System.out.println("Hello");
		System.out.println("------------------------------------------------------------");

		//LocalDateTime datetime1 = LocalDateTime.of(2017, 1, 14, 10, 34);  
	//StageType flatStage = StageType.FLAT;
		//portal.addStageToRace(1, "race1", "stage1", 15.3, datetime1, flatStage);
		//portal.addStageToRace(1, "race1", "stage1", 15.3, datetime1, flatStage);
		//portal.addStageToRace(1, "race1", "stage1", 15.3, datetime1, flatStage);
		//System.out.println(portal.viewRaceDetails(3));
		
		
		//this needs to be fixed 
		//portal.getRaceStages(1);
		
		
		//System.out.println(portal.getStageLength(1));

		//System.out.println(portal.viewRaceDetails(1));

		//portal.createTeam("CycleTeamm", "Amazing cycling team!");
		//portal.createTeam("cycelteammm", "Amazing cycling team!");
		//String wowza = Arrays.toString(portal.getTeams());
		//System.out.println(wowza);
		//System.out.println("HELLO");
		//portal.removeTeam(1);

		//String wowza2 = Arrays.toString(portal.getTeams());
		//System.out.println(wowza2);
		
		
		//portal.removeRaceById(3);
		//portal.removeRaceById(11);
		String testRaceIds1 = Arrays.toString(portal.getRaceIds());
		System.out.println(testRaceIds1);

		
		
		//.out.println("------------------------------------------------------------");
		//String testRaceIds2 = Arrays.toString(portal.getRaceIds());
		//System.out.println(testRaceIds2);
		//System.out.println("------------------------------------------------------------");
		
		//portal.createRider(2, "lancearmstrong", 2000);
		//String wowza3 = Arrays.toString(portal.getTeamRiders(1));
		//System.out.println(wowza3);
		
		portal.getNumberOfStages(1);
		System.out.println("there are " + portal.getNumberOfStages(1) + " stages");
		System.out.println("------------------------------------------------------------");
		//String wowza4 = Arrays.toString(portal.getTeams());
		//System.out.println(wowza4);		
		//portal.getTeamRiders(2);
		//System.out.println("------------------------------------------------------------");
		
		portal.createTeam("WATSONTEAM", "VERY COOL AMAZING CYCLING TEAM");
		portal.createTeam("DAVIDTEAM", "VERY NOT COOL NOT AMAZING CYCLING TEAM");

		portal.createRider(1, "GARY", 2000);
		portal.createRider(1, "GARY GLITTER", 2000);
		portal.createRider(1, "MIKE TYSON", 2000);
		portal.createRider(1, "KIM KARDASHIAN", 2000);
		portal.createRider(1, "RUMER WILLIS", 2000);
		
		
		
		//portal.removeRider(1); - BREOKE
		
		
		//String listOfTeams = Arrays.toString(portal.getTeamRiders(1));
		//System.out.println(listOfTeams);
		
		LocalDateTime datetime2 = LocalDateTime.of(2017, 1, 14, 10, 34);  
		StageType flatStage2 = StageType.FLAT;
		portal.addStageToRace(6,"thisisthestagename", "testtoaddstagetorace", 14.4, datetime2, flatStage2);
		portal.addStageToRace(6,"thisisthestagenamee", "testtoaddstagetorace", 14.4, datetime2, flatStage2);
		portal.addStageToRace(6,"thisisthestagenameee", "testtoaddstagetorace", 14.4, datetime2, flatStage2);
		portal.addStageToRace(6,"thisisthestagenameeee", "testtoaddstagetorace", 14.4, datetime2, flatStage2);
		portal.addStageToRace(6,"thisisthestagenameeeee", "testtoaddstagetorace", 14.4, datetime2, flatStage2);
		portal.addStageToRace(6,"thisisthestagenameeeeee", "testtoaddstagetorace", 14.4, datetime2, flatStage2);
		
		System.out.println(portal.getStageLength(1));
		
		

		System.out.println("there are " + portal.getNumberOfStages(6) + " stages");



		
		
		
		
		
		

		
	}

}
