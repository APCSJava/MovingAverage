package movingaverage;

/***
 * An abstract class to serve as parent for concrete classes that provide a
 * moving average of values.
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

	// Concrete classes must specify an implementation
	public abstract double getAverage();

	// Concrete classes must specify an implementation
	public abstract void addValue(double d);

	// Provide access to the values
	public double[] getValues() {
		return lastN;
	}

}
