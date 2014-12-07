package testing;
import lejos.nxt.Button;
import lejos.nxt.Motor;

public class MotorTest {
	public static void main(String[] args)	{
		System.out.println("Motor Testing In Progress...");
		System.out.println("Please do not disturb!");
		System.out.println("");
		Button.waitForAnyPress();
		Motor.A.forward();
		System.out.println("Forwards!");
		Button.waitForAnyPress();
		Motor.A.backward();
		System.out.println("Now Backwards!");
		System.out.println("");
		Button.waitForAnyPress();
		Motor.A.stop();
		System.out.println("we're done now.");
		Button.waitForAnyPress();
	}
}