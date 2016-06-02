package movingaverage.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import movingaverage.MovingAverage;
import movingaverage.MovingAverage1;
import movingaverage.MovingAverage2;

public class MovingAverageTest {

	private static final double TOLERANCE = 0.00001;

	@Test
	public void testMovingAverage1() {
		MovingAverage ma = new MovingAverage1(5);
		assertEquals("incorrect beginning average", 0.0, ma.getAverage(), TOLERANCE);
		assertNotEquals("wrong initial average", 1.0, ma.getAverage(), TOLERANCE);
		ma.addValue(100.0);
		assertEquals("failed 100.0/5", 20, ma.getAverage(), TOLERANCE);
		ma.addValue(100.0);
		assertEquals("failed 200.0/5", 40, ma.getAverage(), TOLERANCE);
		ma.addValue(100.0);
		assertEquals("failed 300.0/5", 60, ma.getAverage(), TOLERANCE);
		ma.addValue(100.0);
		assertEquals("failed 400.0/5", 80, ma.getAverage(), TOLERANCE);
		ma.addValue(100.0);
		assertEquals("failed 500.0/5", 100, ma.getAverage(), TOLERANCE);
		ma.addValue(0.0);
		assertEquals("failed 400.0/5", 80, ma.getAverage(), TOLERANCE);
		ma.addValue(20.0);
		assertEquals("failed 320.0/5", 64, ma.getAverage(), TOLERANCE);
		ma.addValue(20.0);
		assertEquals("failed 240.0/5", 48, ma.getAverage(), TOLERANCE);
		for (int i = 0; i < 5; i++) {
			ma.addValue(-3.0);
		}
		assertEquals("failed -3 injection", -3.0, ma.getAverage(), TOLERANCE);
		for (int i = 0; i < 5; i++) {
			ma.addValue(i);
		}
		assertEquals("failed increment loop", 2.0, ma.getAverage(), TOLERANCE);
	}

	@Test
	public void stressTestMovingAverage() {
		Random rand = new Random();
		rand.setSeed(1987);
		MovingAverage ma = new MovingAverage1(10000);
		long startTime, finishTime, elapsedTime;
		// begin recording
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			ma.addValue(rand.nextDouble());
			ma.getAverage();
		}
		finishTime = System.currentTimeMillis();
		elapsedTime = finishTime - startTime;
		System.out.println("10000 operations took: " + elapsedTime + " milliseconds.");
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			ma.addValue(rand.nextDouble());
			ma.getAverage();
		}
		finishTime = System.currentTimeMillis();
		elapsedTime = finishTime - startTime;
		System.out.println("100000 operations took: " + elapsedTime + " milliseconds.");

		for (int count = 0; count < 5; count++) {
			startTime = System.currentTimeMillis();
			for (int i = 0; i < 1000000; i++) {
				ma.addValue(rand.nextDouble());
				ma.getAverage();
			}
			finishTime = System.currentTimeMillis();
			elapsedTime = finishTime - startTime;
			System.out.println("1000000 operations took: " + elapsedTime + " milliseconds.");
		}
	}

}
