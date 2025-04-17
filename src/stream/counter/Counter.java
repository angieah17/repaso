package stream.counter;

public class Counter {

	private int value; 
	private int maxValue;
	private String model;
	
	
	public Counter(int maxValue, String model) {
		value = value > 0 ? value : 0;
		this.maxValue = maxValue > 0 ? maxValue : 100_000;
		this.model = model != null || model != "" ? model : "N-CONTER";
	}
	
	
	public Counter(int maxValue) {
		this(maxValue, "N-CONTER");
	}
		
	
	public Counter (Counter c) {
		this.value = c.value;
		this.maxValue = c.maxValue;
		this.model = c.model;
	}
	
	public Counter() {
		this(100_000, "N-CONTER");
	}


	@Override
	public String toString() {
		return String.format("Contador: modelo (%s) y valor %d "
				+ "de %d.  ", model, value, maxValue);
	}
	
	public boolean increment () {
		
		return increment(1);
	}
	
	public boolean increment (int n) {
		
		if(n <= 0) return false;
				
		
		if (value + n <= maxValue) {
			value += n;
			return true;
		} 
		
		value = maxValue;
		return false;
	}
	
	public boolean reset () {
		if (value == maxValue) {
			value = 0;
			return true;
		}
		return false;
	}
	
	
	public int getValue() {
		return value;
	}
}
