// wheel diameter = 3.25 	radius = 1.625	circumference: = 10.21018
// apparent wheel radius = 0.97500	diameter = 1.95
// motor: 12 tooth	wheel: 20 tooth
// gear ratio: 6/10 = .6 (wheel does .6 rotations for every motor rotation)
// apparent wheel circumference: .6(10.21018) = 6.12611

package testing;

import lejos.nxt.Button;
import lejos.nxt.Motor;
//import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.Pose;
import lejos.util.Delay;

public class NavPractice {
	static float diameter = 1.95f, width = 4.875f;
	static int speed, angle, delay = 500;
	static DifferentialPilot pilot = new DifferentialPilot(diameter, width, Motor.B, Motor.C, true);
	static OdometryPoseProvider pose = new OdometryPoseProvider(pilot);
	static Pose current = new Pose();
	
	public static void go(int speed, int angle)	{
		pose.setPose(current);
		pilot.setTravelSpeed(speed);
		pilot.rotate(angle);
		//Delay.msDelay(delay);
		NavPractice.printCurrentPose();
		pilot.steer(100, -180);
		//Delay.msDelay(delay);
		NavPractice.printCurrentPose();
		pilot.rotate(angle);
		//Delay.msDelay(delay);
		NavPractice.printCurrentPose();
		return;
	}
	
	public static void printCurrentPose()	{
		current = pose.getPose();
		//System.out.println(current.getX());
		//System.out.println(current.getY());
		System.out.println(current.getHeading());
		System.out.println("");
	}

	public static void main(String[] args)	{
		pilot.addMoveListener(pose);
		Button.waitForAnyPress();
		NavPractice.go(100, 90);
		Button.waitForAnyPress();
	}
}
