package testing;

import lejos.nxt.Button;
import lejos.nxt.Motor;

public class MotorTest3 {
	public static void main(String[] args)	{
		Button.waitForAnyPress();
		Motor.A.rotate(1440);
		System.out.println("returned");
		Button.waitForAnyPress();
		Motor.A.rotateTo(0);
		System.out.println("returned");
		Button.waitForAnyPress();
	}

}
