// wheel diameter = 3.25 	radius = 1.625	circumference: = 10.21018
// apparent wheel radius = 0.97500	diameter = 1.95
// motor: 12 tooth	wheel: 20 tooth
// gear ratio: 6/10 = .6 (wheel does .6 rotations for every motor rotation)
// apparent wheel circumference: .6(10.21018) = 6.12611

package testing;													// what the class belongs to

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.robotics.navigation.Navigator;							// importing other classes; like
import lejos.robotics.navigation.DifferentialPilot;					// libraries in C
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.Pose;

public class NavPractice {
	static float diameter = 1.95f, width = 4.875f;					// variable declaration and
	static int speed = 100;											// object creation
	static DifferentialPilot pilot = new DifferentialPilot(diameter, width, Motor.B, Motor.C, true);
	static OdometryPoseProvider pose = new OdometryPoseProvider(pilot);
	static Pose current = new Pose();
	static Navigator nav = new Navigator(pilot);
	
	public static void setNavigatorPath(int distance)	{			// path assignment for navigator
		nav.addWaypoint(distance, 0);
		nav.addWaypoint(0, -distance);
		nav.addWaypoint(-distance, 0);
		nav.addWaypoint(0, distance);
		nav.addWaypoint(0, 0, 0);
	}
	
	public static void goRotate(int angle)	{						// rotate instructions
		pose.setPose(current);										// initialize pose
		pilot.rotate(angle);										// move
		NavPractice.printCurrentPose();								// call output method
		pilot.steer(100, -180);
		NavPractice.printCurrentPose();
		pilot.rotate(angle);
		NavPractice.printCurrentPose();
		return;
	}
	
	public static void printCurrentPose()	{						// output method;
		current = pose.getPose();									// get current pose
		//System.out.println(current.getX());						// print current data
		//System.out.println(current.getY());
		System.out.println(current.getHeading());
		System.out.println("");
	}

	public static void main(String[] args)	{						// main method; executed first
		pilot.addMoveListener(pose);								// enable pose tracking
		pilot.setTravelSpeed(speed);
		Button.waitForAnyPress();
		//NavPractice.goRotate(90);									// call rotate method
		NavPractice.setNavigatorPath(10);							// call path assignment method
		nav.followPath();											// execute path
		Button.waitForAnyPress();
	}
}
