
public class RandomThing {

	public RandomThing() {}
	
	public double roll() {
		double result = (Math.random()*100);
        return result;
    }
	
	public double popGrowth(double rate) {
		//[-.05,.05]
		rate = (Math.random()*100);
		return rate;
	}
	
	public double gdpGrowth(int rate) {
		return rate;
	}

}
