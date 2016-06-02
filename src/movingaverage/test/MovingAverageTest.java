package movingaverage.test;

import static org.junit.Assert.*;

import org.junit.Test;

import movingaverage.MovingAverage;
import movingaverage.MovingAverage1;

public class MovingAverageTest {

	@Test
	public void testMovingAverage1() {
		MovingAverage ma = new MovingAverage1(5);
		assertTrue(ma.getAverage()==0.0);
		ma.addValue(100.0);
	}

}
