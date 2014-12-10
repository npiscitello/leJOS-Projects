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


public class NavPractice {
	static float diameter = 1.95f, width = 4.875f;
	static int speed, angle;
	static DifferentialPilot pilot = new DifferentialPilot(diameter, width, Motor.B, Motor.C, true);
	
	public static void go(int speed, int angle)	{
		pilot.setTravelSpeed(speed);
		pilot.rotate(angle);
		pilot.steer(100, -180);
		pilot.rotate(angle);
	}

	public static void main(String[] args)	{
		
		Button.waitForAnyPress();
		NavPractice.go(100, 90);
	}
}
