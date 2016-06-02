package movingaverage;

/***
 * Maintains a moving average of values
 * 
 * @version 1 June, 2016
 *
 */

public abstract class MovingAverage {

	// An array sized to store the most recent N samples
	private double[] lastN;

	/**
	 * Constructor
	 * 
	 * @param n
	 *            the number of values that need to be stored
	 */
	public MovingAverage(int n) {
		lastN = new double[n];
	}

	// This class leaves the implementation to future subclasses
	public abstract double getAverage();

	// This class leaves the implementation to future subclasses
	public abstract void addValue(double d);

	// Provide access to the values
	public double[] getValues() {
		return lastN;
	}

}
