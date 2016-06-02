package movingaverage;

public class MovingAverage1 extends MovingAverage {

	public MovingAverage1(int n) {
		super(n);
	}

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
		for (int i = 1; i<values.length; i++) {
			values[i-1] = values[i];
		}
		values[values.length-1] = d;		
	}

}
