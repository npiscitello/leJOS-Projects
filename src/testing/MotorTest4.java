package testing;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.util.Delay;

public class MotorTest4 {
	static int speed = 720;
	static int y = 0;
	public static void main(String[] args)	{
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
		Motor.C.setSpeed(speed);
		Motor.A.rotateTo(-1440, true);
		Motor.B.rotateTo(-1440, true);
		Motor.C.rotateTo(-1440, true);
		while(Motor.A.isMoving() && Motor.B.isMoving() && Motor.C.isMoving())	{
			LCD.drawInt(Motor.A.getTachoCount(), 0, y);
			LCD.drawInt(Motor.B.getTachoCount(), 5, y);
			LCD.drawInt(Motor.C.getTachoCount(), 10, y);
			Delay.msDelay(200);
			y = y + 1;
		}
		Button.waitForAnyPress();
	}
}