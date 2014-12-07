package testing;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.util.Delay;

public class MotorTest2 {
	public static void main(String[] args)	{
		Motor.A.setSpeed(720);
		Motor.A.forward();
		Delay.msDelay(2000);
		System.out.println("Ideal Value 1480");
		Motor.A.stop();
		System.out.println(Motor.A.getTachoCount());
		Delay.msDelay(250);
		Motor.A.backward();
		while(Motor.A.getTachoCount() != 0)	{Delay.msDelay(1);}
		Motor.A.stop();
		System.out.println(Motor.A.getTachoCount());
		Button.waitForAnyPress();
	}
}
