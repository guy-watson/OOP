import cycling.CyclingPortal;
import cycling.CyclingPortalInterface;
import cycling.IDNotRecognisedException;
import cycling.IllegalNameException;
import cycling.InvalidLengthException;
import cycling.InvalidNameException;
import cycling.MiniCyclingPortalInterface;
import cycling.StageType;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

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
	 */
	public static void main(String[] args) throws IllegalNameException, InvalidNameException, IDNotRecognisedException, InvalidLengthException {
		System.out.println("The system compiled and started the execution...");

		//MiniCyclingPortalInterface portal = MiniCyclingPortalInterfaceal();
		CyclingPortalInterface portal = new CyclingPortal();

		assert (portal.getRaceIds().length == 0)
				: "Innitial SocialMediaPlatform not empty as required or not returning an empty array.";

		for (Integer i = 0;i <= 100; i++) {
			portal.createRace("wheelyrace" + " " + i+1, "wheely bike race" + " " + i+1);
		}
		System.out.println("------------------------------------------------------------");
		String testRaceIds = Arrays.toString(portal.getRaceIds());
		System.out.println(testRaceIds);
		System.out.println("Hello");
		System.out.println("------------------------------------------------------------");

		LocalDateTime datetime1 = LocalDateTime.of(2017, 1, 14, 10, 34);  
		StageType flatStage = StageType.FLAT;
		portal.addStageToRace(1, "race1", "stage1", 15.3, datetime1, flatStage);
		portal.addStageToRace(1, "race1", "stage1", 15.3, datetime1, flatStage);
		portal.addStageToRace(1, "race1", "stage1", 15.3, datetime1, flatStage);
		portal.addStageToRace(1, "race1", "stage1", 15.3, datetime1, flatStage);
		
		System.out.println("------------------------------------------------------------");
		System.out.println(portal.getStageLength(1));
		System.out.println("------------------------------------------------------------");

		System.out.println(portal.viewRaceDetails(1));
	}

}
