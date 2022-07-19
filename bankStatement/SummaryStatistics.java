package bankStatement;

public class SummaryStatistics {
	
	
	private final double sum;
	private final double min;
	private final double max;
	private final double average;
	
	public SummaryStatistics(final double sum, final double min, final double max, final double average) 
	{
		
		this.sum = sum;
		this.min = min;
		this.max = max;
		this.average = average;
		
		
		
	}

	
	
	public double getSum() {return this.sum;}
	
	public double getMin() {return this.min;}
	
	public double getMax() {return this.max;}
	
	public double getAverage() {return this.average;}
	
	

}
