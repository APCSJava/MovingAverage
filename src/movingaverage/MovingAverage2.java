package movingaverage;

public class MovingAverage2 extends MovingAverage {

	public MovingAverage2(int n) {
		super(n);
		currIndex = 0;
		numValues = n;
	}
	
	private int currIndex;
	private int numValues;

	@Override
	public double getAverage() {
		double sum = 0;
		double[] values = getValues();
		for (int i = 0; i<getValues().length; i++) {
			sum+=values[i];
		}
		return sum/values.length;
	}

	@Override
	public void addValue(double d) {
		double[] values = getValues();
		values[currIndex] = d;
		currIndex++;
		currIndex%=numValues;
	}

}
