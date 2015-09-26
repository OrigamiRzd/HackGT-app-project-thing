
public class RandomThing {

	public RandomThing() {}
	
	public double popGrowth(int rate) {
		//[-.05,.05]
		rate = (Math.random()*10);
		return rate;
	}
	
	public double gdpGrowth(int rate) {
		return rate;
	}
}
