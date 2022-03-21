import cycling.CyclingPortal;
import cycling.CyclingPortalInterface;
import cycling.IllegalNameException;
import cycling.InvalidNameException;
import cycling.MiniCyclingPortalInterface;
import java.io.*;
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
	 */
	public static void main(String[] args) throws IllegalNameException, InvalidNameException {
		System.out.println("The system compiled and started the execution...");

		//MiniCyclingPortalInterface portal = MiniCyclingPortalInterfaceal();
		CyclingPortalInterface portal = new CyclingPortal();

		assert (portal.getRaceIds().length == 0)
				: "Innitial SocialMediaPlatform not empty as required or not returning an empty array.";

		portal.createRace("wheelybike", "wheely bike race");
		portal.createRace("wheelooooo", "whellooooooo");
		portal.createRace("mealsonwheels", "mealsonwhelllssssss");
		String testRaceIds = Arrays.toString(portal.getRaceIds());
		System.out.println(testRaceIds);
		System.out.println("Hello");
	}
}
